import java.util.*;


/*
 * Klasse die die Anbindung an die OpenSenseMap simuliert
 */

public class SenseMapSimulation implements SenseMap
{
    String name = "BoxSimulation";
    
    // Werte der Box:
    double aktTemp = 13.0;
    double aktLuftdruck = 1013;
    double aktLuftfeuchte = 0.5;
    
    
    
    public String nameEinlesen()
    {
        return name;
    }
    
    public ArrayList<Sensor> sensorenEinlesen()
    {
        
        ArrayList<Sensor> liste = new ArrayList<Sensor>();

        Sensor s1 = new Sensor("1","Temperatur", "°C");
        Sensor s2 = new Sensor("2","Luftdruck" ,"hPa");
        Sensor s3 = new Sensor("3", "Luftfeuchte", "%");
        liste.add(s1);
        liste.add(s2);
        liste.add(s3);
        return liste;
    }
    
    public Messung getAktMessung(String sensorId)
    {
        double wert;
        if (sensorId.equals("1")) // Temperatur
        {
            wert = aktTemp;
        }
        else if (sensorId.equals("2")) // Luftdruck
        {
            wert = aktLuftdruck;
        }
        else //Luftfeuchte
        {
            wert = aktLuftfeuchte;
        }
        String erzeugtAm = "2021-04-03";
        
        Messung messung = new Messung(wert,erzeugtAm);
        return messung;
    }
    public ArrayList<Messung> getVieleMessungen(String sensorId)
    {
        return new ArrayList<Messung>();
    }
    
}
