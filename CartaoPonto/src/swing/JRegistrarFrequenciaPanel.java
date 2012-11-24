package swing;
import java.awt.CardLayout;

import javax.swing.*;  

@SuppressWarnings("serial")
public class JRegistrarFrequenciaPanel extends JPanel{
	
	public JRegistrarFrequenciaPanel(JPanel principal, CardLayout cards){
		add(new JLabel("Numero Cartão"));
		JTextField valor = new JTextField(8);
		add(valor);
		add(new JButton("Registrar"));
		//add(new JButton(new JRegistrarFrequenciaAction(principal, cards, valor)));
		add(new JButton("Cancelar"));
	}
	
	public JRegistrarFrequenciaPanel(){
		this(null,null);
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
