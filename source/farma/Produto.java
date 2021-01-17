package farmacia;

import java.awt.Color;
import java.awt.TextArea;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Produto {
	  private Integer prod_codigo;
	  private String prod_nome;
	  private String prod_categoria;
	  private Integer prod_estoque;
	  private String prod_fornecedor;
	  private Double prod_preco;
	  private String prod_marca;
	  private String prod_dtvalidade;
	  
	  public Produto(){ };
	  
	  public void setProd_codigo (Integer newVar) {
	    prod_codigo = newVar;
	  }
	  
	  public Integer getProd_codigo () {
		return prod_codigo;
	  }
	  
	  public void setProd_nome (String newVar) {
		prod_nome = newVar;
	  }
	  
	  public String getProd_nome () {
	    return prod_nome;
	  }

	  public void setProd_categoria (String newVar) {
	    prod_categoria = newVar;
	  }

	  public String getProd_categoria () {
	    return prod_categoria;
	  }

	  public void setProd_estoque (Integer newVar) {
	    prod_estoque = newVar;
	  }

	  public Integer getProd_estoque () {
	    return prod_estoque;
	  }

	  public void setProd_fornecedor (String newVar) {
	    prod_fornecedor = newVar;
	  }

	  public String getProd_fornecedor () {
	    return prod_fornecedor;
	  }

	  public void setProd_preco (Double newVar) {
	    prod_preco = newVar;
	  }

	  public Double getProd_preco () {
	    return prod_preco;
	  }

	  public void setProd_marca (String newVar) {
	    prod_marca = newVar;
	  }

	  public String getProd_marca () {
	    return prod_marca;
	  }

	  public void setProd_dtvalidade (String newVar) {
	    prod_dtvalidade = newVar;
	  }

	  public String getProd_dtvalidade () {
	    return prod_dtvalidade;
	  }

	  public void cadastra(Produto prod) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);

	      String Sql = "INSERT INTO `produto`(`prod_nome`, `prod_categoria`, `prod_estoque`,"
	      		+ " `prod_fornecedor`, `prod_preco`, `prod_marca`, `prod_dtvalidade`) VALUES"
	      		+ " ('"+prod.getProd_nome()+"','"+prod.getProd_categoria()+"',"
	      		+ " '"+prod.getProd_estoque()+"','"+prod.getProd_fornecedor()+"',"
	      		+ " '"+prod.getProd_preco()+"','"+prod.getProd_marca()+"',"
	      		+ " '"+prod.getProd_dtvalidade()+"')";
	      
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      conn.close();
	  }
	  
	  public void atualiza(Produto prod) throws SQLException{
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "UPDATE `produto` SET `prod_nome` = '"+prod.getProd_nome()+"',"
		    		+ "`prod_categoria` = '"+prod.getProd_categoria()+"', `prod_estoque` = '"+prod.getProd_estoque()+"',"
		    		+ "`prod_fornecedor` = '"+prod.getProd_fornecedor()+"', `prod_preco` = '"+prod.getProd_preco()+"',"
		    		+ "`prod_marca` = '"+prod.getProd_marca()+"', `prod_dtvalidade`='"+prod.getProd_dtvalidade()+"'"
		    		+ " WHERE `prod_codigo` = '"+prod.getProd_codigo()+"'";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		    comando.close();
		    conn.close();
	  }

	  public void deleta(int cod) throws SQLException{
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "DELETE FROM `produto` WHERE `prod_codigo` = '"+cod+"'";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		    comando.close();
		    conn.close();
	  }

	  public Produto busca(int cod) throws SQLException{
		  Produto prod = new Produto();
	      String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      String Sql = "SELECT * FROM `produto` WHERE `prod_codigo` = '"+ cod + "'";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      
	      ResultSet resultado = comando.executeQuery();
	      
	      if(resultado != null && resultado.next()){
	    	  prod.setProd_codigo(Integer.parseInt(resultado.getString("prod_codigo")));
	    	  prod.setProd_nome(resultado.getString("prod_nome"));
	    	  prod.setProd_categoria(resultado.getString("prod_categoria"));
	    	  prod.setProd_estoque(Integer.parseInt(resultado.getString("prod_estoque")));
	    	  prod.setProd_fornecedor(resultado.getString("prod_fornecedor"));
	    	  prod.setProd_preco(Double.parseDouble(resultado.getString("prod_preco")));
	    	  prod.setProd_marca(resultado.getString("prod_marca"));
	    	  prod.setProd_dtvalidade(resultado.getString("prod_dtvalidade"));
          }
	      
	      resultado.close();
	      comando.close();
	      conn.close();
	      return prod;
	  }

	  public String lista() throws SQLException{
		    String lista = "";
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
			
			String Sql = "SELECT * FROM `produto`";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
		    ArrayList<String> registros = new ArrayList<>();
	        while(resultado.next()){
	            registros.add("\nCódigo: "+resultado.getString("prod_codigo") + 
	            		"\nNome: " + resultado.getString("prod_nome") + 
	                    "\nCategoria: " + resultado.getString("prod_categoria") + 
	                    "\nEstoque: " + resultado.getString("prod_estoque") +
	                    "\nFornecedor: " + resultado.getString("prod_fornecedor") +
	                    "\nPreco: R$" + resultado.getString("prod_preco") +
	                    "\nMarca: " + resultado.getString("prod_marca") +
	                    "\nData val: " + resultado.getString("prod_dtvalidade") + "\n\n");
	        }
	        
	        for(int j = 0; j < registros.size(); j++) {
	            lista += registros.get(j) + "\n";
	        }
		   
		    resultado.close();
		    comando.close();
		    conn.close();
		    return lista;
	  }
}
