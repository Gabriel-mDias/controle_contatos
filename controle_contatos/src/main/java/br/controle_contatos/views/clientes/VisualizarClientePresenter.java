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
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarClientePresenter implements IPresenter {

    private ClienteView view;
    private JDesktopPane containerPai;
    private ClienteBusiness clienteBusiness;
    private Cliente clienteExibido;

    public VisualizarClientePresenter(JDesktopPane containerPai, Long idCliente) {
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

    public VisualizarClientePresenter(JDesktopPane containerPai, Cliente cliente) {
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
        this.view.getBtnConfirmar().setEnabled(false);
        this.view.getBtnConfirmar().setVisible(false);
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
        var contato = this.clienteExibido.getContato() == null ? "" : this.clienteExibido.getContato();
        var codigo = this.clienteExibido.getCodigo() == null ? "" : this.clienteExibido.getCodigo();

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
        this.view.getTxtContato().setText(contato);
        this.view.getTxtCodigo().setText(codigo);

        this.view.getTxtBairro().setText(bairro);
        this.view.getTxtCep().setText(cep);
        this.view.getTxtMunicipio().setText(municipio);
        this.view.getTxtComplemento().setText(complemento);
        this.view.getCbUf().setSelectedItem(uf);
        this.view.getTxtNumero().setText(numero);
        this.view.getTxtLogradouro().setText(logradouro);

        this.view.getTxtNomeFantasia().setEnabled(false);
        this.view.getTxtRazaoSocial().setEnabled(false);
        this.view.getTxtCnpjCpf().setEnabled(false);
        this.view.getTxtTipo().setEnabled(false);
        this.view.getTxtLojaRisco().setEnabled(false);
        this.view.getTxtTelefone().setEnabled(false);
        this.view.getTxtContato().setEnabled(false);
        this.view.getTxtCodigo().setEnabled(false);

        this.view.getTxtBairro().setEnabled(false);
        this.view.getTxtCep().setEnabled(false);
        this.view.getTxtMunicipio().setEnabled(false);
        this.view.getTxtComplemento().setEnabled(false);
        this.view.getCbUf().setEnabled(false);
        this.view.getTxtNumero().setEnabled(false);
        this.view.getTxtLogradouro().setEnabled(false);
        this.view.getTxtTelefone().setEnabled(false);
    }
}
