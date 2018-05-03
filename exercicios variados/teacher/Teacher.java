public class Teacher{
   private String name;
   private int age;
   
   public Teacher(String name, int age){
      this.setName(name);
      this.setAge(age);
   }
   
   
   public String getData(){
      return "Name: " + name + ", Age: " + age;     
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setAge(int age){
      this.age = age;
   }
}