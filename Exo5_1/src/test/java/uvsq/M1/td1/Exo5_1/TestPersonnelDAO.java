package uvsq.M1.td1.Exo5_1;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.*;

import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;


public class TestPersonnelDAO {

	
	

		
		
		private Fonction fonc;
		private Telephone tel;
		private Personnel  personnel;
		private Personnel  personnel1;
		private PersonnelDAO s;

	@Before()
	public void setUp() {

		personnel=(new PersonnelBuilder("ouchene", "rachel", fonc.directeur).
	date(LocalDate.parse("2011-12-01")).
	addNumeroTelephone(new ClasseTele(tel.fixePro,"06 89 51 12 53")).build());
		personnel1=(new PersonnelBuilder("aissou", "rachel", fonc.directeur).
				date(LocalDate.parse("2011-12-01")).
				addNumeroTelephone(new ClasseTele(tel.fixePro,"06 89 51 12 53")).build());
		s= new PersonnelDAO();
	}
		
		
	@Test
	public void testWrite()
	{
		s.save(personnel1,personnel1.getNom()+".personel");

	}
	@Test
	public void testUpdate()
	{
		s.update(personnel, personnel1.getNom()+".personel",personnel.getNom()+".personel");


	}
	@Test
	public void testFind() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		assertTrue(s.find(personnel.getNom()+".personel").getClass().equals(personnel.getClass()));
		assertTrue(s.find(personnel.getNom()+".personel").getDate().equals(personnel.getDate()));
		assertTrue(s.find(personnel.getNom()+".personel").getFonc().equals(personnel.getFonc()));
		assertTrue(s.find(personnel.getNom()+".personel").getDate().equals(LocalDate.parse("2011-12-01")));

	}


	@Test
	public void testDelete()
	{
		s.delete(personnel, personnel.getNom()+".personel");

	}


	}

