package controlevendas.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UtilsFrontEnd {
    
    /******************************************************
     * EXIBE UM ELEMENTO E OCULTA APÓS DETERMINADOS MILISSEGUNDOS
     * @param label
     *******************************************************/
    public static void showHiddeElement(JLabel label, int delay) {
        label.setVisible(true);
        UtilsFrontEnd.setTimeout(() -> {
            label.setVisible(false);
        }, delay);
    }
    
    public static void showHiddeElement(JTextField field, int delay) {        
        field.setVisible(true);
        UtilsFrontEnd.setTimeout(() -> {
            field.setVisible(false);
        }, delay);
    }
    
    public static void showHiddeElement(JButton btn, int delay) {
        btn.setVisible(true);
        UtilsFrontEnd.setTimeout(() -> {
            btn.setVisible(false);
        }, delay);
    }
    
    
    /******************************************************
     * MÉTODO QUE EXECUTA FUNCAO COM UM INTERVALO
     * @param runnable
     * @param delay 
     *******************************************************/
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception error){
                System.err.println(error);
            }
        }).start();
    }
    
    /******************************************************
     * REMOVE BACKGROUND DE UM DETERMINADO BOTAO 
     * @param button
     *******************************************************/
    public static void removeBackground(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
   
    /******************************************************
     * LIMPA TODOS OS DADOS DA TABELA
     * @param table
     *******************************************************/
    public static void cleanTable(JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setNumRows(0);
    }
    
    /******************************************************
     * REMOVE APENAS UMA LINHA DA TABELA
     * @param table
     *******************************************************/
    public static void cleanRowTable(JTable table, int row) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.removeRow(row);
    }
}