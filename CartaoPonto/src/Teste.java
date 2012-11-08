import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/CartaoPonto", "postgres", "senacrs");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Funcionario");

		while (rs.next()) {
			int c = rs.getInt("codigoCartao");
			String s = rs.getString("nome");
			System.out.println(c);
			System.out.println(s);
		}
		
		//comandos para fechar os objetos
		/*con.close();
		stmt.close();
		rs.close();*/
	}
}
