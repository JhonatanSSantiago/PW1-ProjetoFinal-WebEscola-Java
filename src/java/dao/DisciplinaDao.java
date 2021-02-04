package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;

/*
 * @author jhons
 */
public class DisciplinaDao {
    
    public Disciplina buscar(String nome){
        Disciplina disciplina = new Disciplina();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from disciplina where nome like '"+nome+"';";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            disciplina.setId(res.getInt("id"));
            disciplina.setNome(res.getString("nome"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return disciplina;
    }
    
    public List<Disciplina> listar(){
        List<Disciplina> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from disciplina;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(res.getInt("id"));
                disciplina.setNome(res.getString("nome"));
                lista.add(disciplina);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Disciplina disciplina) {
        String nome = disciplina.getNome();
        String id = Integer.toString(disciplina.getId());
        String idCurso = Integer.toString(disciplina.getCurso().getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO disciplina VALUES (" + id + ",'" + nome + "', " + idCurso + ");" ;


        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Disciplina disciplina) {
        String nome = disciplina.getNome();
        String id = Integer.toString(disciplina.getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update disciplina set nome= '"+nome+"' where id = "+id+";";

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
        String sql = "delete from disciplina where id="+id+";";

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
