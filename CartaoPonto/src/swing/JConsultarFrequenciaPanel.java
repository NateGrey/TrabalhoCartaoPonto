package swing;
import Ponto.Frequencia;
import Ponto.FrequenciaDAO;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JConsultarFrequenciaPanel extends JPanel{
	
	public JConsultarFrequenciaPanel(JPanel principal, CardLayout cards){
		add(new JLabel("Numero Cartão"));
		JTextField valor = new JTextField(8);
		add(valor);
		add(new JButton("Consultar"));
		//add(new JButton(new JConsultarFrequenciaAction(principal, cards, valor)));
		add(new JButton("Cancelar"));
		
	    
	    FrequenciaDAO fre = new FrequenciaDAO();
	    
	    ArrayList<Frequencia> lista = new ArrayList<Frequencia>();
	    lista.addAll(fre.listaFrequencia("123123"));
	    
	    String[][] dados = new String[lista.size()][];  
	    int i = 0; 
	    
	    for (Frequencia f: lista) {  
	      dados[i] = new String[] { f.getCartao(),f.getDia().toString(),f.getEntrada().toString(),
	    		  f.getIntervalo().toString(),f.getVolta().toString(),f.getSaida().toString()};  
	      i += 1;  
	    } 
	    
	    String[] coluna = new String[] {"Cartao","Data","Entrada","Intervalo","Volta","Saida"};
	    
	    DefaultTableModel exibir = new DefaultTableModel(dados,coluna); 
	    //add(new JTable(exibir));
	    
	    JTable table=new JTable(exibir);  
	    JScrollPane scrollpane = new JScrollPane(table);      
	      
	    //scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);    
	    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    
	    this.add(scrollpane, BorderLayout.CENTER);
	}
	
	public JConsultarFrequenciaPanel(){
		this(null,null);
	}
	
	private static void painel(){
		JFrame frame = new JFrame("Consulta Frequencia do Funcionário");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarFrequenciaPanel();
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
