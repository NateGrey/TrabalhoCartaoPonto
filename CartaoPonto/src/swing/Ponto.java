package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;

import swing.action.JAboutMenuAction;
import swing.action.JConsultarFrequenciaMenuAction;
import swing.action.JRegistrarFrequenciaMenuAction;
import swing.action.JSairMenuAction;

public class Ponto {
	
	public static final String PRINCIPAL = "PRINCIPAL";

	private static void tela() {
        
        JFrame frame = new JFrame("Controle de Cartão Ponto");
        
        CardLayout cards = new CardLayout();
        
        JPanel principal = new JPanel(cards);
        JPanel registrar = new JRegistrarFrequenciaPanel(principal, cards);
        JPanel consultar = new JConsultarFrequenciaPanel(principal, cards);
        JPanel vazio = new JPanel();
		JLabel label = new JLabel("Controle de Cartão Ponto - Tela Inicial");
		vazio.add(label);

		principal.add(vazio, PRINCIPAL);
		principal.add(registrar, JRegistrarFrequenciaMenuAction.REGISTRAR1);
		principal.add(consultar, JConsultarFrequenciaMenuAction.CONSULTAR1);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("icon.png").getImage());
        frame.getContentPane().add(principal);
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Arquivo");
        menubar.add(file);
        JMenu acao = new JMenu("Operações");
        menubar.add(acao);
        JMenu help = new JMenu("Ajuda");
        menubar.add(help);
        
        Action consultaAction = new JConsultarFrequenciaMenuAction(principal,cards);
        acao.add(consultaAction);
        Action registraAction = new JRegistrarFrequenciaMenuAction(principal,cards);
        acao.add(registraAction);
        Action exitAction = new JSairMenuAction();
		file.add(exitAction);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);
        
        frame.setJMenuBar(menubar);
        frame.setMinimumSize(new Dimension(800,600));
        //frame.setMaximumSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tela();
			}
		});
	}
}
