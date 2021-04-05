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
    
    ArrayList<Messung> temperaturMesswerte;
    
    public SenseMapSimulation()
    {
        temperaturMesswerte = new ArrayList<Messung>();
        temperaturMesswerteErstellen();
    }
    
    
    public String nameEinlesen()
    {
        return name;
    }
    
    public ArrayList<Sensor> sensorenEinlesen()
    {
        
        ArrayList<Sensor> liste = new ArrayList<Sensor>();

        Sensor s1 = new Sensor("1","Temperatur", "°C");
        Sensor s2 = new Sensor("2","Luftfeuchte" ,"%");
        Sensor s3 = new Sensor("3", "Luftdruck", "hPa");
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
            wert = aktLuftfeuchte;
        }
        else //Luftfeuchte
        {
            wert = aktLuftdruck;
        }
        String erzeugtAm = "2021-04-03T13:00:05.238Z";
        
        Messung messung = new Messung(wert,erzeugtAm);
        return messung;
    }
    public ArrayList<Messung> getVieleMessungen(String sensorId)
    {
        return temperaturMesswerte;
    }
    
    private void temperaturMesswerteErstellen()
    {
        
        temperaturMesswerte.add(new Messung(6,"2021-04-03T08:00:05.238Z"));       
        temperaturMesswerte.add(new Messung(8,"2021-04-03T09:00:05.238Z"));
        temperaturMesswerte.add(new Messung(11,"2021-04-03T10:00:05.238Z"));
        temperaturMesswerte.add(new Messung(12,"2021-04-03T11:00:05.238Z"));
        temperaturMesswerte.add(new Messung(13,"2021-04-03T12:00:05.238Z"));
        temperaturMesswerte.add(new Messung(14,"2021-04-03T13:00:05.238Z"));
        temperaturMesswerte.add(new Messung(13,"2021-04-03T14:00:05.238Z"));
    }
}
