package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Ponto;

@SuppressWarnings("serial")
public class JRegistrarFrequenciaPanelCancelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JRegistrarFrequenciaPanelCancelAction(JPanel principal, CardLayout cards) {
		super("Cancelar");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			System.out.println("Cancelar operação de registrar ponto");
			cards.show(principal, Ponto.PRINCIPAL);
		}

	}
}