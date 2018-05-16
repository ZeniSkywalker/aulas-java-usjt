package ppint.grid;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ppint.calculadora.Calculadora;
public class CalculadoraGrid extends JFrame implements ActionListener
{
	JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao,
		botao1, botao2, botao3, botao4, botao5, botao6, botao7,
		botao8, botao9, botao0, botaoIgual, botaoLimpar;
	JTextField textoResultado;
	Calculadora calculadora;
	
	// Método Construtor
	public CalculadoraGrid(Calculadora c)
{
		//recebe o objeto calculadora que fará os cálculos
		calculadora = c;
		Container caixa = getContentPane();
		//cria um layout com 5 linhas e 1 coluna
		//a primeira fica com o mostrador da calculadora
		//a mais com cada linha de botões
		caixa.setLayout(new GridLayout(5,1));
		//isso é necessário para criar 5 linhas de igual tamanho
		//se dividir em duas células, uma para o mostrador, outra
		//para os botões, o mostrador fica enorme
		//se usarmos só um painel 5x5, o mostrador fica do tamanho
		//de um botão
		JPanel linha1 = new JPanel();
		linha1.setLayout(new GridLayout(1,1,2,2));
		JPanel linha2 = new JPanel();
		linha2.setLayout(new GridLayout(1,4,2,2));
		JPanel linha3 = new JPanel();
		linha3.setLayout(new GridLayout(1,4,2,2));
		JPanel linha4 = new JPanel();
		linha4.setLayout(new GridLayout(1,4,2,2));
		JPanel linha5 = new JPanel();
		linha5.setLayout(new GridLayout(1,4,2,2));
		
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
		//inclui o texto no container de cima
		linha1.add(textoResultado);
		//inclui o resto no container de baixo
		linha2.add(botao7);
		linha2.add(botao8);
		linha2.add(botao9);
		linha2.add(botaoSoma);
		linha3.add(botao4);
		linha3.add(botao5);
		linha3.add(botao6);
		linha3.add(botaoSubtracao);
		linha4.add(botao1);
		linha4.add(botao2);
		linha4.add(botao3);
		linha4.add(botaoMultiplicacao);
		linha5.add(botao0);
		linha5.add(botaoLimpar);
		linha5.add(botaoIgual);
		linha5.add(botaoDivisao);
		//agora inclui o conteiner de cima e de baixo
		//no conteiner principal
		caixa.add(linha1);
		caixa.add(linha2);
		caixa.add(linha3);
		caixa.add(linha4);
		caixa.add(linha5);
		
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
		setSize(350,240);
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

