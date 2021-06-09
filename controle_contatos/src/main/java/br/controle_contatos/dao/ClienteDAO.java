package br.controle_contatos.dao;

import br.controle_contatos.dao.connection.SqliteManager;
import br.controle_contatos.models.Cliente;
import br.controle_contatos.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ClienteDAO {

    private SqliteManager manager;

    public ClienteDAO() {
        this.manager = new SqliteManager();
    }

    public void update(Cliente cliente) throws SQLException, Exception {

        try {
            String query = "UPDATE Cliente SET razao_social=?, telefone=?, cnpj_cpf=?, nome_fantasia=? WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getRazaoSocial());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getCnpjCpf());
            ps.setString(4, cliente.getNomeFantasia());
            ps.setLong(5, cliente.getId());

            
            ps.executeUpdate();
            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao Atualizar");
        }
    }

    public void insert(Cliente cliente) throws Exception {
        try {
            String query = "INSERT INTO Cliente(razao_social, telefone, cnpj_cpf, nome_fantasia, "
                    + cliente.getEndereco() != null ? ", id_endereco ) " : " ) "
                    + "VALUES (?,?,?,?,?,?,?"
                    + cliente.getEndereco() != null ? ",?" : ""
                    + ")";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getRazaoSocial());
            ps.setString(2, cliente.getTelefone());
            ps.setString(6, cliente.getCnpjCpf());
            ps.setString(7, cliente.getNomeFantasia());
            if (cliente.getEndereco() != null) {
                ps.setLong(8, cliente.getEndereco().getId());
            }

            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    public List<Cliente> getByParametros(Cliente cliente) throws Exception {
        try {
            StringBuilder query = new StringBuilder("SELECT c.id, c.razao_social, c.nome_fantasia, c.telefone, c.cnpj_cpf, ");
            query.append(" e.id, e.logradouro, e.numero, e.complemento, e.bairro, e.municipio, e.cep, e.uf ");
            query.append(" FROM Cliente c, Endereco e ");
            query.append(" WHERE c.id_endereco = e.id ");

            if (cliente != null) {

                if (cliente.getId() != null && cliente.getId().compareTo(0L) > 0) {
                    query.append(" AND c.id = ? ");
                }

                if (cliente.getRazaoSocial() != null && cliente.getRazaoSocial().length() > 0) {
                    query.append(" AND UPPER(c.razao_social) LIKE ? ");
                }

                if (cliente.getNomeFantasia() != null && cliente.getNomeFantasia().length() > 0) {
                    query.append(" AND UPPER(c.nome_fantasia) LIKE ? ");
                }

                if (cliente.getTelefone() != null && cliente.getTelefone().length() > 0) {
                    query.append(" AND c.telefone LIKE ? ");
                }

                if (cliente.getCnpjCpf() != null && cliente.getCnpjCpf().length() > 0) {
                    query.append(" AND c.cnpj_cpf LIKE ? ");
                }

                if (cliente.getEndereco() != null) {

                    if (cliente.getEndereco().getLogradouro().length() > 0) {
                        query.append(" AND UPPER(e.logradouro) LIKE ? ");
                    }

                    if (cliente.getEndereco().getUf() != null && cliente.getEndereco().getUf().length() > 0) {
                        query.append(" AND UPPER(e.uf) LIKE ? ");
                    }

                    if (cliente.getEndereco().getNumero() != null && cliente.getEndereco().getNumero().compareTo(0) > 0) {
                        query.append(" AND e.numero = ? ");
                    }

                    if (cliente.getEndereco().getCep() != null && cliente.getEndereco().getCep().length() > 0) {
                        query.append(" AND UPPER(e.cep) LIKE ? ");
                    }

                    if (cliente.getEndereco().getComplemento() != null && cliente.getEndereco().getComplemento().length() > 0) {
                        query.append(" AND UPPER(e.complemento) LIKE ? ");
                    }

                    if (cliente.getEndereco().getBairro() != null && cliente.getEndereco().getBairro().length() > 0) {
                        query.append(" AND UPPER(e.bairro) LIKE ? ");
                    }

                    if (cliente.getEndereco().getMunicipio() != null && cliente.getEndereco().getMunicipio().length() > 0) {
                        query.append(" AND UPPER(e.municipio) LIKE ? ");
                    }
                }
            }

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            PreparedStatement ps = conn.prepareStatement(query.toString());

            if (cliente != null) {

                int posicao = 1;

                if (cliente.getId() != null && cliente.getId().compareTo(0L) > 0) {
                    ps.setLong(posicao++, cliente.getId());
                }

                if (cliente.getRazaoSocial() != null && cliente.getRazaoSocial().length() > 0) {
                    ps.setString(posicao++, "%" + cliente.getRazaoSocial().toUpperCase() + "%");
                }

                if (cliente.getNomeFantasia() != null && cliente.getNomeFantasia().length() > 0) {
                    ps.setString(posicao++, "%" + cliente.getNomeFantasia().toUpperCase() + "%");
                }

                if (cliente.getTelefone() != null && cliente.getTelefone().length() > 0) {
                    ps.setString(posicao++, "%" + cliente.getTelefone() + "%");
                }

                if (cliente.getCnpjCpf() != null && cliente.getCnpjCpf().length() > 0) {
                    ps.setString(posicao++, "%" + cliente.getCnpjCpf() + "%");
                }

                if (cliente.getEndereco() != null) {

                    if (cliente.getEndereco().getLogradouro().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getLogradouro().toUpperCase() + "%");
                    }

                    if (cliente.getEndereco().getUf() != null && cliente.getEndereco().getUf().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getUf().toUpperCase() + "%");
                    }

                    if (cliente.getEndereco().getNumero() != null && cliente.getEndereco().getNumero().compareTo(0) > 0) {
                        ps.setLong(posicao++, cliente.getEndereco().getNumero());
                    }

                    if (cliente.getEndereco().getCep() != null && cliente.getEndereco().getCep().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getCep().toUpperCase() + "%");
                    }

                    if (cliente.getEndereco().getComplemento() != null && cliente.getEndereco().getComplemento().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getComplemento().toUpperCase() + "%");
                    }

                    if (cliente.getEndereco().getBairro() != null && cliente.getEndereco().getBairro().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getBairro().toUpperCase() + "%");
                    }

                    if (cliente.getEndereco().getMunicipio() != null && cliente.getEndereco().getMunicipio().length() > 0) {
                        ps.setString(posicao++, "%" + cliente.getEndereco().getMunicipio().toUpperCase() + "%");
                    }
                }
            }

            ResultSet rs = ps.executeQuery();
            List<Cliente> contatos = new ArrayList<>();

            while (rs.next()) {
                Cliente elemento = new Cliente();
                Endereco enderecoElemento = new Endereco();

                elemento.setId(rs.getLong("id"));
                elemento.setRazaoSocial(rs.getString("razao_social"));
                elemento.setNomeFantasia(rs.getString("nome_fantasia"));
                elemento.setTelefone(rs.getString("telefone"));
                elemento.setCnpjCpf(rs.getString("cnpj_cpf"));

                enderecoElemento.setLogradouro(rs.getString("logradouro"));
                enderecoElemento.setNumero(rs.getInt("numero"));
                enderecoElemento.setComplemento(rs.getString("complemento"));
                enderecoElemento.setBairro(rs.getString("bairro"));
                enderecoElemento.setMunicipio(rs.getString("municipio"));
                enderecoElemento.setCep(rs.getString("cep"));
                enderecoElemento.setUf(rs.getString("uf"));

                elemento.setEndereco(enderecoElemento);
                contatos.add(elemento);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return contatos;

        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            ex.printStackTrace();
            throw new Exception("Erro ao buscar");
        }
    }

}
