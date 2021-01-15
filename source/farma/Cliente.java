package farmacia;

import java.awt.Color;
import java.awt.TextArea;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Cliente {
	  private String clie_cpf;
	  private String clie_nome;
	  private String clie_rg;
	  private char clie_sexo;
	  private String clie_planosaude;
	  private Double clie_desconto;
	  private String clie_tel;
	  private String clie_cep;
	  private String clie_rua;
	  private String clie_numero;
	  private String clie_bairro;
	  
	  public Cliente(){ };
	  
	  public void setClie_cpf (String newVar) {
	    clie_cpf = newVar;
	  }

	  public String getClie_cpf () {
	    return clie_cpf;
	  }

	  public void setClie_nome (String newVar) {
	    clie_nome = newVar;
	  }

	  public String getClie_nome () {
	    return clie_nome;
	  }

	  public void setClie_rg (String newVar) {
	    clie_rg = newVar;
	  }

	  public String getClie_rg () {
	    return clie_rg;
	  }

	  public void setClie_sexo (char newVar) {
	    clie_sexo = newVar;
	  }

	  public char getClie_sexo () {
	    return clie_sexo;
	  }

	  public void setClie_planosaude (String newVar) {
	    clie_planosaude = newVar;
	  }

	  public String getClie_planosaude () {
	    return clie_planosaude;
	  }

	  public void setClie_desconto (Double newVar) {
	    clie_desconto = newVar;
	  }

	  public Double getClie_desconto () {
	    return clie_desconto;
	  }

	  public void setClie_tel (String newVar) {
	    clie_tel = newVar;
	  }

	  public String getClie_tel () {
	    return clie_tel;
	  }

	  public void setClie_cep (String newVar) {
	    clie_cep = newVar;
	  }

	  public String getClie_cep () {
	    return clie_cep;
	  }

	  public void setClie_rua (String newVar) {
	    clie_rua = newVar;
	  }

	  public String getClie_rua () {
	    return clie_rua;
	  }

	  public void setClie_numero (String newVar) {
	    clie_numero = newVar;
	  }

	  public String getClie_numero () {
	    return clie_numero;
	  }

	  public void setClie_bairro (String newVar) {
	    clie_bairro = newVar;
	  }

	  public String getClie_bairro () {
	    return clie_bairro;
	  }

	  public void cadastra(Cliente cli) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);

	      String Sql = "INSERT INTO `cliente` (`clie_cpf`, `clie_nome`, `clie_rg`, `clie_sexo`,"
	      		+ " `clie_planosaude`, `clie_desconto`, `clie_tel`, `clie_cep`, `clie_rua`,"
	      		+ " `clie_numero`, `clie_bairro`) VALUES ('"+cli.getClie_cpf()+"','"+cli.getClie_nome()+"',"
	      		+ "'"+cli.getClie_rg()+"','"+cli.getClie_sexo()+"','"+cli.getClie_planosaude()+"',"
	      		+ "'"+cli.getClie_desconto()+"','"+cli.getClie_tel()+"','"+cli.getClie_cep()+"',"
	      		+ "'"+cli.getClie_rua()+"','"+cli.getClie_numero()+"','"+cli.getClie_bairro()+"');";
	      
	      JOptionPane.showMessageDialog(null, Sql);
	      
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      conn.close();
	  }

	  public void deleta(){
		  
	  }

	  public void atualiza(){
		  
	  }

	  public Cliente busca(String cpf) throws SQLException{
		    Cliente cli = new Cliente();
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "SELECT * FROM `cliente` WHERE `clie_cpf` = '"+cpf+"'";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
	        while(resultado.next()){
	            cli.setClie_cpf(resultado.getString("clie_cpf")); 
	            cli.setClie_nome(resultado.getString("clie_nome")); 
	            cli.setClie_rg(resultado.getString("clie_rg")); 
	            String gen = resultado.getString("clie_sexo");
	            cli.setClie_sexo(gen.charAt(0)); 
	            cli.setClie_planosaude(resultado.getString("clie_planosaude")); 
	            cli.setClie_desconto(Double.parseDouble(resultado.getString("clie_desconto").replace(",", "."))); 
	            cli.setClie_tel(resultado.getString("clie_tel")); 
	            cli.setClie_cep(resultado.getString("clie_cep")); 
	            cli.setClie_rua(resultado.getString("clie_rua")); 
	            cli.setClie_numero(resultado.getString("clie_numero")); 
	            cli.setClie_bairro(resultado.getString("clie_bairro")); 
	        }
		   
		    resultado.close();
		    comando.close();
		    conn.close();
		    return cli;
	  }

	  public String lista() throws SQLException{
			String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		    String Sql = "SELECT `clie_nome`, `clie_sexo`, `clie_planosaude`, `clie_tel` FROM `cliente`";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
		    ArrayList<String> registros = new ArrayList<>();
	        while(resultado.next()){
	            registros.add("Nome: "+resultado.getString("clie_nome") + 
	                    "\nSexo: " + resultado.getString("clie_sexo") + 
	                    "\nPlano de Saúde: " + resultado.getString("clie_planosaude") + 
	                    "\nTelefone: " + resultado.getString("clie_tel")+"\n");
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
