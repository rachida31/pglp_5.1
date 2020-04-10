package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *implemantation de la classe AfficheIterator 
 *pour afficher le  personnel d'un groupe.
 * @author rachida ouchene.
 * 
 */
public class AfficheIterator extends ClassIterator implements 
Iterator<InterfacePersonne>, Serializable{

	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
	* constructeur AfficheGroupeIterator qui appelle le constructeur de 
	* la classe mere GroupeIterator.
	 * @param ArrayList<InterfacePersonne> list.
	 * liste  de personnel.
	 * @param personnelGroupe un groupe de personnel.
	 * */
	public AfficheIterator(CompositePersonne personnelGroupe, ArrayList<InterfacePersonne> list) {
		super(personnelGroupe, list);


	
	}
	/**
	 * methode afficheGroupeIterator 
	 * qui affiche la liste de personnel d'un groupe.
	 * 
	 * */
	@Override
	public void afficheIterator() {
System.out.println(this.getList());
	    Iterator<InterfacePersonne> iterator = this.getList().iterator();

	    while(iterator.hasNext()) {
           
             iterator.next().print();
        }
	    
	}



	
	
	
	
	
	
	
	
}
