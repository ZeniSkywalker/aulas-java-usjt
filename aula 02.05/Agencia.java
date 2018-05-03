import javax.swing.JOptionPane;
public class Agencia {
	private double saldo;
	public static void main(String args[]) {
		ContaCorrente cc = new ContaCorrente();
		cc.setNumero(98);
		System.out.println(cc);
		double c1 = 2.8;
		cc.depositar(c1);
		cc.imprimeSaldo();
	}
}
