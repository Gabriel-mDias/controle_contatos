/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.views.clientes;

import br.controle_contatos.business.ClienteBusiness;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.Endereco;
import br.controle_contatos.views.interfaces.IPresenter;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            this.view.requestFocus();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
            this.containerPai.add(this.view);
            this.view.requestFocus();
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
        try {
            Cliente novoCliente = new Cliente();
            Endereco endereco = new Endereco();

            novoCliente.setNomeFantasia(this.view.getTxtNomeFantasia().getText());
            novoCliente.setRazaoSocial(this.view.getTxtRazaoSocial().getText());
            if( this.view.getTxtCnpjCpf().getText() != null && this.view.getTxtCnpjCpf().getText().length() > 0 ){
                var cnpj = this.view.getTxtCnpjCpf().getText().replaceAll("[\\D]", "");
                novoCliente.setCnpjCpf(cnpj);
            }     
            novoCliente.setTipo(this.view.getTxtTipo().getText());
            novoCliente.setLojaRisco(this.view.getTxtLojaRisco().getText());
            novoCliente.setTelefone(this.view.getTxtTelefone().getText());
            novoCliente.setCodigo(this.view.getTxtCodigo().getText());
            novoCliente.setContato(this.view.getTxtContato().getText());
            
            endereco.setBairro(this.view.getTxtBairro().getText());
            if( this.view.getTxtCep().getText() != null && this.view.getTxtCep().getText().length() > 0 ){
                var cep = this.view.getTxtCep().getText().replace("-", "");
                endereco.setCep(cep);
            }      
            endereco.setMunicipio(this.view.getTxtMunicipio().getText());
            endereco.setComplemento(this.view.getTxtComplemento().getText());
            endereco.setUf(String.valueOf(this.view.getCbUf().getSelectedItem()));
            endereco.setNumero(Integer.valueOf(this.view.getTxtNumero().getText()));
            endereco.setLogradouro(this.view.getTxtLogradouro().getText());

            novoCliente.setEndereco(endereco);
        
            this.clienteBusiness.insert(novoCliente);
            JOptionPane.showConfirmDialog(view, "Cliente inserido!", "Inserir Cliente", JOptionPane.DEFAULT_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Falha ao inserir cliente", "Inserir Cliente", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
