package br.com.tech4me.tech4music.shared;

public class MusicaDto {
    private String id;
    private String titulo;
    private String artista;

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
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    @Override
    public String toString() {
        return "\nMusica: titulo: " + titulo + "\nartista: " + artista +"\nid: "+ id;
    }

    

}
