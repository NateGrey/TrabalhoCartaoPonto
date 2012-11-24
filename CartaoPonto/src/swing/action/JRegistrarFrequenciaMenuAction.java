package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JRegistrarFrequenciaMenuAction extends AbstractAction {
	public static final String REGISTRAR1 = "REGISTRAR1";

	private JPanel principal;
	private CardLayout cards;

	public JRegistrarFrequenciaMenuAction(JPanel principal, CardLayout cards) {
		super("Registrar Frequencia");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, REGISTRAR1);
	}
}
