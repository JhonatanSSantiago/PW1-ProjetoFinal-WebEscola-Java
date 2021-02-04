/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jhons
 */
public class Conexao {
    private final String url = "jdbc:postgresql://localhost/WebEscola20-2";
    private final String usuario="postgres";
    private final String senha="1998";
    
    public Connection getConexao(){
        Connection result = null;
        try {
            Class.forName("org.postgresql.Driver");
            result = DriverManager.getConnection(url, usuario, senha);
            return result;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}
