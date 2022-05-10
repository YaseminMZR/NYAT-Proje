package AkýllýCihaz;

import java.util.ArrayList;

public class CihazOtoKontrol {
	
	
	  ArrayList<IObserver> observer;

	    public CihazOtoKontrol(){
	        observer = new ArrayList<>();
	    }

	    public void addObserver(IObserver o) {
	        observer.add(o);
	    }

	    public void YuksekSicaklikBilgilendirme(){
	        for(IObserver observer : observer){
	            observer.Bilgilendir(UyariMesajlari.YuksekSicaklik());
	        }
	    }

	    public void DusukSicaklikBilgilendirme(){
	        for(IObserver observer : observer){
	            observer.Bilgilendir(UyariMesajlari.DusukSicaklik());
	        }
	    }
	    
	    public void DengeDurumuBilgilendirme() {
	    	for(IObserver observer: observer) {
	    		observer.Bilgilendir(UyariMesajlari.DengeDurumu());
	    	}
	    }

}
