import java.util.*;

public class Messreihe
{
   private ArrayList<Messung> messwerte;
   
   public Messreihe()
   {
       messwerte = new ArrayList<Messung>();
   }
   
   public void hinzufuegen(Messung m)
   {
       messwerte.add(m);
   }
   
   public void vieleWerteHinzufuegen(ArrayList<Messung> liste)
   {
       messwerte.addAll(liste);
    }
   
   public double max()
   {
       double max = messwerte.get(0).getWert();
       for (Messung m : messwerte)
       {
           if (m.getWert() > max)
           {
               max = m.getWert();
            }
        }
        return max;
    }

   
}
