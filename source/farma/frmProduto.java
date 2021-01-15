package farmacia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class frmProduto extends JFrame {
	private static final long serialVersionUID = -4209133095828296852L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProduto frame = new frmProduto(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmProduto(boolean list) throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 500);
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
		
		Produto prod = new Produto();
	    
		if(list){
			JLabel lblNewLabel = new JLabel("Lista de Produtos");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(180, 12, 176, 16);
			contentPane.add(lblNewLabel);
			
			TextArea cxTxt = new TextArea();
			cxTxt.setBounds(10, 101, 425, 340);
			cxTxt.setBackground(Color.WHITE);
			contentPane.add(cxTxt);
			cxTxt.setEditable(false); 
	        cxTxt.setText(prod.lista());
		}else{
			JLabel lblNewLabel = new JLabel("Gestão de Produtos");
			lblNewLabel.setForeground(new Color(0, 0, 102));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel.setBounds(160, 13, 180, 15);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Nome");
			lblNewLabel_2.setBounds(10, 60, 50, 14);
			contentPane.add(lblNewLabel_2);
			JTextField txtNome = new JTextField();
			txtNome.setBounds(100, 60, 205, 20);
			contentPane.add(txtNome);
			txtNome.setColumns(10);
			
			JButton btnBusca = new JButton("Busca");
			btnBusca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					prod.setProd_nome(txtNome.getText());
					// prod.busca(prod.getProd_nome());
				}
			});
			btnBusca.setBackground(new Color(0, 0, 102));
			btnBusca.setForeground(Color.WHITE);
			btnBusca.setFont(new Font("Arial", Font.PLAIN, 13));
			btnBusca.setBounds(325, 57, 80, 23);
			contentPane.add(btnBusca);
			
			JLabel lblNewLabel_3 = new JLabel("Categoria");
			lblNewLabel_3.setBounds(10, 110, 80, 14);
			contentPane.add(lblNewLabel_3);
			JTextField txtCateg = new JTextField();
			txtCateg.setBounds(100, 110, 307, 20);
			contentPane.add(txtCateg);
			txtCateg.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Estoque");
			lblNewLabel_4.setBounds(10, 160, 46, 14);
			contentPane.add(lblNewLabel_4);
			JTextField txtEst = new JTextField();
			txtEst.setBounds(100, 160, 307, 20);
			contentPane.add(txtEst);
			txtEst.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Fornecedor");
			lblNewLabel_5.setBounds(10, 210, 80, 14);
			contentPane.add(lblNewLabel_5);
			JTextField txtForne = new JTextField();
			txtForne.setBounds(100, 210, 307, 20);
			contentPane.add(txtForne);
			txtForne.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Preço");
			lblNewLabel_6.setBounds(10, 260, 46, 14);
			contentPane.add(lblNewLabel_6);
			JTextField txtPrec = new JTextField();
			txtPrec.setBounds(100, 260, 307, 20);
			contentPane.add(txtPrec);
			txtPrec.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Marca");
			lblNewLabel_7.setBounds(10, 310, 46, 14);
			contentPane.add(lblNewLabel_7);
			JTextField txtMarc = new JTextField();
			txtMarc.setBounds(100, 310, 307, 20);
			contentPane.add(txtMarc);
			txtMarc.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Dt. valid");
			lblNewLabel_8.setBounds(10, 360, 46, 14);
			contentPane.add(lblNewLabel_8);
			JTextField txtDtVal = new JTextField();
			txtDtVal.setBounds(100, 360, 307, 20);
			contentPane.add(txtDtVal);
			txtDtVal.setColumns(10);
			
			JButton btnSalva = new JButton("Salva");
			btnSalva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					prod.setProd_nome(txtNome.getText());
					prod.setProd_categoria(txtCateg.getText());
					prod.setProd_estoque(Integer.parseInt(txtEst.getText()));
					prod.setProd_fornecedor(txtForne.getText());
					prod.setProd_preco(Double.parseDouble(txtPrec.getText().replace(",", ".")));
					prod.setProd_marca(txtMarc.getText());
					prod.setProd_dtvalidade(txtDtVal.getText());
					try {
						prod.cadastra(prod);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnSalva.setBackground(new Color(0, 0, 102));
			btnSalva.setForeground(Color.WHITE);
			btnSalva.setFont(new Font("Arial", Font.PLAIN, 13));
			btnSalva.setBounds(80, 410, 80, 23);
			contentPane.add(btnSalva);
			
			JButton btnEdita = new JButton("Edita");
			btnEdita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					prod.atualiza();
				}
			});
			btnEdita.setBackground(new Color(0, 0, 102));
			btnEdita.setForeground(Color.WHITE);
			btnEdita.setFont(new Font("Arial", Font.PLAIN, 13));
			btnEdita.setBounds(180, 410, 80, 23);
			contentPane.add(btnEdita);
			
			JButton btnDel = new JButton("Deleta");
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					prod.deleta();
				}
			});
			btnDel.setBackground(new Color(0, 0, 102));
			btnDel.setForeground(Color.WHITE);
			btnDel.setFont(new Font("Arial", Font.PLAIN, 13));
			btnDel.setBounds(280, 410, 80, 23);
			contentPane.add(btnDel);
			
		}
	}
}
