
public class ContaCorrente {
	private int digito;
	private int numero;
	private Agencia agencia;
	private double saldo;
	
	public ContaCorrente() {}
	
	public ContaCorrente(int digito, int numero, Agencia agencia, double saldo) {
		this.digito = digito;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getDigito() {
		return digito;
	}
	public void setDigito(int digito) {
		this.digito = digito;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double depositar(double deposito) {
		return saldo = saldo + deposito;
	}
	
	public double sacar(double saque){
		if(saldo <= saque) {
			System.out.println("Saque nao efetuado");
		}
		else {
			System.out.println("O valor sacado foi: " + saque);
		}
		return saldo = saldo - saque;
	}
	
	public double returnSaldo(){
		return saldo;
	}
	
	public void imprimeSaldo(){
		System.out.println("Conta Corrente: " + numero + "-" + digito + "\n");
	}
}
