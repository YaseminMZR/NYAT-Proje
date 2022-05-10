package AkýllýCihaz;

public class AlgilayiciFactory {
	
    public static ISicaklikAlgilayici algilayiciOlustur(String tip, int min, int max) throws InterruptedException{
        
        ISicaklikAlgilayici algilayici = null;
        if(tip.equals("Fahrenheit")){
            algilayici = new FahrenheitSicaklikAlgilayici(tip,min,max);
        }
        else if(tip.equals("Celcius")){
            algilayici = new CelciusSicaklikAlgilayici(tip,min,max);
        }
        
        return algilayici;
    }

}
