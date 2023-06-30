package org.example.entity;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Color.ColoresEnum colores;
    public enum ColoresEnum {
        Negro,
        Blanco,
        Plomo
    }
    @Column(length = 30)
    private int Disponibilidad;
    @OneToOne
    @MapsId
    private Producto producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ColoresEnum getColores() {
        return colores;
    }

    public void setColores(ColoresEnum colores) {
        this.colores = colores;
    }

    public int getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        Disponibilidad = disponibilidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
