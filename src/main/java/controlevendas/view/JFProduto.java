package controlevendas.view;

import controlevendas.data.CategoriaData;
import controlevendas.data.ProdutoData;
import controlevendas.model.Categoria;
import controlevendas.model.Produto;
import controlevendas.utils.UtilsFormulario;
import controlevendas.utils.UtilsFrontEnd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JFProduto extends javax.swing.JInternalFrame {
    private Produto objProduto;
    private ProdutoData objProdutoData;
    private ArrayList<Produto> products;
    private Categoria objCategoria;
    private CategoriaData objCategoriaData;
    private ArrayList<Categoria> categories;
    private int cod;
    
    private int ultCatInserida; // ULTIMA CATEGORIA INSERIDA NA TABELA DE CATEGORIAS DO PRODUTO (PARA NÃO INSERIR LINHAS REPETIDAS)

    public JFProduto() {
        initComponents();        
        // INCIALIZANDO ATRIBUTOS
        this.objProduto = new Produto();
        this.objProdutoData = new ProdutoData();
        this.products = new ArrayList<>();
        this.objCategoria = new Categoria();
        this.objCategoriaData = new CategoriaData();
        this.categories = new ArrayList<>();
        this.cod=0;
        this.ultCatInserida = -1;
        
        // INICIALIZANDO FUNCOES
        setStylesManual();
        getAllProducts();
        getAllCategories();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDescricaoProduto = new javax.swing.JTextArea();
        jlCodigoProduto = new javax.swing.JLabel();
        jbRemoverCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCategoriasProduto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mensagemErro = new javax.swing.JButton();
        mensagemSucesso = new javax.swing.JButton();
        jtfPeso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfEstoque = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfLargura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCategoriasExistentes = new javax.swing.JTable();
        jbEnviar = new javax.swing.JButton();
        jbAdicionarCategoria = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Produto");
        setToolTipText("");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(124, 1000));
        setPreferredSize(new java.awt.Dimension(1100, 980));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfDescricaoProduto.setBackground(new java.awt.Color(255, 255, 255));
        jtfDescricaoProduto.setColumns(20);
        jtfDescricaoProduto.setRows(5);
        jtfDescricaoProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jScrollPane1.setViewportView(jtfDescricaoProduto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 960, 100));

        jlCodigoProduto.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlCodigoProduto.setForeground(new java.awt.Color(14, 104, 255));
        jlCodigoProduto.setText("0");
        jlCodigoProduto.setEnabled(false);
        getContentPane().add(jlCodigoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jbRemoverCategoria.setBackground(new java.awt.Color(14, 104, 255));
        jbRemoverCategoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbRemoverCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jbRemoverCategoria.setText("-");
        jbRemoverCategoria.setEnabled(false);
        jbRemoverCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jbRemoverCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 50, 140));

        jtCategoriasProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCategoriasProduto.setRowHeight(30);
        jtCategoriasProduto.setShowGrid(true);
        jtCategoriasProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriasProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCategoriasProduto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 420, 140));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 104, 255));
        jLabel2.setText("CADASTRAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jtfNome.setBackground(new java.awt.Color(255, 255, 255));
        jtfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 380, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 104, 255));
        jLabel12.setText("Nome");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        mensagemErro.setBackground(new java.awt.Color(242, 195, 195));
        mensagemErro.setForeground(new java.awt.Color(255, 51, 51));
        mensagemErro.setText("Houve algum erro.");
        mensagemErro.setBorder(null);
        mensagemErro.setFocusPainted(false);
        mensagemErro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensagemErroActionPerformed(evt);
            }
        });
        getContentPane().add(mensagemErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 540, 40));

        mensagemSucesso.setBackground(new java.awt.Color(204, 255, 204));
        mensagemSucesso.setForeground(new java.awt.Color(0, 204, 51));
        mensagemSucesso.setText("Ação realizada com sucesso!");
        mensagemSucesso.setBorder(null);
        mensagemSucesso.setFocusPainted(false);
        getContentPane().add(mensagemSucesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 540, 40));

        jtfPeso.setBackground(new java.awt.Color(255, 255, 255));
        jtfPeso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfPeso.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 140, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 104, 255));
        jLabel5.setText("Peso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, -1));

        jtfPreco.setBackground(new java.awt.Color(255, 255, 255));
        jtfPreco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfPreco.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 110, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 104, 255));
        jLabel8.setText("Preço");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jtfEstoque.setBackground(new java.awt.Color(255, 255, 255));
        jtfEstoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstoqueActionPerformed(evt);
            }
        });
        getContentPane().add(jtfEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 100, 40));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(14, 104, 255));
        jLabel9.setText("Estoque");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jtfLargura.setBackground(new java.awt.Color(255, 255, 255));
        jtfLargura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfLargura.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfLargura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLarguraActionPerformed(evt);
            }
        });
        getContentPane().add(jtfLargura, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 130, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(14, 104, 255));
        jLabel7.setText("Largura");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(14, 104, 255));
        jLabel10.setText("Descrição");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(14, 104, 255));
        jLabel13.setText("Categorias do Produto");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        jtCategoriasExistentes.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtCategoriasExistentes.setRowHeight(30);
        jtCategoriasExistentes.setShowGrid(true);
        jtCategoriasExistentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriasExistentesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtCategoriasExistentes);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 390, 140));

        jbEnviar.setBackground(new java.awt.Color(14, 104, 255));
        jbEnviar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jbEnviar.setText("ENVIAR");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 170, 40));

        jbAdicionarCategoria.setBackground(new java.awt.Color(14, 104, 255));
        jbAdicionarCategoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbAdicionarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jbAdicionarCategoria.setText("+");
        jbAdicionarCategoria.setEnabled(false);
        jbAdicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jbAdicionarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 50, 140));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(14, 104, 255));
        jLabel14.setText("Categorias Existentes");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

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
        getContentPane().add(jtfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 950, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("(insira ao menos 1)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, -1));

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço", "Estoque", "Peso", "Largura", "Descricao", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutos.setRowHeight(30);
        jtProdutos.setShowGrid(true);
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtProdutos);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 950, 140));

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
        getContentPane().add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 830, 170, 40));

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
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 830, 170, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(14, 104, 255));
        jLabel15.setText("Pesquisar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("(nome ou descrição do produto)");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /****************************************************
     * CLIQUE BOTAO REMOVER CATEGORIA DA TABELA DE CATEGORIAS DO PRODUTO
     ****************************************************/
    private void jbRemoverCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverCategoriaActionPerformed
        int rowSelected = jtCategoriasProduto.getSelectedRow();
        DefaultTableModel tableCatProduto = (DefaultTableModel) jtCategoriasProduto.getModel();
        
        if(rowSelected < 0) return;
        tableCatProduto.removeRow(rowSelected);
    }//GEN-LAST:event_jbRemoverCategoriaActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        
    }//GEN-LAST:event_jtfNomeActionPerformed

    /****************************************************
     * CLIQUE NA TABELA CATEGORIAS DO PRODUTO
     ****************************************************/
    private void jtCategoriasProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriasProdutoMouseClicked
        jbRemoverCategoria.setEnabled(true);
    }//GEN-LAST:event_jtCategoriasProdutoMouseClicked

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed
      
    }//GEN-LAST:event_jtfPesoActionPerformed

    private void jtfPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecoActionPerformed
      
    }//GEN-LAST:event_jtfPrecoActionPerformed

    private void jtfEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstoqueActionPerformed
      
    }//GEN-LAST:event_jtfEstoqueActionPerformed

    private void jtfLarguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLarguraActionPerformed
       
    }//GEN-LAST:event_jtfLarguraActionPerformed
   
    /****************************************************
     * CLIQUE NA TABELA CATEGORIAS EXISTENTES
     ****************************************************/
    private void jtCategoriasExistentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriasExistentesMouseClicked
        jbAdicionarCategoria.setEnabled(true);
    }//GEN-LAST:event_jtCategoriasExistentesMouseClicked

    /****************************************************
     * CLIQUE NO BOTAO DE ENVIAR/CADASTRAR PRODUTO  
     ****************************************************/
    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        try {
            // VERIFICANDO SE O OBJETO PRODUTO FOI PREENCHIDO CORRETAMENTE
            if((!setValuesProduct()) || (!validateFields())) {
                mensagemErro.setText("Verifique se todos os campos estão preenchidos e tente novamente!");
                UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
                return;
            }

            // VERIFICANDO SE A LABEL DO CÓDIGO DO PRODUTO É DIFERENTE DE 0
            // CASO SEJA, DEVE-SE REALIZAR A ATUALIZAÇÃO DO PRODUTO
            if(Integer.parseInt(jlCodigoProduto.getText()) != 0) {
                objProdutoData.update(objProduto);
                manipulationSuccess();
                return;
            }
        
            // CADASTRANDO PRODUTO
            objProdutoData.insert(objProduto);
            manipulationSuccess();
        } catch (NumberFormatException | SQLException ex) {
            mensagemErro.setText("Houve algum erro! Verifique se não existe categorias repetidas.");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
            System.err.println("Erro ao inserir ou atualizar produto: " +ex);
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEnviarActionPerformed
    
    /****************************************************
     * CLIQUE NO BOTAO DE ADICIONAR CATEGORIA EXISTENTE AO PRODUTO
     ****************************************************/
    private void jbAdicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarCategoriaActionPerformed
        DefaultTableModel tableCatsProduto = (DefaultTableModel) jtCategoriasProduto.getModel();
        int rowSelected = jtCategoriasExistentes.getSelectedRow();
        
        if((rowSelected < 0) || (this.ultCatInserida == rowSelected)) return;
        tableCatsProduto.addRow(new String[] {  
            ""+categories.get(rowSelected).getCodCategoria(),
            ""+categories.get(rowSelected).getNome(),
            ""+categories.get(rowSelected).getDataCadastro(),
            ""+categories.get(rowSelected).getDescricao()
        });
        this.ultCatInserida = rowSelected;
    }//GEN-LAST:event_jbAdicionarCategoriaActionPerformed

    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed

    }//GEN-LAST:event_jtfPesquisaActionPerformed

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        try {
            this.products = objProdutoData.getProducts(jtfPesquisa.getText());
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    /****************************************************
     * CLIQUE NA TABELA QUE POSSUI TODOS OS PRODUTOS
     ****************************************************/
    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked
        jbEditar.setEnabled(true);
        jbExcluir.setEnabled(true);
    }//GEN-LAST:event_jtProdutosMouseClicked
    
    /****************************************************
     * CLIQUE NO BOTÃO DE EXCLUIR PRODUTO
     ****************************************************/
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            int rowSelected = jtProdutos.getSelectedRow();
            
            objProdutoData.delete(products.get(rowSelected).getCod());
            mensagemErro.setText("Produto deletado com sucesso!");
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
            UtilsFrontEnd.cleanRowTable(jtProdutos, rowSelected); // EXCLUINDO O DADO DA TABELA
            
            // DESABILITANDO BOTOES
            jbExcluir.setEnabled(false);
            jbEditar.setEnabled(false);
        } catch (Exception ex) {
            mensagemErro.setText("Erro ao deletar produto. Verifique se o mesmo contém PEDIDO(S) e TENTE NOVAMENTE!");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 7000);
            Logger.getLogger(JFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed
    
    /****************************************************
     * CLIQUE NO BOTÃO DE EDITAR
     ****************************************************/
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = jtProdutos.getSelectedRow();
        DefaultTableModel tableCatsProduto = (DefaultTableModel) jtCategoriasProduto.getModel();
        
        this.ultCatInserida = -1;
        jlCodigoProduto.setText(""+products.get(rowSelected).getCod());
        jtfNome.setText(""+products.get(rowSelected).getNome());
        jtfPreco.setText(""+products.get(rowSelected).getPreco());
        jtfEstoque.setText(""+products.get(rowSelected).getQtdEstoque());
        jtfPeso.setText(""+products.get(rowSelected).getPeso());
        jtfLargura.setText(""+products.get(rowSelected).getLargura());
        jtfDescricaoProduto.setText(""+products.get(rowSelected).getDescricao());
        
        // INSERINDO AS CATEGORIAS NA TABELA
        for(Categoria category : products.get(rowSelected).getCategorias()) {
            tableCatsProduto.addRow(new String[] {  
                ""+category.getCodCategoria(),
                ""+category.getNome(),
                ""+category.getDataCadastro(),
                ""+category.getDescricao()
            });
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void mensagemErroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensagemErroActionPerformed
       
    }//GEN-LAST:event_mensagemErroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbAdicionarCategoria;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbRemoverCategoria;
    private javax.swing.JLabel jlCodigoProduto;
    private javax.swing.JTable jtCategoriasExistentes;
    private javax.swing.JTable jtCategoriasProduto;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextArea jtfDescricaoProduto;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfLargura;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JButton mensagemErro;
    private javax.swing.JButton mensagemSucesso;
    // End of variables declaration//GEN-END:variables

    /**************************************************
     * FUNCOES PERSONLIZADAS
     *************************************************/
    private void setStylesManual() {
        jlCodigoProduto.setVisible(false);
        mensagemErro.setVisible(false);
        mensagemSucesso.setVisible(false);
    }
    
    /**************************************************
     * SETANDO VALORES DO PRODUTO
     *************************************************/
    private boolean setValuesProduct() {
        ArrayList<Categoria> arrayCategories = new ArrayList<>(); // ARRAYLIST COM AS CATEGORIAS DO PRODUTO
        DefaultTableModel tableCatsProduto = (DefaultTableModel) jtCategoriasProduto.getModel();
        
        // BUSCANDO AS CATEGORIAS QUE ESTÃO NA TABELA DE CATEGORIAS DO PRODUTO E INSERINDO NO ARRAYLIST
        for(int i=0; i < tableCatsProduto.getRowCount(); i++) {
            Categoria categoria = new Categoria(
                    Integer.parseInt((String) tableCatsProduto.getValueAt(i, 0)),
                    (String) tableCatsProduto.getValueAt(i, 1),
                    (String) tableCatsProduto.getValueAt(i, 2),
                    (String) tableCatsProduto.getValueAt(i, 3)
            );
            arrayCategories.add(categoria);
        }
        
        this.objProduto.setCod(Integer.parseInt(jlCodigoProduto.getText()));
        this.objProduto.setNome(jtfNome.getText());
        this.objProduto.setPreco(Float.parseFloat(jtfPreco.getText()));
        this.objProduto.setQtdEstoque(Integer.parseInt(jtfEstoque.getText()));
        this.objProduto.setPeso(Float.parseFloat(jtfPeso.getText()));
        this.objProduto.setLargura(Float.parseFloat(jtfLargura.getText()));
        this.objProduto.setDescricao(jtfDescricaoProduto.getText().toString());
        this.objProduto.setCategorias(arrayCategories);
        
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
            Logger.getLogger(JFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getAllProducts() {
        try {
            // BUSCANDO OS DADOS E CHAMANDO FUNCAO DE ADICAO NA TABELA
            this.products = objProdutoData.getProducts();
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * ADICIONANDO VALORES NAS TABELAS
     *************************************************/
    private void addInTable() {
        DefaultTableModel tableCategoriasExistentes = (DefaultTableModel) jtCategoriasExistentes.getModel();
        DefaultTableModel tableCategoriasProduto = (DefaultTableModel) jtCategoriasProduto.getModel();
        DefaultTableModel tableProdutos = (DefaultTableModel) jtProdutos.getModel();
        
        // ZERANDO A QUANTIDADE DE LINHAS
        tableCategoriasExistentes.setNumRows(0);
        tableCategoriasProduto.setNumRows(0);
        tableProdutos.setNumRows(0);
        
        // INSERINDO DADOS NA TABELA DE CATEGORIAS EXISTENTES
        categories.forEach(category -> {
            tableCategoriasExistentes.addRow(new String[] {""+category.getCodCategoria(), 
                                                 category.getNome(), 
                                                 category.getDataCadastro(), 
                                                 category.getDescricao()
                                                });
        });
        
        // INSERINDO DADOS NA TABELA DE CATEGORIAS DO PRODUTO
        products.forEach(product -> {
            tableProdutos.addRow(new String[] {""+product.getCod(),
                                                 product.getNome(), 
                                                 ""+product.getPreco(), 
                                                 ""+product.getQtdEstoque(), 
                                                 ""+product.getPeso(), 
                                                 ""+product.getLargura(), 
                                                 ""+product.getDescricao(), 
                                                 product.getDataCadastro()
                                                });
        });
    }
    
    /**************************************************
     * INSERÇÃO OU ATUALIZAÇÃO DE DADOS EFETUADA COM SUCESSO
     *************************************************/   
    private void manipulationSuccess() {
        try {
            UtilsFormulario.cleanFields(this);
            jtfDescricaoProduto.setText("");
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
            getAllProducts();

            mensagemSucesso.setText("Ação realizada com sucesso!");

            // EXIBINDO MENSAGEM DE SUCESSO
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
        } catch (Exception ex) {
            Logger.getLogger(JFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * LIMPA OS DADOS DA TABELA
     *************************************************/   
    private boolean validateFields() {
        ArrayList<JTextField> fieldsRequired = new ArrayList<>();
        fieldsRequired.add(jtfNome);
        fieldsRequired.add(jtfPeso);
        fieldsRequired.add(jtfEstoque);
        fieldsRequired.add(jtfPreco);
        fieldsRequired.add(jtfLargura);
        
        if((!UtilsFormulario.validateFieldsArray(fieldsRequired)) || (jtCategoriasProduto.getRowCount() <= 0)) return false;
        
        return true;
    }
}