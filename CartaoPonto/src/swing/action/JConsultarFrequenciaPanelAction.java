package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.JConsultarFrequenciaPanel;
import Ponto.Frequencia;
import Ponto.FrequenciaDAO;


@SuppressWarnings("serial")
public class JConsultarFrequenciaPanelAction extends AbstractAction {
	private JPanel principal;
	private JConsultarFrequenciaPanel p;
	private CardLayout cards;
	private JTextField valor;

	public JConsultarFrequenciaPanelAction(JPanel principal, CardLayout cards, JTextField valor, JConsultarFrequenciaPanel p) {
		super("Consultar");
		
		this.principal = principal;
		this.cards = cards;
		this.valor = valor;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		FrequenciaDAO fre = new FrequenciaDAO();
	    ArrayList<Frequencia> lista = new ArrayList<Frequencia>();
	    lista.addAll(fre.listaFrequencia(this.valor.getText()));
		
	   if (lista.isEmpty()) {
			System.out.println("Funcionário não encontrado!");
			JOptionPane.showMessageDialog(principal.getRootPane(),
					"Funcionario não encontrado!", "Operação cancelada",
					JOptionPane.ERROR_MESSAGE);

		}else{
			System.out.println(lista);
			p.refresh();
		}
	}
	
	public String getValor(){
		return this.valor.getText();
	}

}