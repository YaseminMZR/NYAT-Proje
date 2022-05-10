package AkýllýCihaz;

import java.sql.SQLException;

public interface IVeriTabaniSunucu {
	
	void Baglan();
    boolean SistemeGiris(String username, String password);
    void BaglantiSonlandir() throws SQLException;
    boolean KullaniciKontrol(String username);
    boolean YetkiKontrol(String username,String password);

}
