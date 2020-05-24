package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * implemantation de la classe CompositeDAO
 * pour la dao d'un groupe de
 * personnel.
 * @param <T> .
 * @author rachida ouchene.
 */

public class CompositeDAO<T extends Serializable>
	extends Serialisation<CompositePersonne>
		implements DAO<CompositePersonne> {
	/**
	 * Elle permit de crer un objet
	 * CompositePersonne.
	 * @param obj .
	 */
	public final void create(final CompositePersonne obj) {
		writeFile(obj, obj.getNomGroupe() + ".composite");
	}

	/**
	 * Metre à jour les informations d'un
	 * CompositePersonne.
	 * @param obj .
	 * @param file .
	 * @throws InExistFille .
	 */
	public final void update(final CompositePersonne
			obj, final String file) throws InExistFille {
		updateFile(obj, obj.getNomGroupe() + ".composite", file);

	}

	/**
	 * Supprime un CompositePersonne.
	 * @param obj .
	 * @throws InExistFille .
	 */
	public final void delete(final CompositePersonne obj)
			throws InExistFille {

		deleteFile(obj.getNomGroupe() + ".composite");
	}

	/**
	 * Retourne l'objet CompositePersonne qu'est lu.
	 * @param s .
	 * @return le contenue de file.
	 */
	@Override
	public final CompositePersonne read(final String s) throws
	FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return readFile(s);
	}

}
