package com.example.tarea3.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "administradores", schema = "public", catalog = "Jugueton")
public class AdministradoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_admin", nullable = false)
    private Integer idAdmin;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 50)
    private String apellido;
    @Basic
    @Column(name = "usuario", nullable = true, length = 25)
    private String usuario;
    @Basic
    @Column(name = "contrasenia", nullable = true, length = 25)
    private String contrasenia;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministradoresEntity that = (AdministradoresEntity) o;

        if (!Objects.equals(idAdmin, that.idAdmin)) return false;
        if (!Objects.equals(nombre, that.nombre)) return false;
        if (!Objects.equals(apellido, that.apellido)) return false;
        if (!Objects.equals(usuario, that.usuario)) return false;
        if (!Objects.equals(contrasenia, that.contrasenia)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdmin != null ? idAdmin.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasenia != null ? contrasenia.hashCode() : 0);
        return result;
    }
}
