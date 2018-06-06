/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaPedidos extends JFrame implements ActionListener {
	private JTextField txtIdPedido, txtIdCliente, txtDataPedido, txtValorPedido;
	private JLabel lblIdPedido, lblIdCliente, lblDataPedido, lblValorPedido;
	private JButton inserir, alterar, excluir, carregar, consultar, sair,
			clientes;
	private Pedido pedido;
	private Connection conn;
        public TelaPedidos(Connection conn, int idCliente) {
            this(conn);
            pedido = new Pedido();
            pedido.setIdCliente(idCliente);
            txtIdCliente.setText(""+idCliente);
        }
	public TelaPedidos(Connection conn) {
		super("Cadastro de Pedidos");
                txtIdPedido = new JTextField(5);
                txtIdCliente = new JTextField(5);
		txtDataPedido = new JTextField(20);
		txtValorPedido = new JTextField(10);
                
                lblIdPedido = new JLabel("Id Ped");
		lblIdCliente = new JLabel("Id Cli");
		lblDataPedido = new JLabel("Data");
		lblValorPedido = new JLabel("Valor");

		inserir = new JButton("Novo");
		alterar = new JButton("Atualiza");
		excluir = new JButton("Exclui");
		carregar = new JButton("Carrega");
		sair = new JButton("Sair");
		consultar = new JButton("Consultas");
		clientes = new JButton("Clientes");

		this.conn = conn;

		Container caixa = getContentPane();
		caixa.setLayout(new BorderLayout());

		JPanel painelBotoes = new JPanel(new FlowLayout());
		JPanel painelPedidos = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel painelCentro = new JPanel(new GridLayout(3, 1));
		JPanel painelLinha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelLinha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelLinha3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                
                JPanel painelAuxLinha1 = new JPanel(new GridLayout(1,4));
                painelAuxLinha1.add(lblIdPedido);
		painelAuxLinha1.add(txtIdPedido);
                painelAuxLinha1.add(lblIdCliente);
		painelAuxLinha1.add(txtIdCliente);
                painelLinha1.add(painelAuxLinha1);
                
		painelLinha2.add(lblDataPedido);
		painelLinha2.add(txtDataPedido);
		painelLinha3.add(lblValorPedido);
		painelLinha3.add(txtValorPedido);
		painelCentro.add(painelLinha1);
		painelCentro.add(painelLinha2);
		painelCentro.add(painelLinha3);
		painelBotoes.add(inserir);
		painelBotoes.add(alterar);
		painelBotoes.add(excluir);
		painelBotoes.add(carregar);
		painelBotoes.add(sair);
		painelPedidos.add(consultar);
		painelPedidos.add(clientes);
		caixa.add(painelCentro, BorderLayout.CENTER);
		caixa.add(painelBotoes, BorderLayout.SOUTH);
		caixa.add(painelPedidos, BorderLayout.NORTH);

		inserir.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);
		carregar.addActionListener(this);
		consultar.addActionListener(this);
		clientes.addActionListener(this);
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
                        if(pedido == null)
                            pedido = new Pedido();
			try {
                            pedido.setId(Integer.parseInt(txtIdPedido.getText()));
			} catch (NumberFormatException e1) {
                            pedido.setId(-1);
			}
                        
			try{
                            if(pedido.getIdCliente() <= 0)
                                pedido.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
                            pedido.setValor(Double.parseDouble(txtValorPedido.getText()));
                            pedido.setData(new java.util.Date(txtDataPedido.getText()));
                            
                        } catch(java.lang.IllegalArgumentException exCa){
                            try{
                            String[] dataGambiarra = txtDataPedido.getText().split("-");
                            pedido.setData(new java.util.Date(dataGambiarra[1] + "/" + dataGambiarra[2] + "/" + dataGambiarra[0]));
                            }catch(Exception ex53){
                                System.out.println("data incorreta mesmo, corre");
                            }
                        }
                        catch(Exception e2){
                            pedido.setIdCliente(-1);
                            pedido.setValor(0.0);
                        }
		}

		if (e.getSource() == inserir) {
			pedido.incluir(pedido.getIdCliente(),conn);
                        txtIdPedido.setText(""+pedido.getId());
			txtIdCliente.setText(""+pedido.getIdCliente());
		} else if (e.getSource() == alterar) {
			if (pedido.getValor() > 0.0) {
				pedido.atualizar(conn);
			} else {
                                System.out.println(pedido);
				JOptionPane.showMessageDialog(this, "Dados invalidos",
						"Cliente", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == excluir) {
			pedido.excluir(conn);
		} else if (e.getSource() == carregar) {
			pedido.carregar(conn);
                        txtIdPedido.setText("" + pedido.getId());
			txtIdCliente.setText("" + pedido.getIdCliente());
			txtDataPedido.setText(String.valueOf(pedido.getData()));
			txtValorPedido.setText(String.valueOf(pedido.getValor()));
		} else if(e.getSource() == clientes){
                    new TelaCliente(conn);
                }
	}

}
