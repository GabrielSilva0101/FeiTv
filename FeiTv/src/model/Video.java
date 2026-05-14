/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabri
 */
public abstract class Video {
    private int id;
    private String titulo;
    private int curtidas;
    private int descurtidas;

    public Video(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.curtidas = 0;
        this.descurtidas = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public int getDescurtidas() {
        return descurtidas;
    }

    public void setDescurtidas(int descurtidas) {
        this.descurtidas = descurtidas;
    }

    
   
}