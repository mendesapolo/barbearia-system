/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.util;

import javax.swing.JOptionPane;

/**
 *
 * @author António Apolo
 */
public class GenericMessage {
    
    public static final String OPERATION_SUCCESS = "Operação efetuada com Sucesso";
    public static final String ERROR_CREATE = "Houve uma falha ao registrar na base de dados";
    public static final String ERROR_LIST = "Falha ao consultar os dados";
    public static final String ERROR_UPDATE = "Falha ao tentar atualizar o registro";
    public static final String ERROR_DELETE = "Falha ao tentar Eliminar o registro";
    public static final String ERROR = "Houve uma falha inesperada no sistema";
    
    public static void showErrorUpdate(){
        JOptionPane.showMessageDialog(null, GenericMessage.ERROR_UPDATE, "Erro ao Atualizar", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorList(){
        JOptionPane.showMessageDialog(null, GenericMessage.ERROR_LIST, "Erro ao Listar", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorCreate(){
        JOptionPane.showMessageDialog(null, GenericMessage.ERROR_CREATE, "Erro ao Registar", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorDelete(){
        JOptionPane.showMessageDialog(null, GenericMessage.ERROR_DELETE, "Erro ao Eliminar", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showInDevelopment(){
        JOptionPane.showMessageDialog(null, "Esta em desenvolvimento...", "INFO", JOptionPane.WARNING_MESSAGE);
    }
    
}
