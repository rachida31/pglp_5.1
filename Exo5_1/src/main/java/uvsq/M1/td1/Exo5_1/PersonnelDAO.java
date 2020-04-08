package uvsq.M1.td1.Exo5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import uvsq.M1.td1.Exo5_1.Personnel.PersonnelBuilder;

public class PersonnelDAO  <T extends Serializable> extends Serialisation<Personnel>  implements DAO<Personnel>{

	
	

	
	
	
	public void save(Personnel obj,String s) {
		 writeFile(obj,s );
	}

	public void update(Personnel obj,String s,String s1) {
		updateFile(obj, s,s1);

	}

	public void delete(Personnel obj,String s) {

		deleteFile(s);
	}

	@Override
	public Personnel find(String s) throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return findFile(s);
	}

	@Override
	public ArrayList<Personnel> findAll() throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
