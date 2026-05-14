/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Filme extends Video {
    private int duracaoMinutos;

    
    public Filme(int id, String titulo) {
        super(id, titulo);
    }

  

    public Filme(int id, String titulo, int duracaoMinutos) {
        super(id, titulo);
        this.duracaoMinutos = duracaoMinutos;
    }
    
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
}