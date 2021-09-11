package controlevendas.utils;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UtilsFormulario {
    /********************************************************* 
     * LIMPAR CAMPOS DE UM JFRAME OU JINTERNALFRAME
    **********************************************************/
    public static void cleanFields(JFrame form) throws Exception {
        cleanFields(form.getComponents());
    }
    
    public static void cleanFields(JInternalFrame form) throws Exception {
        cleanFields(form.getContentPane().getComponents());
    }
    
    private static void cleanFields(Component[] form) throws Exception {
        for(Component c: form) {
            if(c instanceof JTextField) {
                JTextField t = (JTextField) c;
                t.setText("");       
            }
            
            if(c instanceof JTextArea) {
                JTextArea t = (JTextArea) c;
                t.setText(""); 
            }
            
            if(c instanceof JComboBox) {
                JComboBox t = (JComboBox) c;
                t.setSelectedIndex(0);       
            }
        }  
    }
    
    /********************************************************* 
     * VALIDAR CAMPOS
    **********************************************************/
    public static boolean validateFields(JFrame form) {
        return validateFields(form.getComponents());
    }
    
    public static boolean validateFields(JInternalFrame form) {
        return validateFields(form.getContentPane().getComponents());
    }
    
    private static boolean validateFields(Component[] form) {
        for(Component c: form) {
            if(c instanceof JTextField) {
                JTextField t = (JTextField) c;
                if(t.getText().trim().length() <= 0) return false;      
            }
            
            if(c instanceof JComboBox) {
                JComboBox t = (JComboBox) c;
                if(t.getSelectedIndex() == 0) return false;  
            }
        }
        
        return true;
    }
    
    /********************************************************* 
     * VALIDAR CAMPOS PASSADOS POR PARÂMETRO
    **********************************************************/
    public static boolean validateFieldsArray(ArrayList<JTextField> fields) {
        for(JTextField field: fields) {
            if(field.getText().trim().length() <= 0) return false;
        }
        
        return true;
    }
}
