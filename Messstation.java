
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
    
    private ArrayList<Sensor> sensoren;
    
    private Sensor temperaturSensor;
    private Sensor luftfeuchteSensor;
    private Sensor luftdruckSensor;
    
    private Messung aktTemp;
    private Messung aktLuftfeuchte;
    private Messung aktLuftdruck;
    
    private Messreihe temperaturen;  
    
    private boolean simulation = true;
    

    public Messstation()
    {
        if (simulation)
        {
            map = new SenseMapSimulation();
        }
        else
        {
            map = new OpenSenseMap();
        }
    
        temperaturen = new Messreihe();
        
        // Daten Einlesen
        sensorenAusSenseMapEinlesen();
        aktuelleMesswerteEinlesen();
        messreihenEinlesen();
        
    }
    
    public void aktuelleMesswerteEinlesen()
    {     
        aktTemp = map.getAktMessung(temperaturSensor.getId());
        aktLuftfeuchte = map.getAktMessung(luftfeuchteSensor.getId());
        aktLuftdruck = map.getAktMessung(luftdruckSensor.getId());   
        
        
    }
    
    private void messreihenEinlesen()
    {
        temperaturen.vieleWerteHinzufuegen(map.getVieleMessungen(temperaturSensor.getId()));
    }
    
    private void sensorenAusSenseMapEinlesen()
    {
        name = map.nameEinlesen();        
        sensoren = map.sensorenEinlesen();
        temperaturSensor = sensoren.get(0);
        luftfeuchteSensor = sensoren.get(1);
        luftdruckSensor = sensoren.get(2);
    }
     
    public void infosAusgeben()
    {
        System.out.println("********************************");
        System.out.println("Sensebox: " + name);
        System.out.println("Sensoren: " );
        System.out.println(" - " + temperaturSensor.toString());
        System.out.println(" - " + luftfeuchteSensor.toString());
        System.out.println(" - " + luftdruckSensor.toString());
        System.out.println("********************************");
        System.out.println();
    }
    
    public void aktuelleWerteAusgeben()
    {
        System.out.println("----- Aktuelle Werte ------");
        System.out.println("Temperatur: " + aktTemp.getWert() + " " + aktTemp.getErzeugtAm());
        System.out.println("Luftfeuchte: " + aktLuftfeuchte.getWert());
        System.out.println("Luftdruck: " + aktLuftdruck.getWert());
        System.out.println("---------------------------");      
        System.out.println();
    }
    
    public void auswertungenAusgeben()
    {
        System.out.println("------- Auswertungen -------");
        System.out.println("Maximale Temperatur: " + temperaturen.max());
        System.out.println("Minimale Temperatur: " + temperaturen.min());
        System.out.println("---------------------------");       
        System.out.println();
    }
    
    public void messreiheAusgeben()
    {
        System.out.println("----- Temperaturen der letzten Zeit ------ ");
        temperaturen.ausgeben();
        System.out.println();
    }
    
    
     
}

    
    
    

