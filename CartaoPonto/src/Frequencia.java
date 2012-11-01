import java.sql.Date;
import java.sql.Time;


public class Frequencia {
	
	  private int cCartao;
	  private Date dia;
	  private Time entrada;
	  private Time intervalo; 
	  private Time volta;
	  private Time saida;
	
	  public Frequencia(int cCartao, Date dia, Time entrada) {
		super();
		this.cCartao = cCartao;
		this.dia = dia;
		this.entrada = entrada;
	}

	
}
