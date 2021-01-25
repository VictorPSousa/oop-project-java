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
import java.awt.TextArea;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class frmFuncion extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncion frame = new frmFuncion(false, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmFuncion(boolean list, int farmaceutic) throws SQLException{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 400);
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
		
		Funcionario func = new Funcionario();
	    
		if(list){
			JLabel lblNewLabel = new JLabel("Lista de Funcion\u00E1rios");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
			
			TextArea cxTxt = new TextArea();
			cxTxt.setBounds(10, 101, 425, 250);
			cxTxt.setBackground(Color.WHITE);
			contentPane.add(cxTxt);
			cxTxt.setEditable(false); 
	        cxTxt.setText(func.lista());
		}else{
			JLabel lblNewLabel = new JLabel("Gestão de Funcionários");
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
			
			JLabel lblNewLabel_6 = new JLabel("Dt Nasc");
			lblNewLabel_6.setBounds(10, 170, 80, 14);
			contentPane.add(lblNewLabel_6);
			JTextField txtDtNasc = new JTextField();
			txtDtNasc.setBounds(100, 170, 307, 20);
			contentPane.add(txtDtNasc);
			txtDtNasc.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("CEP");
			lblNewLabel_9.setBounds(10, 200, 46, 14);
			contentPane.add(lblNewLabel_9);
			JTextField txtCEP = new JTextField();
			txtCEP.setBounds(100, 200, 307, 20);
			contentPane.add(txtCEP);
			txtCEP.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Rua");
			lblNewLabel_10.setBounds(10, 230, 46, 14);
			contentPane.add(lblNewLabel_10);
			JTextField txtRua = new JTextField();
			txtRua.setBounds(100, 230, 307, 20);
			contentPane.add(txtRua);
			txtRua.setColumns(10);
			
			JLabel lblNewLabel_11 = new JLabel("Número");
			lblNewLabel_11.setBounds(10, 260, 46, 14);
			contentPane.add(lblNewLabel_11);
			JTextField txtNum = new JTextField();
			txtNum.setBounds(100, 260, 307, 20);
			contentPane.add(txtNum);
			txtNum.setColumns(10);
			
			JLabel lblNewLabel_12 = new JLabel("Bairro");
			lblNewLabel_12.setBounds(10, 290, 46, 14);
			contentPane.add(lblNewLabel_12);
			JTextField txtBairro = new JTextField();
			txtBairro.setBounds(100, 290, 307, 20);
			contentPane.add(txtBairro);
			txtBairro.setColumns(10);
			
			JButton btnBusca = new JButton("Busca");
			btnBusca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					try{
						Funcionario funcio = new Funcionario();
						funcio = funcio.busca(txtCPF.getText());
						txtCPF.setText(funcio.getFunc_cpf());
						txtNome.setText(funcio.getFunc_nome());
						txtRG.setText(funcio.getFunc_rg());
						txtSexo.setText(funcio.getFunc_sexo()+"");
						txtDtNasc.setText(funcio.getFunc_dtnascimento());
						txtCEP.setText(funcio.getFunc_cep());
						txtRua.setText(funcio.getFunc_rua());
						txtNum.setText(funcio.getFunc_numero());
						txtBairro.setText(funcio.getFunc_bairro());
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
			
			if(farmaceutic == 1){
				Farmaceutico farma = new Farmaceutico();
				
				JLabel lblNewLabel_13 = new JLabel("CRF");
				lblNewLabel_13.setBounds(10, 320, 40, 23);
				contentPane.add(lblNewLabel_13);
				JTextField txtCRF = new JTextField();
				txtCRF.setBounds(40, 320, 60, 23);
				contentPane.add(txtCRF);
				txtCRF.setColumns(10);
				
				JButton btnSalva = new JButton("Salva");
				btnSalva.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						farma.setFunc_cpf(txtCPF.getText());
						farma.setFunc_nome(txtNome.getText());
						farma.setFunc_rg(txtRG.getText());
						farma.setFunc_sexo(txtSexo.getText().charAt(0));
						farma.setFunc_dtnascimento(txtDtNasc.getText());
						farma.setFunc_cep(txtCEP.getText());
						farma.setFunc_rua(txtRua.getText());
						farma.setFunc_numero(txtNum.getText());
						farma.setFunc_bairro(txtBairro.getText());
						farma.setFarma_crf(txtCRF.getText());
						try{
							farma.cadastra(farma);
							JOptionPane.showMessageDialog(null, "Farmacêutico cadastrado com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnSalva.setBackground(new Color(0, 0, 102));
				btnSalva.setForeground(Color.WHITE);
				btnSalva.setFont(new Font("Arial", Font.PLAIN, 13));
				btnSalva.setBounds(100, 320, 80, 23);
				contentPane.add(btnSalva);
				
				JButton btnEdita = new JButton("Edita");
				btnEdita.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						farma.setFunc_cpf(txtCPF.getText());
						farma.setFunc_nome(txtNome.getText());
						farma.setFunc_rg(txtRG.getText());
						farma.setFunc_sexo(txtSexo.getText().charAt(0));
						farma.setFunc_dtnascimento(txtDtNasc.getText());
						farma.setFunc_cep(txtCEP.getText());
						farma.setFunc_rua(txtRua.getText());
						farma.setFunc_numero(txtNum.getText());
						farma.setFunc_bairro(txtBairro.getText());
						farma.setFarma_crf(txtCRF.getText());
						try{
							farma.atualiza(farma);
							JOptionPane.showMessageDialog(null, "Farmacêutico editado com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnEdita.setBackground(new Color(0, 0, 102));
				btnEdita.setForeground(Color.WHITE);
				btnEdita.setFont(new Font("Arial", Font.PLAIN, 13));
				btnEdita.setBounds(200, 320, 80, 23);
				contentPane.add(btnEdita);
				
				JButton btnDel = new JButton("Deleta");
				btnDel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try{
							farma.deleta(txtCPF.getText());
							JOptionPane.showMessageDialog(null, "Farmacêutico excluído com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnDel.setBackground(new Color(0, 0, 102));
				btnDel.setForeground(Color.WHITE);
				btnDel.setFont(new Font("Arial", Font.PLAIN, 13));
				btnDel.setBounds(300, 320, 80, 23);
				contentPane.add(btnDel);
			}else {
				JButton btnSalva = new JButton("Salva");
				btnSalva.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						func.setFunc_cpf(txtCPF.getText());
						func.setFunc_nome(txtNome.getText());
						func.setFunc_rg(txtRG.getText());
						func.setFunc_sexo(txtSexo.getText().charAt(0));
						func.setFunc_dtnascimento(txtDtNasc.getText());
						func.setFunc_cep(txtCEP.getText());
						func.setFunc_rua(txtRua.getText());
						func.setFunc_numero(txtNum.getText());
						func.setFunc_bairro(txtBairro.getText());
						try{
							func.cadastra(func);
							JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnSalva.setBackground(new Color(0, 0, 102));
				btnSalva.setForeground(Color.WHITE);
				btnSalva.setFont(new Font("Arial", Font.PLAIN, 13));
				btnSalva.setBounds(80, 320, 80, 23);
				contentPane.add(btnSalva);
				
				JButton btnEdita = new JButton("Edita");
				btnEdita.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						func.setFunc_cpf(txtCPF.getText());
						func.setFunc_nome(txtNome.getText());
						func.setFunc_rg(txtRG.getText());
						func.setFunc_sexo(txtSexo.getText().charAt(0));
						func.setFunc_dtnascimento(txtDtNasc.getText());
						func.setFunc_cep(txtCEP.getText());
						func.setFunc_rua(txtRua.getText());
						func.setFunc_numero(txtNum.getText());
						func.setFunc_bairro(txtBairro.getText());
						try{
							func.atualiza(func);
							JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnEdita.setBackground(new Color(0, 0, 102));
				btnEdita.setForeground(Color.WHITE);
				btnEdita.setFont(new Font("Arial", Font.PLAIN, 13));
				btnEdita.setBounds(180, 320, 80, 23);
				contentPane.add(btnEdita);
				
				JButton btnDel = new JButton("Deleta");
				btnDel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try{
							func.deleta(txtCPF.getText());
							JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
							setVisible(false);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
				});
				btnDel.setBackground(new Color(0, 0, 102));
				btnDel.setForeground(Color.WHITE);
				btnDel.setFont(new Font("Arial", Font.PLAIN, 13));
				btnDel.setBounds(280, 320, 80, 23);
				contentPane.add(btnDel);
			}
		}
	}
}
