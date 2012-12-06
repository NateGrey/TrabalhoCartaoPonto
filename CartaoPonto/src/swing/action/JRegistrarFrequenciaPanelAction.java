package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ponto.FrequenciaDAO;
import swing.Ponto;


@SuppressWarnings("serial")
public class JRegistrarFrequenciaPanelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;
	private JTextField valor;

	public JRegistrarFrequenciaPanelAction(JPanel principal, CardLayout cards, JTextField valor) {
		super("Registrar");
		
		this.principal = principal;
		this.cards = cards;
		this.valor = valor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FrequenciaDAO fre = new FrequenciaDAO();
		
		if (!fre.isFuncionario(valor.getText())){
			System.out.println("Funcion�rio n�o encontrado!");
			JOptionPane.showMessageDialog(principal.getRootPane(),
					"Funcionario n�o encontrado!", "Opera��o cancelada",
					JOptionPane.ERROR_MESSAGE);

		}else {
			String dia = new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date());
			String update = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		
			if(!fre.controlaPonto(valor.getText(), dia, update))
			{
				System.out.println("O funcion�rio j� fechou seu horario!");
				JOptionPane.showMessageDialog(principal.getRootPane(),
						"O funcion�rio j� fechou seu horario!", "Opera��o cancelada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (principal != null) {
			cards.show(principal, Ponto.PRINCIPAL);
		}

	}
}