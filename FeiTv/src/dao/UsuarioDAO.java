/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuarios;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet consultar(Usuarios usuarios) throws SQLException {
        String sql = "select * from tbusuarios where usuario = ? and senha =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuarios.getUsuario());
        statement.setString(2, usuarios.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;

    }

    public void inserir(Usuarios usuarios) throws SQLException {
        String sql = "insert into tbusuarios (nome, usuario, senha) values ('"
                + usuarios.getNome() + "','"
                + usuarios.getUsuario() + "','"
                + usuarios.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();

    }

}
