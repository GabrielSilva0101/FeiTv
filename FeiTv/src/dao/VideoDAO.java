package dao;

import model.Video;
import model.Filme; 
import model.Serie; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }
    

    // Funcionalidade: Buscar vídeo por nome e Listar informações
    public List<Video> buscarPorNome(String termoBusca) throws SQLException {
        List<Video> videosEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM tbvideos WHERE titulo ILIKE ?"; 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + termoBusca + "%");
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            Video v;
            String tipo = rs.getString("tipo");
            
            // Aplicação prática de Polimorfismo
            if (tipo.equalsIgnoreCase("Filme")) {
                v = new Filme(rs.getInt("id"), rs.getString("titulo"), rs.getInt("duracao"));
            } else {
                v = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("temporadas"));
            }
            
            v.setCurtidas(rs.getInt("curtidas"));
            v.setDescurtidas(rs.getInt("descurtidas"));
            videosEncontrados.add(v);
        }
        statement.close();
        return videosEncontrados;
    }

    // Funcionalidade: Curtir vídeo
    public void adicionarCurtida(int idVideo) throws SQLException {
        String sql = "UPDATE tbvideos SET curtidas = curtidas + 1 WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idVideo);
        statement.execute();
        statement.close();
    }

    // Funcionalidade: Descurtir vídeo
    public void adicionarDescurtida(int idVideo) throws SQLException {
        String sql = "UPDATE tbvideos SET descurtidas = descurtidas + 1 WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idVideo);
        statement.execute();
        statement.close();
    }
    
    
}