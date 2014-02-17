package br.com.jtron.restnfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jtron.restnfe.dto.Empresa;
import br.com.jtron.restnfe.util.ConnectionHelper;

public class EmpresaDAO {
	
	
	public Empresa obterEmpresaUnica(){
		
		Empresa empresa = new Empresa();
		
		Connection con = null;		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionHelper.getConnection();			
			ps = con.prepareStatement("select * from empresa where id = 1");					
			rs = ps.executeQuery();
				
			if(rs.next()){					
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setCodEstado(rs.getString("codigoEstado"));
					empresa.setNome(rs.getString("nome"));
			}
										
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(con);
			ConnectionHelper.close(ps);
			ConnectionHelper.close(rs);
		}
		
		return empresa;
		
		
	}
	

}
