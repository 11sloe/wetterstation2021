
import java.util.ArrayList;

/**
 * Die Klasse beschreibt eine Messstation
 * 
 * @author sloe
 * @version 1.0
 */
public class Messstation
{

    private String name;
    private SenseMap map;  

    private ArrayList<Messreihe> messreihen;


    public Messstation(String senseBoxId)
    {
        if (senseBoxId.equals("sim"))
        {
            map = new SenseMapSimulation();
        }
        else
        {
            map = new OpenSenseMap(senseBoxId);
        }

        // Daten Einlesen
        basisinfosAusSenseMapEinlesen();
        messreihenEinlesen();
        aktuelleMesswerteEinlesen();   

    }

    public void aktuelleMesswerteEinlesen()
    {     
        for (Messreihe s: messreihen)
        {
            Messung m = map.getAktMessung(s.getSensorId());
            s.eineMessungHinzufuegen(m);
        }        
    }

    private void messreihenEinlesen()
    {
        for (Messreihe s:messreihen)
        {
            s.messungenHinzufuegen(map.getVieleMessungen(s.getSensorId()));
        }
    }

    private void basisinfosAusSenseMapEinlesen()
    {
        name = map.nameEinlesen();        
        messreihen = map.sensorenEinlesen();
    }

    public void infosAusgeben()
    {
        System.out.println("********************************");
        System.out.println("Sensebox: " + name);
        System.out.println("Sensoren: " );
        for (Messreihe s:messreihen)
        {
            System.out.println(" - " + s.toString());
        }
        System.out.println("********************************");
        System.out.println();
    }

    public void aktuelleWerteAusgeben()
    {
        System.out.println("----- Aktuelle Werte ------");
        for (Messreihe r : messreihen)
        {
            System.out.println(r.getTitel() + " \t" + r.getAktWert());
        }
        System.out.println("---------------------------");      
        System.out.println();
    }

    public void auswertungenAusgeben()
    {
        System.out.println("------- Auswertungen -------");
        for(Messreihe r: messreihen)
        {
            System.out.println(r.getTitel());                  
            System.out.println( "Max: " + r.getMaxWert());
            System.out.println( "Min: " + r.getMinWert());
            System.out.println();

        }
        System.out.println("---------------------------");       
        System.out.println();
    }

}
    
