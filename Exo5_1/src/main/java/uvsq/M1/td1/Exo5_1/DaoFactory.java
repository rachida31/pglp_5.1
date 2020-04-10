package uvsq.M1.td1.Exo5_1;

/**
 *implemantation de la classe DaoFactory 
 *pour factory les deux objets Personnel et CompositePersonne .
 * @author rachida ouchene.
 * 
 */
public class DaoFactory {
	
	/**
     * Retourne Un objet PersonnelDAO .
     * 
     * @return PersonnelDAO.
     * 
     * 
     */
		public static DAO<Personnel> getPersonnelDAO(){ 
			return new PersonnelDAO<Personnel>();
		}
		/**
	     * Retourne Un objet CompositeDAO.
	     * 
	     * @return CompositeDAO.
	     *
	     */
		 public static DAO<CompositePersonne> getCompositePersonnel() {
		        return new CompositeDAO<CompositePersonne>();
		        
		    }
		

}
