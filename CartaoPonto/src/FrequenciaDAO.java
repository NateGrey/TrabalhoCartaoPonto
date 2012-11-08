import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;


public class FrequenciaDAO {
	
	private static final String selectListaFrequencia = "SELECT * FROM Frequencia WHERE cCartao = ?";
	private static final String selectControlaPonto = "SELECT * FROM Frequencia WHERE cCartao = ? and dia = CURRENT_DATE";
	private static final String insertRegistraPonto = "INSERT INTO Frequencia (cCartao,dia,entrada) VALUES (?,CURRENT_DATE,CURRENT_TIME(0))";
	private static final String updateAtualizaPontoInter = "UPDATE Frequencia SET intervalo = CURRENT_TIME(0) WHERE cCartao = ? AND dia = CURRENT_DATE";
	private static final String updateAtualizaPontoVolta = "UPDATE Frequencia SET volta = CURRENT_TIME(0) WHERE cCartao = ? AND dia = CURRENT_DATE";
	private static final String updateAtualizaPontoSaida = "UPDATE Frequencia SET saida = CURRENT_TIME(0) WHERE cCartao = ? AND dia = CURRENT_DATE";
	
	
	public void controlaPonto(String cCartao, String dia, String update){
		
		if (cCartao == null) {
			throw new IllegalArgumentException("O número do cartão não pode ser nulo!");
		}
		if (dia == null) {
			throw new IllegalArgumentException("O dia não pode ser nulo!");
		}
		if (update == null) {
			throw new IllegalArgumentException("A hora de entrada não pode ser nulo!");
		}
		
		try {
			Connection con = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/CartaoPonto", "postgres", "senacrs");

			PreparedStatement stmt = con.prepareStatement(selectControlaPonto);
			stmt.clearParameters(); 
			stmt.setString(1, cCartao);
			
			ResultSet rs = stmt.executeQuery();
			
			if (!rs.next()) {
				registraPonto(cCartao);
			}else{
				Time i = rs.getTime("intervalo");
				Time v = rs.getTime("volta");
				Time s = rs.getTime("saida");
				if (i == null){
					atualizaPonto(cCartao, updateAtualizaPontoInter);
				}else{
					if (v == null){
						atualizaPonto(cCartao, updateAtualizaPontoVolta);
					}else{
						if (s == null){
							atualizaPonto(cCartao, updateAtualizaPontoSaida);
						}else{
							System.out.println("O funcionario já fechou seu horario!");
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
	}
	
	
	private void registraPonto(String cCartao){
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/CartaoPonto", "postgres", "senacrs");

			PreparedStatement stmt = con.prepareStatement(insertRegistraPonto);
			stmt.setString(1, cCartao);
			
			int r = stmt.executeUpdate();
			
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
		
	}
	
	
	private void atualizaPonto(String cCartao, String sql){
		
		if (sql == null) {
			throw new IllegalArgumentException("Não há consulta sql!");
		}
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/CartaoPonto", "postgres", "senacrs");
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cCartao);
			int r = stmt.executeUpdate();
			
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Frequencia> listaFrequencia(String cCartao){
		
		if (cCartao == null) {
			throw new IllegalArgumentException("O número do cartão não pode ser nulo!");
		}
		
		ArrayList<Frequencia> lista = new ArrayList<Frequencia>(); 
		
		try {
			Connection con = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/CartaoPonto", "postgres", "senacrs");

			PreparedStatement stmt = con.prepareStatement(selectListaFrequencia);
			stmt.clearParameters();
			stmt.setString(1, cCartao);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Frequencia f = new Frequencia();
				f.setCartao(rs.getString("cCartao"));
				f.setDia(rs.getDate("dia"));
				f.setEntrada(rs.getTime("entrada"));
				f.setIntervalo(rs.getTime("intervalo"));
				f.setVolta(rs.getTime("volta"));
				f.setSaida(rs.getTime("saida"));
				lista.add(f);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		
		return lista;
		
		// FIXME: fechar conexões
	} 
	

}
