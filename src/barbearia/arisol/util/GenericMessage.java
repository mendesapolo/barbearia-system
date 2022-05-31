/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.util;

import java.awt.Component;
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
    
    public static void showAlertMessage(Component c, String msg){
        JOptionPane.showMessageDialog(c, msg, "Alerta !!", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showSuccess(Component c, String msg){
        JOptionPane.showMessageDialog(c, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showSuccess(Component c){
        JOptionPane.showMessageDialog(c, "Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int dataNotFound(Component c){
        return JOptionPane.showConfirmDialog(c, "Estes dados não foram encotrados?", "Dados não encotrados", JOptionPane.YES_NO_OPTION);
    }
    
    public static int confirmDeleteData(Component c){
        return JOptionPane.showConfirmDialog(c, "Desejas eliminar este registro permanentemente?", "Eliminar Dado", JOptionPane.YES_NO_OPTION);
    }
    
    public static void requiredData(Component c, String note){
        JOptionPane.showMessageDialog(c, "O(s) Campo(s) ("+note+") é/são obrigatório", "Campo(s) Obrigatório(s)", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showInvalidData(Component c){
        JOptionPane.showMessageDialog(c, "Dados inválido. Verifique todos os campos", "Dados inválidos", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showSuccessUpdate(Component c){
        JOptionPane.showMessageDialog(c, "Atualizado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showSuccessDelete(Component c){
        JOptionPane.showMessageDialog(c, "Eliminado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
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
