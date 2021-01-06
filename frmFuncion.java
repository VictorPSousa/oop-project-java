package farmacia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class frmFuncion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncion frame = new frmFuncion(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmFuncion(boolean list) throws SQLException{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea cxTxt = new JTextArea();
		cxTxt.setBounds(10, 96, 425, 178);
		contentPane.add(cxTxt);
		String usuario = "root";
	    String senha = "";
	    String url = "jdbc:mysql://localhost/farmacia";
	    java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	    
		if(list) {
			JLabel lblNewLabel = new JLabel("Lista de Funcion\u00E1rios");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
			
			String Sql = "SELECT * FROM `funcionario`";
		    PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
		    comando.execute();
		      
		    ResultSet resultado = comando.executeQuery();
		    
		    ArrayList<String> registros = new ArrayList<>();
	        while(resultado.next()){
	            registros.add(resultado.getString("func_nome") + 
	                    " \t " + resultado.getString("func_sexo") + 
	                    " \t " + resultado.getString("func_dtnascimento"));
	        }
	        String lista = "Nome \t \t Sexo \t \t Data Nas. \n";
	        for(int j = 0; j < registros.size(); j++) {
	            lista += registros.get(j) + "\n";
	        }
	        cxTxt.setText(lista);
		   
		    resultado.close();
		    comando.close();
		    conn.close();
		}else {
			JLabel lblNewLabel = new JLabel("Formulário");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
		}
	}
}
