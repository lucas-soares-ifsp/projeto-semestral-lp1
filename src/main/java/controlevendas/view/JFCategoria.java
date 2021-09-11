package controlevendas.view;

import controlevendas.data.CategoriaData;
import controlevendas.model.Categoria;
import controlevendas.utils.UtilsFormulario;
import controlevendas.utils.UtilsFrontEnd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JFCategoria extends javax.swing.JInternalFrame {
    private Categoria objCategoria;
    private CategoriaData objCategoriaData;
    private ArrayList<Categoria> categories;
    private int cod;

    public JFCategoria() {
        initComponents();        
        // INCIALIZANDO ATRIBUTOS
        this.objCategoria = new Categoria();
        this.objCategoriaData = new CategoriaData();
        this.categories = new ArrayList<>();
        this.cod=0;
        
        // INICIALIZANDO FUNCOES
        setStylesManual();
        getAllCategories();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDescricaoCategoria = new javax.swing.JTextArea();
        jlCodigoCategoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbEnviar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCategorias = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeCategoria = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        mensagemErro = new javax.swing.JButton();
        mensagemSucesso = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Categorias");
        setToolTipText("");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(124, 1000));
        setPreferredSize(new java.awt.Dimension(830, 880));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        jtfPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaActionPerformed(evt);
            }
        });
        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(jtfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 680, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 104, 255));
        jLabel6.setText("Descrição");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jtfDescricaoCategoria.setBackground(new java.awt.Color(255, 255, 255));
        jtfDescricaoCategoria.setColumns(20);
        jtfDescricaoCategoria.setRows(5);
        jtfDescricaoCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jScrollPane1.setViewportView(jtfDescricaoCategoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 680, 110));

        jlCodigoCategoria.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlCodigoCategoria.setForeground(new java.awt.Color(14, 104, 255));
        jlCodigoCategoria.setText("0");
        jlCodigoCategoria.setEnabled(false);
        getContentPane().add(jlCodigoCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 104, 255));
        jLabel1.setText("CATEGORIAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jbEnviar.setBackground(new java.awt.Color(14, 104, 255));
        jbEnviar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jbEnviar.setText("ENVIAR");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 170, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(14, 104, 255));
        jLabel11.setText("Pesquisar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jtCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Data Cadastro", "Descricao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCategorias.setRowHeight(30);
        jtCategorias.setShowGrid(true);
        jtCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCategorias);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 680, 140));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 104, 255));
        jLabel2.setText("CADASTRAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jtfNomeCategoria.setBackground(new java.awt.Color(255, 255, 255));
        jtfNomeCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfNomeCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfNomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jtfNomeCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 680, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 104, 255));
        jLabel12.setText("Nome");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jbExcluir.setBackground(new java.awt.Color(14, 104, 255));
        jbExcluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("EXCLUIR");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, 170, 40));

        jbEditar.setBackground(new java.awt.Color(14, 104, 255));
        jbEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbEditar.setText("EDITAR");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, 170, 40));

        mensagemErro.setBackground(new java.awt.Color(242, 195, 195));
        mensagemErro.setForeground(new java.awt.Color(255, 51, 51));
        mensagemErro.setText("Houve algum erro! Verifique se a categoria já é existente.");
        mensagemErro.setBorder(null);
        mensagemErro.setFocusPainted(false);
        getContentPane().add(mensagemErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 440, 40));

        mensagemSucesso.setBackground(new java.awt.Color(204, 255, 204));
        mensagemSucesso.setForeground(new java.awt.Color(0, 204, 51));
        mensagemSucesso.setText("Categoria salva com sucesso!");
        mensagemSucesso.setBorder(null);
        mensagemSucesso.setFocusPainted(false);
        getContentPane().add(mensagemSucesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 440, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed
        
    }//GEN-LAST:event_jtfPesquisaActionPerformed
    
    /****************************************************
     * CLIQUE BOTAO ENVIAR DADOS CATEGORIA
     ****************************************************/
    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
      try {
            // VERIFICANDO SE O OBJETO CATEGORIA FOI PREENCHIDO CORRETAMENTE
            if((!setValuesCategory()) || (!validateFields())) {
                mensagemErro.setText("Verifique se todos os campos foram preenchidos corretamente.");
                UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
                return;
            }

            // VERIFICANDO SE A LABEL DO CÓDIGO DA CATEGORIA É DIFERENTE DE 0
            // CASO SEJA, DEVE-SE REALIZAR A ATUALIZAÇÃO DA CATEGORIA
            if(Integer.parseInt(jlCodigoCategoria.getText()) != 0) {
                objCategoriaData.update(objCategoria);
                mensagemErro.setText("Categoria atualizada com sucesso!");
                manipulationSuccess();
                return;
            }
        
            // CADASTRANDO CATEGORIA
            objCategoriaData.insert(objCategoria);
            mensagemErro.setText("Categoria salva com sucesso!");
            manipulationSuccess();
        } catch (NumberFormatException | SQLException ex) {
            mensagemErro.setText("Houve algum erro! Verifique se a categoria já é existente.");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
            System.err.println("Erro ao criar categoria: " +ex);
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void jtfNomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeCategoriaActionPerformed
        
    }//GEN-LAST:event_jtfNomeCategoriaActionPerformed

    /****************************************************
     * CLIQUE BOTAO EXCLUIR CATEGORIA
     ****************************************************/
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            objCategoriaData.delete(Integer.parseInt(""+categories.get(jtCategorias.getSelectedRow()).getCodCategoria()));
            mensagemSucesso.setText("Categoria excluída com sucesso!");
            cleanRowsTable();
            manipulationSuccess();
            
        } catch (Exception ex) {
            mensagemSucesso.setText("Erro ao excluir categoria. Verifique se não existem produtos vinculados!");
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    /****************************************************
     * CLIQUE BOTAO EDITAR CATEGORIA
     ****************************************************/
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = jtCategorias.getSelectedRow();
        
        if(rowSelected < 0) return;
        jlCodigoCategoria.setText(""+categories.get(rowSelected).getCodCategoria());
        jtfNomeCategoria.setText(""+categories.get(rowSelected).getNome());
        jtfDescricaoCategoria.setText(""+categories.get(rowSelected).getDescricao());
    }//GEN-LAST:event_jbEditarActionPerformed

    /****************************************************
     * PESQUISANDO CATEGORIAS
     ****************************************************/
    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        try {
            this.categories = objCategoriaData.getCategories(jtfPesquisa.getText());
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    /****************************************************
     * CLIQUE NA TABELA
     ****************************************************/
    private void jtCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriasMouseClicked
        jbEditar.setEnabled(true);
        jbExcluir.setEnabled(true);        
    }//GEN-LAST:event_jtCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JLabel jlCodigoCategoria;
    private javax.swing.JTable jtCategorias;
    private javax.swing.JTextArea jtfDescricaoCategoria;
    private javax.swing.JTextField jtfNomeCategoria;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JButton mensagemErro;
    private javax.swing.JButton mensagemSucesso;
    // End of variables declaration//GEN-END:variables

    /**************************************************
     * FUNCOES PERSONLIZADAS
     *************************************************/
    private void setStylesManual() {
        jlCodigoCategoria.setVisible(false);
        mensagemErro.setVisible(false);
        mensagemSucesso.setVisible(false);
    }
    
    /**************************************************
     * SETANDO VALORES NA CATEGORIA
     *************************************************/
    private boolean setValuesCategory() {
        objCategoria.setCodCategoria(Integer.parseInt(jlCodigoCategoria.getText()));
        objCategoria.setNome(jtfNomeCategoria.getText());
        objCategoria.setDescricao(jtfDescricaoCategoria.getText());
        
        return true;
    }
    
    /**************************************************
     * BUSCANDO TODAS AS CATEGORIA
     *************************************************/
    private void getAllCategories() {
        try {
            // BUSCANDO OS DADOS E CHAMANDO FUNCAO DE ADICAO NA TABELA
            this.categories = objCategoriaData.getCategories();
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * ADICIONANDO CATEGORIAS NA TABELA
     *************************************************/
    private void addInTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jtCategorias.getModel();
        tableModel.setNumRows(0);
            
        categories.forEach(category -> {
            tableModel.addRow(new String[] {""+category.getCodCategoria(), 
                                            category.getNome(), 
                                            category.getDataCadastro(), 
                                            category.getDescricao()
                                            });
        });
    }
    
    /**************************************************
     * INSERÇÃO OU ATUALIZAÇÃO DE DADOS EFETUADA COM SUCESSO
     *************************************************/   
    private void manipulationSuccess() {
        // LIMPANDO CAMPOS
        jlCodigoCategoria.setText("0");
        jtfNomeCategoria.setText("");
        jtfDescricaoCategoria.setText("");
        getAllCategories();

        // EXIBINDO MENSAGEM DE SUCESSO
        UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
    }
    
    /**************************************************
     * LIMPA OS DADOS DA TABELA
     *************************************************/   
    private void cleanRowsTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jtCategorias.getModel();
        tableModel.setNumRows(0);
    }
    
    /**************************************************
     * LIMPA OS DADOS DA TABELA
     *************************************************/   
    private boolean validateFields() {
        ArrayList<JTextField> fieldsRequired = new ArrayList<>();
        fieldsRequired.add(jtfNomeCategoria);
        
        if(!UtilsFormulario.validateFieldsArray(fieldsRequired)) return false;
        
        return true;
    }
}