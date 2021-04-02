
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
    private OpenSenseMap map;  
    
    
    private Sensor temperaturSensor;
    private Sensor luftfeuchteSensor;
    private Sensor luftdruckSensor;
    
    private Messung aktTemp;
    private Messung aktLuftfeuchte;
    private Messung aktLuftdruck;
    

    public Messstation()
    {
        map = new OpenSenseMap();
        datenEinlesen();
        infosAusgeben();
    }
    
    public void messwerteAktualisieren()
    {     
        aktTemp = map.getAktMessung(temperaturSensor.getId());
        aktLuftfeuchte = map.getAktMessung(luftfeuchteSensor.getId());
        aktLuftdruck = map.getAktMessung(luftdruckSensor.getId());      
    }
    
    private void datenEinlesen()
    {
        name = map.nameEinlesen();        
        ArrayList<Sensor> sensoren = map.sensorenEinlesen();
        temperaturSensor = sensoren.get(0);
        luftfeuchteSensor = sensoren.get(1);
        luftdruckSensor = sensoren.get(2);
    }
     
    private void infosAusgeben()
    {
        System.out.println("********************************");
        System.out.println("Sensebox: " + name);
        System.out.println("Sensoren: " );
        temperaturSensor.ausgeben();
        luftfeuchteSensor.ausgeben();
        luftdruckSensor.ausgeben();
        System.out.println("********************************");
    }
    
    public void aktuelleWerteAusgeben()
    {
        System.out.println("--- Aktuelle Werte ---");
        System.out.println("Temperatur: " + aktTemp.getWert());
        System.out.println("Luftfeuchte: " + aktLuftfeuchte.getWert());
        System.out.println("Luftdruck: " + aktLuftdruck.getWert());
    }
    
     
}

    
    
    

