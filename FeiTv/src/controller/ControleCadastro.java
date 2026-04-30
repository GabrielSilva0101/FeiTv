/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao. UsuarioDAO;
import dao.ConexaoUsuarios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuarios;
import view.Cadastro;


public class ControleCadastro {
    
    private Cadastro tela3;
    
    public ControleCadastro(Cadastro tela3){
        this.tela3= tela3;
    }
    
    
    public void salvarUsuario(){
        String nome = tela3.getTxt_nome().getText();
        String usuario = tela3.getTxt_usuario().getText();
        String senha = tela3.getTxt_senha().getText();
        Usuarios usuarios = new Usuarios(nome, usuario, senha);
        
        
        ConexaoUsuarios conexao = new ConexaoUsuarios();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(usuarios);
            JOptionPane.showMessageDialog(tela3,"Usuario Cadastrado", "Aviso",
                                            JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(tela3, "Usuario não cadastrado!", "Erro",
                                            JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
