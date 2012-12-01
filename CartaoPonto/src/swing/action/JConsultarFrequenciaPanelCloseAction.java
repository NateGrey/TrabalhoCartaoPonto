package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Ponto;

@SuppressWarnings("serial")
public class JConsultarFrequenciaPanelCloseAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JConsultarFrequenciaPanelCloseAction(JPanel principal, CardLayout cards) {
		super("Fechar");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			System.out.println("Fechar a visualização da frequencia");
			cards.show(principal, Ponto.PRINCIPAL);
		}

	}
}