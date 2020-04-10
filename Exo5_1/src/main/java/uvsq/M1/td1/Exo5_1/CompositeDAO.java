package uvsq.M1.td1.Exo5_1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 *implemantation de la classe CompositeDAO 
 *pour la dao d'un groupe de personnel.
 * @author rachida ouchene.
 * 
 */

public class CompositeDAO <T extends Serializable> extends Serialisation<CompositePersonne>  implements DAO<CompositePersonne> {
	/**
     * Elle permit de crer un objet CompositePersonne.
     */
	public void create(CompositePersonne obj) {
			 writeFile(obj,obj.getNomGroupe()+".composite");
		}
	/**
	 * Metre à jour les informations d'un CompositePersonne.
	 *      
	 */
		public void update(CompositePersonne obj,String file) throws InExistFille {
			updateFile(obj,obj.getNomGroupe()+".composite",file);

		}
		/**
	     * Supprime un CompositePersonne.
	     */
		public void delete(CompositePersonne obj) throws InExistFille {

			deleteFile(obj.getNomGroupe()+".composite");
		}
		/**
	     * Retourne l'objet CompositePersonne qu'est lu.
	     */
		@Override
		public CompositePersonne read(String s) throws FileNotFoundException, ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			return readFile(s);
		}

		

	}

	
	
