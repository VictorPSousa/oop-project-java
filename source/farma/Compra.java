package farmacia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Compra{
	  private Integer compra_numNF;
	  private Integer produtoCod;
	  private String clienteCod;
	  private String funcionarioCod;
	  private String compra_data;
	  private Double compra_valor;
	  private Integer compra_qtd;
	  private String compra_pag;
	  
	  public Compra(){};
	  
	  public void setCompra_numNF (Integer newVar) {
	    compra_numNF = newVar;
	  }

	  public Integer getCompra_numNF () {
	    return compra_numNF;
	  }

	  public void setProduto (Integer newVar) {
		  produtoCod = newVar;
	  }

	  public Integer getProduto () {
	    return produtoCod;
	  }

	  public void setCliente (String newVar) {
	    clienteCod = newVar;
	  }

	  public String getCliente () {
	    return clienteCod;
	  }

	  public void setFuncionario (String newVar) {
	    funcionarioCod = newVar;
	  }

	  public String getFuncionario () {
	    return funcionarioCod;
	  }

	  public void setCompra_data (String newVar) {
	    compra_data = newVar;
	  }

	  public String getCompra_data () {
	    return compra_data;
	  }

	  public void setCompra_valor (Double newVar) {
	    compra_valor = newVar;
	  }

	  public Double getCompra_valor () {
	    return compra_valor;
	  }

	  public void setCompra_qtd (Integer newVar) {
	    compra_qtd = newVar;
	  }

	  public Integer getCompra_qtd () {
	    return compra_qtd;
	  }

	  public void setCompra_pag (String newVar) {
	    compra_pag = newVar;
	  }

	  public String getCompra_pag () {
	    return compra_pag;
	  }

	  public void efetua(Compra comp) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	    
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      String Sql = "SELECT `prod_preco` FROM `produto` WHERE `prod_codigo` = '"+comp.getProduto()+"';";
		  PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		  comando.execute();
		      
		  ResultSet resultado = comando.executeQuery();
		    
		  ArrayList<String> registros = new ArrayList<>();
	      while(resultado.next()){
	            registros.add(resultado.getString("prod_preco"));
	      }
	      String preco = "";
	      for(int j = 0; j < registros.size(); j++) {
	    	  preco = registros.get(j);
	      }

		  resultado.close();
		  comando.close();
		  
		  Double valor = (Double.parseDouble(preco)) * comp.getCompra_qtd();

	      String Sql_compra = "INSERT INTO `compra`( `prod_codigo`, `clie_cpf`, `func_cpf`, `compra_data`,"
	      		+ " `compra_valor`, `compra_qtd`, `compra_pag`) VALUES ('"+comp.getProduto()+"',"
	      		+ "'"+comp.getCliente()+"','"+comp.getFuncionario()+"',"
	      		+ "DATE(NOW()),"+valor+","
	      		+ "'"+comp.getCompra_qtd()+"','"+comp.getCompra_pag()+"');";
	      
	      PreparedStatement comando_compra = (PreparedStatement) conn.prepareStatement(Sql_compra);
	      comando_compra.execute();
	      comando_compra.close();
	      conn.close();
	  }
	  
	  public void atualiza(Compra comp) throws SQLException{
		  	String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "SELECT `prod_preco` FROM `produto` WHERE `prod_codigo` = '"+comp.getProduto()+"';";
			PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
			comando.execute();
			      
			ResultSet resultado = comando.executeQuery();
			    
			ArrayList<String> registros = new ArrayList<>();
		    while(resultado.next()){
		            registros.add(resultado.getString("prod_preco"));
		    }
		    String preco = "";
		    for(int j = 0; j < registros.size(); j++) {
		    	  preco = registros.get(j);
		    }

			resultado.close();
			comando.close();
			
			Double valor = (Double.parseDouble(preco)) * comp.getCompra_qtd();
			  
		    String Sql_compra = "UPDATE `compra` SET "
		    		+ "`prod_codigo`='"+comp.getProduto()+"',`clie_cpf`='"+comp.getCliente()+"',"
		    		+ "`func_cpf`='"+comp.getFuncionario()+"',`compra_valor`="+valor+","
		    		+ "`compra_qtd`='"+comp.getCompra_qtd()+"',`compra_pag`='"+comp.getCompra_pag()+"'"
		    		+ " WHERE `compra_numnf`='"+comp.getCompra_numNF()+"';";
		    
		    PreparedStatement comando_compra = (PreparedStatement) conn.prepareStatement(Sql_compra);
		    comando_compra.execute();
		    comando_compra.close();
		    conn.close();
	  }

	  public Compra busca(int nf) throws SQLException{
		    Compra cmp = new Compra();
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "SELECT * FROM `compra` WHERE `compra_numnf` = '"+nf+"'";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
	        while(resultado.next()){
	        	cmp.setProduto(Integer.parseInt(resultado.getString("prod_codigo"))); 
	        	cmp.setCliente(resultado.getString("clie_cpf")); 
	        	cmp.setFuncionario(resultado.getString("func_cpf")); 
	        	cmp.setCompra_qtd(Integer.parseInt(resultado.getString("compra_qtd"))); 
	        	cmp.setCompra_pag(resultado.getString("compra_pag")); 
	        }
		   
		    resultado.close();
		    comando.close();
		    conn.close();
		    return cmp;
	  }
	  
	  public String lista() throws SQLException{
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "SELECT * FROM `compra`";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
		    ArrayList<String> registros = new ArrayList<>();
	        while(resultado.next()){
	            registros.add("NF: "+resultado.getString("compra_numnf")+
	            		"\nProduto(Cod): "+resultado.getString("prod_codigo") + 
	                    "\nCliente(CPF): " + resultado.getString("clie_cpf") + 
	                    "\nAtendente: " + resultado.getString("func_cpf") + 
	                    "\nData: " + resultado.getString("compra_data") +
	                    "\nValor: " + resultado.getString("compra_valor") +
	                    "\nQuantidade: " + resultado.getString("compra_qtd") +
	                    "\nPagamento: " + resultado.getString("compra_pag") +"\n");
	        }
	        String lista = "";
	        for(int j = 0; j < registros.size(); j++) {
	            lista += registros.get(j) + "\n";
	        }

		    resultado.close();
		    comando.close();
		    conn.close();
		    return lista;
	  }
}
