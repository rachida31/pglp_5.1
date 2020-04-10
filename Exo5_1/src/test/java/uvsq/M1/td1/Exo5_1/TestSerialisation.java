package uvsq.M1.td1.Exo5_1;
import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;
import static org.junit.Assert.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import org.junit.*;

public class TestSerialisation {
	private Personnel  personnel;
@Before()
public void setUp() {

	personnel=(new PersonnelBuilder("aissou", "rachel", Fonction.directeur).
date(LocalDate.parse("2011-12-01")).
addNumeroTelephone(new ClasseTele(Telephone.fixePro,"06 89 51 12 53")).build());

}
@Test
public void TestPrint()
{
	boolean bool = true;

	   ObjectOutputStream oos = null;

	    try {

	      final FileOutputStream fichier = new FileOutputStream("personnel.ser");
	      
	      oos = new ObjectOutputStream(fichier);
	      oos.writeObject(personnel);
	      oos.flush();
	      bool = true;
	    } catch (IOException e) {
	      e.printStackTrace();
	      bool = false;
	    	assertTrue("La sérialisation n\'est pas passé", bool == false);

	    } finally {
	    	assertTrue("La sérialisation est passé", bool == true);
try {
	        if (oos != null) {
	          oos.flush();
	          oos.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }}
	
}
}
	
	
	
	
	
	


