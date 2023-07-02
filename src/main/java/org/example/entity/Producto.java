package org.example.entity;

import javax.persistence.*;
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String nombre;
    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private MedidaEnum medida;
    public enum MedidaEnum {
        Unidades,
        Caja
    }
    @Column(length = 20)
    private String documento;
    @Column
    private int cantidad;
    @Column(length = 80)
    private String razonsocial;
    @Column
    private int precio;
    @Column(length = 1000)
    private String descripcion;

    @Column(length = 40)
    private String color;
    @OneToOne
    private Categoria categoria;
    @Column
    private boolean stock;
    @Column
    private boolean vigencia;
    @Column
    private boolean recomendado;
    @OneToOne
    private DocumentoAlmacenado foto;

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

    public MedidaEnum getMedida() {
        return medida;
    }

    public void setMedida(MedidaEnum medida) {
        this.medida = medida;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public DocumentoAlmacenado getFoto() {
        return foto;
    }

    public void setFoto(DocumentoAlmacenado foto) {
        this.foto = foto;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }
}
