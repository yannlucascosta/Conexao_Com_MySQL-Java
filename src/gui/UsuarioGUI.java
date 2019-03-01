package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField1;
	private JTextField textField4;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
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
	public UsuarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textId.setText("");

			}
		});
		btnNewButton.setBounds(109, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 227, 89, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuarios = new Usuario();
				usuarios.setNome(textField1.getText());
				usuarios.setCpf(textField2.getText());
				usuarios.setEmail(textField3.getText());
				usuarios.setTelefone(textField4.getText());

				if ((textField1.getText().isEmpty()) || (textField2.getText().isEmpty())
						|| (textField3.getText().isEmpty()) || (textField4.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				} else {

					// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
					UsuarioDAO dao = new UsuarioDAO();
					dao.adiciona(usuarios);
					JOptionPane.showMessageDialog(null, "Usuário " + textField1.getText() + " inserido com sucesso! ");
				}

				// apaga os dados preenchidos nos campos de texto
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textId.setText("");

			}
		});

		textField2 = new JTextField();
		textField2.setBounds(128, 62, 189, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(128, 94, 189, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(128, 31, 189, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField4 = new JTextField();
		textField4.setBounds(128, 125, 189, 20);
		contentPane.add(textField4);
		textField4.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(70, 34, 48, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cpf");
		lblNewLabel_1.setBounds(70, 65, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(70, 97, 48, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setBounds(70, 128, 48, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(208, 227, 89, 23);
		contentPane.add(btnSair);

		textId = new JTextField();
		textId.setBounds(128, 156, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarios = new Usuario();
				usuarios.setId(Integer.parseInt(textId.getText()));
				UsuarioDAO dao = new UsuarioDAO();
				dao.remove(usuarios);
				JOptionPane.showMessageDialog(null, "Usuário " + "removido com sucesso! ");

			}
		});
		btnRemove.setBounds(308, 227, 89, 23);
		contentPane.add(btnRemove);

		JLabel JLabelId = new JLabel("Id");
		JLabelId.setBounds(94, 159, 24, 14);
		contentPane.add(JLabelId);

	}
}
