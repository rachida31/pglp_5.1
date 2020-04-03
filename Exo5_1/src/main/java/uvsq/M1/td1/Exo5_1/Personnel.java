package uvsq.M1.td1.Exo5_1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import  java.io.Serializable ;
	
public class Personnel implements Serializable {

	
		private final String nom;	
		private final String prenom;
		private final List<ClasseTele> tel;
		private final Fonction fonc;
		private final  LocalDate date;
		
	public static class PersonnelBuilder {
		private final String nom;	
		private final String prenom;
		private  List<ClasseTele> tel=new ArrayList<ClasseTele>();
		private final Fonction fonc;
		private   LocalDate date;
		
			
			public PersonnelBuilder(String nom, String prenom, Fonction fonc) {
				this.nom = nom;
				this.prenom = prenom;
				this.fonc = fonc;
			}
			
			public PersonnelBuilder date(LocalDate date) {
				this.date = date;
				return this;
			}
			
			public PersonnelBuilder addNumeroTelephone(ClasseTele numeroTelephone) {
				this.tel.add(numeroTelephone);
				return this;
			}
			
			public Personnel build() {
				return new Personnel(this);
			}
		}
		
		
		
	Personnel(PersonnelBuilder builder) {
		nom = builder.nom;
		prenom = builder.prenom;
		fonc = builder.fonc;
		date = builder.date;
		tel = builder.tel;
	}
		
		/*public Personnel (String nom,String prenom,Telephone tel,Fonction fonc,LocalDate date )
		
		{
			this.nom=nom;
			this.prenom=prenom;
			this.fonc=fonc;
			this.tel=new ArrayList();
			this.date=date;
		
		}*/

		public String getNom() {
			return nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public List<ClasseTele> getTel() {
			return tel;
		}

		public Fonction getFonc() {
			return fonc;
		}

		public LocalDate getDate() {
			return date;
		}
	}

	
	
	

	
