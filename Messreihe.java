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
    
    public double min()
   {
       double min = messwerte.get(0).getWert();
       for (Messung m : messwerte)
       {
           if (m.getWert() <  min)
           {
               min = m.getWert();
            }
        }
        return min;
    }
    
    public void ausgeben()
    {
        for (Messung m : messwerte)
        {
            System.out.println(m.getWert() + " \t " + m.getErzeugtAm());
        }
    }

   
}
