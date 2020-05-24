package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * implemantation de la classe CompositePersonne pour definir
 * un groupe de personnel.
 * @author rachida ouchene.
 */
public class CompositePersonne implements InterfacePersonne, Serializable {
	/**.
	 * contrôleur de la version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * la liste des personnels.
	 * @see CompositePersonne#CompositePersonne().
	 * @see CompositePersonne#getPersonnel().
	 */
	private final ArrayList<InterfacePersonne> personnel;
	/**
	 * Le nom de groupe qu'est de type String.
	 * @see CompositePersonne#CompositePersonne().
	 * @see CompositePersonne#getNomGroupe().
	 */
	private String nomGroupe;

	/**.
	 * Constructor CompositePersonne qu'inisialise
	 * @see nomGroupe a une chaine vide.
	 * et @see personnel cree une new ArrayList.
	 */
	public CompositePersonne() {
		this.nomGroupe = " ";
		this.personnel = new ArrayList<InterfacePersonne>();

	}

	/**.
	 * Constructor CompositePersonne qu'inisialise @see NomGroupe
	 * @see personnel la liste des personnels passer en parametre.
	 * @param personnel1  un liste des personnels .
	 * @param nomGroupe1  le nom de qroupe.
	 */
	public CompositePersonne(final ArrayList<InterfacePersonne>
		personnel1, final String nomGroupe1) {
		this.nomGroupe = nomGroupe1;
		this.personnel = personnel1;

	}

	/**
	 * @return une liste des personnels.
	 * @see personnel.
	 */
	public final ArrayList<InterfacePersonne> getPersonnel() {
		return this.personnel;
		// return ( ArrayList<InterfacePersonne>)
		// Collections.unmodifiableList(this.personnel);

	}

	/**
	 * Permet d'affiche le nom de groupe , ainsi
	 * que la liste des personnels.
	 */
	public final void print() {
		System.out.println("Le nom du groupe est : " + this.nomGroupe);

		for (InterfacePersonne per : personnel) {
			per.print(); // Delegation
		}
	}

	/**
	 * Elle ajoute un personnel per dans la liste des personnels.
	 * @see personnel.
	 * @param per le personnel a rajouter dans le groupe.
	 */
	public final void add(final InterfacePersonne per) {
		System.out.println(this.personnel.contains(per));
		personnel.add(per);
	}

	/**
	 * @return int qu'est la taille da la liste des personnel.
	 * @see personnel.
	 */
	public final int size() {
		return this.personnel.size();
	}

	/**
	 * Retourne le nom de groupe.
	 * @return String qu'est le nom de groupe .
	 * @see NomGroupe
	 */
	public final String getNomGroupe() {
		return this.nomGroupe;
	}

	/**.
	 * Elle supperimme un personnel passer en parametre perso si
	 * il existe dans la liste des personnel @see personnel sinon
	 * elle genera une exception de type
	 * @throws InExistArgumentException :.
	 * @param perso un personnel que on veut supperimer de la liste .
	 */
	public final void remove(final Personnel perso) {
		if (this.personnel.contains(perso)) {
			System.out.println(this.personnel.contains(perso));
			this.personnel.remove(perso);
		} else {
			System.out.println(this.personnel.contains(perso));

			throw new InExistArgumentException();
		}
	}
}
