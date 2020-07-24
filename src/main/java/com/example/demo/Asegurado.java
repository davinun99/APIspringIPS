package com.example.demo;

public class Asegurado implements Respuesta{
    private Persona persona;
    private Empleador empleador;
    public Asegurado(Persona persona, Empleador empleador){
        this.persona = persona;
        this.empleador = empleador;
    }
    /**
     * @return the empleador
     */
    public Empleador getEmpleador() {
        return empleador;
    }
    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }
    /**
     * @param empleador the empleador to set
     */
    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }
    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}