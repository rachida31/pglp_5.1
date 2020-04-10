package uvsq.M1.td1.Exo5_1;
/**
 *implemantation de la classe D'exception InExistArgumentException 
 *qui se genera quand un element que on veut supperimer dans une
 * liste n\'existe pas ..
 * @author rachida ouchene.
 * 
 */
public class InExistArgumentException extends IllegalArgumentException {
	
	public InExistArgumentException() {
	super(" \n L\'element n\'existe pas !");
	}


}
