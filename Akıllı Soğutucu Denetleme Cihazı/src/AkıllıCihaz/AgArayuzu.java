package Ak�ll�Cihaz;

public class AgArayuzu implements IAgArayuzu{

	
	@Override
	public void GirisMesaji() {
		
        System.out.println("\n <<AKILLI SO�UTUCU DENETLEME C�HAZI>>");
        System.out.println("Ho�geldiniz...");		
		
	}

	@Override
	public void Giris() {
	      System.out.println("Do�rulama ba�ar�l�. Giri� yap�lana kadar l�tfen bekleyiniz.");
	      System.out.println("L�tfen Bekleyiniz.");
	      Arac.bekle(500);
	      System.out.println("L�tfen Bekleyiniz..");
	      Arac.bekle(500);
	      System.out.println("L�tfen Bekleyiniz...");
	      System.out.println("Giri� Ba�ar�l�.");
		
	}

	@Override
	public void CikisYap() {
		
        System.out.println("Cikis Yapiliyor.");
        Arac.bekle(500);
        System.out.println("Cikis Yapiliyor..");
        Arac.bekle(500);
        System.out.println("Cikis Yapiliyor...");
        System.out.println("��k�� Yap�ld�.");
	}

	@Override
	public void anaMenuyuGoster() {
		
		System.out.println("**********************************************");
		System.out.println("Ana Menu");
		System.out.println("1-So�utucuyu A�ma");
		System.out.println("2-So�utucuyu Kapatma");
		System.out.println("3-S�cakl�k G�sterme");
		System.out.println("4-Cihaz OtoKontrol� ");
		System.out.println("5-��k��");
		System.out.println("**********************************************");
	}

	@Override
	public void MesajGoruntule(String mesaj) {
		
		System.out.println(mesaj);
		
	}

	@Override
	public void hataliGirisMesaji() {
		System.out.println("B�yle Bir Kullan�c� Bulunmamaktad�r.");
		System.out.println("L�tfen Tekrar Deneyiniz");
		
		
	}
	

		
	
	
	

}
