package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Contato;

/**
 * @brief Classe ContatoDao
 * @author Paulo Henrique
 * @date criado em: 01/09/2023
 */
public class ContatoDao {

    // a conexão com o banco de dados
    private Connection connection;
    
    // contrutor usado na classe: FiltroConexao do pacote filtro para obter uma conexão.
    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Contato contato) {
        String sql = "insert into agenda.contatos "
                + "(nome,endereco,email,dataNascimento)"
                + " values (?,?,?,?)";

        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // seta os valores           
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEndereco());
            stmt.setString(3, contato.getEmail());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void altera(Contato contato) {
        String sql = "update agenda.contatos set nome=?, email=?,"
                + "endereco=?, dataNascimento=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from agenda.contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Contato get(int id) {
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from agenda.contatos where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Contato contato = new Contato();
            
            while (rs.next()) {                
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setEmail(rs.getString("email"));
                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
            }
            stmt.close();
            rs.close();
            System.out.println("ID: " + contato.getId());
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Data Nascimento: " + contato.getDataNascimento());
            return contato;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }
    
    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from agenda.contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setEmail(rs.getString("email"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                // adicionando	o objeto à lista
                contatos.add(contato);
            }
            stmt.close();
            rs.close();
            return contatos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }        
    
    public List<Contato> getPesquisaNome(String pesquisa) {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            //PreparedStatement stmt = this.connection.prepareStatement("select * from agenda.contatos where nome like '?%'");
            PreparedStatement stmt = this.connection.prepareStatement("select * from agenda.contatos where nome like '%"+pesquisa+"%'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setEmail(rs.getString("email"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                // adicionando	o objeto à lista
                contatos.add(contato);
            }
            stmt.close();
            rs.close();
            return contatos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
