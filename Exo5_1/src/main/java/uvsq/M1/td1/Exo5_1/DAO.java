package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * implemantation de l'interface {@link DAO} pour implimenter
 * les quatres Operations CRUD.
 * @param <T> .
 * @author rachida ouchene.
 */
 interface DAO<T> {
	/**
	 * la methode create.
	 * @param t .
	 * @throws Exception .
	 **/
	 void create(T t) throws Exception;
	/**
	 * la méthode update.
	 * @param t .
	 * @param file .
	 * @throws Exception .
	 **/
	 void update(T t, String file) throws Exception;
	/**
	 * la méthode delete.
	 * @param t .
	 * @throws Exception .
	 **/
	 void delete(T t) throws Exception;
	/**
	 * la méthode read.
	 * @param s .
	 * @throws IOException .
	 * @throws FileNotFoundException .
	 * @throws ClassNotFoundException .
	 * @return T .
	 **/
	 T read(String s) throws
	FileNotFoundException, ClassNotFoundException, IOException;

}
