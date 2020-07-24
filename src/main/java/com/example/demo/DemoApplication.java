
package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/consulta/{cedula}")
	public Respuesta consultav2(@PathVariable(value = "cedula") String cedula, HttpServletResponse servletResponse ) {
		try {
			//Preparo el request para el form IPS
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("nro_cic",cedula);
			map.add("envio", "ok");
			map.add("recuperar", "Recuperar");
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://servicios.ips.gov.py/consulta_asegurado/comprobacion_de_derecho_externo.php";
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			
			//Recibo como respuesta codigo Html
			String htmlBody = response.getBody();
			
			try {
				int ci = Integer.parseInt(cedula);
			} catch (Exception e) {
				//TODO: handle exception
				servletResponse.setStatus(400);
				return new RespNoExitosa("g101", "Parámetros inválidos");
			}

			Persona persona = parserPersona(htmlBody);
			if(persona == null){
				servletResponse.setStatus(404);
				return new RespNoExitosa("g100", "usuario con cédula " + cedula + " no existe");
			}
			Empleador empleador = parserEmpleador(htmlBody);
			return new Asegurado(persona, empleador);

		} catch (Exception e) {
			//TODO: handle exception
			servletResponse.setStatus(500);
			return new RespNoExitosa("g102","Error interno del servidor");
		}
	}

	public Empleador parserEmpleador(String htmlBody){
		//Extraigo desde <tr bgcolor=#e2e8f6>, donde empieza la tabla de empleador
		String primeraBusqueda = "<tr bgcolor=#e2e8f6>";
		String primerReemplazo = "<td align=center>";
		String segundoReemplazo = "<td align='center' >";
		String auxStringEmpleador;
		auxStringEmpleador = htmlBody.substring( htmlBody.indexOf(primeraBusqueda) + primeraBusqueda.length() );
		
		int segundaBusqueda = auxStringEmpleador.indexOf(primeraBusqueda);
		//si no se encuentra el siguiente tag tr significa que no tenemos datos del empleador:
		if (segundaBusqueda == -1) {
			return null;
		}
		auxStringEmpleador = auxStringEmpleador.substring(segundaBusqueda + primeraBusqueda.length());

		//reemplazo los tags <td>
		auxStringEmpleador = auxStringEmpleador.replaceAll(primerReemplazo, "").replaceAll(segundoReemplazo, "");
		//divido el resultante en un array compuesto por los </td>
		String valoresEmpleador[] = auxStringEmpleador.split("</td>");
		
		String nroPatronal = valoresEmpleador[0].trim();
		String Empleador = valoresEmpleador[1].trim();
		String Estado = valoresEmpleador[2].trim();
		int mesesDeAporte = 0;
		try {
			mesesDeAporte = Integer.parseInt(valoresEmpleador[3].trim());
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		String vencimiento = valoresEmpleador[4].trim();
		String ultimoPeriodoAbonado = valoresEmpleador[5].trim();
		return new Empleador(nroPatronal, Empleador, Estado, mesesDeAporte, vencimiento, ultimoPeriodoAbonado);
	}
	public Persona parserPersona(String htmlBody){
		//Extraigo desde <input name=elegir type=radio value='' checked id=0></input>, donde empieza la tabla de nombres
		String primeraBusqueda = "<input name=elegir type=radio value='' checked id=0></input>";
		String primerReemplazo = "<td align=center>";
		String auxStringPersona;
		int indexOfPrimeraBus = htmlBody.indexOf(primeraBusqueda);
		if( indexOfPrimeraBus == -1){
			return null;
		}
		auxStringPersona = htmlBody.substring( indexOfPrimeraBus + primeraBusqueda.length() );
		//reemplazo los tags <td>
		auxStringPersona = auxStringPersona.replaceAll(primerReemplazo, "");
		//divido el resultante en un array compuesto por los </td>
		String valoresPersona[] = auxStringPersona.split("</td>");		

		//extraigo los resultados del array
		String documentos = valoresPersona[1].trim();
		String nombre = valoresPersona[2].trim();
		String apellido = valoresPersona[3].trim();
		String nacimiento = valoresPersona[4].trim();
		String sexo = valoresPersona[5].trim();
		String tipoAseg = valoresPersona[6].trim();

		String benef = valoresPersona[7].trim();
		int benefActivos = 0;
		try {
			benefActivos = Integer.parseInt(benef);
		} catch (Exception e) {
			//TODO: handle exception
		}
		String enrol = valoresPersona[8].trim();
		String venc = valoresPersona[9].trim();
		if( venc.equals("")){
			venc = "No tiene";
		}
		
		//creo la nueva persona con los valores y retorno
		
		Persona nuevaPersona = new Persona(documentos, nombre, apellido, nacimiento, sexo.charAt(0), tipoAseg, benefActivos, enrol, venc);
		return nuevaPersona;
	}

}
            