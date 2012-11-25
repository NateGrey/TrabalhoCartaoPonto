package swing.action;

import Ponto.Frequencia;
import Ponto.FrequenciaDAO;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.Ponto;


@SuppressWarnings("serial")
public class JConsultarFrequenciaPanelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;
	private JTextField valor;

	public JConsultarFrequenciaPanelAction(JPanel principal, CardLayout cards, JTextField valor) {
		super("Consultar");
		
		this.principal = principal;
		this.cards = cards;
		this.valor = valor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		FrequenciaDAO fre = new FrequenciaDAO();
	    ArrayList<Frequencia> lista = new ArrayList<Frequencia>();
	    lista.addAll(fre.listaFrequencia(valor.getText()));
		
	   if (lista.isEmpty()) {
			System.out.println("Funcionario não encontrado!");
			JOptionPane.showMessageDialog(principal.getRootPane(),
					"Funcionario não encontrado!", "Operação cancelada",
					JOptionPane.ERROR_MESSAGE);

		}else{
			System.out.println(lista);
			String[][] dados = new String[lista.size()][];  
		    int i = 0; 
		    
		    for (Frequencia f: lista) {  
		      dados[i] = new String[] { f.getCartao(),f.getDia().toString(),f.getEntrada().toString(),
		    		  f.getIntervalo().toString(),f.getVolta().toString(),f.getSaida().toString()};  
		      i += 1;  
		    }
		    
		   String[] coluna = new String[] {"Cartao","Data","Entrada","Intervalo","Volta","Saida"};
		}
		/*if (principal != null) {
			cards.show(principal, Ponto.PRINCIPAL);
		}*/

	}
}