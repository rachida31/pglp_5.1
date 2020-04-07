package uvsq.M1.td1.Exo5_1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
public  abstract class ClassIterator implements Iterator<InterfacePersonne>, Serializable{

	
	private CompositePersonne composite;
	private ArrayList<InterfacePersonne> list;
	private int index;
	public ClassIterator(CompositePersonne personnelGroupe,
			ArrayList<InterfacePersonne> list) {
		this.composite = personnelGroupe;
		this.list = list;
		this.list.addAll(composite.getPersonnel());
		this.index=-1;

	}

	public boolean hasNext() {
		return !list.isEmpty();
	}

	public InterfacePersonne next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        else 
        {	System.out.println(list.get(index++));
        list.get(index++).print();
        	return list.get(index++);
        }
	}


	public InterfacePersonne getComposite() {
		return composite;
	}
	public  ArrayList<InterfacePersonne> getList() {
		return list;
		//return( ArrayList<InterfacePersonne>) Collections.unmodifiableList(this.list);

	}
	
	public abstract void afficheIterator();
	
	
}

