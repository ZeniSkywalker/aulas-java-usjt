package ppint.frame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import ppint.calculadora.Calculadora;
public class CalculadoraFlow extends JFrame implements ActionListener
{
	JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao,
		botao1, botao2, botao3, botao4, botao5, botao6, botao7,
		botao8, botao9, botao0, botaoIgual, botaoLimpar;
	JTextField textoResultado;
	Calculadora calculadora;
	
	// Método Construtor
	public CalculadoraFlow(Calculadora c)
{
		//recebe o objeto calculadora que fará os cálculos
		calculadora = c;
		Container caixa = getContentPane();
		caixa.setLayout(new FlowLayout());
		
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
		caixa.add(textoResultado);
		caixa.add(botao7);
		caixa.add(botao8);
		caixa.add(botao9);
		caixa.add(botaoSoma);
		caixa.add(botao4);
		caixa.add(botao5);
		caixa.add(botao6);
		caixa.add(botaoSubtracao);
		caixa.add(botao1);
		caixa.add(botao2);
		caixa.add(botao3);
		caixa.add(botaoMultiplicacao);
		caixa.add(botao0);
		caixa.add(botaoLimpar);
		caixa.add(botaoIgual);
		caixa.add(botaoDivisao);
		
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
		setSize(350,200);
		setVisible(true);
	}
	
	// Método do Listener
	public void actionPerformed(ActionEvent evento)
{
		
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
	
} // Fecha a classe Soma