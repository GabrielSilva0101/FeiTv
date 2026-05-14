package model;



import java.util.ArrayList;
import java.util.List;

public class ListaReproducao {
    private int id;
    private String nome;
    private Usuario dono;
    private List<Video> videos;

    public ListaReproducao(int id, String nome, Usuario dono) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.videos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

   
}