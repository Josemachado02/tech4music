package br.com.tech4me.tech4music.model;





import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("musicas")
public class Musica {
    @Id
    private String id;
    @NotEmpty(message = "O titulo precisa ser preenchido")
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int anoLancamento;
    private String compositor;

    

    @Override
    public String toString() {
        return "MUSICA  \ntitulo: " + titulo + "\nartista: " + artista + "\nalbum: " + album + "\ngenero: "+ genero + "\nAno de lançameto: "+ anoLancamento +"\ncompositor: " + compositor + "\nid: " +id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoDeLancamento() {
        return anoLancamento;
    }
    public void setAnoDeLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}
