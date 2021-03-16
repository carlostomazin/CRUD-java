/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhoste:5432/teste","postgres", "123");
        return conexao;
    }
}