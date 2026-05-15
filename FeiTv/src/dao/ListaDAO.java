package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ListaReproducao; 
import model.Video;
import model.Filme;
import model.Serie;
import model.Usuario;

public class ListaDAO {

    private Connection conn;

    public ListaDAO(Connection conn) {
        this.conn = conn;
    }

    public List<ListaReproducao> buscarListasDoUsuario(String usuarioId) throws SQLException {
        List<ListaReproducao> listas = new ArrayList<>();
        String sql = "SELECT * FROM tblistas WHERE usuario_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id_lista");
                    String nome = rs.getString("nome");
                    // Mudámos o nome da variável aqui para idDono para não dar conflito!
                    String idDono = rs.getString("usuario_id");

                    Usuario dono = new Usuario();
                    dono.setUsuario(idDono);

                    ListaReproducao l = new ListaReproducao(id, nome, dono);
                    listas.add(l);
                }
            }
        }
        return listas;
    }

    public void criarNovaLista(String nome, String usuarioId) throws SQLException {
        String sql = "INSERT INTO tblistas (nome, usuario_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, usuarioId);
            stmt.execute();
        }
    }

    public void inserirVideoNaLista(int idLista, int idVideo) throws SQLException {
        String sql = "INSERT INTO tblista_video (id_lista, id_video) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLista);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    public void removerVideoDaLista(int idLista, int idVideo) throws SQLException {
        String sql = "DELETE FROM tblista_video WHERE id_lista = ? AND id_video = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLista);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    public void excluirLista(int idLista) throws SQLException {
        String sqlRelacao = "DELETE FROM tblista_video WHERE id_lista = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sqlRelacao)) {
            stmt.setInt(1, idLista);
            stmt.execute();
        }

        String sqlLista = "DELETE FROM tblistas WHERE id_lista = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sqlLista)) {
            stmt.setInt(1, idLista);
            stmt.execute();
        }
    }

    public List<Video> listarVideosPorLista(int idLista) throws SQLException {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT v.* FROM tbvideos v "
                + "JOIN tblista_video lv ON v.id = lv.id_video "
                + "WHERE lv.id_lista = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLista);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Video v;

                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    int curtidas = rs.getInt("curtidas");
                    int descurtidas = rs.getInt("descurtidas");

                    String tipo = rs.getString("tipo");

                    if ("Filme".equals(tipo)) {
                        int duracao = rs.getInt("duracao");
                        v = new Filme(id, titulo, duracao);
                    } else {
                        int temporadas = rs.getInt("temporadas");
                        v = new Serie(id, titulo, temporadas);
                    }

                    v.setCurtidas(curtidas);
                    v.setDescurtidas(descurtidas);

                    videos.add(v);
                }
            }
        }
        return videos;
    }
}
