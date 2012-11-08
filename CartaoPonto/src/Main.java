
public class Main {

	public static void main(String[] args) {
		
		FrequenciaDAO fre = new FrequenciaDAO();
		
		String dia = new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date());
		String update = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		
		fre.controlaPonto("123123", dia, update);
		
		//System.out.println("Tabela da Frequencia");
		//System.out.println(fre.listaFrequencia("123123"));
		
	    //System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())); 
		
	}

}
