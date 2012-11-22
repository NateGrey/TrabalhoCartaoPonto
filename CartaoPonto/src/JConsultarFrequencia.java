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
	
	private static void tela() {
        
        JFrame frame = new JFrame("Controle de Cartão Ponto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Arquivo");
        menubar.add(file);
        JMenu registro = new JMenu("Registrar Ponto");
        menubar.add(registro);
        JMenu consulta = new JMenu("Consultar Frequencia");
        menubar.add(consulta);
        JMenu help = new JMenu("Ajuda");
        menubar.add(help);
        JMenuItem exit = new JMenuItem("Sair");
        file.add(exit); 
        JMenuItem about = new JMenuItem("Sobre");
        help.add(about);
        
        frame.setJMenuBar(menubar);

        frame.pack();
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //tela();
            	painel();
            }
        });

	}

}
