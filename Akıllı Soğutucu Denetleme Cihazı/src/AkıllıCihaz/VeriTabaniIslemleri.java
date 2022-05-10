package AkýllýCihaz;

import java.sql.SQLException;

public class VeriTabaniIslemleri {
	
	
	private IVeriTabaniSunucu veritabani;	

    public VeriTabaniIslemleri(IVeriTabaniSunucu veritabani){
	    this.veritabani =  veritabani;
	}
    
    
	public void BaglantiKur(){
	    veritabani.Baglan();
	}

	
	public boolean GirisKontrol(String username, String password){
	    return veritabani.SistemeGiris(username,password);
	}
	
	public boolean KullaniciKontrol(String username){
	    return veritabani.KullaniciKontrol(username);
	}
	
	public boolean YetkiKontrol(String username,String password){
	    return veritabani.YetkiKontrol(username,password);
	}
	
	public void BaglantiSonlandir() throws SQLException {
	    veritabani.BaglantiSonlandir();
	}
	

}
