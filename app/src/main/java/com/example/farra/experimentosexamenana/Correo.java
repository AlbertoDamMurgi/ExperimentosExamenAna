package com.example.farra.experimentosexamenana;

/**
 * Created by Farra on 11/12/2017.
 */

public class Correo {

    private String remitente;
    private String asunto;
    private String contenido;
    private int imagencontacto;

    public Correo(String remitente, String asunto, String contenido, int imagencontacto) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.imagencontacto = imagencontacto;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getImagencontacto() {
        return imagencontacto;
    }

    public void setImagencontacto(int imagencontacto) {
        this.imagencontacto = imagencontacto;
    }
}
