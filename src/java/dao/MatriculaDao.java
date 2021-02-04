package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;
/*
 * @author jhons
 */
public class MatriculaDao {
    public Matricula buscar(String id){
        Matricula matricula = new Matricula();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from matricula where where id="+id+";";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            matricula.setId(res.getInt("id"));
            matricula.setStatus(res.getString("status"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return matricula;
    }
    
    public List<Matricula> listar(){
        List<Matricula> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from matricula;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Matricula matricula = new Matricula();
                matricula.setId(res.getInt("id"));
                matricula.setStatus(res.getString("status"));
                lista.add(matricula);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Matricula matricula) {
        String status = matricula.getStatus();
        String id = Integer.toString(matricula.getId());
        String nota = String.valueOf(matricula.getNota());
        String idAluno = Integer.toString(matricula.getAluno().getId());
        String idTurma = Integer.toString(matricula.getTurma().getId());
        

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO matricula VALUES (" + id + ",'" + idAluno + "', " + idTurma + ", " + nota + ", '" + status + "');" ;


        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Matricula matricula) {
        String nota = String.valueOf(matricula.getNota());
        String id = Integer.toString(matricula.getId());
        String status = matricula.getStatus();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update matricula set nome= '"+nota+"', status= '"+status+"' where id = "+id+";";

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
        String sql = "delete from matricula where id="+id+";";

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
