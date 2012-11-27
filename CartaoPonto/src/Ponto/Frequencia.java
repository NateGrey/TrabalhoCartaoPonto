package Ponto;
import java.sql.Date;
import java.sql.Time;


public class Frequencia {
	
	  private String cCartao;
	  private Date dia;
	  private Time entrada;
	  private Time intervalo; 
	  private Time volta;
	  private Time saida;
	
	public Frequencia() {
		super();
	}

	public Frequencia(String cCartao, Date dia, Time entrada) {
		super();
		setCartao(cCartao);
		setDia(dia);
		setEntrada(entrada);
	}

	public String getCartao() {
		return cCartao;
	}

	public void setCartao(String cCartao) {
		if (cCartao == null) {
			throw new IllegalArgumentException("O número do cartão não pode ser nulo!");
		}
		
		this.cCartao = cCartao;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		if (dia == null) {
			throw new IllegalArgumentException("O dia não pode ser nulo!");
		}
		
		this.dia = dia;
	}

	public Time getEntrada() {
		return entrada;
	}

	public void setEntrada(Time entrada) {
		if (entrada == null) {
			throw new IllegalArgumentException("A hora de entrada não pode ser nulo!");
		}
		
		this.entrada = entrada;
	}

	public Time getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Time intervalo) {
		/*if (intervalo == null) {
			throw new IllegalArgumentException("A hora do intervalo não pode ser nulo!");
		}*/
		
		this.intervalo = intervalo;
	}

	public Time getVolta() {
		return volta;
	}

	public void setVolta(Time volta) {
		/*if (volta == null) {
			throw new IllegalArgumentException("A hora da volta não pode ser nulo!");
		}*/
		
		this.volta = volta;
	}

	public Time getSaida() {
		return saida;
	}

	public void setSaida(Time saida) {
		/*if (saida == null) {
			throw new IllegalArgumentException("A hora da saida não pode ser nulo!");
		}*/
		
		this.saida = saida;
	}

	@Override
	public String toString() {
		return String.format("\nFrequencia [cCartao=%s, dia=%s, entrada=%s, intervalo=%s," +
						"volta=%s, saida=%s]",cCartao, dia, entrada, intervalo, volta, saida);
	}
}
