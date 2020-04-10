package uvsq.M1.td1.Exo5_1;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
/**
 *implemantation de la classeimmuable  Personne 
 *pour definir un personnel.
 * @author rachida ouchene.
 * 
 */
public final class Personnel implements  InterfacePersonne , Serializable{
	/**
	 * contrôleur de la version
	 */
	private static final long   serialVersionUID=1L;
	/**
     *Le nom d'un personnel.
     * @see Personne#Personne().
     * @see Personne#getNom().
     */
	private final String nom;	
	/**
     *Le pernom d'un personnel .
     * @see Personne#Personne().
     * @see Personne#getPrenom().
     */
	private final String prenom;
	/**
     *La liste des telephones d'un personnel.
     * @see Personne#Personne().
     * @see Personne#getTel().
     */
	private final List<ClasseTele> tel;
	/**
     *La fonction d'un personnel.
     * @see Personne#Personne().
     * @see Personne#getFonc().
     */
	private final Fonction fonc;
	/**
     *La date de naissonce d'un personnel .
     * @see Personne#Personne().
     * @see Personne#getDate().
     */
	private final  LocalDate date;
	/**
     *le Id d'un personnel.
     * @see Personne#Personne().
     * @see Personne#getIdPerso().
     */
	private final  int   idPerso;
	/**
	 *implemantation de la classe PersonnelBuilder 
	 *pour implementer notre builder.
	 * 
	 */
public static class PersonnelBuilder {
	/**
	 * variable obligatoire.
	 * 
	 */
	
	private final String nom;	
	private final String prenom;
	private final Fonction fonc;
	private  static int idPerso;


	/**
	 * variable optionnel.
	 * 
	 */
	private  List<ClasseTele> tel=new ArrayList<ClasseTele>();
	private  LocalDate date;
	/**
	* Constructor PersonnelBuilder de notre builder qu'inisialise les variable obligatoire.
	 * @param nom.
	 * Le nom de personnel.
	 * * @param prenom.
	 * Le prenom de personnel.
	 * @param fonc 
	 * La fonction  d'un personnel.
	 * */
		public PersonnelBuilder(String nom, String prenom, Fonction fonc) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonc = fonc;
			idPerso+=1;  
		}
		/**
	     * permet d'initialiser la date de notre builder @see date .
	     * @return un objet de type PersonnelBuilder qui est notre builder.
	     * 
	     * @see num.
	     */
		public PersonnelBuilder date(LocalDate date) {
			this.date = date;
			return this;
		}
		/**
		 * 	Ajoute un numero de telephone a la liste des telephone 
		 * dans notre builder.
	     * @return PersonnelBuilder qui est notre builder.
	     * 
	     */
		public PersonnelBuilder addNumeroTelephone(ClasseTele numeroTelephone) {
			this.tel.add(numeroTelephone);
			return this;
		}
		/**
		 * @return un objet de type Personne, c'est l'objet que on a crée.
	     * 
	     */
		public Personnel build() {
			return new Personnel(this);
		}
	}
	
	
/**
* Constructor Personnel qu'inisialise les informations d'un personnel a partir 
* de notre  builder
 * @param builder de type PersonnelBuilder qui va nous permetre d'initialiser les informations 
 * d'un personnel.
 * */
Personnel(PersonnelBuilder builder) {
	nom = builder.nom;
	prenom = builder.prenom;
	fonc = builder.fonc;
	date = builder.date;
	tel = builder.tel;
	idPerso=PersonnelBuilder.idPerso;
}
/**
 * 
 * @return nom d'un personnel.
 * 
 * @see nom.
 */
	public String getNom() {
		return nom;
	}
	/**
     * 
     * @return prenom d'un personnel.
     * 
     * @see prenom.
     */
	public String getPrenom() {
		return prenom;
	}
	/**
     * 
     * @return le Id d'un personnel.
     * 
     * @see idPerso.
     */
	public int getIdPersonne() {
		return this.idPerso;
	}
	/**
     * 
     * @return la liste des telephone sd'un personnel.
     * 
     * @see tel.
     */
	public List<ClasseTele> getTel() {
		return ( List<ClasseTele>) Collections.unmodifiableList(this.tel);

		
	}
	/**
     * 
     * @return la fonction d'un personnel de type Fonction.
     * 
     * @see fonc.
     */
	public Fonction getFonc() {
		return fonc;
	}
	/**
     * Retourne La date de naissance d'un personnel de type LocalDate.
     * 
     * @return la date de naissance.
     * 
     * @see date.
     */
	public LocalDate getDate() {
		return date;
	}
	/**
	 *la methode print elle aaffiche 
	 *les informations d'un personnel. 
     * 
     */
	public void print() {
		System.out.println(" Je suis le personnel numéro  : " + this.idPerso +" Mon nom est "+this.nom+" "+this.prenom);
		
	}
}
