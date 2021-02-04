package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

/**
 *
 * @author jhons
 */
public class AlunoDao {

     public Aluno buscar(String nome){
        Aluno aluno = new Aluno();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from aluno where nome like '"+nome+"';";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            aluno.setId(res.getInt("id"));
            aluno.setNome(res.getString("nome"));
            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return aluno;
    }
    
    public List<Aluno> listar(){
        List<Aluno> lista = new ArrayList();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "select * from aluno;";
         try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Aluno aluno = new Aluno();
                aluno.setId(res.getInt("id"));
                aluno.setNome(res.getString("nome"));
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            
        }
        return lista;
    }
    
    public String incluir(Aluno aluno) {
        String nome = aluno.getNome();
        String id = Integer.toString(aluno.getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "insert INTO aluno VALUES (" + id + ",'" + nome + "');";
       // String sql = "insert INTO aluno VALUES (" + id + ",'" + nome + "');";

        try {
            Statement st = conn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro de conexão");
            return sql;
        }
        return "Gravado com sucesso";
    }

    public String alterar(Aluno aluno) {
        String nome = aluno.getNome();
        String id = Integer.toString(aluno.getId());

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "update aluno set nome= '"+nome+"' where id = "+id+";";

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
        String sql = "delete from aluno where id="+id+";";

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

