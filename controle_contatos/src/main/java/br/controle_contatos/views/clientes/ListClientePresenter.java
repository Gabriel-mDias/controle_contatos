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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author gabriel
 */
public class ListClientePresenter implements IPresenter{
    
    private ListClienteView view;
    private JDesktopPane containerPai;
    private ClienteBusiness clienteBusiness;
    private Cliente filtro;
    private List<Cliente> listClientes;
    
    public ListClientePresenter(JDesktopPane containerPai){
        filtro = new Cliente();
        listClientes = new ArrayList<>();
        clienteBusiness = new ClienteBusiness();
        
        try{
            this.containerPai = containerPai;
            this.view = new ListClienteView();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
            this.containerPai.add(view);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public ListClienteView getView() {
        return view;
    }

    @Override
    public void initComponents() throws Exception {
        this.view.getBtnBuscar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarContatos();
            }
        });
        
        this.view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
        
        this.view.getBtnExibir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibir();
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
    
    public void buscarContatos(){
        try{
            this.filtro = new Cliente();
            String valorBuscado = this.view.getTxtFiltro().getText();
        
            switch ( this.view.getCbBusca().getSelectedIndex() ){
                case 0:
                    filtro.setCnpjCpf(valorBuscado);
                    break;
                case 1:
                    filtro.setNomeFantasia(valorBuscado);
                    break;
                case 2:
                    filtro.setRazaoSocial(valorBuscado);
                    break;
                default:
                    filtro.setCnpjCpf(valorBuscado);
                    break;
            }

            this.listClientes.clear();
            this.listClientes.addAll(this.clienteBusiness.getByParametros(filtro));
            this.preencheTabela();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    private void preencheTabela(){
        var dadosTabela = new DefaultTableModel(new Object[]{"ID", "CNPJ ou CPF", "Nome Fantasia", "Razão Social"}, 0);
        
        for(Cliente elemento : listClientes){
            dadosTabela.addRow( new Object[]{
                elemento.getId(),
                elemento.getCnpjCpf(),
                elemento.getNomeFantasia(),
                elemento.getRazaoSocial()
            });
        }
        
        this.view.getTblClientes().setModel(dadosTabela);
    }
    
    private void excluir(){
        try{
            var posicaoSelecionada = this.view.getTblClientes().getSelectedRow();
        
            if(posicaoSelecionada < 0 ){
                JOptionPane.showMessageDialog(view, "Cliente não selecionado", "Excluir Cliente", JOptionPane.ERROR_MESSAGE);
            }else{
                var idCliente = this.listClientes.get(posicaoSelecionada);
                this.clienteBusiness.excluir(idCliente.getId());
                JOptionPane.showConfirmDialog(view, "Cliente excluído!", "Excluir Cliente", JOptionPane.DEFAULT_OPTION);
                this.listClientes.remove(idCliente);
                preencheTabela();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Error ao excluir o cliente, consultar os desenvolvedores", "Excluir Cliente", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void exibir(){
        try{
            var posicaoSelecionada = this.view.getTblClientes().getSelectedRow();
        
            if(posicaoSelecionada < 0 ){
                JOptionPane.showMessageDialog(view, "Cliente não selecionado", "Exibir Cliente", JOptionPane.ERROR_MESSAGE);
            }else{
                var cliente = this.listClientes.get(posicaoSelecionada);
                new VisualizarCliente(containerPai, cliente);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Error ao exibir o cliente, consultar os desenvolvedores", "Exibir Cliente", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
