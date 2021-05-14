package com.unla.oo22021.entities;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "tipoDni")
    private String tipoDni;

    @Column(name = "nroDni")
    private long nroDni;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private User user;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String tipoDni, long nroDni, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.nroDni = nroDni;
        this.email = email;
    }

    public Persona(String nombre, String apellido, String tipoDni, long nroDni, String email) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}