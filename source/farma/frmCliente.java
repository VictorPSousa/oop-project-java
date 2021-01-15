package farmacia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

public class frmCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCliente frame = new frmCliente(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmCliente(boolean list) throws SQLException{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolta = new JButton("Voltar");
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnVolta.setBackground(new Color(0, 0, 102));
		btnVolta.setForeground(Color.WHITE);
		btnVolta.setFont(new Font("Arial", Font.PLAIN, 13));
		btnVolta.setBounds(10, 11, 68, 23);
		contentPane.add(btnVolta);
		
		Cliente cli = new Cliente();

	    
		if(list) {
			JLabel lblNewLabel = new JLabel("Lista de Clientes");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
			
	        TextArea cxTxt = new TextArea();
			cxTxt.setBounds(10, 101, 425, 300);
			cxTxt.setBackground(Color.WHITE);
			contentPane.add(cxTxt);
			cxTxt.setEditable(false); 
	        cxTxt.setText(cli.lista());
		}else {
			JLabel lblNewLabel = new JLabel("Gestão de Clientes");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(160, 13, 180, 15);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("CPF");
			lblNewLabel_2.setBounds(10, 50, 50, 14);
			contentPane.add(lblNewLabel_2);
			JTextField txtCPF = new JTextField();
			txtCPF.setBounds(100, 50, 205, 20);
			contentPane.add(txtCPF);
			txtCPF.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Nome");
			lblNewLabel_3.setBounds(10, 80, 80, 14);
			contentPane.add(lblNewLabel_3);
			JTextField txtNome = new JTextField();
			txtNome.setBounds(100, 80, 307, 20);
			contentPane.add(txtNome);
			txtNome.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("RG");
			lblNewLabel_4.setBounds(10, 110, 46, 14);
			contentPane.add(lblNewLabel_4);
			JTextField txtRG = new JTextField();
			txtRG.setBounds(100, 110, 307, 20);
			contentPane.add(txtRG);
			txtRG.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Sexo");
			lblNewLabel_5.setBounds(10, 140, 80, 14);
			contentPane.add(lblNewLabel_5);
			JTextField txtSexo = new JTextField();
			txtSexo.setBounds(100, 140, 307, 20);
			contentPane.add(txtSexo);
			txtSexo.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Plan Saúde");
			lblNewLabel_6.setBounds(10, 170, 80, 14);
			contentPane.add(lblNewLabel_6);
			JTextField txtPlan = new JTextField();
			txtPlan.setBounds(100, 170, 307, 20);
			contentPane.add(txtPlan);
			txtPlan.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Desconto");
			lblNewLabel_7.setBounds(10, 200, 60, 14);
			contentPane.add(lblNewLabel_7);
			JTextField txtDesco = new JTextField();
			txtDesco.setBounds(100, 200, 307, 20);
			contentPane.add(txtDesco);
			txtDesco.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Fone");
			lblNewLabel_8.setBounds(10, 230, 46, 14);
			contentPane.add(lblNewLabel_8);
			JTextField txtTel = new JTextField();
			txtTel.setBounds(100, 230, 307, 20);
			contentPane.add(txtTel);
			txtTel.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("CEP");
			lblNewLabel_9.setBounds(10, 260, 46, 14);
			contentPane.add(lblNewLabel_9);
			JTextField txtCEP = new JTextField();
			txtCEP.setBounds(100, 260, 307, 20);
			contentPane.add(txtCEP);
			txtCEP.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Rua");
			lblNewLabel_10.setBounds(10, 290, 46, 14);
			contentPane.add(lblNewLabel_10);
			JTextField txtRua = new JTextField();
			txtRua.setBounds(100, 290, 307, 20);
			contentPane.add(txtRua);
			txtRua.setColumns(10);
			
			JLabel lblNewLabel_11 = new JLabel("Número");
			lblNewLabel_11.setBounds(10, 320, 46, 14);
			contentPane.add(lblNewLabel_11);
			JTextField txtNum = new JTextField();
			txtNum.setBounds(100, 320, 307, 20);
			contentPane.add(txtNum);
			txtNum.setColumns(10);
			
			JLabel lblNewLabel_12 = new JLabel("Bairro");
			lblNewLabel_12.setBounds(10, 350, 46, 14);
			contentPane.add(lblNewLabel_12);
			JTextField txtBairro = new JTextField();
			txtBairro.setBounds(100, 350, 307, 20);
			contentPane.add(txtBairro);
			txtBairro.setColumns(10);
			
			JButton btnBusca = new JButton("Busca");
			btnBusca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					String cpf = txtCPF.getText();
					try{
						Cliente clie = new Cliente();
						clie = cli.busca(cpf);
						txtCPF.setText(clie.getClie_cpf());
						txtNome.setText(clie.getClie_nome());
						txtRG.setText(clie.getClie_rg());
						txtSexo.setText(clie.getClie_sexo()+"");
						txtPlan.setText(clie.getClie_planosaude());
						txtDesco.setText(Double.toString(clie.getClie_desconto()));
						txtTel.setText(clie.getClie_tel());
						txtCEP.setText(clie.getClie_cep());
						txtRua.setText(clie.getClie_rua());
						txtNum.setText(clie.getClie_numero());
						txtBairro.setText(clie.getClie_bairro());
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			});
			btnBusca.setBackground(new Color(0, 0, 102));
			btnBusca.setForeground(Color.WHITE);
			btnBusca.setFont(new Font("Arial", Font.PLAIN, 13));
			btnBusca.setBounds(325, 47, 80, 23);
			contentPane.add(btnBusca);
			
			JButton btnSalva = new JButton("Salva");
			btnSalva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cli.setClie_cpf(txtCPF.getText());
					cli.setClie_nome(txtNome.getText());
					cli.setClie_rg(txtRG.getText());
					String gen = txtSexo.getText();
					cli.setClie_sexo(gen.charAt(0));
					cli.setClie_planosaude(txtPlan.getText());
					cli.setClie_desconto(Double.parseDouble(txtDesco.getText().replace(",", ".")));
					cli.setClie_tel(txtTel.getText());
					cli.setClie_cep(txtCEP.getText());
					cli.setClie_rua(txtRua.getText());
					cli.setClie_numero(txtNum.getText());
					cli.setClie_bairro(txtBairro.getText());
					try {
						cli.cadastra(cli);
						setVisible(false);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnSalva.setBackground(new Color(0, 0, 102));
			btnSalva.setForeground(Color.WHITE);
			btnSalva.setFont(new Font("Arial", Font.PLAIN, 13));
			btnSalva.setBounds(80, 380, 80, 23);
			contentPane.add(btnSalva);
			
			JButton btnEdita = new JButton("Edita");
			btnEdita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cli.setClie_cpf(txtCPF.getText());
					cli.setClie_nome(txtNome.getText());
					cli.setClie_rg(txtRG.getText());
					String gen = txtSexo.getText();
					cli.setClie_sexo(gen.charAt(0));
					cli.setClie_planosaude(txtPlan.getText());
					cli.setClie_desconto(Double.parseDouble(txtDesco.getText().replace(",", ".")));
					cli.setClie_tel(txtTel.getText());
					cli.setClie_cep(txtCEP.getText());
					cli.setClie_rua(txtRua.getText());
					cli.setClie_numero(txtNum.getText());
					cli.setClie_bairro(txtBairro.getText());
					try {
						cli.atualiza(cli);
						JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
						setVisible(false);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnEdita.setBackground(new Color(0, 0, 102));
			btnEdita.setForeground(Color.WHITE);
			btnEdita.setFont(new Font("Arial", Font.PLAIN, 13));
			btnEdita.setBounds(180, 380, 80, 23);
			contentPane.add(btnEdita);
			
			JButton btnDel = new JButton("Deleta");
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cpf = txtCPF.getText();
					try {
						cli.deleta(cpf);
						JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
						setVisible(false);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnDel.setBackground(new Color(0, 0, 102));
			btnDel.setForeground(Color.WHITE);
			btnDel.setFont(new Font("Arial", Font.PLAIN, 13));
			btnDel.setBounds(280, 380, 80, 23);
			contentPane.add(btnDel);
		}
	}
}
