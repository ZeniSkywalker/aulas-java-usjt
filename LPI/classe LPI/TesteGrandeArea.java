import java.util.*;
public class TesteGrandeArea{
   private String grandesAreas[];
   private ArrayList<String> areas[];
      
   public TesteGrandeArea(){
      grandesAreas = new String[7];
      grandesAreas[0]= "Ciencias Exatas e da Terra";
      grandesAreas[1]= "Ciencias Biologicas";
      grandesAreas[2]= "Engenharias";
      grandesAreas[3]= "Ciencias da Saude";
      grandesAreas[4]= "Ciencias Agrarias";
      grandesAreas[5]= "Ciencias Sociais Aplicadas";
      grandesAreas[6]= "Ciencias Humanas";
      areas = new ArrayList[7];
      for(int i=0; i<7; i++)
         areas[i] = new ArrayList<String>();
      areas[0].add("Matematica");   
      areas[0].add("Probabilidade e Estatistica");
      areas[0].add("Ciencia da Computacao");
      areas[0].add("Astronomia");
      areas[0].add("Fisica");
      areas[0].add("Quimica");
      areas[0].add("Geociencias");      
      areas[0].add("Oceanografia");
      areas[1].add("Biologia Geral");   
      areas[1].add("Gen�tica");
      areas[1].add("Bot�nica");
      areas[1].add("Zoologia");
      areas[1].add("Ecologia");
      areas[1].add("Morfologia");
      areas[1].add("Fisiologia");      
      areas[1].add("Bioqu�mica");
      areas[1].add("Biof�sica");
      areas[1].add("Farmacologia");
      areas[1].add("Imunologia");
      areas[1].add("Microbiologia");      
      areas[1].add("Parasitologia");
      areas[2].add("Engenharia Civil");
      areas[2].add("Engenharia de Minas");      
      areas[2].add("Engenharia de Materiais e Metal�rgica");
      areas[2].add("Engenharia El�trica");
      areas[2].add("Engenharia Mec�nica");
      areas[2].add("Engenharia Qu�mica");
      areas[2].add("Engenharia Sanit�ria");      
      areas[2].add("Engenharia de Produ��o");
      areas[2].add("Engenharia Nuclear");      
      areas[2].add("Engenharia de Transportes");
      areas[2].add("Engenharia Naval e Oce�nica");
      areas[2].add("Engenharia Aeroespacial");      
      areas[2].add("Engenharia Biom�dica");
      areas[3].add("Medicina");
      areas[3].add("Odontologia");
      areas[3].add("Farm�cia");      
      areas[3].add("Enfermagem");
      areas[3].add("Nutri��o");      
      areas[3].add("Sa�de Coletiva");
      areas[3].add("Fonoaudiologia");
      areas[3].add("Fisioterapia e Terapia Ocupacional");      
      areas[3].add("Educa��o F�sica");
      areas[4].add("Agronomia");      
      areas[4].add("Recursos Florestais e Engenharia Florestal");  
      areas[4].add("Engenharia Agr�cola");
      areas[4].add("Zootecnia");
      areas[4].add("Medicina Veterin�ria");      
      areas[4].add("Recursos Pesqueiros e Engenharia de Pesca");
      areas[4].add("Ci�ncia e Tecnologia de Alimentos");    
      areas[5].add("Direito");      
      areas[5].add("Administra��o");
      areas[5].add("Economia");
      areas[5].add("Arquitetura e Urbanismo");      
      areas[5].add("Planejamento Urbano e Regional");
      areas[5].add("Ci�ncia da Informa��o");      
      areas[5].add("Museologia");  
      areas[5].add("Comunica��o");
      areas[5].add("Servi�o Social");
      areas[5].add("Economia Dom�stica");      
      areas[5].add("Desenho Industrial");
      areas[5].add("Filosofia");
      areas[6].add("Sociologia");      
      areas[6].add("Antropologia");
      areas[6].add("Arqueologia");
      areas[6].add("Hist�ria");      
      areas[6].add("Geografia");
      areas[6].add("Psicologia");      
      areas[6].add("Educa��o");  
      areas[6].add("Ci�ncia Pol�tica");
      areas[6].add("Teologia");
      areas[6].add("Lingu�stica");      
      areas[6].add("Letras");
      areas[6].add("Artes");   
   }

   public ArrayList<String> getAreas(int indice){
      return areas[indice];
   }

   public String getGrandesAreas(int indice){
      return grandesAreas[indice];
   }

   public static void main(String args[]){
      TesteGrandeArea ga = new TesteGrandeArea();
      for(int i=0; i<7; i++){
         System.out.println("Grande Area: " + ga.getGrandesAreas(i));
         System.out.println("Areas: " + ga.getAreas(i));
      }   
   }      
}

