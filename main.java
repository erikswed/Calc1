/**
 * Du ska göra en miniräknare.
 * Den ska kunna utföra de 4 räknesätten.
 * Det ska vara en klass där du bryter ut så mycket som möjligt till medlemsmetoder.
 * Den ska innehålla ett minne där den senaste operationen finns lagrad. Talen som ska beräknas ska lagras i en flyttalsvektor.
 * Programkörningsexempel:
 * Vad vill du göra?
 * 1:Addera
 * 2:Subtrahera
 * 3.Multiplicera
 * 4:Dividera
 * 5: Avslute
 * Ange ditt val:1
 * Ange tal 1: 23
 * Ange tal 2: 6.5
 * Resultat: 29,50
 * Vad vill du göra?
 * 1:Addera
 * 2:Subtrahera
 * 3.Multiplicera
 * 4:Dividera
 * 5: Avslute
 * Ange ditt val:8
 * Inget giltigt val försök igen!
 * Vad vill du göra?
 * 1:Addera
 * 2:Subtrahera
 * 3.Multiplicera
 * 4:Dividera
 * 5: Avslute
 * Ange ditt val:5
 */
import java.util.Scanner;
import java.util.*;
public class Main {
   
   /**
   * Detta representerar värdena för en operation, alltså två tal som har använts i en operation. 
   */
   private static class Talen{
       public double num1;
       public double num2;
       
       public Talen(double num1, double num2){
           this.num1 = num1;
           this.num2 = num2;
       }
   }
   // Den ska innehålla ett minne där den senaste operationen finns lagrad som denna
   public static List<Double> kommaIhåg = new ArrayList<Double>();
   // Talen som ska beräknas ska lagras i en flyttalsvektor som denna.
   public static List<Talen> sparadeTalListan = new ArrayList<Talen>();

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       boolean forts = true;
       while (forts == true) {
           double[] tal = new double[2];
           System.out.println("Vad vill du göra? \n1.Addera\n2.Subtrahera\n3.Multiplicera\n4.Dividera\n5. Avsluta");
           int val = scan.nextInt();
           Double result;
           switch (val) {
               case 1:
                   mataInTvå(tal);
                   result = addera(tal);
                   System.out.println("Summan är: " + result);
                   savekommaIhåg(result);
                   break;
               case 2:
                   mataInTvå(tal);
                   result = subtrahera(tal);
                   System.out.println("Differensen är: " + result);
                   savekommaIhåg(result);
                   break;
               case 3:
                   mataInTvå(tal);
                   result = multiplicera(tal);
                   System.out.println("Produkten är: " + result);
                   savekommaIhåg(result);
                   break;
               case 4:
                   mataInTvå(tal);
                   result = dividera(tal);
                   System.out.println("Kvoten är: " + result);
                   savekommaIhåg(result);
                   break;
               case 5:
                   //avsluta
                   forts = false;
                   break;
               default:
                   System.out.println("Felinmatning");
           }
           for(Double item : kommaIhåg) {
             System.out.println("Printar minne: " + item);
           }
       }
   }
   
   public static double[] mataInTvå(double[] val) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Ange tal 1: ");
       val[0] = scan.nextDouble();
       System.out.println("Ange tal 2: ");
       val[1] = scan.nextDouble();   
       sparadeTalListan.add(new Talen(val[0], val[1]));
       return val;
   }
   
   public static void savekommaIhåg(Double val){
       kommaIhåg.add(val);
   }

   public static double addera (double []t){
      return t[0] + t[1];
   }
   
   public static double subtrahera(double []t){
      return t[0] - t[1];
   }
   
   public static double multiplicera (double []t){
      return t[0] * t[1];
   }
   
   public static double dividera (double []t){
          return t[0] / t[1];
   }
}
