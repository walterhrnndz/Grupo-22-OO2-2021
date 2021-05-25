package com.unla.Grupo22OO22021.models;

import com.unla.Grupo22OO22021.entities.User;

public class PersonaModel {

    private int id;
    private String nombre;
    private String apellido;
    private String tipoDni;
    private long dni;
    private String email;
    private User user;
    private String userRole;

    public PersonaModel(int id, String nombre, String apellido, String tipoDni, long dni, String email, User user) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.email = email;
        this.user = user;
    }

    public PersonaModel(String nombre, String apellido, String tipoDni, long dni, String email, User user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.email = email;
        this.user = user;
    }

    public PersonaModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
