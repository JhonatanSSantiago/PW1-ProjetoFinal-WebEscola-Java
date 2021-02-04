package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Professor;
/*
 * @author jhons
 */
public class ProfessorDao {
    public Professor buscar(String nome){
        Professor professor = new Professor();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from professor where nome like '"+nome+"';";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            professor.setId(res.getInt("id"));
            professor.setNome(res.getString("nome"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return professor;
    }
    
    public List<Professor> listar(){
        List<Professor> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from professor;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Professor professor = new Professor();
                professor.setId(res.getInt("id"));
                professor.setNome(res.getString("nome"));
                lista.add(professor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Professor professor) {
        String nome = professor.getNome();
        String id = Integer.toString(professor.getId());
        String status = professor.getStatus();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO professor VALUES (" + id + ",'" + nome + "', "+status+"');";
       

        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Professor professor) {
        String nome = professor.getNome();
        String id = Integer.toString(professor.getId());
        String status = professor.getStatus();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update professor set nome= '"+nome+"', status= '"+status+"' where id = "+id+";";

        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return "Erro ao alterar";
        }
        return "Alterado com sucesso";
    }
    
    public String deletar(String id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "delete from professor where id="+id+";";

        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return "Erro ao deletar";
        }
        return "Deletado com sucesso";
    }
    
}
