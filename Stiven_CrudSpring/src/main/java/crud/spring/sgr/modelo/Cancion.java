package crud.spring.sgr.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cancion {
    @Id
    private int id;
    private String nombre;
    private String ritmo;
    private String duracion;
    private String album;
    private String posicionenalbum;
    private String banda;
    private String interprete;
    private String autor;
    private String fechalanzamiento;
    private int usuariocc;

    public Cancion() {
    }

    public Cancion(int id, String nombre, String ritmo, String duracion, String album, String posicionenalbum, String banda,
                   String interprete, String autor, String fechalanzamiento, int usuariocc) {
        this.id = id;
        this.nombre = nombre;
        this.ritmo = ritmo;
        this.duracion = duracion;
        this.album = album;
        this.posicionenalbum = posicionenalbum;
        this.banda = banda;
        this.interprete = interprete;
        this.autor = autor;
        this.fechalanzamiento = fechalanzamiento;
        this.usuariocc = usuariocc;
    }

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

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPosicionenalbum() {
        return posicionenalbum;
    }

    public void setPosicionenalbum(String posicionenalbum) {
        this.posicionenalbum = posicionenalbum;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(String fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }

    public int getUsuariocc() {
        return usuariocc;
    }

    public void setUsuariocc(int usuariocc) {
        this.usuariocc = usuariocc;
    }
}
