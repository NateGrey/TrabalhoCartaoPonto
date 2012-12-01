package swing;
import java.awt.CardLayout;

import javax.swing.*;  

import swing.action.JRegistrarFrequenciaPanelAction;
import swing.action.JRegistrarFrequenciaPanelCancelAction;

@SuppressWarnings("serial")
public class JRegistrarFrequenciaPanel extends JPanel{
	
	private JTextField valor;
	
	public JRegistrarFrequenciaPanel(JPanel principal, CardLayout cards){
		add(new JLabel("Numero Cartão"));
		valor = new JTextField(8);
		add(valor);
		add(new JButton(new JRegistrarFrequenciaPanelAction(principal, cards, valor)));
		add(new JButton(new JRegistrarFrequenciaPanelCancelAction(principal, cards)));
	}
	
	public JRegistrarFrequenciaPanel(){
		this(null,null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JRegistrarFrequenciaPanel::setVisible %b\n", aFlag);
		this.valor.setText("");
	}
	
	private static void painel(){
		JFrame frame = new JFrame("Registrar Frequencia do Funcionário");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JRegistrarFrequenciaPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	painel();
            }
        });

	}

}
