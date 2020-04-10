package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *implemantation de la classe CompositePersonne 
 *pour definir un groupe de personnel.
 * @author rachida ouchene.
 * 
 */
public class CompositePersonne implements  InterfacePersonne, Serializable{
	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
     *la liste des personnels.
     * @see CompositePersonne#CompositePersonne().
     * @see CompositePersonne#getPersonnel().
     */
		private final ArrayList<InterfacePersonne> personnel ;
		/**
	     *Le nom de groupe qu'est de type String.
	     * @see CompositePersonne#CompositePersonne().
	     * @see CompositePersonne#getNomGroupe().
	     */
		private String NomGroupe;
		/**
		* Constructor CompositePersonne qu'inisialise @see nomGroupe a une chaine vide
		* et @see personnel cree une new ArrayList.
		 *
		 * */
		public CompositePersonne()
		{
		this.NomGroupe=" ";
		this.personnel=new ArrayList<InterfacePersonne>();
		
		}
		/**
		* Constructor CompositePersonne qu'inisialise @see NomGroupe 
		* @see personnel la liste des personnels passer en parametre.
		 * @param personnel.
		 * un liste des personnels .
		 * @param NomGroupe le nom de qroupe.
		 * */
		public CompositePersonne(ArrayList<InterfacePersonne> personnel,String NomGroupe)
		{
		this.NomGroupe=NomGroupe;
		this.personnel=personnel;
		
		}
		/**	      
	     * @return une liste des personnels.
	     * 
	     * @see personnel.
	     */
		public  ArrayList<InterfacePersonne>getPersonnel()
		{
		return this.personnel;	
		//return ( ArrayList<InterfacePersonne>) Collections.unmodifiableList(this.personnel);

		}
		/**
	     * Permet d'affiche le nom de groupe ,
	     * ainsi que la liste des personnels.
	     */
		public void print()
		{
			System.out.println("Le nom du groupe est : "+this.NomGroupe);

			  for (InterfacePersonne per :personnel) {
			        per.print();  //Delegation
			    }
		}

		/**
	     * Elle ajoute un personnel per dans la liste des personnels.
	     *
	     * @see personnel.
	     */
	public void add(InterfacePersonne per) 
	{
		System.out.println(this.personnel.contains(per));
		personnel.add(per);
	}

	/**
     * 
     * @return int qu'est la taille da la liste des personnel.
     * 
     * @see personnel.
     */	  
public int size()
{
	return this.personnel.size();
}
/**
 * Retourne le nom de groupe.
 * 
 * @return String qu'est le nom de groupe .
 * 
 * @see NomGroupe
 */
public String getNomGroupe()
{
	return this.NomGroupe;
}
/**
 *Elle supperimme un  personnel passer en parametre 
 *perso si il existe  dans la liste des personnel @see personnel
 *sinon elle genera une exception de type InExistArgumentException.
 * 
 *@param perso un personnel que on veut supperimer de la liste .
 * 
 */
	public void remove(Personnel perso) {
		if(this.personnel.contains(perso)) {
			System.out.println(this.personnel.contains(perso));
		this.personnel.remove(perso);}
		else 
			{
			System.out.println(this.personnel.contains(perso));

			throw new InExistArgumentException();
	}
	}
}
