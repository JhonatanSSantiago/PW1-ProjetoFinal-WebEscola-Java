package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Turma;
/*
 * @author jhons
 */
public class TurmaDao {
    public Turma buscar(String nome){
        Turma turma = new Turma();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from turma where nome like '"+nome+"';";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            turma.setId(res.getInt("id"));
            turma.setPeriodoLetivo(res.getString("periodo"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return turma;
    }
    
    public List<Turma> listar(){
        List<Turma> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from turma;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Turma turma = new Turma();
                turma.setId(res.getInt("id"));
                turma.setPeriodoLetivo(res.getString("periodo"));
                lista.add(turma);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Turma turma) {
        String id = Integer.toString(turma.getId());
        String nome = turma.getNome();
        String periodo = turma.getPeriodoLetivo();
        String idProfessor = Integer.toString(turma.getProfessor().getId());
        String idDisciplina = Integer.toString(turma.getDisciplina().getId());
        

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO turma VALUES (" + id + ",'" + nome + "', '" + periodo + "', " + idDisciplina + ", " + idProfessor + ");" ;


        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Turma turma) {
        String id = Integer.toString(turma.getId());
        String nome = turma.getNome();
        String periodo = turma.getPeriodoLetivo();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update turma set nome= '"+nome+"', periodoletivo= '"+periodo+"' where id = "+id+";";

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
        String sql = "delete from turma where id="+id+";";

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
