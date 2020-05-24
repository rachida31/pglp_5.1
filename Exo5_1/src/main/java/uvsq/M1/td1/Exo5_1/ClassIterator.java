package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implemantation de la classe abstract
 * ClassIterator qui implement Iterator .
 * @author rachida ouchene.
 */
public abstract class ClassIterator
implements Iterator<InterfacePersonne>, Serializable {

	/**
	 * contrôleur de la version.
	 */
	private static final long serialVersionUID = 1L;
	/**.
	 * le composite qu'est de type
	 * CompositePersonne c'est un groupe de
	 * personnels
	 * @see ClassIterator#ClassIterator().
	 * @see ClassIterator#getComposite().
	 */
	private CompositePersonne composite;
	/**
	 * la liste des InterfacePersonne qui
	 * sont des personnel ou groupe de personnels.
	 * @see ClassIterator#ClassIterator().
	 * @see ClassIterator#getList().
	 */
	private ArrayList<InterfacePersonne> list;
	/**
	 * Un index pour parcourir la liste il
	 * est de type int.
	 * @see ClassIterator#ClassIterator().
	 */
	private int index;

	/**.
	 * Constructor ClassIterator qu'inisialise
	 * @see personnelGroupe et la @see list.
	 * @param list1 liste des personnels.
	 * @param personnelGroupe1 le groupe de personnel .
	 */
	public ClassIterator(final CompositePersonne personnelGroupe1, final
			ArrayList<InterfacePersonne> list1) {
		this.composite = personnelGroupe1;
		this.list = list1;
		this.list.addAll(composite.getPersonnel());
		this.index = -1;

	}

	/**
	 * Retourne un boullean 1 si la liste a
	 * un next 0 sinon .
	 * @return un boullean 1 si la liste a
	 * un next 0 sinon .
	 */
	public final boolean hasNext() {
		return !list.isEmpty();
	}

	/**.
	 * Retourne un InterfacePersonne qu'est
	 * soit un personnel soit un groupe de
	 * personnel si il y'a un next sinon
	 * elle genere une exception de type
	 * @throws NoSuchElementException est genere.
	 * @return soit un personnel soit un
	 * groupe de personnel .
	 */
	public final InterfacePersonne next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		} else {
			System.out.println(list.get(index++));
			list.get(index++).print();
			return list.get(index++);
		}
	}

	/**
	 * Retourne un groupe de personnel.
	 * @return u groupe .
	 * @see composite.
	 */
	public final InterfacePersonne getComposite() {
		return composite;
	}

	/**
	 * Retourne La list des personnel.
	 * @return list.
	 * @see list
	 */
	public final ArrayList<InterfacePersonne> getList() {
		return list;
		// return( ArrayList<InterfacePersonne>)
		// Collections.unmodifiableList(this.list);

	}
	/**
	 *la methode affiche.
	 **/
	public abstract void afficheIterator();

}
