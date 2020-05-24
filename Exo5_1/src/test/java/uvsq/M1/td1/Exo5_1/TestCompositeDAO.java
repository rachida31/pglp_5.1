package uvsq.M1.td1.Exo5_1;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.*;
import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;

public class TestCompositeDAO {
	private ArrayList<InterfacePersonne> personnel;
	private ArrayList<InterfacePersonne> personnel1;
	private Personnel p1;
	private CompositePersonne perso, perso2;
	private CompositePersonne perso1;
	private CompositeDAO<CompositePersonne> s;

	@Before()
	public void setUp() {

		this.personnel = new ArrayList<InterfacePersonne>();
		this.personnel1 = new ArrayList<InterfacePersonne>();

		p1 = (new PersonnelBuilder("aissou", "rachel", Fonction.directeur).date(LocalDate.parse("2011-12-01"))
				.addNumeroTelephone(new ClasseTele(Telephone.fixePro, "06 89 51 12 53")).build());
		personnel.add(p1);
		personnel
				.add(new PersonnelBuilder("aissou", "aylan", Fonction.chargeMission).date(LocalDate.parse("2014-11-01"))
						.addNumeroTelephone(new ClasseTele(Telephone.portable, "06 89 51 12 53")).build());
		personnel.add(new PersonnelBuilder("papi", "silas", Fonction.chargeMission).date(LocalDate.parse("2019-07-01"))
				.addNumeroTelephone(new ClasseTele(Telephone.fixePerso, "06 89 51 12 53")).build());
		perso = new CompositePersonne(personnel, "comptabilité");
		personnel1
				.add(new PersonnelBuilder("khaled", "aylan", Fonction.chargeMission).date(LocalDate.parse("2014-11-01"))
						.addNumeroTelephone(new ClasseTele(Telephone.portable, "06 89 51 12 53")).build());
		personnel1.add(new PersonnelBuilder("mami", "silas", Fonction.chargeMission).date(LocalDate.parse("2019-07-01"))
				.addNumeroTelephone(new ClasseTele(Telephone.fixePerso, "06 89 51 12 53")).build());
		perso1 = new CompositePersonne(personnel1, "informatique");

		s = new CompositeDAO<CompositePersonne>();
	}

	@Test
	public void testWrite() {
		s.create(perso1);

	}

	@Test(expected = InExistFille.class)
	public void testUpdate() throws InExistFille {
		s.update(perso, perso.getNomGroupe() + ".composite");

	}

	@Test
	public void testread() throws FileNotFoundException, ClassNotFoundException, IOException {
		assertTrue(s.read(perso1.getNomGroupe() + ".composite").getClass().equals(perso1.getClass()));
		assertTrue(s.read(perso1.getNomGroupe() + ".composite").getNomGroupe().equals(perso1.getNomGroupe()));
		assertFalse(s.read(perso1.getNomGroupe() + ".composite").getNomGroupe().equals("comptabilité"));

	}

	@Test(expected = InExistFille.class)
	public void testDelete() throws InExistFille {
		s.delete(perso);

	}

	@Test
	public void testDaoFactory() throws Exception {
		DAO<CompositePersonne> compositeDao = DaoFactory.getCompositePersonnel();
		compositeDao.create(perso);
		perso2 = compositeDao.read(perso.getNomGroupe() + ".composite");
		assertTrue(perso.getNomGroupe().equals(perso2.getNomGroupe()));
		compositeDao.update(perso1, perso.getNomGroupe() + ".composite");
		perso2 = compositeDao.read(perso1.getNomGroupe() + ".composite");
		assertFalse(perso2.getNomGroupe().equals(perso.getNomGroupe()));
	}

}
