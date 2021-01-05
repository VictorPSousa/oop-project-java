package farmacia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FarmaciaInterface {

	private JFrame frame;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmaciaInterface window = new FarmaciaInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarmaciaInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Farm\u00E1cia Guarulhense\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 11, 268, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fa\u00E7a login para acessar o sistema");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(90, 59, 241, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(80, 116, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(169, 113, 162, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(169, 160, 162, 20);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha\r\n");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(80, 163, 79, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton logar = new JButton("Entrar\r\n");
		logar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Funcionario func = new Funcionario();
				try {
					func.login(user.getText(), pass.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		logar.setBackground(new Color(0, 0, 102));
		logar.setForeground(new Color(255, 255, 255));
		logar.setFont(new Font("Arial", Font.BOLD, 16));
		logar.setBounds(165, 207, 89, 23);
		frame.getContentPane().add(logar);
	}
}
