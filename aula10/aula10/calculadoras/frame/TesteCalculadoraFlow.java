package ppint.frame;

import javax.swing.JFrame;

import ppint.calculadora.Calculadora;


public class TesteCalculadoraFlow {
	
	public static void main(String args[])
{
		Calculadora calculadora = new Calculadora();
		CalculadoraFlow tela = new CalculadoraFlow(calculadora);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // Fecha o método main()
}