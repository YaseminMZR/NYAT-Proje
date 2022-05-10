package AkýllýCihaz;


import java.util.Random;

public class CelciusSicaklikAlgilayici implements ISicaklikAlgilayici {
	
	public String tip = "Celcius";
	public int maksimumDeger = 30;
	public int minimumDeger = 0;
	private double value = 0;
	
	public CelciusSicaklikAlgilayici(String tip, int min,int max) throws InterruptedException {
		
		this.minimumDeger = min;
		this.maksimumDeger = max;
		this.tip = tip;
		value =20;
	}
	

    @Override
    public double degerGetir(){
        return value;
    }
	
	
    @Override
    public void sicaklikOlc() throws InterruptedException {
    	algila();
        Random rnd = new Random();
        value = minimumDeger + (maksimumDeger - minimumDeger) * rnd.nextDouble();
        
    }
	
    @Override
    public void algila() throws InterruptedException {
        System.out.println("Sicaklik olculuyor.");
        Arac.bekle(500);
        System.out.println("Sicaklik olculuyor..");
        Arac.bekle(500);
        System.out.println("Sicaklik olculuyor...");
        Arac.bekle(500);
    }

    
    


}
