/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.views;

import br.controle_contatos.views.clientes.ClientePresenter;
import br.controle_contatos.views.clientes.ListClientePresenter;
import br.controle_contatos.views.interfaces.IPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gabriel
 */
public class TelaPrincipalPresenter implements IPresenter{
    
    private TelaPrincipalView view;

    public TelaPrincipalPresenter() {
        try{
            this.view = new TelaPrincipalView();
            this.initComponents();
            this.centralizarTela();
            this.view.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() throws Exception {
        
        this.view.getItemInserirCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientePresenter(view.getMainContainer());
            }
        });
        
        this.view.getItemListarCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListClientePresenter(view.getMainContainer());
            }
        });
        
    }

    @Override
    public void centralizarTela() throws Exception {
    }
    
}
