/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControlePlataforma;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Filme;
import model.Serie;
import model.Usuario;
import model.Video;

/**
 *
 * @author gabri
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);

        this.usuarioLogado = usuario;
        this.controle = new ControlePlataforma();

        if (lbl_ola != null) {
            lbl_ola.setText("Olá, " + usuario.getNome());
        }
        carregarPlaylists();
    }

    private void carregarPlaylists() {
        // Onde você carrega as playlists na tela:
        java.util.List<model.ListaReproducao> listas = controle.listarMinhasPlaylists(usuarioLogado.getUsuario());
        cbPlaylist.removeAllItems(); // Limpa as antigas

        // Percorre a lista e adiciona uma por uma no ComboBox
        for (model.ListaReproducao lista : listas) {
            // Adiciona no formato "ID - Nome" para você conseguir pegar o ID depois na hora de salvar!
            cbPlaylist.addItem(lista.getId() + " - " + lista.getNome());
        }
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public ControlePlataforma getControle() {
        return controle;
    }

    public void setControle(ControlePlataforma controle) {
        this.controle = controle;
    }

    public JButton getBtn_addplaylist() {
        return btn_addplaylist;
    }

    public void setBtn_addplaylist(JButton btn_addplaylist) {
        this.btn_addplaylist = btn_addplaylist;
    }

    public JButton getBtn_curtir() {
        return btn_curtir;
    }

    public void setBtn_curtir(JButton btn_curtir) {
        this.btn_curtir = btn_curtir;
    }

    public JButton getBtn_descurtir() {
        return btn_descurtir;
    }

    public void setBtn_descurtir(JButton btn_descurtir) {
        this.btn_descurtir = btn_descurtir;
    }

    public JButton getBtn_excluirPlaylist() {
        return btn_excluirPlaylist;
    }

    public void setBtn_excluirPlaylist(JButton btn_excluirPlaylist) {
        this.btn_excluirPlaylist = btn_excluirPlaylist;
    }

    public JButton getBtn_novaPlaylist() {
        return btn_novaPlaylist;
    }

    public void setBtn_novaPlaylist(JButton btn_novaPlaylist) {
        this.btn_novaPlaylist = btn_novaPlaylist;
    }

    public JButton getBtn_pesquisar() {
        return btn_pesquisar;
    }

    public void setBtn_pesquisar(JButton btn_pesquisar) {
        this.btn_pesquisar = btn_pesquisar;
    }

    public JButton getBtn_removerVideo() {
        return btn_removerVideo;
    }

    public void setBtn_removerVideo(JButton btn_removerVideo) {
        this.btn_removerVideo = btn_removerVideo;
    }

    public JButton getBtn_sair() {
        return btn_sair;
    }

    public void setBtn_sair(JButton btn_sair) {
        this.btn_sair = btn_sair;
    }

    public JComboBox<String> getCbPlaylist() {
        return cbPlaylist;
    }

    public void setCbPlaylist(JComboBox<String> cbPlaylist) {
        this.cbPlaylist = cbPlaylist;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JLabel getLbl_buscar() {
        return lbl_buscar;
    }

    public void setLbl_buscar(JLabel lbl_buscar) {
        this.lbl_buscar = lbl_buscar;
    }

    public JLabel getLbl_feitv() {
        return lbl_feitv;
    }

    public void setLbl_feitv(JLabel lbl_feitv) {
        this.lbl_feitv = lbl_feitv;
    }

    public JLabel getLbl_ola() {
        return lbl_ola;
    }

    public void setLbl_ola(JLabel lbl_ola) {
        this.lbl_ola = lbl_ola;
    }

    public JTable getTabelaPlaylist() {
        return tabelaPlaylist;
    }

    public void setTabelaPlaylist(JTable tabelaPlaylist) {
        this.tabelaPlaylist = tabelaPlaylist;
    }

    public JTable getTabelaVideos() {
        return tabelaVideos;
    }

    public void setTabelaVideos(JTable tabelaVideos) {
        this.tabelaVideos = tabelaVideos;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(JTextField txt_buscar) {
        this.txt_buscar = txt_buscar;
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPlaylist = new javax.swing.JComboBox<>();
        btn_novaPlaylist = new javax.swing.JButton();
        btn_removerVideo = new javax.swing.JButton();
        btn_excluirPlaylist = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPlaylist = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        lbl_buscar = new javax.swing.JLabel();
        btn_curtir = new javax.swing.JButton();
        btn_pesquisar = new javax.swing.JButton();
        btn_descurtir = new javax.swing.JButton();
        btn_addplaylist = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVideos = new javax.swing.JTable();
        lbl_feitv = new javax.swing.JLabel();
        btn_sair = new javax.swing.JButton();
        lbl_ola = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Selecione a Playlist");

        cbPlaylist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPlaylist.addActionListener(this::cbPlaylistActionPerformed);

        btn_novaPlaylist.setText("[   Nova Playlist   ]");
        btn_novaPlaylist.addActionListener(this::btn_novaPlaylistActionPerformed);

        btn_removerVideo.setText("[   Remover Vídeo dos favoritos  ]");
        btn_removerVideo.addActionListener(this::btn_removerVideoActionPerformed);

        btn_excluirPlaylist.setText("[   Excluir Lista   ]");
        btn_excluirPlaylist.addActionListener(this::btn_excluirPlaylistActionPerformed);

        tabelaPlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Tipo", "Duração/Tempo", "Curtidas", "Descurtidas"
            }
        ));
        jScrollPane3.setViewportView(tabelaPlaylist);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_novaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(btn_excluirPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btn_removerVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novaPlaylist)
                    .addComponent(btn_excluirPlaylist)
                    .addComponent(btn_removerVideo))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Favoritos", jPanel2);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_buscar.setText("Buscar");

        btn_curtir.setText("[     Curtir      ]");
        btn_curtir.addActionListener(this::btn_curtirActionPerformed);

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(this::btn_pesquisarActionPerformed);

        btn_descurtir.setText("[       Descurtir     ]");
        btn_descurtir.addActionListener(this::btn_descurtirActionPerformed);

        btn_addplaylist.setText("[   Adicionar aos Favoritos ]");
        btn_addplaylist.setActionCommand("[   Adicionar à Playlist   ]");
        btn_addplaylist.addActionListener(this::btn_addplaylistActionPerformed);

        tabelaVideos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Tipo", "Duração/Tempo", "Curtidas", "Descurtidas"
            }
        ));
        jScrollPane2.setViewportView(tabelaVideos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbl_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_curtir, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btn_descurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(btn_addplaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_buscar)
                    .addComponent(btn_pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addplaylist)
                    .addComponent(btn_descurtir)
                    .addComponent(btn_curtir)))
        );

        jTabbedPane1.addTab("Explorar Vídeos", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 470));

        lbl_feitv.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_feitv.setText("Fei Tv");
        getContentPane().add(lbl_feitv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btn_sair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_sair.setContentAreaFilled(false);
        btn_sair.addActionListener(this::btn_sairActionPerformed);
        getContentPane().add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 60, -1));

        lbl_ola.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lbl_ola.setText("Olá...");
        getContentPane().add(lbl_ola, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-470, 0, 1280, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaPlaylistActionPerformed
        String nomeLista = JOptionPane.showInputDialog("Nome da nova Playlist:");
        if (nomeLista != null && !nomeLista.trim().isEmpty()) {
            controle.criarLista(nomeLista, usuarioLogado);
            carregarPlaylists();
        }
    }//GEN-LAST:event_btn_novaPlaylistActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        String busca = txt_buscar.getText();
        List<Video> lista = controle.listarVideos(busca);

        DefaultTableModel model = (DefaultTableModel) tabelaVideos.getModel();
        model.setNumRows(0);

        for (Video v : lista) {
            String duracaoOuTempo = (v instanceof Filme) ? ((Filme) v).getDuracaoMinutos() + " min" : ((Serie) v).getTemporadas() + " temp";
            model.addRow(new Object[]{
                v.getId(), v.getTitulo(), v.getClass().getSimpleName(), duracaoOuTempo, v.getCurtidas(), v.getDescurtidas()
            });
        }


    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_curtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_curtirActionPerformed
        int linha = tabelaVideos.getSelectedRow();
        if (linha >= 0) {
            int idVideo = (int) tabelaVideos.getValueAt(linha, 0);
            controle.interagirVideo(idVideo, true);
            btn_pesquisarActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um vídeo primeiro!");
        }
    }//GEN-LAST:event_btn_curtirActionPerformed

    private void btn_descurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_descurtirActionPerformed
        int linha = tabelaVideos.getSelectedRow();
        if (linha >= 0) {
            int idVideo = (int) tabelaVideos.getValueAt(linha, 0);
            controle.interagirVideo(idVideo, false);
            btn_pesquisarActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um vídeo primeiro!");
        }
    }//GEN-LAST:event_btn_descurtirActionPerformed

    private void btn_addplaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addplaylistActionPerformed
        int linha = tabelaVideos.getSelectedRow();
        if (linha >= 0) {
            if (cbPlaylist.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Crie uma playlist na Aba 2 primeiro!");
                return;
            }
            int idVideo = (int) tabelaVideos.getValueAt(linha, 0);
            int idLista = Integer.parseInt(cbPlaylist.getSelectedItem().toString().split(" - ")[0]);
            controle.gerenciarVideoNaLista(idLista, idVideo, true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um vídeo!");
        }

    }//GEN-LAST:event_btn_addplaylistActionPerformed

    private void btn_excluirPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirPlaylistActionPerformed
        if (cbPlaylist.getSelectedItem() == null) {
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Excluir esta playlist?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int idLista = Integer.parseInt(cbPlaylist.getSelectedItem().toString().split(" - ")[0]);
            controle.excluirLista(idLista);
            carregarPlaylists();
            ((DefaultTableModel) tabelaPlaylist.getModel()).setNumRows(0);
        }

    }//GEN-LAST:event_btn_excluirPlaylistActionPerformed

    private void btn_removerVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerVideoActionPerformed
        int linha = tabelaPlaylist.getSelectedRow();
        if (linha >= 0 && cbPlaylist.getSelectedItem() != null) {
            int idVideo = (int) tabelaPlaylist.getValueAt(linha, 0);
            int idLista = Integer.parseInt(cbPlaylist.getSelectedItem().toString().split(" - ")[0]);
            controle.gerenciarVideoNaLista(idLista, idVideo, false);
            cbPlaylistActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um vídeo na playlist!");
        }

    }//GEN-LAST:event_btn_removerVideoActionPerformed

    private void cbPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlaylistActionPerformed
        if (cbPlaylist.getSelectedItem() == null) {
            return;
        }
        int idLista = Integer.parseInt(cbPlaylist.getSelectedItem().toString().split(" - ")[0]);
        List<Video> lista = controle.listarVideosDaPlaylist(idLista);
        DefaultTableModel model = (DefaultTableModel) tabelaPlaylist.getModel();
        model.setNumRows(0);
        for (Video v : lista) {
            String duracao = (v instanceof Filme) ? ((Filme) v).getDuracaoMinutos() + "m" : ((Serie) v).getTemporadas() + "t";
            model.addRow(new Object[]{v.getId(), v.getTitulo(), v.getClass().getSimpleName(), duracao, v.getCurtidas(), v.getDescurtidas()});
        }

    }//GEN-LAST:event_cbPlaylistActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed

        this.dispose();

        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_btn_sairActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
//    }
    private Usuario usuarioLogado;
    private ControlePlataforma controle;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addplaylist;
    private javax.swing.JButton btn_curtir;
    private javax.swing.JButton btn_descurtir;
    private javax.swing.JButton btn_excluirPlaylist;
    private javax.swing.JButton btn_novaPlaylist;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_removerVideo;
    private javax.swing.JButton btn_sair;
    private javax.swing.JComboBox<String> cbPlaylist;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_feitv;
    private javax.swing.JLabel lbl_ola;
    private javax.swing.JTable tabelaPlaylist;
    private javax.swing.JTable tabelaVideos;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
