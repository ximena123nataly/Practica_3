/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMERGENTES;



public class registro {
    private int id;
    private String  fecha;
    private String nombre;
    private String apellido;
    private String turno;
    private String seminarios;

    public registro() {
        this.id = 0;
        this.fecha = "";
        this.nombre = "";
        this.apellido = "";
        this.turno = "";
        this.seminarios = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

    public String toString() {
        return "registro{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", apellidos=" + apellido + ", turno=" + turno + ", seminario=" + seminarios + '}';
    }

  
    
}
