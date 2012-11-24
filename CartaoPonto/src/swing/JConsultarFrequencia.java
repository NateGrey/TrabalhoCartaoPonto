package swing;
import javax.swing.*;  

@SuppressWarnings("serial")
public class JConsultarFrequencia extends JPanel{
	
	public JConsultarFrequencia(){
		add(new JLabel("Numero Cartão"));
		add(new JTextField(8));
		add(new JButton("Consultar"));
		add(new JButton("Cancelar"));
	}
	
	private static void painel(){
		JFrame frame = new JFrame("Consulta Frequencia do Funcionário");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarFrequencia();
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
