package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RespNoExitosa implements Respuesta {
    private String codigo;
    private String error;
    public RespNoExitosa(String codigo, String error){
        this.codigo = codigo;
        this.error = error;
    }
    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }
    
}