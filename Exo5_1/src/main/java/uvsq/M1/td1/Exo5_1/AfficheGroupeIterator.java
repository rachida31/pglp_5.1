package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class AfficheGroupeIterator extends GroupeIterator implements 
Iterator<CompositePersonne> , Serializable{

	public AfficheGroupeIterator(ArrayList<CompositePersonne> listComposite) {
		super(listComposite);
	}

	@Override
	public void afficheGroupeIterator() {

	    Iterator<CompositePersonne> iterator = this.getList().iterator();

	    while(iterator.hasNext()) {
           
             iterator.next().print();
        }
		
	}

	
	
	
	

}
