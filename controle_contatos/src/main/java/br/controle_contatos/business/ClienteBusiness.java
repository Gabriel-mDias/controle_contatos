/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle_contatos.business;

import br.controle_contatos.dao.ClienteDAO;
import br.controle_contatos.dao.EnderecoDAO;
import br.controle_contatos.models.Cliente;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ClienteBusiness {

    private ClienteDAO clienteDAO;
    private EnderecoDAO enderecoDAO;

    public ClienteBusiness() {
        this.clienteDAO = new ClienteDAO();
        this.enderecoDAO = new EnderecoDAO();
    }

    public void insert(Cliente cliente) throws Exception {
        if (cliente != null) {

            if (cliente.getEndereco() != null) {
                Long idEndereco = this.enderecoDAO.insert(cliente.getEndereco());
                cliente.getEndereco().setId(idEndereco);
            }

            this.clienteDAO.insert(cliente);

        } else {
            throw new Exception("Cliente passado para a inserção é vazio ou inválido");
        }
    }

    public void update(Cliente cliente) throws Exception {
        if (cliente != null) {
            this.clienteDAO.update(cliente);
            if (cliente.getEndereco() != null) {
                this.enderecoDAO.update(cliente.getEndereco());
            } else {
                throw new Exception("Endereço passado para update é nulo");
            }
        } else {
            throw new Exception("Cliente passado para update é nulo");
        }
    }

    public List<Cliente> getByParametros(Cliente clienteConsultado) throws Exception {
        if (clienteConsultado != null) {
            return this.clienteDAO.getByParametros(clienteConsultado);
        } else {
            throw new Exception("Cliente passado para a busca é vazio ou inválido");
        }
    }
    
    public void excluir(Long id) throws Exception {
        if(id != null){
            Cliente clienteId = new Cliente();
            clienteId.setId(id);
            var listaExclusao = this.clienteDAO.getByParametros(clienteId);
            
            if(listaExclusao != null && listaExclusao.size() == 1){
                var clienteExcluido = listaExclusao.get(0);
                
                if(clienteExcluido.getEndereco() != null && clienteExcluido.getEndereco().getId() != null){
                    this.enderecoDAO.delete(clienteExcluido.getEndereco().getId());
                }
                
                this.clienteDAO.delete(id);
            }
        }else{
            throw new Exception("ID passado para exclusão é inválido");
        }
    }
    
    public List<String> getAllMunicipios() throws Exception {
        return this.enderecoDAO.getAllMunicipios();
    }
}
