package crud.spring.sgr.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    private int cc;
    private String pass;
    private String nombre;
    private String apellido;
    private String genero;
    private String email;

    // Constructor 
    public Usuario() {
    }

    // Constructor con los atributos
    public Usuario(int cc, String pass, String nombre, String apellido, String genero, String email) {
        this.cc = cc;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
    }

    // Getters y setters

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}