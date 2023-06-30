package org.example.entity;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String Nombre;
    @Column(name = "stock")
    private boolean Stock;
    @OneToOne
    private DocumentoAlmacenado Foto;

    public Categoria(int id, String nombre, boolean stock, DocumentoAlmacenado foto) {
        this.id = id;
        Nombre = nombre;
        Stock = stock;
        Foto = foto;
    }

    public Categoria() {

    }

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

    public boolean isStock() {
        return Stock;
    }

    public void setStock(boolean stock) {
        Stock = stock;
    }

    public DocumentoAlmacenado getFoto() {
        return Foto;
    }

    public void setFoto(DocumentoAlmacenado foto) {
        Foto = foto;
    }
}
