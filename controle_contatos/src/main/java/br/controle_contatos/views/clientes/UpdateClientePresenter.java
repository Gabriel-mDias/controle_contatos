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
public class UpdateClientePresenter implements IPresenter {
    
    private ClienteView view;
    private JDesktopPane containerPai;
    private ClienteBusiness clienteBusiness;
    private Cliente clienteExibido;

    public UpdateClientePresenter(JDesktopPane containerPai, Long idCliente) {
        try {
            this.clienteExibido = new Cliente();
            this.clienteExibido.setId(idCliente);
            this.clienteBusiness = new ClienteBusiness();
            this.containerPai = containerPai;
            this.view = new ClienteView();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
            this.containerPai.add(this.view);
            this.view.getFocusOwner();
            this.exibirClienteById();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UpdateClientePresenter(JDesktopPane containerPai, Cliente cliente) {
        try {
            this.clienteBusiness = new ClienteBusiness();
            this.containerPai = containerPai;
            this.view = new ClienteView();
            this.view.requestFocus();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
            this.containerPai.add(this.view);
            this.exibirCliente(cliente);
            this.view.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initComponents() throws Exception {
        this.view.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCliente();
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

    private void exibirClienteById() {
        try {
            this.clienteExibido = this.clienteBusiness.getByParametros(this.clienteExibido).get(0);
            this.preencheTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Falha ao buscar cliente", "Exibir Cliente", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void exibirCliente(Cliente cliente) {
        try {
            this.clienteExibido = cliente;
            this.preencheTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Falha ao exibir os dados do cliente", "Exibir Cliente", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void preencheTela() {
        var nomeFantasia = this.clienteExibido.getNomeFantasia() == null ? "" : this.clienteExibido.getNomeFantasia();
        var razaoSocial = this.clienteExibido.getRazaoSocial() == null ? "" : this.clienteExibido.getRazaoSocial();
        var cnpj = this.clienteExibido.getCnpjCpf() == null ? "" : this.clienteExibido.getCnpjCpf();
        var tipo = this.clienteExibido.getTipo() == null ? "" : this.clienteExibido.getTipo();
        var lojaRisco = this.clienteExibido.getLojaRisco() == null ? "" : this.clienteExibido.getLojaRisco();
        var telefone = this.clienteExibido.getTelefone() == null ? "" : this.clienteExibido.getTelefone();
        var codigo = this.clienteExibido.getCodigo()== null ? "" : this.clienteExibido.getCodigo();
        var contato = this.clienteExibido.getContato()== null ? "" : this.clienteExibido.getContato();

        var bairro = this.clienteExibido.getEndereco().getBairro() == null ? "" : this.clienteExibido.getEndereco().getBairro();
        var cep = this.clienteExibido.getEndereco().getCep() == null ? "" : this.clienteExibido.getEndereco().getCep();
        var municipio = this.clienteExibido.getEndereco().getMunicipio() == null ? "" : this.clienteExibido.getEndereco().getMunicipio();
        var complemento = this.clienteExibido.getEndereco().getComplemento() == null ? "" : this.clienteExibido.getEndereco().getComplemento();
        var uf = this.clienteExibido.getEndereco().getUf() == null ? "" : this.clienteExibido.getEndereco().getUf();
        var numero = this.clienteExibido.getEndereco().getNumero() == null ? "" : String.valueOf(this.clienteExibido.getEndereco().getNumero());
        var logradouro = this.clienteExibido.getEndereco().getLogradouro() == null ? "" : this.clienteExibido.getEndereco().getLogradouro();

        this.view.getTxtNomeFantasia().setText(nomeFantasia);
        this.view.getTxtRazaoSocial().setText(razaoSocial);
        this.view.getTxtCnpjCpf().setText(cnpj);
        this.view.getTxtTipo().setText(tipo);
        this.view.getTxtLojaRisco().setText(lojaRisco);
        this.view.getTxtTelefone().setText(telefone);
        this.view.getTxtCodigo().setText(codigo);
        this.view.getTxtContato().setText(contato);

        this.view.getTxtBairro().setText(bairro);
        this.view.getTxtCep().setText(cep);
        this.view.getTxtMunicipio().setText(municipio);
        this.view.getTxtComplemento().setText(complemento);
        this.view.getCbUf().setSelectedItem(uf);
        this.view.getTxtNumero().setText(numero);
        this.view.getTxtLogradouro().setText(logradouro);
    }
    
    private void updateCliente(){
        try {
            Cliente clienteAlterado = new Cliente();
            Endereco enderecoAlterado = new Endereco();
            
            var idEndereco = this.clienteExibido.getEndereco() == null ? null : this.clienteExibido.getEndereco().getId();
            enderecoAlterado.setId(idEndereco);

            clienteAlterado.setNomeFantasia(this.view.getTxtNomeFantasia().getText());
            clienteAlterado.setRazaoSocial(this.view.getTxtRazaoSocial().getText());
            if( this.view.getTxtCnpjCpf().getText() != null && this.view.getTxtCnpjCpf().getText().length() > 0 ){
                var cnpj = this.view.getTxtCnpjCpf().getText().replaceAll(".", "").replaceAll("-", "").replaceAll("/","");
                clienteAlterado.setCnpjCpf(cnpj);
            }     
            clienteAlterado.setTipo(this.view.getTxtTipo().getText());
            clienteAlterado.setLojaRisco(this.view.getTxtLojaRisco().getText());
            clienteAlterado.setTelefone(this.view.getTxtTelefone().getText());
            clienteAlterado.setCodigo(this.view.getTxtCodigo().getText());
            
            enderecoAlterado.setBairro(this.view.getTxtBairro().getText());
            if( this.view.getTxtCep().getText() != null && this.view.getTxtCep().getText().length() > 0 ){
                var cep = this.view.getTxtCep().getText().replace("-", "");
                enderecoAlterado.setCep(cep);
            }      
            enderecoAlterado.setMunicipio(this.view.getTxtMunicipio().getText());
            enderecoAlterado.setComplemento(this.view.getTxtComplemento().getText());
            enderecoAlterado.setUf(String.valueOf(this.view.getCbUf().getSelectedItem()));
            enderecoAlterado.setNumero(Integer.valueOf(this.view.getTxtNumero().getText()));
            enderecoAlterado.setLogradouro(this.view.getTxtLogradouro().getText());

            clienteAlterado.setEndereco(enderecoAlterado);
            clienteAlterado.setId(this.clienteExibido.getId());
            
            this.clienteBusiness.update(clienteAlterado);
            JOptionPane.showConfirmDialog(view, "Cliente alterado!", "Alterar Cliente", JOptionPane.DEFAULT_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Falha ao alterar cliente", "Alterar Cliente", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
