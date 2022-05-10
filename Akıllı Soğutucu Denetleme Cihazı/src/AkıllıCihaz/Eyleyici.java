package AkýllýCihaz;

public class Eyleyici extends CihazOtoKontrol implements IEyleyici {

	boolean sogutucuAcik ;
	boolean sogutucuKapali;
	
	public Eyleyici() {
		this.sogutucuAcik = false;
		this.sogutucuKapali = true;
	}
	
	@Override
	public void sogutucuAc() {
		
		if(sogutucuKapali) {
			System.out.println("Lütfen Bekleyiniz...");
			Arac.bekle(3000);
			System.out.println("Soðutucu açýlýyor.");
			Arac.bekle(500);
			System.out.println("Soðutucu açýlýyor..");
			Arac.bekle(500);
			System.out.println("Soðutucu açýlýyor...");
			System.out.println("Soðutucu baþarýyla açýldý...");
			sogutucuAcik = true;
			sogutucuKapali = false;
		}
		else
			System.out.println("Soðutucu zaten açýk durumdadýr.");
		
	}

	@Override
	public void sogutucuKapat() {
		if(sogutucuAcik) {
			System.out.println("Lütfen Bekleyiniz...");
			Arac.bekle(3000);
			System.out.println("Soðutucu kapatýlýyor.");
			Arac.bekle(500);
			System.out.println("Soðutucu kapatýlýyor..");
			Arac.bekle(500);
			System.out.println("Soðutucu kapatýlýyor...");
			System.out.println("Soðutucu baþarýyla kapatýldý...");
			sogutucuAcik = false;
			sogutucuKapali= true;
		}
		else
			System.out.println("Soðutucu zaten kapalý durumdadýr.");
	 	
	}
	
	public void CihazOtoKontrol(double sicaklik) {
		
		if(sicaklik>=25) {
			YuksekSicaklikBilgilendirme();
			sogutucuAc();
		}
		else if(sicaklik>8 && sicaklik<25) {
			DengeDurumuBilgilendirme();
		}	
		else {
			DusukSicaklikBilgilendirme();
			sogutucuKapat();
		}
		
		
	}



}
