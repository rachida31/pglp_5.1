package uvsq.M1.td1.Exo5_1;
import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;
import static org.junit.Assert.*;
import org.junit.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
public class TestSerialisationComp {
	private  ArrayList<InterfacePersonne> personnel ;
	private CompositePersonne perso;
	private Personnel  p1;
@Before()
public void setUp() {
	this.personnel=new ArrayList<InterfacePersonne>();

p1=(new PersonnelBuilder("aissou", "rachel", Fonction.directeur).
date(LocalDate.parse("2011-12-01")).
addNumeroTelephone(new ClasseTele(Telephone.fixePro,"06 89 51 12 53")).build());
personnel.add(p1);
	personnel.add(new PersonnelBuilder("aissou", "aylan", Fonction.chargeMission).
date(LocalDate.parse("2014-11-01")).
addNumeroTelephone(new ClasseTele(Telephone.portable,"06 89 51 12 53")).build());
	personnel.add(new PersonnelBuilder("aissou", "silas", Fonction.chargeMission).
date(LocalDate.parse("2019-07-01")).
addNumeroTelephone(new ClasseTele(Telephone.fixePerso,"06 89 51 12 53")).build());
	perso=new CompositePersonne(personnel,"comptabilité");

}
	@Test
	public void TestGroupe()
	{

		boolean bool = true;

		   ObjectOutputStream oos = null;

		    try {

		      final FileOutputStream fichier = new FileOutputStream("groupre.ser");
		      
		      oos = new ObjectOutputStream(fichier);
		      oos.writeObject(perso);
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
	
	
	
	

