package farmacia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Compra{
	  private Integer compra_numNF;
	  private Produto produto;
	  private Cliente cliente;
	  private Funcionario funcionario;
	  private String compra_data;
	  private Double compra_valor;
	  private Integer compra_qtd;
	  private String compra_pag;
	  
	  public Compra () { };
	  
	  public void setCompra_numNF (Integer newVar) {
	    compra_numNF = newVar;
	  }

	  public Integer getCompra_numNF () {
	    return compra_numNF;
	  }

	  public void setProduto (Produto newVar) {
	    produto = newVar;
	  }

	  public Produto getProduto () {
	    return produto;
	  }

	  public void setCliente (Cliente newVar) {
	    cliente = newVar;
	  }

	  public Cliente getCliente () {
	    return cliente;
	  }

	  public void setFuncionario (Funcionario newVar) {
	    funcionario = newVar;
	  }

	  public Funcionario getFuncionario () {
	    return funcionario;
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

	  public void efetua(){
		  
	  }
	  
	  public void atualiza(){
		  
	  }

	  public void busca(){
		  
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
