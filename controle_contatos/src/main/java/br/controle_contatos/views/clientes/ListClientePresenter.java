/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.views.clientes;

import br.controle_contatos.views.interfaces.IPresenter;
import java.awt.Dimension;
import javax.swing.JDesktopPane;

/**
 *
 * @author gabriel
 */
public class ListClientePresenter implements IPresenter{
    
    private ListClienteView view;
    private JDesktopPane containerPai;
    
    public ListClientePresenter(JDesktopPane containerPai){
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
    }

    @Override
    public void centralizarTela() throws Exception {
        Dimension desktopSize = containerPai.getSize();
        Dimension jInternalFrameSize = this.view.getSize();
        this.view.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                              (desktopSize.height - jInternalFrameSize.height) / 2);
    }
    
}
