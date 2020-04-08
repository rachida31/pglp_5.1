package uvsq.M1.td1.Exo5_1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;



	
public class CompositeDAO <T extends Serializable> extends Serialisation<CompositePersonne>  implements DAO<CompositePersonne> {

	
	

	
		

		
		
		
		public void save(CompositePersonne obj,String s) {
			 writeFile(obj,s );
		}

		public void update(CompositePersonne obj,String s,String s1) {
			updateFile(obj, s,s1);

		}

		public void delete(CompositePersonne obj,String s) {

			deleteFile(s);
		}

		@Override
		public CompositePersonne find(String s) throws FileNotFoundException, ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			return findFile(s);
		}

		@Override
		public ArrayList<CompositePersonne> findAll() throws FileNotFoundException, ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			return null;
		}

		

	}

	
	
