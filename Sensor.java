
public class Sensor
{
    private String id;
    
    private String sensortyp;
    private String titel;
    private String einheit;

    public Sensor(String id_, String titel_, String einheit_)
    {
        id = id_;
        titel = titel_;
        einheit = einheit_;
    }
    
    public void ausgeben()
    {
        System.out.println(titel + " ( " + einheit + " )"); 
    }
    
    public String getId()
    {
        return id;
    }
    
    
}
