package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;
	
	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
		
		
	}
	public void gravarUsuario(ModelLogin Objeto)throws Exception {
		String sql = "INSERT INTO model_login (login, senha, nome, email) VAlUES (?, ?, ?, ?);";
			PreparedStatement preparedSql = connection.prepareStatement(sql);
			
			preparedSql.setString(1, Objeto.getLogin());
			preparedSql.setString(2, Objeto.getSenha());
			preparedSql.setString(3, Objeto.getNome());
			preparedSql.setString(4, Objeto.getEmail());
			
			
			preparedSql.execute();
			connection.commit();
			
	}
}
