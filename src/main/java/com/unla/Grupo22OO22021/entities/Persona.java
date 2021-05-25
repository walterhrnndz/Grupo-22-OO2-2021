package com.unla.Grupo22OO22021.entities;

import javax.persistence.*;

@Entity
@Table(name = "persona", uniqueConstraints = @UniqueConstraint(columnNames = {"dni", "email"}))
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "tipo_dni")
    private String tipoDni;

    @Column(name = "dni", unique = true)
    private long dni;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String tipoDni, long dni, String email, User user) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.email = email;
        this.user = user;
    }

    public Persona(String nombre, String apellido, String tipoDni, long dni, String email, User user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.email = email;
        this.user = user;
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
}
