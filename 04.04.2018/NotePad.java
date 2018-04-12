import java.util.ArrayList;
public class NotePad{
   private ArrayList<String> notes;
   
   public NotePad(){
      notes = new ArrayList<String>();
   }
   
   public void insertNote(String notes){
      this.notes.add(notes);
   }
   
   public void removeNote(int i){
      this.notes.remove(i);
   }
   
   public String getNote(int i){
      return notes.get(i);
   
   }
   
   public void modifyNote(int i, String note){
     this.notes.set(i, note);
   }
   
   public String printNotes(){
     String text = "";
     for(int i = 0; i < notes.size(); i++){
         text += getNote(i) + "\n";
      }
     
     return text;
   }
}