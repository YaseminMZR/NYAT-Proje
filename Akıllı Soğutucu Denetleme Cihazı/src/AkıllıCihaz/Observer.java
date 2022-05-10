package AkıllıCihaz;

public class Observer implements IObserver {

	@Override
	public void Bilgilendir(String mesaj) {
		
		System.out.println(mesaj);
		
	}
	

}



