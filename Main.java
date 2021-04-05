
public class Main
{
    
    public static void main(String[] args)
    {
        Messstation station = new Messstation();
        
        station.infosAusgeben();
        // Alle Werte anzeigen
        station.aktuelleWerteAusgeben();
        station.auswertungenAusgeben();
        station.messreiheAusgeben();
    }
}
