package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
private static String Banco = "jdbc:postgresql://localhost:5432/curso-jsp";
private static String user = "postgres";
private static String senha = "1234";
private static Connection connection = null;


public static Connection getConnection() {
	return connection;
}

static {
	conectar();
}
public SingleConnectionBanco() {/*quando tiver uma instancia vai conectar*/
	conectar();
	
	
}

private static void conectar() {
	try {
		
		if(connection == null) {
			Class.forName("org.postgresql.Driver");/*Carrega o driver de conexão do banco*/
			connection = DriverManager.getConnection(Banco, user, senha);
			connection.setAutoCommit(false);/*Para não efetuar alterações no banco sem nosso comando*/
			
		}
		
	} catch (Exception e) {
   e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
	}
}


}
