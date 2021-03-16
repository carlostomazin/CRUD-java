/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.teste.model.Aplicacao;

/**
 *
 * @author Carlos
 */
public class AplicacaoDAO {
    private final Connection connection ;

    public AplicacaoDAO(Connection connection) {
        this.connection = connection;
    }

       
    
    public void insert (Aplicacao aplicacao) throws SQLException{
        
        String sql = "insert into aplicacao (razaoSocial,nomeFantasia,endereco) values (?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, aplicacao.getRazaosocial());
        statement.setString(2, aplicacao.getNomefantasia());
        statement.setString(3, aplicacao.getEndereco());
        statement.execute();
        
    }
    
    public void remove (Aplicacao aplicacao) throws SQLException {
        String sql = "delete from aplicacao where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, aplicacao.getId());
        statement.executeUpdate();
    }
    
    public void edit (Aplicacao aplicacao) throws SQLException{
        
        String sql = "update aplicacao set razaosocial = ?,nomefantasia = ?,endereco = ? where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, aplicacao.getRazaosocial());
        statement.setString(2, aplicacao.getNomefantasia());
        statement.setString(3, aplicacao.getEndereco());
        statement.setInt(4, aplicacao.getId());
        statement.executeUpdate();
        
        
        
    }

    public List<Aplicacao> Listar() throws SQLException{
        
        List<Aplicacao> aplicacoes = new ArrayList<>();
        
        String sql = "select * from aplicacao;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = null;
        rs = statement.executeQuery();
        
        while(rs.next()){
            Aplicacao aplicacao = new Aplicacao();
            
            aplicacao.setId(rs.getInt(1));
            aplicacao.setRazaosocial(rs.getString(2));
            aplicacao.setNomefantasia(rs.getString(3));
            aplicacao.setEndereco(rs.getString(4));
            
            aplicacoes.add(aplicacao);
        }
        
        statement.execute();
        return aplicacoes;
    }}



