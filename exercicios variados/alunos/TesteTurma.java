import javax.swing.JOptionPane;
public class TesteTurma{
   public static void main (String[] args){
      String nome= JOptionPane.showInputDialog("Nome");
      String curso = JOptionPane.showInputDialog("Curso");
      int quantidadeDeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantia de alunos"));
      int serie = Integer.parseInt(JOptionPane.showInputDialog("Serie"));
      
      Turma turma = new Turma(nome, curso, quantidadeDeAlunos, serie);
      JOptionPane.showMessageDialog(null, "Nome: " + turma.getNome() + " Curso: " + turma.getCurso() + " Quantia de alunos: " + turma.getQuantidadeDeAlunos() + " Serie: "+ turma.getSerie());  
      
      turma.setQuantidadeDeAlunos(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantia de alunos: ")));
      JOptionPane.showMessageDialog(null, "Nome: " + turma.getNome() + " Curso: " + turma.getCurso() + " Quantia de alunos: " + turma.getQuantidadeDeAlunos() + " Serie: "+ turma.getSerie());
   }
}