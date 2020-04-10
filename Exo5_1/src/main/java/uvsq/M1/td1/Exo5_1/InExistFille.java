package uvsq.M1.td1.Exo5_1;
import java.nio.file.NoSuchFileException;
/**
 *implemantation de la classe D'exception InExistFille 
 *qui se genera quand un fichier que on veut supperimer 
 *ou lire  n\'existe pas .
 * @author rachida ouchene.
 * 
 */
public class InExistFille extends NoSuchFileException{
	public InExistFille() {
		super(" \n Le fichier  n\'existe pas !");
		}

}
