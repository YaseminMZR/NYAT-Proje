package Ak�ll�Cihaz;

public class Arac {
	

    public static void bekle(int sure){
        try
        {
            Thread.sleep(sure);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
