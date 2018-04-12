import javax.swing.JOptionPane;
public class AppNote2{
      public static void main(String args[]){
      NotePad note = new NotePad();

      int index = 0;
      int i;
      
      do{
         index = Integer.parseInt(JOptionPane.showInputDialog("******* MENU *******" + "\n\n"
         + "1 - Insert a note" + "\n" + "2 - Remove a note" + "\n" + "3 - Modify a note" + "\n"
         + "4 - List all Notes" + "\n" + "5 - Quit" + "\n\n" + "**********************"));
         
         switch(index){
            case 1: 
               note.insertNote(JOptionPane.showInputDialog("Write a note: "));
               break;
               
            case 2:
               note.removeNote(Integer.parseInt(JOptionPane.showInputDialog("Type the note what should be removed: " )));
              
               break;
            
            case 3:
               i = Integer.parseInt(JOptionPane.showInputDialog("Type the note what you want to modify: "));
               note.modifyNote(i, JOptionPane.showInputDialog("Note number: " + note.getNote(i)));
               break;      
         
            case 4:
               JOptionPane.showMessageDialog(null, note.printNotes());
               break;
               
            default: 
               JOptionPane.showMessageDialog(null, "Type a valid option!");
               break;   
         }
      } while(index != 5);
   }
}

// mandar para andreia ate domingo: prof.andreiamachion@usjt.br
// assunto exercicio aula 07
// nome completo e RA
// anexar os arquivos .java