package uvsq.M1.td1.Exo5_1;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.*;
import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;

public class TestCompositeDAO {

	


		
		

			
			
			private Fonction fonc;
			private Telephone tel;
			private  ArrayList<InterfacePersonne> personnel ;
			private  ArrayList<InterfacePersonne> personnel1 ;

			private Personnel  p1;
			private CompositePersonne perso;
			private CompositePersonne perso1;

			private CompositeDAO s;

		@Before()
		public void setUp() {

			this.personnel=new ArrayList<InterfacePersonne>();
			this.personnel1=new ArrayList<InterfacePersonne>();

			p1=(new PersonnelBuilder("aissou", "rachel", fonc.directeur).
			date(LocalDate.parse("2011-12-01")).
			addNumeroTelephone(new ClasseTele(tel.fixePro,"06 89 51 12 53")).build());
			personnel.add(p1);
				personnel.add(new PersonnelBuilder("aissou", "aylan", fonc.chargeMission).
			date(LocalDate.parse("2014-11-01")).
			addNumeroTelephone(new ClasseTele(tel.portable,"06 89 51 12 53")).build());
				personnel.add(new PersonnelBuilder("papi", "silas", fonc.chargeMission).
			date(LocalDate.parse("2019-07-01")).
			addNumeroTelephone(new ClasseTele(tel.fixePerso,"06 89 51 12 53")).build());
				perso=new CompositePersonne(personnel,"comptabilité");
				personnel1.add(new PersonnelBuilder("khaled", "aylan", fonc.chargeMission).
						date(LocalDate.parse("2014-11-01")).
						addNumeroTelephone(new ClasseTele(tel.portable,"06 89 51 12 53")).build());
							personnel1.add(new PersonnelBuilder("mami", "silas", fonc.chargeMission).
						date(LocalDate.parse("2019-07-01")).
						addNumeroTelephone(new ClasseTele(tel.fixePerso,"06 89 51 12 53")).build());
							perso1=new CompositePersonne(personnel1,"informatique");
							
			s= new CompositeDAO();
		}
			
			
		@Test
		public void testWrite()
		{
			s.save(perso1,perso1.getNomGroupe()+".composite");

		}
		@Test
		public void testUpdate()
		{
			s.update(perso,perso1.getNomGroupe()+".composite",perso.getNomGroupe()+".composite");


		}
		@Test
		public void testFind() throws FileNotFoundException, ClassNotFoundException, IOException
		{
			assertTrue(s.find(perso.getNomGroupe()+".composite").getClass().equals(perso.getClass()));
			assertTrue(s.find(perso.getNomGroupe()+".composite").getNomGroupe() .equals(perso.getNomGroupe()));
			assertFalse(s.find(perso.getNomGroupe()+".composite").getNomGroupe().equals("informatique"));

		}


		@Test
		public void testDelete()
		{
			s.delete(perso,perso.getNomGroupe()+".composite");

		}


		}


	
