package farmacia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frmCompra extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					frmCompra frame = new frmCompra(false, "0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmCompra(boolean list, String func_cpf) throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		Compra comp = new Compra();
		
		if(list){
			JLabel lblNewLabel = new JLabel("Lista de Compras");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
			
			TextArea cxTxt = new TextArea();
			cxTxt.setBounds(10, 101, 413, 150);
			cxTxt.setBackground(Color.WHITE);
			contentPane.add(cxTxt);
			cxTxt.setEditable(false); 
	        cxTxt.setText(comp.lista());
		}else{
			JLabel lblNewLabel = new JLabel("Registro de Compras");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 11, 174, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Código(NF)");
			lblNewLabel_2.setBounds(10, 50, 70, 14);
			contentPane.add(lblNewLabel_2);
			JTextField txtNF = new JTextField();
			txtNF.setBounds(100, 50, 205, 20);
			contentPane.add(txtNF);
			txtNF.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Produto(Cód)");
			lblNewLabel_3.setBounds(10, 80, 90, 14);
			contentPane.add(lblNewLabel_3);
			JTextField txtProdCod = new JTextField();
			txtProdCod.setBounds(100, 80, 307, 20);
			contentPane.add(txtProdCod);
			txtProdCod.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Cliente(CPF)");
			lblNewLabel_4.setBounds(10, 110, 70, 14);
			contentPane.add(lblNewLabel_4);
			JTextField txtCliCPF = new JTextField();
			txtCliCPF.setBounds(100, 110, 307, 20);
			contentPane.add(txtCliCPF);
			txtCliCPF.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Quantidade");
			lblNewLabel_5.setBounds(10, 140, 80, 14);
			contentPane.add(lblNewLabel_5);
			JTextField txtQntd = new JTextField();
			txtQntd.setBounds(100, 140, 307, 20);
			contentPane.add(txtQntd);
			txtQntd.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Form Pagar");
			lblNewLabel_6.setBounds(10, 170, 90, 14);
			contentPane.add(lblNewLabel_6);
			JTextField txtPag = new JTextField();
			txtPag.setBounds(100, 170, 307, 20);
			contentPane.add(txtPag);
			txtPag.setColumns(10);
			
			JButton btnBusca = new JButton("Busca");
			btnBusca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					int notFisc = Integer.parseInt(txtNF.getText());
					try{
						Compra compra = new Compra();
						compra = comp.busca(notFisc);
						txtProdCod.setText(Integer.toString(compra.getProduto()));
						txtCliCPF.setText(compra.getCliente());
						txtQntd.setText(Integer.toString(compra.getCompra_qtd()));
						txtPag.setText(compra.getCompra_pag()+"");
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
					comp.setProduto(Integer.parseInt(txtProdCod.getText()));
					comp.setCliente(txtCliCPF.getText());
					comp.setFuncionario(func_cpf);
					comp.setCompra_qtd(Integer.parseInt(txtQntd.getText()));
					comp.setCompra_pag(txtPag.getText());
					try {
						comp.efetua(comp);
						JOptionPane.showMessageDialog(null, "Compra registrada com sucesso!");
						setVisible(false);
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			});
			btnSalva.setBackground(new Color(0, 0, 102));
			btnSalva.setForeground(Color.WHITE);
			btnSalva.setFont(new Font("Arial", Font.PLAIN, 13));
			btnSalva.setBounds(120, 210, 80, 23);
			contentPane.add(btnSalva);
			
			JButton btnEdita = new JButton("Edita");
			btnEdita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comp.setCompra_numNF(Integer.parseInt(txtNF.getText()));
					comp.setProduto(Integer.parseInt(txtProdCod.getText()));
					comp.setCliente(txtCliCPF.getText());
					comp.setFuncionario(func_cpf);
					comp.setCompra_qtd(Integer.parseInt(txtQntd.getText()));
					comp.setCompra_pag(txtPag.getText());
					try {
						comp.atualiza(comp);
						JOptionPane.showMessageDialog(null, "Compra editada com sucesso!");
						setVisible(false);
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			});
			btnEdita.setBackground(new Color(0, 0, 102));
			btnEdita.setForeground(Color.WHITE);
			btnEdita.setFont(new Font("Arial", Font.PLAIN, 13));
			btnEdita.setBounds(230, 210, 80, 23);
			contentPane.add(btnEdita);
		}
	}

}
