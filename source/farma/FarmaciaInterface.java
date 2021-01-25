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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class FarmaciaInterface {
	private JFrame frame;
	private JTextField user;
	private JTextField pass;

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

	public FarmaciaInterface() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 502, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Funcionario func = new Funcionario();
		
		JLabel lblNewLabel = new JLabel("Farm\u00E1cia Guarulhense\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 11, 268, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel txtIni = new JLabel("Fa\u00E7a login para acessar o sistema");
		txtIni.setFont(new Font("Arial", Font.PLAIN, 16));
		txtIni.setHorizontalAlignment(SwingConstants.CENTER);
		txtIni.setBounds(113, 60, 241, 19);
		frame.getContentPane().add(txtIni);
		
		JLabel txtApr = new JLabel(" Este \u00E9 o Sistema de Controle da Farm\u00E1cia.");
		txtApr.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApr.setHorizontalAlignment(SwingConstants.CENTER);
		txtApr.setBounds(77, 90, 338, 14);
		frame.getContentPane().add(txtApr);
		
		JLabel userLabel = new JLabel("Usu\u00E1rio");
		userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		userLabel.setBounds(90, 116, 79, 14);
		frame.getContentPane().add(userLabel);
		
		user = new JTextField();
		user.setBounds(197, 114, 218, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(197, 161, 218, 20);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		JLabel passLabel = new JLabel("Senha\r\n");
		passLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		passLabel.setBounds(90, 163, 79, 14);
		frame.getContentPane().add(passLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Funcionarios");
		menuBar.add(mnNewMenu);
		
		JMenu mnuFuncList = new JMenu("Lista");
		mnuFuncList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmFuncion c = null;
				try {
					c = new frmFuncion(true, 0);
				}catch(SQLException e){
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		JMenu mnuFuncAct = new JMenu("Ações");
		mnuFuncAct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmFuncion c = null;
				try {
					if(func.getFunc_nivel_acesso() != 0) {
						c = new frmFuncion(false, 1);
					}else{
						c = new frmFuncion(false, 0);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		mnNewMenu.add(mnuFuncAct);
		mnNewMenu.add(mnuFuncList);
		
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnuClieAct = new JMenu("A\u00E7\u00F5es");
		mnuClieAct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCliente c = null;
				try {
					c = new frmCliente(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		JMenu mnuClieList = new JMenu("Lista");
		mnuClieList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCliente c = null;
				try {
					c = new frmCliente(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		mnNewMenu_1.add(mnuClieAct);
		mnNewMenu_1.add(mnuClieList);
		
		JMenu mnNewMenu_2 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnuProdAct = new JMenu("A\u00E7\u00F5es");
		mnuProdAct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmProduto c = null;
				try {
					c = new frmProduto(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		JMenu mnuProdList = new JMenu("Lista");
		mnuProdList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmProduto c = null;
				try {
					c = new frmProduto(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		mnNewMenu_2.add(mnuProdAct);
		mnNewMenu_2.add(mnuProdList);
		
		JMenu mnuComp = new JMenu("Compras");
		menuBar.add(mnuComp);
		JMenu mnuCompReg = new JMenu("Registrar");
		mnuCompReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCompra c = null;
				try{
					c = new frmCompra(false, func.getFunc_cpf());
				}catch(SQLException e){
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		JMenu mnuCompList = new JMenu("Lista");
		mnuCompList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCompra c = null;
				try {
					c = new frmCompra(true, "0");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		
		mnuComp.add(mnuCompReg);
		mnuComp.add(mnuCompList);
		
		JMenuItem mnuSair = new JMenuItem("Sair");
		menuBar.add(mnuSair);
		mnuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		menuBar.setVisible(false);
		txtApr.setVisible(false);
		
		JButton logar = new JButton("Entrar\r\n");
		logar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try {
					func.login(user.getText(), pass.getText());
					if(func.getFunc_nome() != null){
						menuBar.setVisible(true);		
						txtIni.setVisible(false);
						userLabel.setVisible(false);
						passLabel.setVisible(false);
						txtApr.setVisible(true);
						user.setVisible(false);
						pass.setVisible(false);
						logar.setVisible(false);
						JLabel txtLog = new JLabel("Bem-vindo(a) "+func.getFunc_nome()+"!");
						txtLog.setFont(new Font("Arial", Font.PLAIN, 16));
						txtLog.setHorizontalAlignment(SwingConstants.CENTER);
						txtLog.setBounds(95, 60, 300, 20);
						frame.getContentPane().add(txtLog);
					}else{
						JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!");
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		});
		logar.setBackground(new Color(0, 0, 102));
		logar.setForeground(new Color(255, 255, 255));
		logar.setFont(new Font("Arial", Font.BOLD, 16));
		logar.setBounds(193, 208, 89, 23);
		frame.getContentPane().add(logar);
	}
}
