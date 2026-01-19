package org.example.model;

import jakarta.persistence.*;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Perfil perfil;

    public Usuario() {}

    public Usuario(String nombre, Perfil perfil) {
        this.nombre = nombre;
        this.perfil = perfil;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", perfil=" + perfil + "]";
    }
}
