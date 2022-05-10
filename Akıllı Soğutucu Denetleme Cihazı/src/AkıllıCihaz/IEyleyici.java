package AkýllýCihaz;

public interface IEyleyici {
	
	public void sogutucuAc();
	public void sogutucuKapat();
	public void CihazOtoKontrol(double sicaklik);
    void addObserver(IObserver izleyici);


}
