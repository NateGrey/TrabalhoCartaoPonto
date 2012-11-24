package swing;

import java.awt.Dimension;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;

import swing.action.JAboutMenuAction;
import swing.action.JSairMenuAction;

public class Ponto {

	private static void tela() {
        
        JFrame frame = new JFrame("Controle de Cartão Ponto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("icon.png").getImage());
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Arquivo");
        menubar.add(file);
        JMenu registro = new JMenu("Registrar Ponto");
        menubar.add(registro);
        JMenu consulta = new JMenu("Consultar Frequencia");
        menubar.add(consulta);
        JMenu help = new JMenu("Ajuda");
        menubar.add(help);
        
        Action exitAction = new JSairMenuAction();
		file.add(exitAction);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);
        
        frame.setJMenuBar(menubar);
        
        frame.setMinimumSize(new Dimension(400,200));

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
