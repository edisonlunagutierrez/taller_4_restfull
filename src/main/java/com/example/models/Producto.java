package com.example.models;

import com.sun.istack.NotNull;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; // Agregamos la importación para @Id
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@XmlRootElement
public class Producto {

    @Id // Agregamos la anotación @Id para definir la clave primaria
    private Long id; // Agregamos el campo de clave primaria

    private String nombre;
    private String marca;

    @NotNull
    @Column(name = "fecha_compra", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaCompra;

    @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;

    public Producto() {
    }

    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }

    @PrePersist
    private void creationTimestamp() {
        Calendar now = Calendar.getInstance();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public Long getId() { // Agregamos el getter para el campo de clave primaria
        return id;
    }

    public void setId(Long id) { // Agregamos el setter para el campo de clave primaria
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
