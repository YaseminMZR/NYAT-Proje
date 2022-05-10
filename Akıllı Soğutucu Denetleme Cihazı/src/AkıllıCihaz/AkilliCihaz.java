package Ak�ll�Cihaz;

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
        	agArayuzu.MesajGoruntule("Kullan�c� Ad�n�z� Giriniz : ");
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
	 	  		  
	 	        		  agArayuzu.MesajGoruntule("Yetkisiz Kullan�c� Giri�i!");
		 	        		 veritabaniIslemleri.BaglantiSonlandir();
		 	        		 agArayuzu.CikisYap();
		 	        		 return;
	 	        	  } 	        		  
	 	        }		  
	 	        else
	 	        	agArayuzu.MesajGoruntule("Girdi�iniz �ifre hatal�d�r.");
        	}
        	else
        		agArayuzu.MesajGoruntule("L�tfen do�ru bir kullan�c� ad� giriniz.");
        
        }while(!dogrulama);
        
        boolean flag = true;
        while(flag){
        		
  
        	agArayuzu.anaMenuyuGoster();
        	agArayuzu.MesajGoruntule("L�tfen yapmak istedi�iniz i�lemi se�iniz : ");
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
             	agArayuzu.MesajGoruntule("L�tfen kullanmak istedi�iniz alg�lay�c� tipini se�iniz.");
            	agArayuzu.MesajGoruntule("1-Celcius");
            	agArayuzu.MesajGoruntule("2-Fahrenheit");
            	int tip = input.nextInt();
            	if(tip ==1) {
            		agArayuzu.MesajGoruntule("S�cakl�k de�eri celcius olarak g�sterilecektir.");
                	IIslem islem3Celcius = new SicaklikGosterme(agArayuzu, Celciusalgilayici);
                	islem3Celcius.IslemYap();
                	
            	}
            	else if(tip==2) {
            		agArayuzu.MesajGoruntule("S�cakl�k de�eri fahrenheit olarak g�sterilecektir.");
                	IIslem islem3Fahrenheit = new SicaklikGosterme(agArayuzu,Fahrenheitalgilayici);
                	islem3Fahrenheit.IslemYap();
            	}
            	else {
            		agArayuzu.MesajGoruntule("Yanl�� bir de�er girdiniz. Varsay�lan olarak Celcius Alg�lay�c� se�ildi.");
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
                 System.out.println("L�tfen ge�erli bir say� giriniz.");
            	
        	 }
        }

    }
}
