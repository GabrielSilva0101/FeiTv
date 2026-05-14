package controller;

import dao.VideoDAO;
import dao.ListaDAO;
import dao.Conexao;
import model.Video;
import model.ListaReproducao;
import model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class ControlePlataforma {

    public void buscarVideo(String nome) {
        // Implementar lógica de busca chamando VideoDAO.buscar(nome)
        // e atualizando a JTable ou JList na View
    }

    public void interagirVideo(int idVideo, boolean isCurtida) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            if (isCurtida) {
                dao.adicionarCurtida(idVideo);
                JOptionPane.showMessageDialog(null, "Você curtiu este vídeo!");
            } else {
                dao.adicionarDescurtida(idVideo);
                JOptionPane.showMessageDialog(null, "Você descurtiu este vídeo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar interação.");
        }
    }

    public void criarLista(String nomeLista, Usuario dono) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            dao.criarNovaLista(nomeLista, dono.getUsuario());
            JOptionPane.showMessageDialog(null, "Lista '" + nomeLista + "' criada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar lista.");
        }
    }

    public List<Video> listarVideos(String termoBusca) {
        Conexao conexao = new Conexao();
        List<Video> resultados = new ArrayList<>();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            resultados = dao.buscarPorNome(termoBusca);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vídeos: " + ex.getMessage());
        }
        return resultados;
    }

    // Adiciona ou remove o vídeo na tabela de relacionamento Lista_Video
    public void gerenciarVideoNaLista(int idLista, int idVideo, boolean adicionar) {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);

            if (adicionar) {
                dao.inserirVideoNaLista(idLista, idVideo);
                JOptionPane.showMessageDialog(null, "Vídeo adicionado aos favoritos!");
            } else {
                dao.removerVideoDaLista(idLista, idVideo);
                JOptionPane.showMessageDialog(null, "Vídeo removido dos favoritos.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar playlist.");
        }
    }

    // Retorna todos os vídeos que estão dentro de uma playlist específica
    public List<Video> listarVideosDaPlaylist(int idLista) {
        Conexao conexao = new Conexao();
        List<Video> videos = new ArrayList<>();
        try {
            Connection conn = conexao.getConnection();
            ListaDAO dao = new ListaDAO(conn);
            videos = dao.listarVideosPorLista(idLista);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a playlist.");
        }
        return videos;
    }

    // Retorna o ResultSet para a View popular o JComboBox
    public java.util.List<model.ListaReproducao> listarMinhasPlaylists(String usuarioId) {
        dao.Conexao conexao = new dao.Conexao();
        try {
            java.sql.Connection conn = conexao.getConnection();
            dao.ListaDAO dao = new dao.ListaDAO(conn);
            return dao.buscarListasDoUsuario(usuarioId);
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao carregar playlists.");
            return new java.util.ArrayList<>();
        }
    }

    public void excluirLista(int idLista) {
        dao.Conexao conexao = new dao.Conexao();
        try {
            java.sql.Connection conn = conexao.getConnection();
            dao.ListaDAO dao = new dao.ListaDAO(conn);
            dao.excluirLista(idLista);
            javax.swing.JOptionPane.showMessageDialog(null, "Playlist excluída com sucesso!");
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir playlist: " + ex.getMessage());
        }
    }
}
