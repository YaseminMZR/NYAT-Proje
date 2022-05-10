package AkýllýCihaz;

import java.sql.SQLException;

public class AnaIslemPlatformu  {
	

    public static void main(String[] args) throws SQLException, InterruptedException {
        AkilliCihaz akilliCihaz = new AkilliCihaz(
                new AgArayuzu(),
                AlgilayiciFactory.algilayiciOlustur("Celcius", 0, 30),
                AlgilayiciFactory.algilayiciOlustur("Fahrenheit",32,30*(9/5)+32),
                new Eyleyici(),
                new Observer(),
                new PostgreSQLSunucu());
        

        akilliCihaz.basla();
    }


	

}
	
	

