package exercicio.border;
import javax.swing.*;

import exercicio.calculadora.Calculadora;

import java.awt.*;
import java.awt.event.*;
public class CalculadoraBorder extends JFrame implements ActionListener
{
	JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao,
		botao1, botao2, botao3, botao4, botao5, botao6, botao7,
		botao8, botao9, botao0, botaoIgual, botaoLimpar;
	JTextField textoResultado;
	Calculadora calculadora;
	
	// Método Construtor
	public CalculadoraBorder(Calculadora c){
		//recebe o objeto calculadora que fará os cálculos
		calculadora = c;
		Container caixa = getContentPane();
		
		caixa.setLayout(new BorderLayout());
		//define-se um painel para cada parte do layout
		//mostrador fica no norte
		JPanel norte = new JPanel();
		norte.setLayout(new GridLayout());
		//botão de limpeza no sul
		JPanel sul = new JPanel();
		sul.setLayout(new GridLayout());
		//botoes de operações no leste
		JPanel leste = new JPanel();
		leste.setLayout(new GridLayout(4,1));
		//botão de igual no oeste
		JPanel oeste = new JPanel();
		oeste.setLayout(new GridLayout());
		//números no centro
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(4,3));
		
		// Instanciação de objetos
		
		botaoSoma = new JButton("+"); 
		botaoSubtracao = new JButton("-"); 
		botaoMultiplicacao = new JButton("*"); 
		botaoDivisao = new JButton("/");
		botaoIgual = new JButton("=");
		botaoLimpar = new JButton("C");
		botao1 = new JButton("1"); 
		botao2 = new JButton("2"); 
		botao3 = new JButton("3"); 
		botao4 = new JButton("4"); 
		botao5 = new JButton("5"); 
		botao6 = new JButton("6"); 
		botao7 = new JButton("7");
		botao8 = new JButton("8"); 
		botao9 = new JButton("9"); 
		botao0 = new JButton("0"); 
		textoResultado = new JTextField(25);
		textoResultado.setHorizontalAlignment(JTextField.RIGHT);
		textoResultado.setEditable(false);
		textoResultado.setText("0");
		
		// Inclusão no container
		norte.add(textoResultado);
		oeste.add(botaoIgual);
		leste.add(botaoSoma);
		leste.add(botaoSubtracao);
		leste.add(botaoMultiplicacao);
		leste.add(botaoDivisao);
		sul.add(botaoLimpar);
		centro.add(botao7);
		centro.add(botao8);
		centro.add(botao9);
		centro.add(botao4);
		centro.add(botao5);
		centro.add(botao6);
		centro.add(botao1);
		centro.add(botao2);
		centro.add(botao3);
		centro.add(botao0);
		//agora inclui o conteiner de cima e de baixo
		//no conteiner principal
		caixa.add(norte, BorderLayout.NORTH);
		caixa.add(sul, BorderLayout.SOUTH);
		caixa.add(leste, BorderLayout.EAST);
		caixa.add(oeste, BorderLayout.WEST);
		caixa.add(centro, BorderLayout.CENTER);
		
		// Registro no listener dos objetos controlados
		botaoSoma.addActionListener(this); 
		botaoSubtracao.addActionListener(this); 
		botaoMultiplicacao.addActionListener(this); 
		botaoDivisao.addActionListener(this);
		botaoIgual.addActionListener(this);
		botaoLimpar.addActionListener(this);
		botao1.addActionListener(this); 
		botao2.addActionListener(this); 
		botao3.addActionListener(this); 
		botao4.addActionListener(this); 
		botao5.addActionListener(this);
		botao6.addActionListener(this); 
		botao7.addActionListener(this);
		botao8.addActionListener(this); 
		botao9.addActionListener(this); 
		botao0.addActionListener(this); 

		
		// Ajustes finais do frame
		setTitle("Calculadora");
		setSize(300,240);
		setVisible(true);
	}
	
	// Método do Listener
	public void actionPerformed(ActionEvent evento){
		
		if(evento.getSource() == botao1)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao1.getText()));
		else if(evento.getSource() == botao2)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao2.getText()));
		else if(evento.getSource() == botao3)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao3.getText()));
		else if(evento.getSource() == botao4)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao4.getText()));
		else if(evento.getSource() == botao5)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao5.getText()));
		else if(evento.getSource() == botao6)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao6.getText()));		
		else if(evento.getSource() == botao7)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao7.getText()));
		else if(evento.getSource() == botao8)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao8.getText()));
		else if(evento.getSource() == botao9)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao9.getText()));
		else if(evento.getSource() == botao0)
			textoResultado.setText(calculadora.concatena(
				textoResultado.getText(), botao0.getText()));
		else if(evento.getSource() == botaoLimpar)
			textoResultado.setText(calculadora.limpa());
		else if(evento.getSource() == botaoSoma)
			textoResultado.setText(calculadora.soma(textoResultado.getText()));
		else if(evento.getSource() == botaoSubtracao)
			textoResultado.setText(calculadora.subtracao(textoResultado.getText()));
		else if(evento.getSource() == botaoDivisao)
			textoResultado.setText(calculadora.divisao(textoResultado.getText()));
		else if(evento.getSource() == botaoMultiplicacao)
			textoResultado.setText(calculadora.multiplicacao(textoResultado.getText()));
		else if(evento.getSource() == botaoIgual)
			textoResultado.setText(calculadora.igual(textoResultado.getText()));
			
		
	} // Fecha o método actionPerformed
	
}



