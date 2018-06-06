public class TernarioEncadeado {
	public static void main (String args[]) {
		int a = 6;
		System.out.println (a<3?"menor que 3":
		                    a<6?"entre 3 e 6":
							a<9?"entre 6 e 9": "maior que 9");
		
	}
}