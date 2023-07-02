package org.example.entity;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcolor;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Color.ColoresEnum colores;
    public enum ColoresEnum {
        Negro,
        Blanco,
        Plomo
    }
    @Column(length = 30)
    private int disponibilidad;
    @OneToOne
    @MapsId
    private Producto producto;

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public ColoresEnum getColores() {
        return colores;
    }

    public void setColores(ColoresEnum colores) {
        this.colores = colores;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
