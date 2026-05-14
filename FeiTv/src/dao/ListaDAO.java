package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ListaReproducao; // Nome do seu modelo atualizado
import model.Video;
import model.Filme;
import model.Serie;
import model.Usuario;

public class ListaDAO {

    private Connection conn;

    public ListaDAO(Connection conn) {
        this.conn = conn;
    }

    // 1. Buscar listas do utilizador (Resolve o erro de conexão ao abrir a tela)
    public List<ListaReproducao> buscarListasDoUsuario(String usuarioId) throws SQLException {
        List<ListaReproducao> listas = new ArrayList<>();
        // O SQL usa a tabela tblistas que criamos no pgAdmin
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

    // 2. Criar nova lista
    public void criarNovaLista(String nome, String usuarioId) throws SQLException {
        String sql = "INSERT INTO tblistas (nome, usuario_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, usuarioId);
            stmt.execute();
        }
    }

    // 3. Adicionar vídeo à lista (Tabela de ligação tblista_video)
    public void inserirVideoNaLista(int idLista, int idVideo) throws SQLException {
        String sql = "INSERT INTO tblista_video (id_lista, id_video) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLista);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    // 4. Remover vídeo da lista específica
    public void removerVideoDaLista(int idLista, int idVideo) throws SQLException {
        String sql = "DELETE FROM tblista_video WHERE id_lista = ? AND id_video = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLista);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    // 5. Eliminar a lista completa
    public void excluirLista(int idLista) throws SQLException {
        // Remove primeiro a ligação para evitar erro de Foreign Key
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

    // 6. Listar vídeos dentro de uma playlist (Aba 2)
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

                    // 1. Pegamos os dados comuns a todos os vídeos primeiro
                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    int curtidas = rs.getInt("curtidas");
                    int descurtidas = rs.getInt("descurtidas");

                    String tipo = rs.getString("tipo");

                    // 2. Criamos o objeto já passando os parâmetros que o construtor exige
                    if ("Filme".equals(tipo)) {
                        int duracao = rs.getInt("duracao");
                        // Cria o Filme passando (id, titulo, duracao) - Ajuste a ordem se no seu construtor for diferente
                        v = new Filme(id, titulo, duracao);
                    } else {
                        int temporadas = rs.getInt("temporadas");
                        // Cria a Serie passando (id, titulo, temporadas)
                        v = new Serie(id, titulo, temporadas);
                    }

                    // 3. Preenchemos o resto usando os setters normais
                    v.setCurtidas(curtidas);
                    v.setDescurtidas(descurtidas);

                    videos.add(v);
                }
            }
        }
        return videos;
    }
}
