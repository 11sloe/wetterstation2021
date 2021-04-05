import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.*;

import org.json.*;

/**
 * Regelt den Zugriff auf die OpenSenseMap
 */
public class OpenSenseMap implements SenseMap
{
    private JSONObject boxDaten;
    private String senseBoxId = "5d8de1a95f3de0001a86f3fb";
    private String API_URL = "https://api.opensensemap.org/";
    
    public OpenSenseMap()
    {
        boxDaten = holeSenseBoxDaten();
    }
    
    public String nameEinlesen()
    {
        return boxDaten.getString("name");
    }
    
    public ArrayList<Sensor> sensorenEinlesen()
    {
        JSONArray sensorenJSON = boxDaten.getJSONArray("sensors");
        ArrayList<Sensor> liste = new ArrayList<Sensor>();

        for (int i = 0; i < sensorenJSON.length(); i++)
        {
            
            JSONObject sensorJSON = sensorenJSON.getJSONObject(i);
            String title = sensorJSON.getString("title");
            String id = sensorJSON.getString("_id");
            String einheit = sensorJSON.getString("unit");
            Sensor sensor = new Sensor(id, title, einheit);
            liste.add(sensor);
        }
        return liste;
    }
    
    public Messung getAktMessung(String sensorId)
    {
        String sensorInfos = get("/boxes/" + senseBoxId+ "/sensors/" + sensorId);
        JSONObject infosJSON = new JSONObject(sensorInfos);
        JSONObject letzteMessungJSON = infosJSON.getJSONObject("lastMeasurement");
        String wertS = letzteMessungJSON.getString("value");
        double wert = Double.parseDouble(wertS);
        String erzeugtAm = letzteMessungJSON.getString("createdAt");
        Messung messung = new Messung(wert,erzeugtAm);
        return messung;
    }
    
    public ArrayList<Messung> getVieleMessungen(String sensorId)
    {
        ArrayList<Messung> liste = new ArrayList<Messung>();
        String messungen = get("/boxes/" + senseBoxId + "/data/" + sensorId);
        JSONArray messungenJSON = new JSONArray(messungen);
        
        for (int i = 0; i < messungenJSON.length(); i++)
        {
            JSONObject messungJSON = messungenJSON.getJSONObject(i);
            Double wert = Double.parseDouble(messungJSON.getString("value"));
            String erzeugtAm = messungJSON.getString("createdAt");
            Messung messung = new Messung(wert,erzeugtAm);
            liste.add(messung);
        }
        return liste;
    }
    
    private JSONObject holeSenseBoxDaten()
    {
        String senseBoxDatenJsonString = get("/boxes/"+senseBoxId);
        JSONObject daten = null;
        if (senseBoxDatenJsonString != null) 
        {
            daten = new JSONObject(senseBoxDatenJsonString);
        }
        return daten;
    }
        
    
    private String get(String anfrage)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL + anfrage))
            .GET() 
            .build();
        HttpResponse<String> response;    
        try{
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response.body();
            }
        catch(Exception e)
        {
            System.out.println("Anfrage fehlgeschlagen");
            return null;
        }
        
    }
    
   
    
}
