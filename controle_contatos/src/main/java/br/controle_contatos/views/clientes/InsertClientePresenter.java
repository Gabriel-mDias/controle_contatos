/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.views.clientes;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.views.interfaces.IPresenter;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class InsertClientePresenter implements IPresenter{
    
    private ClienteView view;
    private JDesktopPane containerPai;
    private ClienteBusiness clienteBusiness;
    
    public InsertClientePresenter(JDesktopPane containerPai){
        try{
            this.clienteBusiness = new ClienteBusiness();
            this.containerPai = containerPai;
            this.view = new ClienteView();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
            this.containerPai.add(this.view);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void initComponents() throws Exception{  
        this.view.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCliente();
            }
        });
    }

    @Override
    public void centralizarTela() throws Exception {
        Dimension desktopSize = containerPai.getSize();
        Dimension jInternalFrameSize = this.view.getSize();
        this.view.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                              (desktopSize.height - jInternalFrameSize.height) / 2);
    }
    
    private void insertCliente(){
        Cliente novoCliente = new Cliente();
        
        novoCliente.setNomeFantasia(this.view.getTxtNomeFantasia().getText());
        novoCliente.setRazaoSocial(this.view.getTxtRazaoSocial().getText());
        novoCliente.setCnpjCpf(this.view.getTxtCnpjCpf().getText());
        
        try {
            this.clienteBusiness.insert(novoCliente);
            JOptionPane.showConfirmDialog(view, "Cliente inserido!", "Inserir Cliente", JOptionPane.DEFAULT_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Falha ao inserir cliente", "Inserir Cliente", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
