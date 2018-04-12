import javax.swing.JOptionPane;
public class TestTeacher {
   public static void main (String args[]) {
      String name = JOptionPane.showInputDialog ("Type teacher's name: ");
      int age = Integer.parseInt(JOptionPane.showInputDialog ("Type teacher's age: "));
     
     Teacher teacher1 = new Teacher(name, age);
          
     name = JOptionPane.showInputDialog ("Type teacher's name: ");
     age = Integer.parseInt(JOptionPane.showInputDialog ("Type teacher's age: "));
         
     Teacher teacher2 = new Teacher(name, age);
     
     System.out.println ("First teacher:\n" + teacher1.getData() +
     "\n" + "\nSecond teacher:\n" + teacher2.getData());

   }
}