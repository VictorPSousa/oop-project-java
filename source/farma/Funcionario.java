package farmacia;

import java.awt.Color;
import java.awt.TextArea;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Funcionario {
	  private String func_cpf;
	  private String func_rg;
	  private String func_dtnascimento;
	  private char func_sexo;
	  private String func_nome;
	  private String func_cep;
	  private String func_rua;  
	  private String func_bairro;
	  private String func_numero;
	  static int func_nivel_acesso;
	  
	  public Funcionario(){
		  func_nivel_acesso = 0;
	  };
	  
	  public Funcionario(int nvl_acesso){
		  Funcionario.func_nivel_acesso = nvl_acesso;
	  };
	  
	  public void setFunc_cpf (String newVar) {
	    func_cpf = newVar;
	  }

	  public String getFunc_cpf () {
	    return func_cpf;
	  }

	  public void setFunc_rg (String newVar) {
	    func_rg = newVar;
	  }

	  public String getFunc_rg () {
	    return func_rg;
	  }

	  public void setFunc_dtnascimento (String newVar) {
	    func_dtnascimento = newVar;
	  }

	  public String getFunc_dtnascimento () {
	    return func_dtnascimento;
	  }

	  public void setFunc_sexo (char newVar) {
	    func_sexo = newVar;
	  }

	  public char getFunc_sexo () {
	    return func_sexo;
	  }

	  public void setFunc_nome (String newVar) {
	    func_nome = newVar;
	  }

	  public String getFunc_nome () {
	    return func_nome;
	  }

	  public void setFunc_cep (String newVar) {
	    func_cep = newVar;
	  }

	  public String getFunc_cep () {
	    return func_cep;
	  }

	  public void setFunc_rua (String newVar) {
	    func_rua = newVar;
	  }

	  public String getFunc_rua () {
	    return func_rua;
	  }

	  public void setFunc_bairro (String newVar) {
	    func_bairro = newVar;
	  }

	  public String getFunc_bairro () {
	    return func_bairro;
	  }

	  public void setFunc_numero (String newVar) {
	    func_numero = newVar;
	  }

	  public String getFunc_numero () {
	    return func_numero;
	  }
	  
	  public int getFunc_nivel_acesso() {
		return func_nivel_acesso;
      }

	  public void login(String cpf_user, String rg_pass) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      String Sql = "SELECT `func_nome` FROM `funcionario` WHERE `func_cpf` = '"+ cpf_user + "' AND `func_rg` = '"+rg_pass+"'";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      
	      ResultSet resultado = comando.executeQuery();
	      
	      if(resultado != null && resultado.next()){
	    	  setFunc_nome(resultado.getString("func_nome"));
	    	  setFunc_cpf(cpf_user);
	    	  
	    	  String Sql_farma = "SELECT * FROM `farmaceutico` WHERE `func_cpf` = '"+cpf_user+ "';";
		      PreparedStatement comando_farma = (PreparedStatement) conn.prepareStatement(Sql_farma);
		      comando_farma.execute();
		      
		      ResultSet resultado_farma = comando_farma.executeQuery();
		      if(resultado_farma != null && resultado_farma.next()){
		    	  Farmaceutico farma = new Farmaceutico();
		    	  farma.setFarma_crf(resultado_farma.getString("farma_crf"));
		      }
		      
		      resultado_farma.close();
		      comando_farma.close();
          }
	      
	      resultado.close();
	      comando.close();
	      conn.close();
	  }

	  public void cadastra(Funcionario func) throws SQLException{
		      String usuario = "root";
		      String senha = "";
		      String url = "jdbc:mysql://localhost/farmacia";
		      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		      String Sql = "INSERT INTO `funcionario` (`func_cpf`, `func_rg`, `func_dtnascimento`, "
		      		+ "`func_sexo`, `func_nome`, `func_cep`, `func_rua`, `func_bairro`, `func_numero`)"
		      		+ " VALUES ('"+func.getFunc_cpf()+"','"+func.getFunc_rg()+"',"
		      		+ "'"+func.getFunc_dtnascimento()+"','"+func.getFunc_sexo()+"',"
		      		+ "'"+func.getFunc_nome()+"','"+func.getFunc_cep()+"',"
		      		+ "'"+func.getFunc_rua()+"','"+func.getFunc_bairro()+"',"
		      		+ "'"+func.getFunc_numero()+"')";
		      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		      comando.execute();
		      comando.close();
		      conn.close();
	  }

	  public void deleta(String func_cpf) throws SQLException{
		  String usuario = "root";
		  String senha = "";
		  String url = "jdbc:mysql://localhost/farmacia";
		  java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		  String Sql = "DELETE FROM `funcionario` WHERE `func_cpf` = '"+func_cpf+"';";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      conn.close();
	  }

	  public String lista() throws SQLException{
		    String usuario = "root";
		    String senha = "";
		    String url = "jdbc:mysql://localhost/farmacia";
		    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
			
			String Sql = "SELECT `func_nome`, `func_sexo`, `func_dtnascimento` FROM `funcionario`";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
		    ArrayList<String> registros = new ArrayList<>();
	        while(resultado.next()){
	            registros.add("Nome: "+resultado.getString("func_nome") + 
	                    "\nSexo: " + resultado.getString("func_sexo") + 
	                    "\nDt. Nasc: " + resultado.getString("func_dtnascimento")+"\n");
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

	  public Funcionario busca(String func_cpf) throws SQLException{
		  	  Funcionario func = new Funcionario();
		      String usuario = "root";
		      String senha = "";
		      String url = "jdbc:mysql://localhost/farmacia";
		      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		      String Sql = "SELECT * FROM `funcionario` WHERE `func_cpf` = '"+ func_cpf + "'";
		      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		      comando.execute();
		      
		      ResultSet resultado = comando.executeQuery();
		      
		      if(resultado != null && resultado.next()){
		    	  func.setFunc_cpf(resultado.getString("func_cpf"));
		    	  func.setFunc_rg(resultado.getString("func_rg"));
		    	  func.setFunc_dtnascimento(resultado.getString("func_dtnascimento"));
		    	  func.setFunc_sexo(resultado.getString("func_sexo").charAt(0));
		    	  func.setFunc_nome(resultado.getString("func_nome"));
		    	  func.setFunc_cep(resultado.getString("func_cep"));
		    	  func.setFunc_rua(resultado.getString("func_rua"));
		    	  func.setFunc_bairro(resultado.getString("func_bairro"));
		    	  func.setFunc_numero(resultado.getString("func_numero"));
	          }
		      
		      resultado.close();
		      comando.close();
		      conn.close();
		      return func;
	  }

	  public void atualiza(Funcionario func) throws SQLException{
		      String usuario = "root";
		      String senha = "";
		      String url = "jdbc:mysql://localhost/farmacia";
		      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		      String Sql = "UPDATE `funcionario` SET `func_rg`='"+func.getFunc_rg()+"',"
		      		+ "`func_dtnascimento`='"+func.getFunc_dtnascimento()+"',`func_sexo`='"+func.getFunc_sexo()+"',"
		      		+ "`func_nome`='"+func.getFunc_nome()+"',`func_cep`='"+func.getFunc_cep()+"',"
		      		+ "`func_rua`='"+func.getFunc_rua()+"',`func_bairro`='"+func.getFunc_bairro()+"',"
		      		+ "`func_numero`='"+func.getFunc_numero()+"' WHERE `func_cpf` = '"+func.getFunc_cpf()+"'";
		      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		      comando.execute();
		      comando.close();
		      conn.close();
	  }
}
