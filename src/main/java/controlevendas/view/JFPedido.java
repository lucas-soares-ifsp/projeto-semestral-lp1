package controlevendas.view;

import controlevendas.data.PedidoData;
import controlevendas.data.ProdutoData;
import controlevendas.data.UsuarioData;
import controlevendas.model.Pedido;
import controlevendas.model.Produto;
import controlevendas.model.Usuario;
import controlevendas.utils.UtilsFormulario;
import controlevendas.utils.UtilsFrontEnd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class JFPedido extends javax.swing.JInternalFrame {
    private Produto objProduto;
    private ProdutoData objProdutoData;
    private Usuario objUsuario;
    private UsuarioData objUsuarioData;
    private Pedido objPedido;
    private PedidoData objPedidoData;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Produto> products;
    private ArrayList<Pedido> pedidos;
    private int ultCatInserida; // ULTIMA CATEGORIA INSERIDA NA TABELA DE CATEGORIAS DO PRODUTO (PARA NÃO INSERIR LINHAS REPETIDAS)

    public JFPedido() {
        initComponents();        
        // INCIALIZANDO ATRIBUTOS
        this.objProduto = new Produto();
        this.objProdutoData = new ProdutoData();
        this.objUsuarioData = new UsuarioData();
        this.pedidos = new ArrayList<>();
        this.products = new ArrayList<>();
        this.objUsuario = new Usuario();
        this.usuarios = new ArrayList<>();
        this.objPedido = new Pedido();
        this.objPedidoData = new PedidoData();
        this.ultCatInserida = -1;
        
        // INICIALIZANDO FUNCOES
        setStylesManual();
        getAllOrders();
        getAllProducts();
        getAllUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDescricaoPedido = new javax.swing.JTextArea();
        jlCodigoPedido = new javax.swing.JLabel();
        jbRemoveProdutoPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mensagemErro = new javax.swing.JButton();
        mensagemSucesso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbEnviar = new javax.swing.JButton();
        jbAddProdutoPedido = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jlRS = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtProdutosExistentes = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtProdutosPedido = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlTotalPedido = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jbClientePedido = new javax.swing.JButton();
        jlNomeClienteCompra = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlCodClienteCompra = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");
        setToolTipText("");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(124, 1000));
        setPreferredSize(new java.awt.Dimension(1100, 980));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfDescricaoPedido.setBackground(new java.awt.Color(255, 255, 255));
        jtfDescricaoPedido.setColumns(20);
        jtfDescricaoPedido.setRows(5);
        jtfDescricaoPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jScrollPane1.setViewportView(jtfDescricaoPedido);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 950, 100));

        jlCodigoPedido.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlCodigoPedido.setForeground(new java.awt.Color(14, 104, 255));
        jlCodigoPedido.setText("0");
        jlCodigoPedido.setEnabled(false);
        getContentPane().add(jlCodigoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jbRemoveProdutoPedido.setBackground(new java.awt.Color(14, 104, 255));
        jbRemoveProdutoPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbRemoveProdutoPedido.setForeground(new java.awt.Color(255, 255, 255));
        jbRemoveProdutoPedido.setText("-");
        jbRemoveProdutoPedido.setEnabled(false);
        jbRemoveProdutoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveProdutoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jbRemoveProdutoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 50, 130));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 104, 255));
        jLabel2.setText("CADASTRAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(14, 104, 255));
        jLabel10.setText("Descrição");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(14, 104, 255));
        jLabel13.setText("Total do Pedido");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jbEnviar.setBackground(new java.awt.Color(14, 104, 255));
        jbEnviar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jbEnviar.setText("ENVIAR");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 170, 40));

        jbAddProdutoPedido.setBackground(new java.awt.Color(14, 104, 255));
        jbAddProdutoPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbAddProdutoPedido.setForeground(new java.awt.Color(255, 255, 255));
        jbAddProdutoPedido.setText("+");
        jbAddProdutoPedido.setEnabled(false);
        jbAddProdutoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProdutoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jbAddProdutoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 50, 130));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(14, 104, 255));
        jLabel14.setText("Produtos Existentes");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

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
        getContentPane().add(jtfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 950, 40));

        jlRS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jlRS.setForeground(new java.awt.Color(51, 51, 51));
        jlRS.setText("R$");
        getContentPane().add(jlRS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jtProdutosExistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço", "Estoque", "Descricao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutosExistentes.setRowHeight(30);
        jtProdutosExistentes.setShowGrid(true);
        jtProdutosExistentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosExistentesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtProdutosExistentes);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 370, 130));

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
        getContentPane().add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 870, 170, 40));

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
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 870, 170, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(14, 104, 255));
        jLabel15.setText("Pesquisar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("(descrição do pedido)");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, -1));

        jtProdutosPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço", "Descricao"
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
        jtProdutosPedido.setRowHeight(30);
        jtProdutosPedido.setShowGrid(true);
        jtProdutosPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosPedidoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtProdutosPedido);
        jtProdutosPedido.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 370, 130));

        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod. Pedido", "Cod. Usuário", "Descricao", "Total", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedidos.setRowHeight(30);
        jtPedidos.setShowGrid(true);
        jtPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPedidosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtPedidos);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 950, 150));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(14, 104, 255));
        jLabel17.setText("Cód. Cliente: ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("(insira ao menos 1)");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, -1, -1));

        jlTotalPedido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jlTotalPedido.setForeground(new java.awt.Color(51, 51, 51));
        jlTotalPedido.setText("0,00");
        getContentPane().add(jlTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.setRowHeight(30);
        jtUsuarios.setShowGrid(true);
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtUsuarios);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 370, 110));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(14, 104, 255));
        jLabel18.setText("Produtos do pedido");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jbClientePedido.setBackground(new java.awt.Color(14, 104, 255));
        jbClientePedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbClientePedido.setForeground(new java.awt.Color(255, 255, 255));
        jbClientePedido.setText("+");
        jbClientePedido.setEnabled(false);
        jbClientePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientePedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jbClientePedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 50, 110));

        jlNomeClienteCompra.setForeground(new java.awt.Color(51, 51, 51));
        jlNomeClienteCompra.setText("   ");
        getContentPane().add(jlNomeClienteCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(14, 104, 255));
        jLabel19.setText("Cliente: ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jlCodClienteCompra.setForeground(new java.awt.Color(51, 51, 51));
        jlCodClienteCompra.setText("    ");
        getContentPane().add(jlCodClienteCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /****************************************************
     * CLIQUE BOTAO REMOVER CATEGORIA DA TABELA DE CATEGORIAS DO PRODUTO
     ****************************************************/
    private void jbRemoveProdutoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveProdutoPedidoActionPerformed
        int rowSelected = jtProdutosPedido.getSelectedRow();
        DefaultTableModel tableCatProduto = (DefaultTableModel) jtProdutosPedido.getModel();
        
        if(rowSelected < 0) return;
        tableCatProduto.removeRow(rowSelected);
        jbRemoveProdutoPedido.setEnabled(false);
        totalOrder();
    }//GEN-LAST:event_jbRemoveProdutoPedidoActionPerformed

  
    /****************************************************
     * CLIQUE NO BOTAO DE ENVIAR/CADASTRAR PRODUTO  
     ****************************************************/
    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        try {
            // VERIFICANDO SE O OBJETO PRODUTO FOI PREENCHIDO CORRETAMENTE
            if((!this.setValuesPedido()) || (!validateFields())) {
                mensagemErro.setText("Verifique se todos os campos estão preenchidos e tente novamente!");
                UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
                return;
            }

            // VERIFICANDO SE A LABEL DO CÓDIGO DO PRODUTO É DIFERENTE DE 0
            // CASO SEJA, DEVE-SE REALIZAR A ATUALIZAÇÃO DO PRODUTO
            if(Integer.parseInt(jlCodigoPedido.getText()) != 0) {
                objPedido.setCod(Integer.parseInt(jlCodigoPedido.getText()));
                objPedidoData.update(objPedido);
            } else {
                // CADASTRANDO PRODUTO
                objPedido.setCod(0);
                objPedidoData.insert(objPedido);
            }
            
            manipulationSuccess();
            jlCodigoPedido.setText("0");
            jlTotalPedido.setText("0,00");
            this.ultCatInserida = -1;
        } catch (NumberFormatException | SQLException ex) {
            mensagemErro.setText("Houve algum erro! Verifique se não existem produtos repetidos.");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
            System.err.println("Erro ao inserir ou atualizar pedido: " +ex);
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEnviarActionPerformed
    
    /****************************************************
     * CLIQUE NO BOTAO DE ADICIONAR CATEGORIA EXISTENTE AO PRODUTO
     ****************************************************/
    private void jbAddProdutoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProdutoPedidoActionPerformed
        DefaultTableModel tableProdutosPed = (DefaultTableModel) jtProdutosPedido.getModel();
        int rowSelected = jtProdutosExistentes.getSelectedRow();
        
        if((rowSelected < 0) || (this.ultCatInserida == rowSelected)) return;
        tableProdutosPed.addRow(new String[] {  
            ""+products.get(rowSelected).getCod(),
            products.get(rowSelected).getNome(),
            ""+products.get(rowSelected).getPreco(),
            products.get(rowSelected).getDescricao()
        });
        totalOrder();
        this.ultCatInserida = rowSelected;
    }//GEN-LAST:event_jbAddProdutoPedidoActionPerformed

    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed

    }//GEN-LAST:event_jtfPesquisaActionPerformed

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        try {
            this.pedidos = objPedidoData.getOrders(jtfPesquisa.getText());
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    /****************************************************
     * CLIQUE NA TABELA QUE POSSUI TODOS OS PRODUTOS
     ****************************************************/
    private void jtProdutosExistentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosExistentesMouseClicked
        jbAddProdutoPedido.setEnabled(true);
    }//GEN-LAST:event_jtProdutosExistentesMouseClicked
    
    /****************************************************
     * CLIQUE NO BOTÃO DE EXCLUIR PRODUTO
     ****************************************************/
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            int rowSelected = jtPedidos.getSelectedRow();
            
            if(rowSelected < 0) return;
            objPedidoData.delete(pedidos.get(rowSelected).getCod());
            mensagemSucesso.setText("Pedido deletado com sucesso!");
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
            getAllOrders(); // EXCLUINDO O DADO DA TABELA
            
            // DESABILITANDO BOTOES
            jbExcluir.setEnabled(false);
            jbEditar.setEnabled(false);
        } catch (Exception ex) {
            mensagemErro.setText("Erro ao deletar pedido. Tente Novamente!");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 7000);
            Logger.getLogger(JFPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed
    
    /****************************************************
     * CLIQUE NO BOTÃO DE EDITAR
     ****************************************************/
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = jtPedidos.getSelectedRow();
        DefaultTableModel tableProdutosPedido = (DefaultTableModel) jtProdutosPedido.getModel();
        
        tableProdutosPedido.setNumRows(0);
        jlCodigoPedido.setText(""+pedidos.get(rowSelected).getCod());
        jlCodClienteCompra.setText(""+pedidos.get(rowSelected).getCodUsuario());
        jtfDescricaoPedido.setText(""+pedidos.get(rowSelected).getDescricao());
        
        UtilsFrontEnd.setTimeout(() -> {
            totalOrder();
        }, 100);
        
        // INSERINDO OS ITENS DO PEDIDO NA TABELA
        for(Produto product : pedidos.get(rowSelected).getItens()) {
            tableProdutosPedido.addRow(new String[] {  
                ""+product.getCod(),
                product.getNome(),
                ""+product.getPreco(),
                product.getDescricao(),
            });
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void mensagemErroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensagemErroActionPerformed
       
    }//GEN-LAST:event_mensagemErroActionPerformed
    
    /****************************************************
     * CLIQUE NA TABELA QUE CONTÉM OS PRODUTOS DO PEDIDO
     ****************************************************/
    private void jtProdutosPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosPedidoMouseClicked
        jbRemoveProdutoPedido.setEnabled(true);
    }//GEN-LAST:event_jtProdutosPedidoMouseClicked
    
    /****************************************************
     * CLIQUE NA TABELA QUE CONTÉM OS PEDIDOS
     ****************************************************/
    private void jtPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidosMouseClicked
        jbEditar.setEnabled(true);
        jbExcluir.setEnabled(true);
    }//GEN-LAST:event_jtPedidosMouseClicked

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
       jbClientePedido.setEnabled(true);
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void jbClientePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientePedidoActionPerformed
        int lineSelected = jtUsuarios.getSelectedRow();
        DefaultTableModel tableUsuarios = (DefaultTableModel) jtUsuarios.getModel();
        
        jlCodClienteCompra.setText(""+tableUsuarios.getValueAt(lineSelected, 0));
        jlNomeClienteCompra.setText(""+tableUsuarios.getValueAt(lineSelected, 1));
    }//GEN-LAST:event_jbClientePedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jbAddProdutoPedido;
    private javax.swing.JButton jbClientePedido;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbRemoveProdutoPedido;
    private javax.swing.JLabel jlCodClienteCompra;
    private javax.swing.JLabel jlCodigoPedido;
    private javax.swing.JLabel jlNomeClienteCompra;
    private javax.swing.JLabel jlRS;
    private javax.swing.JLabel jlTotalPedido;
    private javax.swing.JTable jtPedidos;
    private javax.swing.JTable jtProdutosExistentes;
    private javax.swing.JTable jtProdutosPedido;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextArea jtfDescricaoPedido;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JButton mensagemErro;
    private javax.swing.JButton mensagemSucesso;
    // End of variables declaration//GEN-END:variables

    /**************************************************
     * FUNCOES PERSONLIZADAS
     *************************************************/
    private void setStylesManual() {
        jlCodigoPedido.setVisible(false);
        mensagemErro.setVisible(false);
        mensagemSucesso.setVisible(false);
    }
    
    /**************************************************
     * INSERE O TOTAL DO PEDIDO
     *************************************************/    
    private void totalOrder() {
        DefaultTableModel tableCatsProduto = (DefaultTableModel) jtProdutosPedido.getModel();
        double total = 0;
        
        for(int i=0; i < tableCatsProduto.getRowCount(); i++) {
            total += Float.parseFloat((String) tableCatsProduto.getValueAt(i, 2));
        }
        
        jlTotalPedido.setText(""+total);
    }
    
    /**************************************************
     * SETANDO VALORES DO PRODUTO
     *************************************************/
    private boolean setValuesPedido() {
        ArrayList<Produto> arrayProducts = new ArrayList<>(); // ARRAYLIST QUE CONTÉM OS ITENS DO PEDIDO
        DefaultTableModel tableProdsPedido = (DefaultTableModel) jtProdutosPedido.getModel();
        
        // INSERINDO NO ARRAYLIST OS ITENS QUE ESTÃO NA TABELA DE PRODUTOS DO PEDIDO
        for(int i=0; i < tableProdsPedido.getRowCount(); i++) {
            Produto product = new Produto();
            product.setCod(Integer.parseInt((String) tableProdsPedido.getValueAt(i, 0)));
        
            arrayProducts.add(product);
        }
        
        this.objPedido.setCodUsuario(Integer.parseInt(jlCodClienteCompra.getText())); // PRECISO ALTERAR DEPOIS
        this.objPedido.setDescricao(jtfDescricaoPedido.getText());
        this.objPedido.setTotal(Float.parseFloat(jlTotalPedido.getText()));
        this.objPedido.setItens(arrayProducts);
        
        return true;
    }
    
    /**************************************************
     * BUSCANDO TODOS OS PEDIDOS
     *************************************************/
    private void getAllOrders() {
        try {
            // BUSCANDO OS DADOS E CHAMANDO FUNCAO DE ADICAO NA TABELA
            this.pedidos = objPedidoData.getOrders();
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * BUSCANDO TODOS OS PRODUTOS
     *************************************************/    
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
     * BUSCANDO TODOS OS USUARIOS
     *************************************************/    
    private void getAllUsers() {
        try {
            this.usuarios = objUsuarioData.getUsers(jtfPesquisa.getText());
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * ADICIONANDO VALORES NAS TABELAS
     *************************************************/
    private void addInTable() {
        DefaultTableModel tableProdutosExistentes = (DefaultTableModel) jtProdutosExistentes.getModel();
        DefaultTableModel tableCategoriasProduto = (DefaultTableModel) jtProdutosPedido.getModel();
        DefaultTableModel tablePedidos = (DefaultTableModel) jtPedidos.getModel();
        DefaultTableModel tableUsuarios = (DefaultTableModel) jtUsuarios.getModel();
        
        // ZERANDO A QUANTIDADE DE LINHAS
        tableProdutosExistentes.setNumRows(0);
        tableCategoriasProduto.setNumRows(0);
        tablePedidos.setNumRows(0);
        tableUsuarios.setNumRows(0);
        
        // INSERINDO DADOS NA TABELA DOS USUARIOS
        this.usuarios.forEach(usuario -> {
            tableUsuarios.addRow(new String[] {  ""+usuario.getCod(),
                                                   usuario.getNome(),
                                                   usuario.getEmail(),
                                                   usuario.getTelefone(),
                                                   usuario.getCpf(),
                                                   usuario.getTipo()
                                             });
        });
        
        // INSERINDO DADOS NA TABELA DOS PEDIDOS
        this.pedidos.forEach(pedido -> {
            tablePedidos.addRow(new String[] {   ""+pedido.getCod(),
                                                 ""+pedido.getCodUsuario(),
                                                 ""+pedido.getDescricao(),
                                                 ""+pedido.getTotal(),
                                                    pedido.getData(),
                                             });
        });
        
        // INSERINDO DADOS NA TABELA DE PRODUTOS EXISTENTES
        this.products.forEach(product -> {
            tableProdutosExistentes.addRow(new String[] {""+product.getCod(),
                                                 product.getNome(), 
                                                 ""+product.getPreco(), 
                                                 ""+product.getQtdEstoque(),
                                                 ""+product.getDescricao()
                                                });
        });
    }
    
    /**************************************************
     * INSERÇÃO OU ATUALIZAÇÃO DE DADOS EFETUADA COM SUCESSO
     *************************************************/   
    private void manipulationSuccess() {
        try {
            UtilsFormulario.cleanFields(this);
            jtfDescricaoPedido.setText("");
            jlNomeClienteCompra.setText("");
            jlCodClienteCompra.setText("");
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
            jbAddProdutoPedido.setEnabled(false);
            getAllOrders();

            mensagemSucesso.setText("Ação realizada com sucesso!");

            // EXIBINDO MENSAGEM DE SUCESSO
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
        } catch (Exception ex) {
            Logger.getLogger(JFPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * LIMPA OS DADOS DA TABELA
     *************************************************/   
    private boolean validateFields() {
        return true;
    }
}