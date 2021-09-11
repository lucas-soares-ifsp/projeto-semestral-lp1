package controlevendas.view;

import controlevendas.data.UsuarioData;
import controlevendas.model.Administrador;
import controlevendas.model.Cliente;
import controlevendas.model.Usuario;
import controlevendas.utils.UtilsFormulario;
import controlevendas.utils.UtilsFrontEnd;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JFUsuario extends javax.swing.JInternalFrame {
    private Usuario objUsuario;
    private Administrador objAdministrador;
    private Cliente objCliente;
    private UsuarioData objUsuarioData;
    private ArrayList<Usuario> usuarios;
    private int cod;
    
    private int ultCatInserida; // ULTIMA CATEGORIA INSERIDA NA TABELA DE CATEGORIAS DO PRODUTO (PARA NÃO INSERIR LINHAS REPETIDAS)

    public JFUsuario() {
        initComponents();        
        // INCIALIZANDO ATRIBUTOS
        this.objUsuario = new Usuario();
        this.objAdministrador = new Administrador();
        this.objCliente = new Cliente();
        this.objUsuarioData = new UsuarioData();
        this.usuarios = new ArrayList<>();
        this.cod=0;
        
        // INICIALIZANDO FUNCOES
        setStylesManual();
        getAllUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jlCodigoUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mensagemErro = new javax.swing.JButton();
        mensagemSucesso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jbEnviar = new javax.swing.JButton();
        jtfPesquisa = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jtfTelefone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JTextField();
        jcbTipoUsuario = new javax.swing.JComboBox<>();
        jlTipo = new javax.swing.JLabel();
        jlSenha = new javax.swing.JLabel();
        jlDataNascimento = new javax.swing.JLabel();
        jtfDataNascimento = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuários");
        setToolTipText("");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(124, 1000));
        setPreferredSize(new java.awt.Dimension(900, 890));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlCodigoUsuario.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlCodigoUsuario.setForeground(new java.awt.Color(14, 104, 255));
        jlCodigoUsuario.setText("0");
        jlCodigoUsuario.setEnabled(false);
        getContentPane().add(jlCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 104, 255));
        jLabel2.setText("CADASTRAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

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
        getContentPane().add(mensagemErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 560, 40));

        mensagemSucesso.setBackground(new java.awt.Color(204, 255, 204));
        mensagemSucesso.setForeground(new java.awt.Color(0, 204, 51));
        mensagemSucesso.setText("Ação realizada com sucesso!");
        mensagemSucesso.setBorder(null);
        mensagemSucesso.setFocusPainted(false);
        getContentPane().add(mensagemSucesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 560, 40));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(14, 104, 255));
        jLabel10.setText("Telefone");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jbEnviar.setBackground(new java.awt.Color(14, 104, 255));
        jbEnviar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jbEnviar.setText("ENVIAR");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 40));

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
        getContentPane().add(jtfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 810, 40));

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
        getContentPane().add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 760, 170, 40));

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
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 170, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(14, 104, 255));
        jLabel15.setText("Pesquisar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Email", "Telefone", "CPF", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane6.setViewportView(jtUsuarios);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 810, 140));

        jtfTelefone.setBackground(new java.awt.Color(255, 255, 255));
        jtfTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefoneActionPerformed(evt);
            }
        });
        jtfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTelefoneKeyReleased(evt);
            }
        });
        getContentPane().add(jtfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 310, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 104, 255));
        jLabel12.setText("Email");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jtfEmail.setBackground(new java.awt.Color(255, 255, 255));
        jtfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });
        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEmailKeyReleased(evt);
            }
        });
        getContentPane().add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 480, 40));

        jtfNome.setBackground(new java.awt.Color(255, 255, 255));
        jtfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
        });
        getContentPane().add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 310, 40));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(14, 104, 255));
        jLabel14.setText("Nome");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(14, 104, 255));
        jLabel17.setText("CPF");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 80, -1));

        jtfCpf.setBackground(new java.awt.Color(255, 255, 255));
        jtfCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCpfActionPerformed(evt);
            }
        });
        jtfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCpfKeyReleased(evt);
            }
        });
        getContentPane().add(jtfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 480, 40));

        jcbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cliente", "Administrador" }));
        jcbTipoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoUsuarioItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 310, 40));

        jlTipo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlTipo.setForeground(new java.awt.Color(14, 104, 255));
        jlTipo.setText("Tipo");
        getContentPane().add(jlTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 250, -1));

        jlSenha.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlSenha.setForeground(new java.awt.Color(14, 104, 255));
        jlSenha.setText("Senha");
        getContentPane().add(jlSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 250, -1));

        jlDataNascimento.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlDataNascimento.setForeground(new java.awt.Color(14, 104, 255));
        jlDataNascimento.setText("Data de Nascimento (ano-mês-dia)");
        getContentPane().add(jlDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 400, -1));

        jtfDataNascimento.setBackground(new java.awt.Color(255, 255, 255));
        jtfDataNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfDataNascimento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataNascimentoActionPerformed(evt);
            }
        });
        jtfDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDataNascimentoKeyReleased(evt);
            }
        });
        getContentPane().add(jtfDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 480, 40));

        jtfSenha.setBackground(new java.awt.Color(255, 255, 255));
        jtfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 104, 255), 3));
        jtfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSenhaActionPerformed(evt);
            }
        });
        jtfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSenhaKeyReleased(evt);
            }
        });
        getContentPane().add(jtfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 480, 40));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("(nome ou email do usuário)");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
  
    /****************************************************
     * CLIQUE NO BOTAO DE ENVIAR/CADASTRAR PRODUTO  
     ****************************************************/
    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        try {
            int optionSelected = jcbTipoUsuario.getSelectedIndex(); // OPÇÃO SELECIONADA NO COMBOBOX DE TIPO DO USUÁRIO
            
            // VERIFICANDO SE O OBJETO DO USUÁRIO FOI PREENCHIDO CORRETAMENTE
            if((!setValuesAdmin() || !setValuesCliente()) || (!validateFields())) {
                mensagemErro.setText("Verifique se todos os campos estão preenchidos e tente novamente!");
                UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
                return;
            }

            // VERIFICANDO SE A LABEL DO CÓDIGO DO USUÁRIO É DIFERENTE DE 0
            // CASO SEJA, DEVE-SE REALIZAR A ATUALIZAÇÃO DO PRODUTO
            if(Integer.parseInt(jlCodigoUsuario.getText()) != 0) {
                if(!setValuesUsuario()) {
                    mensagemErro.setText("Está ocorrendo algum erro nos valores do usuário, tente novamente!");
                    UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
                    return;
                }
                        
                objUsuarioData.update(objUsuario); // ATUALIZANDO USUÁRIO
                manipulationSuccess();
                return;
            }
            
            // CLIENTE
            if(optionSelected == 1) {
                objUsuarioData.insert(objCliente); // CADASTRANDO USUARIO
                manipulationSuccess();
                return;
            }
            
            // ADMIN
            if(optionSelected == 2) {
                objUsuarioData.insert(objAdministrador); // CADASTRANDO USUARIO
                manipulationSuccess();
                return;
            }
        } catch (NumberFormatException | SQLException ex) {
            mensagemErro.setText("Houve algum erro! Verifique se o usuário já é existeste e tente novamente.");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 3000);
            System.err.println("Erro ao inserir ou atualizar pedido: " +ex);
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEnviarActionPerformed
    
    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed

    }//GEN-LAST:event_jtfPesquisaActionPerformed

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        try {
            this.usuarios = objUsuarioData.getUsers(jtfPesquisa.getText());
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    /****************************************************
     * CLIQUE NO BOTÃO DE EXCLUIR PRODUTO
     ****************************************************/
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            int rowSelected = jtUsuarios.getSelectedRow();
            
            if(rowSelected < 0) return;
            
            objUsuarioData.delete(usuarios.get(rowSelected).getCod(), this.objUsuario.getTipo());
            getAllUsers();
            mensagemErro.setText("Produto deletado com sucesso!");
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);
            
            // DESABILITANDO BOTOES
            jbExcluir.setEnabled(false);
            jbEditar.setEnabled(false);
        } catch (Exception ex) {
            mensagemErro.setText("Erro ao deletar usuário. Verifique se ele não possui nenhum pedido e TENTE NOVAMENTE!");
            UtilsFrontEnd.showHiddeElement(mensagemErro, 7000);
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed
    
    /****************************************************
     * CLIQUE NO BOTÃO DE EDITAR
     ****************************************************/
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = jtUsuarios.getSelectedRow();
        
        jlTipo.setVisible(false);
        jcbTipoUsuario.setVisible(false);
        
        jlCodigoUsuario.setText(""+usuarios.get(rowSelected).getCod());
        jtfNome.setText(usuarios.get(rowSelected).getNome());
        jtfEmail.setText(usuarios.get(rowSelected).getEmail());
        jtfTelefone.setText(usuarios.get(rowSelected).getTelefone());
        jtfCpf.setText(usuarios.get(rowSelected).getCpf());
    }//GEN-LAST:event_jbEditarActionPerformed

    private void mensagemErroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensagemErroActionPerformed
       
    }//GEN-LAST:event_mensagemErroActionPerformed
      
    /****************************************************
     * CLIQUE NA TABELA QUE CONTÉM OS PEDIDOS
     ****************************************************/
    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        jbEditar.setEnabled(true);
        jbExcluir.setEnabled(true);
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void jtfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelefoneActionPerformed

    private void jtfTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefoneKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelefoneKeyReleased

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void jtfEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailKeyReleased

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeKeyReleased

    private void jtfCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCpfActionPerformed

    private void jtfCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCpfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCpfKeyReleased

     /****************************************************
     * ALTERA O ITEM DO COMBOBOX
     ****************************************************/   
    private void jcbTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoUsuarioItemStateChanged
        int optionSelected = jcbTipoUsuario.getSelectedIndex();
        
        // CLIENTE
        if(optionSelected == 1) {
            setStylesManual();
            jlDataNascimento.setVisible(true);
            jtfDataNascimento.setVisible(true);
            
            return;
        }
        
        // ADMIN
        if(optionSelected == 2) {
            setStylesManual();
            jlSenha.setVisible(true);
            jtfSenha.setVisible(true);
            
            return;
        }
        
        setStylesManual();
    }//GEN-LAST:event_jcbTipoUsuarioItemStateChanged

    private void jtfDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataNascimentoActionPerformed

    private void jtfDataNascimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDataNascimentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataNascimentoKeyReleased

    private void jtfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSenhaActionPerformed

    private void jtfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSenhaKeyReleased

    }//GEN-LAST:event_jtfSenhaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<String> jcbTipoUsuario;
    private javax.swing.JLabel jlCodigoUsuario;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfDataNascimento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JButton mensagemErro;
    private javax.swing.JButton mensagemSucesso;
    // End of variables declaration//GEN-END:variables

    /**************************************************
     * FUNCOES PERSONLIZADAS
     *************************************************/
    private void setStylesManual() {
        jlCodigoUsuario.setVisible(false);
        mensagemErro.setVisible(false);
        mensagemSucesso.setVisible(false);
        
        // OCULTANDO OS CAMPOS DE CLIENTE E ADMIN
        jlDataNascimento.setVisible(false);
        jtfDataNascimento.setVisible(false);
        jlSenha.setVisible(false);
        jtfSenha.setVisible(false);
    }
    
    /**************************************************
     * SETANDO VALORES DO USUÁRIO
     *************************************************/
    private boolean setValuesUsuario() {
        int rowSelected = jtUsuarios.getSelectedRow();
        DefaultTableModel tableUsuarios = (DefaultTableModel) jtUsuarios.getModel();
        String typeUser = (String) tableUsuarios.getValueAt(rowSelected, 5);
        
        // INSERINDO DADOS DO USUÁRIO NOS CAMPOS DO FORMULÁRIO
        if(typeUser == "administrador")
            System.out.println("Tipo do usuário: "+typeUser);
        
        if(typeUser == "cliente")
            System.out.println("Tipo do usuário: "+typeUser);
        
        this.objUsuario.setCod(Integer.parseInt(jlCodigoUsuario.getText()));
        this.objUsuario.setNome(jtfNome.getText());
        this.objUsuario.setEmail(jtfEmail.getText());
        this.objUsuario.setTelefone(jtfTelefone.getText());
        this.objUsuario.setCpf(jtfCpf.getText());
        this.objUsuario.setTipo(typeUser);
                
        return true;
    }
    
    /**************************************************
     * SETANDO VALORES DO CLIENTE
     *************************************************/
    private boolean setValuesCliente() {
        this.objCliente.setCod(Integer.parseInt(jlCodigoUsuario.getText()));
        this.objCliente.setNome(jtfNome.getText());
        this.objCliente.setEmail(jtfEmail.getText());
        this.objCliente.setTelefone(jtfTelefone.getText());
        this.objCliente.setCpf(jtfCpf.getText());
        this.objCliente.setDataNascimento(jtfDataNascimento.getText());

        return true;
    }
    
    /**************************************************
     * SETANDO VALORES DO ADMINISTRADOR
     *************************************************/
    private boolean setValuesAdmin() {
        this.objAdministrador.setCod(Integer.parseInt(jlCodigoUsuario.getText()));
        this.objAdministrador.setNome(jtfNome.getText());
        this.objAdministrador.setEmail(jtfEmail.getText());
        this.objAdministrador.setTelefone(jtfTelefone.getText());
        this.objAdministrador.setCpf(jtfCpf.getText());
        this.objAdministrador.setSenha(jtfSenha.getText());

        return true;
    }
    
    /**************************************************
     * BUSCANDO TODOS OS USUÁRIOS
     *************************************************/
    private void getAllUsers() {
        try {
            // BUSCANDO OS DADOS E CHAMANDO FUNCAO DE ADICAO NA TABELA
            this.usuarios = this.objUsuarioData.getUsers();
            addInTable();
        } catch (Exception ex) {
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * ADICIONANDO VALORES NAS TABELAS
     *************************************************/
    private void addInTable() {
        DefaultTableModel tableUsuarios = (DefaultTableModel) jtUsuarios.getModel();
        
        // ZERANDO A QUANTIDADE DE LINHAS
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
    }
    
    /**************************************************
     * INSERÇÃO OU ATUALIZAÇÃO DE DADOS EFETUADA COM SUCESSO
     *************************************************/   
    private void manipulationSuccess() {
        try {            
            // AÇOES NO FORMULÁRIO
            UtilsFormulario.cleanFields(this);
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
            getAllUsers();
            jlCodigoUsuario.setText("0");
            jcbTipoUsuario.setVisible(true);
            jlTipo.setVisible(true);
            
            // EXIBINDO MENSAGEM DE SUCESSO
            mensagemSucesso.setText("Ação realizada com sucesso!");
            UtilsFrontEnd.showHiddeElement(mensagemSucesso, 3000);

        } catch (Exception ex) {
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************************************************
     * VALIDAR CAMPOS
     *************************************************/   
    private boolean validateFields() {
        ArrayList<JTextField> fieldsRequired = new ArrayList<>();
        fieldsRequired.add(jtfNome);
        fieldsRequired.add(jtfEmail);
        fieldsRequired.add(jtfTelefone);
        fieldsRequired.add(jtfCpf);
        
        if(!UtilsFormulario.validateFieldsArray(fieldsRequired)) return false;
        
        return true;
    }
}