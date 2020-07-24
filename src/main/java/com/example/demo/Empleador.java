package com.example.demo;

public class Empleador {
    private String nroPatronal;
    private String Empleador;
    private String Estado;
    private int mesesDeAporte;
    private String vencimiento;
    private String ultimoPeriodoAbonado;

    public Empleador(String nroPatronal, String Empleador, String Estado, int mesesDeAporte, String vencimiento, String ultimoPeriodoAbonado){
        this.nroPatronal = nroPatronal;
        this.Empleador = Empleador;
        this.Estado = Estado;
        this.mesesDeAporte = mesesDeAporte;
        this.vencimiento = vencimiento;
        this.ultimoPeriodoAbonado = ultimoPeriodoAbonado;
    }
    /**
     * @param empleador the empleador to set
     */
    public void setEmpleador(String empleador) {
        Empleador = empleador;
    }
    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        Estado = estado;
    }
    /**
     * @param mesesDeAporte the mesesDeAporte to set
     */
    public void setMesesDeAporte(int mesesDeAporte) {
        this.mesesDeAporte = mesesDeAporte;
    }
    /**
     * @param nroPatronal the nroPatronal to set
     */
    public void setNroPatronal(String nroPatronal) {
        this.nroPatronal = nroPatronal;
    }
    /**
     * @param ultimoPeriodoAbonado the ultimoPeriodoAbonado to set
     */
    public void setUltimoPeriodoAbonado(String ultimoPeriodoAbonado) {
        this.ultimoPeriodoAbonado = ultimoPeriodoAbonado;
    }
    /**
     * @param vencimiento the vencimiento to set
     */
    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    /**
     * @return the empleador
     */
    public String getEmpleador() {
        return Empleador;
    }
    /**
     * @return the estado
     */
    public String getEstado() {
        return Estado;
    }
    /**
     * @return the mesesDeAporte
     */
    public int getMesesDeAporte() {
        return mesesDeAporte;
    }
    /**
     * @return the nroPatronal
     */
    public String getNroPatronal() {
        return nroPatronal;
    }
    /**
     * @return the ultimoPeriodoAbonado
     */
    public String getUltimoPeriodoAbonado() {
        return ultimoPeriodoAbonado;
    }
    /**
     * @return the vencimiento
     */
    public String getVencimiento() {
        return vencimiento;
    }
    
}