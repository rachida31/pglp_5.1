package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * implemantation de la classe PersonnelDAO pour
 * la dao d'un personnel.
 * @param <T> .
 * @author rachida ouchene.
 */
public class PersonnelDAO<T extends Serializable> extends
	Serialisation<Personnel> implements DAO<Personnel> {
	/**
	 * Elle permit de crer un objet Personnel.
	 * @param obj .
	 */
	public final void create(final Personnel obj) {
		writeFile(obj, obj.getNom() + ".personnel");
	}

	/**
	 * Metre à jour les informations d'un Personnel.
	 * @param obj .
	 * @param file .
	 * @throws InExistFille .
	 */
	public final void update(final Personnel obj, final
			String file) throws InExistFille {
		updateFile(obj, obj.getNom() + ".personnel", file);

	}

	/**
	 * Supprime un Personnel.
	 * @param obj .
	 * @throws InExistFille .
	 */
	public final void delete(final Personnel obj) throws InExistFille {

		deleteFile(obj.getNom() + ".personnel");
	}

	/**
	 * Retourne l'objet Personnel qu'est lu.
	 * @param s .
	 * @throws FileNotFoundException .
	 * @throws ClassNotFoundException .
	 * @throws IOException .
	 */
	@Override
	public final Personnel read(final String s) throws
	FileNotFoundException, ClassNotFoundException, IOException {
		return readFile(s);
	}

}
