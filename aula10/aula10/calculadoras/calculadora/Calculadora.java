package ppint.calculadora;
//A calculadora só faz operações com inteiros
public class Calculadora
{
	public long operando1, operando2;
	public char operacao;
	//indica se deve realizar a operação ou esperar o próximo número
	boolean inicioOperacao;
	//decide se concatena ou substitui o número do mostrador
	//serve para evitar a digitação de vários zeros à esquerda
	boolean meioDigitacao;
	
	public Calculadora(){
		operando1 = 0;
		operando2 = 0;
		operacao = ' ';
		inicioOperacao = true;
		meioDigitacao = false;
	}
	
	public String concatena(String c1, String c2){
		if(meioDigitacao){
			if(c1.equals("0"))
				return c2;
			return c1+c2;
		}
		else {
			meioDigitacao = true;
			return c2;
		}
	}
	
	public String limpa(){
		operando1 = 0;
		operando2 = 0;
		operacao = ' ';
		meioDigitacao = false;
		inicioOperacao = true;
		return "0";
	}
	
	public String igual(String v){
		meioDigitacao = false;
		long resultado = 0L;
		if(!inicioOperacao){
			operando2 = Long.parseLong(v);
			if(operacao == '+')
				resultado = operando1 + operando2;
	 	   else if(operacao == '-')
				resultado = operando1 - operando2;
			else if(operacao == '*')
				resultado = operando1 * operando2;
			else if(operacao == '/')
				resultado = operando1 / operando2;
			operando1 = 0;
			operando2 = 0;
			operacao = ' ';
			inicioOperacao = true;
			return ""+resultado;
		}
		else
			return v;
	}
	
	public String soma(String v){
		meioDigitacao = false;
		if(inicioOperacao){
			operacao = '+';
			operando1 = Long.parseLong(v);
			inicioOperacao = false;
			return v;
		}
		else {
			//simula um igual
			long resultado = Long.parseLong(igual(v));
			//mas nao reinicia a operacao
			inicioOperacao = false;
			operando1 = resultado;
			operando2 = 0;
			operacao = '+';
			return ""+resultado;
		}
	}	
	
	public String subtracao(String v){
		meioDigitacao = false;
		if(inicioOperacao){
			operacao = '-';
			operando1 = Long.parseLong(v);
			inicioOperacao = false;
			return v;
		}
		else {
			long resultado = Long.parseLong(igual(v));
			inicioOperacao = false;
			operando1 = resultado;
			operando2 = 0;
			operacao = '-';
			return ""+resultado;
		}
	}
	
	//divisão por inteiro; trunca o resultado
	public String divisao(String v){
		meioDigitacao = false;
		if(inicioOperacao){
			operacao = '/';
			operando1 = Long.parseLong(v);
			inicioOperacao = false;
			return v;
		}
		else {
			long resultado = Long.parseLong(igual(v));
			inicioOperacao = false;
			operando1 = resultado;
			operando2 = 0;
			operacao = '/';
			return ""+resultado;
		}
	}

	public String multiplicacao(String v){
		meioDigitacao = false;
		if(inicioOperacao){
			operacao = '*';
			operando1 = Long.parseLong(v);
			inicioOperacao = false;
			return v;
		}
		else {
			long resultado = Long.parseLong(igual(v));
			inicioOperacao = false;
			operando1 = resultado;
			operando2 = 0;
			operacao = '*';
			return ""+resultado;
		}
	}
} 