package org.example.entity;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String Nombres;
    @Column(length = 100)
    private String ApellidoPaterno;
    @Column(length = 100)
    private String ApellidoMaterno;
    @Column(length = 20)
    private String TipoDoc;
    @Column(length = 11)
    private String NumDoc;
    @Column(length = 500)
    private String DireccionEnvio;
    @Column(length = 100)
    private String Departamento;
    @Column(length = 100)
    private String Provincia;
    @Column(length = 100)
    private String Distrito;
    @Column(length = 9)
    private String Telefono;
    @OneToOne
    private DocumentoAlmacenado Foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        TipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String numDoc) {
        NumDoc = numDoc;
    }

    public String getDireccionEnvio() {
        return DireccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        DireccionEnvio = direccionEnvio;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public DocumentoAlmacenado getFoto() {
        return Foto;
    }

    public void setFoto(DocumentoAlmacenado foto) {
        Foto = foto;
    }

    public String getNombreCompletoCiente(){
        return this.Nombres != null && this.ApellidoPaterno != null && this.ApellidoMaterno != null ?
                this.Nombres + " " + this.ApellidoPaterno + " " + this.ApellidoMaterno: "-----";
    }

}