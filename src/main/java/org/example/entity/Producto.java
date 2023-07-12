package org.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String nombre;
    @Column(length = 100)
    private String medida;

    @Column(length = 20)
    private String documento;
    @Column
    private int stock;
    @Column(length = 80)
    private String razonSocial;
    @Column
    private Double precio;
    @Column(length = 1000)
    private String descripcion;
    @OneToOne
    private Categoria categoria;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int cantidad) {
        this.stock = cantidad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
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
