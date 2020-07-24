# APIspringIPS

#Problema:

Objetivo: Apificar la página web siguiente:
http://servicios.ips.gov.py/consulta_asegurado/
Esta página de IPS (seguridad médica y social de la República del Paraguay) tiene un pequeño
formulario que pide una cédula de identidad y devuelve los datos del asegurado en HTML para su
visualización en un navegador convencional.
El objetivo de este test es APIFICAR dicha página para convertirla en un API RESTful de tal forma a
que los datos arrojados por la página puedan integrarse con otros sistemas satélites que requieran
hacer uso de la información en cuestión.
Detalles de la solición
Programar un API RESTful en el lenguaje indicado por el evaluador, que implemente la siguiente
consulta:
http://API-IMPLEMENTADO/consulta/{cedula}
El parámetro debe ser pasado a través de la URL mencionada. Por detrás, el API deberá llamar al
web site de IPS para obtener la información que tendrá que ser devuelta en formato JSON:
{ "persona": { "Documento": "9999999", "Nombres": "Juan Antonio", "Apellidos": "Pérez
González", "Fecha Nacim": "2017-12-12", "Sexo": "M", "Tipo Asegurado": "TITULAR",
"Beneficiarios Activos": 0, "Enrolado": "NO", "Vencimiento de fe de vida": "No tiene" },
"empleador": { "Nro. Patronal": "000688-0098", "Empleador": "Antonio S.A.E.C.A.",
"Estado": "ACTIVO", "Meses de aporte": 290, "Vencimiento": "2017-12-12", "Ultimo
Periodo Abonado": "JUNIO/2017" } }
El STATUS HTTP de retorno debe ser 200 en caso de éxito.
Si la cédula no se encuentra, hay que retornar un error 404:
{ "codigo": "g100", "error": "usuario con cédula XXXXX no existe" }
Si el parámetro de cédula está mal formado (ejemplo, tiene caracteres no numéricos) hay que
retornar un eerror 400:
{ "codigo": "g101", "error": "Parámetros inválidos" }
Si hay un error interno, hay que tratarlo y retornar un error 500:
{ "codigo": "g102", "error": "Error interno del servidor" }

#Solucion:

#Recursos:
