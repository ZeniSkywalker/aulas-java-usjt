import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaCliente extends JFrame implements ActionListener {
	private JTextField txtNome, txtId, txtFone;
	private JLabel lblNome, lblId, lblFone;
	private JButton inserir, alterar, excluir, carregar, consultar, sair,
			pedidos;
	private Cliente cliente;
	private Connection conn;

	public TelaCliente(Connection conn) {
		super("Cadastro de Clientes");
		txtNome = new JTextField(30);
		txtId = new JTextField(5);
		txtFone = new JTextField(10);

		lblId = new JLabel("Id");
		lblNome = new JLabel("Nome");
		lblFone = new JLabel("Fone");

		inserir = new JButton("Novo");
		alterar = new JButton("Atualiza");
		excluir = new JButton("Exclui");
		carregar = new JButton("Carrega");
		sair = new JButton("Sair");
		consultar = new JButton("Consultas");
		pedidos = new JButton("Pedidos");

		this.conn = conn;

		Container caixa = getContentPane();
		caixa.setLayout(new BorderLayout());

		JPanel painelBotoes = new JPanel(new FlowLayout());
		JPanel painelPedidos = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel painelCentro = new JPanel(new GridLayout(3, 1));
		JPanel painelLinha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelLinha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelLinha3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		painelLinha1.add(lblId);
		painelLinha1.add(txtId);
		painelLinha2.add(lblNome);
		painelLinha2.add(txtNome);
		painelLinha3.add(lblFone);
		painelLinha3.add(txtFone);
		painelCentro.add(painelLinha1);
		painelCentro.add(painelLinha2);
		painelCentro.add(painelLinha3);
		painelBotoes.add(inserir);
		painelBotoes.add(alterar);
		painelBotoes.add(excluir);
		painelBotoes.add(carregar);
		painelBotoes.add(sair);
		painelPedidos.add(consultar);
		painelPedidos.add(pedidos);
		caixa.add(painelCentro, BorderLayout.CENTER);
		caixa.add(painelBotoes, BorderLayout.SOUTH);
		caixa.add(painelPedidos, BorderLayout.NORTH);

		inserir.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);
		carregar.addActionListener(this);
		consultar.addActionListener(this);
		pedidos.addActionListener(this);
		sair.addActionListener(this);

		setSize(552, 255);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sair){
			System.exit(0);
		} else if (e.getSource() == consultar) {
			new TelaConsulta(conn);
			dispose();
		} else {
			cliente = new Cliente();
			try {
				cliente.setIdCliente(Integer.parseInt(txtId.getText()));
			} catch (NumberFormatException e1) {
				cliente.setIdCliente(-1);
			}
			cliente.setNome(txtNome.getText());
			cliente.setFone(txtFone.getText());
		}

		if (e.getSource() == inserir) {
			cliente.incluir(conn);
			txtId.setText(""+cliente.getIdCliente());
		} else if (e.getSource() == alterar) {
			if (cliente.getNome().length() > 0
					&& cliente.getFone().length() > 0) {
				cliente.atualizar(conn);
			} else {
				JOptionPane.showMessageDialog(this, "Dados invalidos",
						"Cliente", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == excluir) {
			cliente.excluir(conn);
		} else if (e.getSource() == carregar) {
			cliente.carregar(conn);
			txtId.setText("" + cliente.getIdCliente());
			txtNome.setText(cliente.getNome());
			txtFone.setText(cliente.getFone());
		} else if(e.getSource() == pedidos){
                    if(txtId.getText().length() > 0)
                        new TelaPedidos(conn, Integer.parseInt(txtId.getText()));
                    else
                        new TelaPedidos(conn);
                }

	}

}