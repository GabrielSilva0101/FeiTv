package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleUsuario {

    
    public void cadastrarUsuario(String nome, String user, String senha) {
        Usuario novoUsuario = new Usuario(nome, user, senha);
        Conexao conexao = new Conexao();
        
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(novoUsuario);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
        }
    }

    public Usuario fazerLogin(String user, String senha) {
        Usuario usuario = new Usuario(null, user, senha);
        Conexao conexao = new Conexao();
        
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            if (dao.consultar(usuario).next()) {
                JOptionPane.showMessageDialog(null, "Login efetuado!");
                return usuario; // Retorna o usuário para manter a sessão na Tela Principal
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + ex.getMessage());
        }
        return null;
    }
}