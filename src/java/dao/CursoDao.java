package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
/*
 * @author jhons
 */
public class CursoDao {
    public Curso buscar(String nome){
        Curso curso = new Curso();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from curso where nome like '"+nome+"';";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            curso.setId(res.getInt("id"));
            curso.setNome(res.getString("nome"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return curso;
    }
    
    public List<Curso> listar(){
        List<Curso> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from curso;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Curso curso = new Curso();
                curso.setId(res.getInt("id"));
                curso.setNome(res.getString("nome"));
                lista.add(curso);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Curso curso) {
        String nome = curso.getNome();
        String id = Integer.toString(curso.getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO curso VALUES (" + id + ",'" + nome + "');";

        try {
            Statement st = conn.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Curso curso) {
        String nome = curso.getNome();
        String id = Integer.toString(curso.getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update curso set nome= '"+nome+"' where id = "+id+";";

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
        String sql = "delete from curso where id="+id+";";

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
