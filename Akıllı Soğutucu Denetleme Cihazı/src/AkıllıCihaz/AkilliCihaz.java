package AkýllýCihaz;

import java.sql.SQLException;
import java.util.Scanner;

public class AkilliCihaz extends AlgilayiciFactory {
	
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final IObserver izleyici;
    private final ISicaklikAlgilayici Celciusalgilayici;
    private final ISicaklikAlgilayici Fahrenheitalgilayici;
    private final IVeriTabaniSunucu veritabaniSunucu;

    private final VeriTabaniIslemleri veritabaniIslemleri;
    
    
    
    public AkilliCihaz(IAgArayuzu agArayuzu, ISicaklikAlgilayici Celciusalgilayici,ISicaklikAlgilayici Fahrenheitalgilayici, IEyleyici eyleyici,IObserver izleyici, IVeriTabaniSunucu veritabaniSunucu){
        this.agArayuzu = agArayuzu;
        this.Celciusalgilayici = Celciusalgilayici;
        this.Fahrenheitalgilayici =Fahrenheitalgilayici;
        this.eyleyici = eyleyici;
        this.izleyici = izleyici;
        this.veritabaniSunucu = veritabaniSunucu;
        veritabaniIslemleri = new VeriTabaniIslemleri(veritabaniSunucu);
        eyleyici.addObserver(izleyici);
    }
    
    public void basla()  throws InterruptedException, SQLException{
    	
        agArayuzu.GirisMesaji();
        Scanner input = new Scanner(System.in);
        
        boolean dogrulama = false;
        do {
        	agArayuzu.MesajGoruntule("Kullanýcý Adýnýzý Giriniz : ");
        	String kullaniciAdi = input.nextLine();
        	veritabaniIslemleri.BaglantiKur();
        	if(veritabaniIslemleri.KullaniciKontrol(kullaniciAdi)) {
	        	agArayuzu.MesajGoruntule("Sifre Giriniz : ");
	 	        String kullaniciSifre = input.nextLine(); 
	 	        if(veritabaniIslemleri.GirisKontrol(kullaniciAdi,kullaniciSifre)){
	 	        	  if(veritabaniIslemleri.YetkiKontrol(kullaniciAdi,kullaniciSifre)){
	 	        		  dogrulama = true;
	 	        		  agArayuzu.Giris();
	 	        	  }
	 	        	  else {
	 	  		  
	 	        		  agArayuzu.MesajGoruntule("Yetkisiz Kullanýcý Giriþi!");
		 	        		 veritabaniIslemleri.BaglantiSonlandir();
		 	        		 agArayuzu.CikisYap();
		 	        		 return;
	 	        	  } 	        		  
	 	        }		  
	 	        else
	 	        	agArayuzu.MesajGoruntule("Girdiðiniz þifre hatalýdýr.");
        	}
        	else
        		agArayuzu.MesajGoruntule("Lütfen doðru bir kullanýcý adý giriniz.");
        
        }while(!dogrulama);
        
        boolean flag = true;
        while(flag){
        		
  
        	agArayuzu.anaMenuyuGoster();
        	agArayuzu.MesajGoruntule("Lütfen yapmak istediðiniz iþlemi seçiniz : ");
        	int secim = input.nextInt();
        	 switch (secim) {

             case 1:
            	 IIslem islem1 = new SogutucuyuAcma(agArayuzu,eyleyici);
            	 islem1.IslemYap();
                 
                 break;
             case 2:
            	 IIslem islem2 = new SogutucuyuKapatma(agArayuzu,eyleyici);
            	 islem2.IslemYap();
            	 
              
                 break;
             case 3:
             	agArayuzu.MesajGoruntule("Lütfen kullanmak istediðiniz algýlayýcý tipini seçiniz.");
            	agArayuzu.MesajGoruntule("1-Celcius");
            	agArayuzu.MesajGoruntule("2-Fahrenheit");
            	int tip = input.nextInt();
            	if(tip ==1) {
            		agArayuzu.MesajGoruntule("Sýcaklýk deðeri celcius olarak gösterilecektir.");
                	IIslem islem3Celcius = new SicaklikGosterme(agArayuzu, Celciusalgilayici);
                	islem3Celcius.IslemYap();
                	
            	}
            	else if(tip==2) {
            		agArayuzu.MesajGoruntule("Sýcaklýk deðeri fahrenheit olarak gösterilecektir.");
                	IIslem islem3Fahrenheit = new SicaklikGosterme(agArayuzu,Fahrenheitalgilayici);
                	islem3Fahrenheit.IslemYap();
            	}
            	else {
            		agArayuzu.MesajGoruntule("Yanlýþ bir deðer girdiniz. Varsayýlan olarak Celcius Algýlayýcý seçildi.");
                	IIslem islem3Varsayilan = new SicaklikGosterme(agArayuzu,Celciusalgilayici);
                	islem3Varsayilan.IslemYap();
            	}

            		 
                 break;
             case 4:
            	 double sicaklik ;
            	 sicaklik = Celciusalgilayici.degerGetir();
            	 eyleyici.CihazOtoKontrol(sicaklik);
             	break;
             case 5:
             	 veritabaniIslemleri.BaglantiSonlandir();
            	 agArayuzu.CikisYap();
            	 flag = false;
                  
                  break;
  
             default:
                 System.out.println("Lütfen geçerli bir sayý giriniz.");
            	
        	 }
        }

    }
}
