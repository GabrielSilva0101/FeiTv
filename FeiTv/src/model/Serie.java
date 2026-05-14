/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Serie extends Video implements Situacao {
    private int temporadas;
    private String statusAtual;

    public Serie(int id, String titulo) {
        super(id, titulo);
    }

    public Serie(int id, String titulo, int temporadas) {
        super(id, titulo);
        this.temporadas = temporadas;
        this.statusAtual = "Em andamento";
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    @Override
    public String getStatus() { return statusAtual; }

    @Override
    public void setStatus(String status) { this.statusAtual = status; }
}
