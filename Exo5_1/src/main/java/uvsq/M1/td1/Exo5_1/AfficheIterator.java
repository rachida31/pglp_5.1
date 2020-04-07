package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class AfficheIterator extends ClassIterator implements 
Iterator<InterfacePersonne>, Serializable{

	public AfficheIterator(CompositePersonne personnelGroupe, ArrayList<InterfacePersonne> list) {
		super(personnelGroupe, list);


	
	}

	@Override
	public void afficheIterator() {

	    Iterator<InterfacePersonne> iterator = this.getList().iterator();

	    while(iterator.hasNext()) {
           
             iterator.next().print();
        }
	    
	}



	
	
	
	
	
	
	
	
}
