package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *implemantation de la classe abstract GroupeIterator qui implement  Iterator.
 *pour afficher les groupes de  personnel .
 * @author rachida ouchene.
 * 
 */
public abstract class GroupeIterator implements Iterator<CompositePersonne>, Serializable{
	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
     *La liste des groupe de personnels.
     * @see GroupeIterator#GroupeIterator().
     * @see GroupeIterator#getListComposite().
     */
	private ArrayList<CompositePersonne> listComposite;
	/**
     *Un index le la liste des groupes des personnels.
     * @see GroupeIterator#GroupeIterator().
     */
	private int index;
	/**
	* Constructor GroupeIterator qu'inisialise @see listComposite 
	* la liste des groupes des personnels .
 	 * @param listComposite.
	 * La liste des groupes des personnels .
	 * */
	public GroupeIterator(ArrayList<CompositePersonne> listComposite )
	{
		this.index=-1;
		this.listComposite=listComposite;
	}
	
	/**
     * Retourne un boullean 1 si la liste a un next 0 sinon .
     * 
     * @return un boullean 1 si la liste a un next 0 sinon  .
     */
	public boolean hasNext() {
		return !listComposite.isEmpty();
	}
	/**
     * Retourne un CompositePersonne qu'est 
     * un  groupe de personnel si il y'a un next sinon elle genere 
     * une exception de type NoSuchElementException est genere.
     * 
     * @return  groupe de personnel .
     * 
    
     */
	public CompositePersonne next() {
        if (!hasNext()) {
        throw new NoSuchElementException();
        }
        else 
        {	System.out.println(listComposite.get(index++));
        listComposite.get(index++).print();
        	return listComposite.get(index++);
        }
	}

	/**
     * Retourne La liste des groupes de personnels.
     * 
     * @return Liste des groupes des personnels.
     * 
     * @see listComposite.
     */
	public  ArrayList<CompositePersonne> getList() {
		return listComposite;
		//return( ArrayList<InterfacePersonne>) Collections.unmodifiableList(this.listComposite);

	}
	
	public abstract void afficheGroupeIterator();
	

	
	
	
	
	
	
}
