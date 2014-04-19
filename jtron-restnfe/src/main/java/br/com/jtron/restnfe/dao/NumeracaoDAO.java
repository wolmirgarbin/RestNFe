package br.com.jtron.restnfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jtron.restnfe.dto.Numeracao;
import br.com.jtron.restnfe.util.ConnectionHelper;

public class NumeracaoDAO {
	
		
	public Numeracao nextVal(Integer idEmpresa,Connection con){				
		Numeracao numeracao = null;				
		PreparedStatement ps = null;
		ResultSet rs = null;						
		try {
			ps = con.prepareStatement("select * from numeracao where idEmpresa = ?");
			ps.setInt(1, idEmpresa);
			rs = ps.executeQuery();			
			if(rs.next()){				
				numeracao = new Numeracao();								
				String nextval = String.valueOf(Integer.valueOf(rs.getString("numero"))+1);											
				numeracao.setNumero(nextval);
				numeracao.setSerie(rs.getString("serie"));				
				updateNextal(nextval, idEmpresa,con);				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return numeracao;
	}		
	
	private void updateNextal(String nextval, Integer idEmpresa,Connection con){
					
		PreparedStatement ps = null;
		try {	
			ps = con.prepareStatement("update numeracao set numero = ? where idEmpresa = ?");
			ps.setString(1, nextval);
			ps.setInt(2, idEmpresa);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
	}

}
