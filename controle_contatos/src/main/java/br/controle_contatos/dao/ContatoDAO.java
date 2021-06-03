package br.controle_contatos.dao;

import br.controle_contatos.dao.connection.SqliteManager;
import br.controle_contatos.models.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ContatoDAO {
    
    private SqliteManager manager;
    
    public ContatoDAO(){
        this.manager = new SqliteManager();
    }
    
    public void insert(Contato contato) throws Exception {
        try {
            String query = "INSERT INTO ContatoContato(razao_social, telefone_1, telefone_2, telefone_3, cnpj_cpf, localidade, uf) "
                       + "VALUES (?,?,?,?,?,?,?)";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, contato.getRazaoSocial());
            ps.setString(2, contato.getTelefone1());
            ps.setString(3, contato.getTelefone2());
            ps.setString(4, contato.getTelefone3());
            ps.setString(5, contato.getCnpjCpf());
            ps.setString(6, contato.getLocalidade());
            ps.setString(7, contato.getUf());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }
    
    public List<Contato> getByParametros(Contato contato) throws Exception {
        try {
            StringBuilder query = new StringBuilder("SELECT c.id, c.razao_social, c.telefone_1, c.telefone_2, c.telefone_3, c.cnpj_cpf, c.localidade, c.uf ");
            query.append(" FROM Contato c ");
            query.append(" WHERE 1=1 ");
            
            if(contato != null){
                
                if(contato.getId() != null && contato.getId().compareTo(0L) > 0 ){
                    query.append(" AND c.id = ? ");
                }
                
                if(contato.getRazaoSocial() != null && contato.getRazaoSocial().length() > 0 ){
                    query.append(" AND c.razao_social LIKE ? ");
                }
                
                if(contato.getTelefone1() != null && contato.getTelefone1().length() > 0 ){
                    query.append(" AND c.telefone_1 LIKE ? ");
                }
                
                if(contato.getTelefone2() != null && contato.getTelefone2().length() > 0 ){
                    query.append(" AND c.telefone_2 LIKE ? ");
                }
                
                if(contato.getTelefone3() != null && contato.getTelefone3().length() > 0 ){
                    query.append(" AND c.telefone_3 LIKE ? ");
                }
                
                if(contato.getCnpjCpf() != null && contato.getCnpjCpf().length() > 0 ){
                    query.append(" AND c.cnpj_cpf LIKE ? ");
                }
                
                if(contato.getLocalidade() != null && contato.getLocalidade().length() > 0 ){
                    query.append(" AND c.localidade LIKE ? ");
                }
                
                if(contato.getUf() != null && contato.getUf().length() > 0 ){
                    query.append(" AND c.uf LIKE ? ");
                }
            }
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            PreparedStatement ps = conn.prepareStatement(query.toString());
            
            
            if(contato != null){
            
                int posicao = 1;
                
                if(contato.getId() != null && contato.getId().compareTo(0L) > 0 ){
                    ps.setLong(posicao++, contato.getId());
                }
                
                if(contato.getRazaoSocial() != null && contato.getRazaoSocial().length() > 0 ){
                    ps.setString(posicao++, contato.getRazaoSocial());
                }
                
                if(contato.getTelefone1() != null && contato.getTelefone1().length() > 0 ){
                    ps.setString(posicao++, contato.getTelefone1());
                }
                
                if(contato.getTelefone2() != null && contato.getTelefone2().length() > 0 ){
                    ps.setString(posicao++, contato.getTelefone2());
                }
                
                if(contato.getTelefone3() != null && contato.getTelefone3().length() > 0 ){
                    ps.setString(posicao++, contato.getTelefone3());
                }
                
                if(contato.getCnpjCpf() != null && contato.getCnpjCpf().length() > 0 ){
                    ps.setString(posicao++, contato.getCnpjCpf());
                }
                
                if(contato.getLocalidade() != null && contato.getLocalidade().length() > 0 ){
                    ps.setString(posicao++, contato.getLocalidade());
                }
                
                if(contato.getUf() != null && contato.getUf().length() > 0 ){
                    ps.setString(posicao++, contato.getUf());
                }
            }
          
            ResultSet rs = ps.executeQuery();
            List<Contato> contatos = new ArrayList<Contato>();
            
            while(rs.next()){
                Contato elemento = new Contato();
                
                elemento.setId(rs.getLong("id"));
                elemento.setRazaoSocial(rs.getString("razao_social"));
                elemento.setTelefone1(rs.getString("telefone_1"));
                elemento.setTelefone2(rs.getString("telefone_2"));
                elemento.setTelefone3(rs.getString("telefone_3"));
                elemento.setCnpjCpf(rs.getString("cnpj_cpf"));
                elemento.setLocalidade(rs.getString("localidade"));
                elemento.setUf(rs.getString("uf"));
                
                contatos.add(elemento);
            }

            this.manager.fechaTransacao();
            this.manager.close();
            
            return contatos;
            
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }
}
