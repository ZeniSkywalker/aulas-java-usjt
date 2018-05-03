import javax.swing.JOptionPane;
public class TestRelation {
   public static void main(String args[]){
      String teacherName = JOptionPane.showInputDialog ("Type teacher's name: ");
      int teacherAge = Integer.parseInt(JOptionPane.showInputDialog ("Type teacher's age: "));
      String disciplineName = JOptionPane.showInputDialog ("Type discipline name: ");
      boolean disciplinePratice = Boolean.parseBoolean(JOptionPane.showInputDialog ("This is a pratical discipline? (true | false):  "));
      
      Teacher teacher = new Teacher(teacherName, teacherAge);
      Discipline discipline = new Discipline(disciplineName, disciplinePratice);
      Relation relation = new Relation(teacher, discipline);
      
      
      System.out.println ("Relation:\n" + relation.getData());

   }

}
