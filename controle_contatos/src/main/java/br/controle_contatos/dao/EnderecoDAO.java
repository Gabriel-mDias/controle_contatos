
package br.controle_contatos.dao;

import br.controle_contatos.dao.connection.SqliteManager;
import br.controle_contatos.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gabriel
 */
public class EnderecoDAO {
    
    private SqliteManager manager;

    public EnderecoDAO() {
        this.manager = new SqliteManager();
    }
    
    /**
     * Método responsável pela inserção de um endereço
     * @param endereco
     * @return id do Endereco inserido
     * @throws Exception 
     */
    public Long insert(Endereco endereco) throws Exception {
        try {
            String query = "INSERT INTO Endereco(logradouro, numero, complemento, bairro, municipio, cep, uf) "
                       + "VALUES (?,?,?,?,?,?,?)";
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, endereco.getLogradouro());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getMunicipio());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getUf());
            
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
        
        return this.maxIdValue(); 
    }
    
    /**
     * Método que busca o maior valor, que corresponde também ao último inserido, na tabela 
     * de endereço.
     * @return maior valor de ID na tabela Endereço
     */
    private Long maxIdValue() throws Exception{
        Long maxId = 0L;
        try{
            String query = "SELECT MAX(id) as maxID FROM Endereco ";
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            ResultSet rs = conn.prepareStatement(query.toString()).executeQuery();
            
            if(rs.next()){
                maxId = rs.getLong("maxID");
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
            
        return maxId;
    }
    
    public void delete(Long id) throws Exception {
        try {
            String SQL = "DELETE FROM Endereco WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao deletar");
        }
    }

}
