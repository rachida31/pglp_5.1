package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


/**
 *implemantation de la classe PersonnelDAO 
 *pour la dao d'un personnel.
 * @author rachida ouchene.
 * 
 */
public class PersonnelDAO  <T extends Serializable> extends Serialisation<Personnel>  implements DAO<Personnel>{
	/**
     * Elle permit de crer un objet Personnel.
     */
	public void create(Personnel obj) {
		 writeFile(obj,obj.getNom()+".personnel" );
	}
	/**
     * Metre à jour les informations d'un Personnel.
     *      
     */
	public void update(Personnel obj,String file) throws InExistFille {
		updateFile(obj,obj.getNom()+".personnel",file);

	}
	/**
     * Supprime un Personnel.
     */
	public void delete(Personnel obj) throws InExistFille {

		deleteFile(obj.getNom()+".personnel");
	}
	/**
     * Retourne l'objet Personnel qu'est lu.
     */
	@Override
	public Personnel read(String s) throws FileNotFoundException, ClassNotFoundException, IOException {
		return readFile(s);
	}

	
	

}
