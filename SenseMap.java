import java.util.*;

public interface SenseMap
{
    public String nameEinlesen();
    public ArrayList<Sensor> sensorenEinlesen();
    public Messung getAktMessung(String sensorId);
    public ArrayList<Messung> getVieleMessungen(String sensorId);
    
}
