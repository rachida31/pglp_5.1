package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface DAO <T>{
	
	
	
	
	public T find(String s)throws FileNotFoundException, ClassNotFoundException, IOException ;

   public ArrayList<T> findAll()throws FileNotFoundException, ClassNotFoundException, IOException ;

   public void save(T t,String  s)throws Exception;

   public void update(T t, String s,String s1)throws Exception;

   public void delete(T t,String s)throws Exception;
	

}
