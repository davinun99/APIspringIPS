package com.example.demo;

public class Persona {
    private String documento;
    private String nombres;
    private String apellidos;
    private String nacimiento;
    private char sexo;
    private String tipoAsegurado;
    private int benefActivos;
    private String enrolado;
    private String feDeVida;

    public Persona( String documento, String nombres, String apellidos, String nacimiento, char sexo,
    String tipoAsegurado, int benefActivos, String enrolado, String feDeVida ){
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.tipoAsegurado = tipoAsegurado;
        this.benefActivos = benefActivos;
        this.enrolado = enrolado;
        this.documento = documento;
        this.feDeVida = feDeVida;
    }
    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }
    
    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }
    /**
     * @return the nacimiento
     */
    public String getNacimiento() {
        return nacimiento;
    }
    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }
    /**
     * @return the tipoAsegurado
     */
    public String getTipoAsegurado() {
        return tipoAsegurado;
    }
    /**
     * @return the benefActivos
     */
    public int getBenefActivos() {
        return benefActivos;
    }
    /**
     * @return the enrolado
     */
    public String getEnrolado() {
        return enrolado;
    }
    /**
     * @return the feDeVida
     */
    public String getFeDeVida() {
        return feDeVida;
    }
    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * @param benefActivos the benefActivos to set
     */
    public void setBenefActivos(int benefActivos) {
        this.benefActivos = benefActivos;
    }
    /**
     * @param enrolado the enrolado to set
     */
    public void setEnrolado(String enrolado) {
        this.enrolado = enrolado;
    }
    /**
     * @param feDeVida the feDeVida to set
     */
    public void setFeDeVida(String feDeVida) {
        this.feDeVida = feDeVida;
    }
    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    /**
     * @param tipoAsegurado the tipoAsegurado to set
     */
    public void setTipoAsegurado(String tipoAsegurado) {
        this.tipoAsegurado = tipoAsegurado;
    }
    
}