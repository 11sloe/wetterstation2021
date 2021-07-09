
public class Main
{
    
    public static void main(String[] args)
    {
        
        //String senseBoxId = "5d8de1a95f3de0001a86f3fb"; //Karlsfeld
        //String senseBoxId = "5c23af9c919bf8001a38c30d";   // Moosach
        String senseBoxId = "60df298616d878001ba3116f";   // ITG
        //String senseBoxId = "sim"; // Simulation
        Messstation station = new Messstation(senseBoxId);
        
        Konsolenausgabe k = new Konsolenausgabe(station);
        
        k.infosAusgeben();
        // Werte anzeigen
        k.aktuelleWerteAusgeben();
        k.auswertungenAusgeben();
    }
}
