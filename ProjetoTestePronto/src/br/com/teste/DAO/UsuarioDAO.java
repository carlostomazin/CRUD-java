 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.teste.model.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author Carlos
 */
public class UsuarioDAO {
    
    private final Connection connection ;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        
        String sql = "insert into usuario (usuario,senha,email,telefone) values (?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.setString(3, usuario.getEmail());
        statement.setString(4, usuario.getTelefone());
        statement.execute();
        
    }

    public boolean ckeckLogin(String usuario, String senha) throws SQLException{
        
       
        
        String sql = "select * from usuario where usuario = ? and senha = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rs = null;
        
        boolean ckeck = false;
        
        statement.setString(1, usuario);
        statement.setString(2, senha);
        
        rs = statement.executeQuery();
        
        if(rs.next()){
            
            ckeck = true;
            
        }
        
        statement.execute();
        return ckeck;
    }
}
    
    

   

