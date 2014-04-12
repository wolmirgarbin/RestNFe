package br.com.jtron.restnfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jtron.restnfe.util.ConnectionHelper;

public class NFeDAO {

	
	public void salvar(String chave,String xml,String protocolo,String ambiente,Connection con,Integer idEmpresa) throws Exception{		
		PreparedStatement ps = null;		
		try {
			ps = con.prepareStatement("insert into nfe (chave,xml,protocolo,ambiente,dataEmissao,idEmpresa) values (?,?,?,?,now(),?)");			
			ps.setString(1, chave);
			ps.setString(2, xml);
			ps.setString(3, protocolo);
			ps.setInt(4, Integer.parseInt(ambiente));			
			ps.setInt(5, idEmpresa);
			ps.executeUpdate();													
		} catch (SQLException e) {
			throw e;
		} finally {			
			try {
				con.commit();
			} catch (SQLException e) {			
				throw e;				
			}			
			ConnectionHelper.close(con);
			ConnectionHelper.close(con);
			ConnectionHelper.close(ps);		
		}
	}
	
	public String obterXmlPorChave(String chave){
		
		
		Connection con = null;		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionHelper.getConnection();			
			ps = con.prepareStatement("select * from nfe where chave = ?");					

			ps.setString(1, chave);
			
			rs = ps.executeQuery();
			
			if(rs.next()){					
					return rs.getString("xml");
			}
										
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(con);
			ConnectionHelper.close(ps);
			ConnectionHelper.close(rs);
		}
		
		return null;
		
	}
		
}