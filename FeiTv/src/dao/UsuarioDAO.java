package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    // Funcionalidade: Cadastrar novo usuário
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tbusuarios (nome, usuario, senha) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getUsuario());
        statement.setString(3, usuario.getSenha());
        statement.execute();
        statement.close();
    }

    // Funcionalidade: Login de usuário
    public ResultSet consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM tbusuarios WHERE usuario = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        // O ResultSet é retornado para o Controller verificar se achou alguém
        return statement.executeQuery(); 
    }
}