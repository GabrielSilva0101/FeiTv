/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;
import view.TelaLogin;
import view.TelaPrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ControleLogin {
    private TelaLogin telal;

    public ControleLogin(TelaLogin telal) {
        this.telal = telal;
    }
    
    public void loginUsuarios (){
        Usuario usuarios = new Usuario (null, telal.getTxt_usuario().getText(), telal.getTxt_senha().getText());
        Conexao conexao = new Conexao ();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuarios);
            if(res.next()){
            JOptionPane.showMessageDialog(telal, "Login Feito", "Aviso",
                                             JOptionPane.INFORMATION_MESSAGE);
            String nome = res.getString("nome");
            String usuario = res.getString("usuario");
            String senha = res.getString("senha");
            
            TelaPrincipal tela2 = new TelaPrincipal (new Usuario(nome, usuario, senha));
            tela2.setVisible(true);
            telal.setVisible(false);            
            } else {
                JOptionPane.showMessageDialog(telal, "Login não efetuado", "ERRO",
                                                JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            
            System.out.println("O erro real é: " + e.getMessage());
            
            JOptionPane.showMessageDialog(telal, "Erro de conexão", "Erro",
                                            JOptionPane.ERROR_MESSAGE);
        
        }
    }
    
}
