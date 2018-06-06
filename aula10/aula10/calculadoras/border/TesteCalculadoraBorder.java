package exercicio.border;
import javax.swing.JFrame;

import exercicio.calculadora.Calculadora;

public class TesteCalculadoraBorder {
	
	public static void main(String args[]){
		Calculadora calculadora = new Calculadora();
		CalculadoraBorder tela = new CalculadoraBorder(calculadora);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // Fecha o método main()
}

