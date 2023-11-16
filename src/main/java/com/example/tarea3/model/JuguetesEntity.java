package com.example.tarea3.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "juguetes", schema = "public", catalog = "Jugueton")
public class JuguetesEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "precio", nullable = true)
    private BigDecimal precio;
    @Basic
    @Column(name = "cantidad", nullable = true)
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuguetesEntity that = (JuguetesEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(precio, that.precio)) return false;
        if (!Objects.equals(cantidad, that.cantidad)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
