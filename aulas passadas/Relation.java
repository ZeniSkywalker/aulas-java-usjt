public class Relation{
   private Teacher teacher;
   private Discipline discipline;
   
   public Relation(Teacher teacher, Discipline discipline){
      this.setTeacher(teacher);
      this.setDiscipline(discipline);   
   }
   
   
   public String getData(){
      return "Relation: [ Teacher: " +teacher.getData() + ", Discipline: " + discipline.getData() + "]";     
   }
   
    public void setTeacher(Teacher teacher){
      this.teacher = teacher;
   }
   
   public void setDiscipline(Discipline discipline){
      this.discipline = discipline;
   }

}