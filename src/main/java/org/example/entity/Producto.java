package org.example.entity;

import javax.persistence.*;
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String Nombre;
    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private MedidaEnum Medida;
    public enum MedidaEnum {
        Unidades,
        Caja
    }
    @Column(length = 20)
    private String Documento;
    @Column
    private int Cantidad;
    @Column(length = 80)
    private String RazonSocial;
    @Column
    private int Precio;
    @Column(length = 1000)
    private String Descripcion;

    @Column(length = 40)
    private String Color;
    @OneToOne
    private Categoria Categoria;
    @Column
    private boolean Stock;
    @Column
    private boolean vigencia;
    @Column
    private boolean recomendado;
    @OneToOne
    private DocumentoAlmacenado Foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public MedidaEnum getMedida() {
        return Medida;
    }

    public void setMedida(MedidaEnum medida) {
        Medida = medida;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.Categoria = categoria;
    }

    public boolean isStock() {
        return Stock;
    }

    public void setStock(boolean stock) {
        Stock = stock;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public DocumentoAlmacenado getFoto() {
        return Foto;
    }

    public void setFoto(DocumentoAlmacenado foto) {
        Foto = foto;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }
}
