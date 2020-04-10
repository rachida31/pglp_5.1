package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *implemantation de l'interface  {@link DAO} pour implimenter les quatres 
 *Operations CRUD
 * @author rachida ouchene.
 * 
 */
public interface DAO <T>{
	
	
	
	

   public void create(T t)throws Exception;

   public void update(T t,String file)throws Exception;

   public void delete(T t)throws Exception;
	public T read(String s)throws FileNotFoundException, ClassNotFoundException, IOException ;


}
