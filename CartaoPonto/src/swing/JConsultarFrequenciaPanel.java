package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Ponto.Frequencia;
import Ponto.FrequenciaDAO;

import swing.action.JConsultarFrequenciaPanelAction;
import swing.action.JConsultarFrequenciaPanelCloseAction;

@SuppressWarnings("serial")
public class JConsultarFrequenciaPanel extends JPanel{
	
	private static final String[] coluna = new String[] {"Cartao","Data","Entrada","Intervalo","Volta","Saida"};
	private  JTable table;
	private DefaultTableModel exibir;
	private JScrollPane scrollpane;
	private JTextField valor;
	
	//@SuppressWarnings("deprecation")
	public JConsultarFrequenciaPanel(JPanel principal, CardLayout cards){
		add(new JLabel("Numero Cartão"));
		valor = new JTextField(8);
		valor.setText("456456");
		add(valor);
		JConsultarFrequenciaPanelAction consultar = new JConsultarFrequenciaPanelAction(principal, cards, valor);
		add(new JButton(consultar));
		add(new JButton(new JConsultarFrequenciaPanelCloseAction(principal, cards)));
		
		table = new JTable();
		exibir = new DefaultTableModel();
		scrollpane = new JScrollPane();
		
		scrollpane = new JScrollPane(table);         
	    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);    
	    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    
	    this.add(scrollpane, BorderLayout.CENTER);	
	}
	
	public JConsultarFrequenciaPanel(){
		this(null,null);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		
		if (aFlag == false) {
			return;
		}
		System.out.printf("JRegistrarFrequenciaPanel::setVisible %b\n", aFlag);
		
		FrequenciaDAO fre = new FrequenciaDAO();
	    
	    ArrayList<Frequencia> lista = new ArrayList<Frequencia>();
	    lista.addAll(fre.listaFrequencia(this.valor.getText()));
	    
	    String[][] dados = new String[lista.size()][];
	    String intervalo, volta, saida;
	    int i = 0; 
	
	    for (Frequencia f: lista) {
	    	if (f.getIntervalo() == null){
	    		intervalo = " -- : -- : -- ";
	    	}else{
	    		intervalo = f.getIntervalo().toString(); 
	    	}
	    	if (f.getVolta() == null){
	    		volta = " -- : -- : -- ";
	    	}else{
	    		volta = f.getVolta().toString(); 
	    	}
	    	if (f.getSaida() == null){
	    		saida = " -- : -- : -- ";
	    	}else{
	    		saida = f.getSaida().toString(); 
	    	}
	    	
	        dados[i] = new String[] { f.getCartao(),f.getDia().toString(),f.getEntrada().toString(),
	        						intervalo,volta,saida};  
	        i += 1;  
	    }
	    
	    exibir.setDataVector(dados,coluna); 
	    table.setModel(exibir);
	    table.enable(false);
	    
	    //System.out.println(this.valor.getText());
	    //this.valor.setText("");
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
