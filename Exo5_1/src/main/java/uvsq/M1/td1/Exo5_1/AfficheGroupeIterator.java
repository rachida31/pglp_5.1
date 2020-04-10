package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *implemantation de la classe AfficheGroupeIterator 
 *pour afficher le groupe de personnel.
 * @author rachida ouchene.
 * 
 */
public class AfficheGroupeIterator extends GroupeIterator implements 
Iterator<CompositePersonne> , Serializable{

	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
	* constructeur AfficheGroupeIterator qui appelle le constructeur de 
	* la classe mere GroupeIterator.
	 * @param listComposite.
	 * liste de groupe de personnel.
	 * */
	public AfficheGroupeIterator(ArrayList<CompositePersonne> listComposite) {
		super(listComposite);
	}
	/**
	 * methode afficheGroupeIterator qui affiche
	 *  la liste de groupe de personnel.
	 * 
	 * */
	@Override
	public void afficheGroupeIterator() {

	    Iterator<CompositePersonne> iterator = this.getList().iterator();

	    while(iterator.hasNext()) {
           
             iterator.next().print();
        }
		
	}

	
	
	
	

}
