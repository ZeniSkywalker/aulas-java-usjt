package ppint.grid;
import javax.swing.JFrame;

import ppint.calculadora.Calculadora;

public class TesteCalculadoraGrid {
	
	public static void main(String args[])
{
		Calculadora calculadora = new Calculadora();
		CalculadoraGrid tela = new CalculadoraGrid(calculadora);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // Fecha o método main()
}
