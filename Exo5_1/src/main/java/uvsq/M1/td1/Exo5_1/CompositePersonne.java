package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CompositePersonne implements  InterfacePersonne, Serializable{
	//Collection of child graphics.
		private final ArrayList<InterfacePersonne> personnel ;
		private String NomGroupe;
		
		public CompositePersonne()
		{
		this.NomGroupe=" ";
		this.personnel=new ArrayList<InterfacePersonne>();
		
		}
		
		public CompositePersonne(ArrayList<InterfacePersonne> personnel,String NomGroupe)
		{
		this.NomGroupe=NomGroupe;
		this.personnel=personnel;
		
		}
		public  ArrayList<InterfacePersonne>getPersonnel()
		{
		return this.personnel;	
		//return ( ArrayList<InterfacePersonne>) Collections.unmodifiableList(this.personnel);

		}
		public void print()
		{
			System.out.println("Le nom du groupe est : "+this.NomGroupe);

			  for (InterfacePersonne per :personnel) {
			        per.print();  //Delegation
			    }
		}

	
	public void add(InterfacePersonne per) 
	{
		System.out.println(this.personnel.contains(per));
		personnel.add(per);
	}

	  
public int size()
{
	return this.personnel.size();
}
public String getNomGroupe()
{
	return this.NomGroupe;
}
	public void remove(Personnel perso) {
		if(this.personnel.contains(perso)) {
			System.out.println(this.personnel.contains(perso));
		this.personnel.remove(perso);}
		else 
			{
			System.out.println(this.personnel.contains(perso));

			throw new InExistArgumentException();
	}
	}
}
