package uvsq.M1.td1.Exo5_1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.*;

import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;

public class TestPersonnelDAO {
	private Personnel personnel, personnel2;
	private Personnel personnel1;
	private PersonnelDAO<Personnel> s;

	@Before()
	public void setUp() {

		personnel = (new PersonnelBuilder("ouchene", "siham", Fonction.directeur).date(LocalDate.parse("2011-12-01"))
				.addNumeroTelephone(new ClasseTele(Telephone.fixePro, "06 89 51 12 53")).build());
		personnel1 = (new PersonnelBuilder("aissou", "rachel", Fonction.directeur).date(LocalDate.parse("2011-12-01"))
				.addNumeroTelephone(new ClasseTele(Telephone.fixePro, "06 89 51 12 53")).build());
		s = new PersonnelDAO<Personnel>();

	}

	@Test
	public void testWrite() {
		s.create(personnel1);

	}

	@Test(expected = InExistFille.class)
	public void testUpdate() throws InExistFille {
		s.update(personnel, personnel.getNom() + ".personnel");

	}

	@Test
	public void testread() throws FileNotFoundException, ClassNotFoundException, IOException {
		assertTrue(s.read(personnel1.getNom() + ".personnel").getClass().equals(personnel1.getClass()));
		assertTrue(s.read(personnel1.getNom() + ".personnel").getDate().equals(personnel1.getDate()));
		assertTrue(s.read(personnel1.getNom() + ".personnel").getFonc().equals(personnel1.getFonc()));
		assertTrue(s.read(personnel1.getNom() + ".personnel").getDate().equals(LocalDate.parse("2011-12-01")));

	}

	@Test(expected = InExistFille.class)
	public void testDelete() throws InExistFille {
		s.delete(personnel);

	}

	@Test
	public void testDaoFactory() throws Exception {
		DAO<Personnel> personnelDao = DaoFactory.getPersonnelDAO();
		personnelDao.create(personnel);
		personnel2 = personnelDao.read(personnel.getNom() + ".personnel");
		assertTrue(personnel2.getPrenom().equals(personnel.getPrenom()));
		personnelDao.update(personnel1, personnel.getNom() + ".personnel");
		personnel2 = personnelDao.read(personnel1.getNom() + ".personnel");

		assertTrue(personnel2.getPrenom().equals(personnel1.getPrenom()));

		assertFalse(personnel2.getPrenom().equals(personnel.getPrenom()));
	}

}
