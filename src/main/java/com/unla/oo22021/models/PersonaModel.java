package com.unla.oo22021.models;

public class PersonaModel {

    private long id;
    private String nombre;
    private String apellido;
    private String tipoDni;
    private long nroDni;
    private String email;
    private UserModel userModel;

    public PersonaModel() {
    }

    public PersonaModel(long id, String nombre, String apellido, String tipoDni, long nroDni, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.nroDni = nroDni;
        this.email = email;
    }

    public PersonaModel(String nombre, String apellido, String tipoDni, long nroDni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.nroDni = nroDni;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public long getNroDni() {
        return nroDni;
    }

    public void setNroDni(long nroDni) {
        this.nroDni = nroDni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}