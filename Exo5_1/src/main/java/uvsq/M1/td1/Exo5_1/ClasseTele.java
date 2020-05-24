package uvsq.M1.td1.Exo5_1;

import java.io.Serializable;

/**
 * implemantation de la classe ClasseTele
 * pour definir un telephone.
 * @author rachida ouchene.
 */
public class ClasseTele implements Serializable {
	/**
	 * contrôleur de la version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * le type de telephone qu'est de type
	 * enum, soit portable soit pro .
	 * @see ClasseTele#ClasseTele().
	 * @see ClasseTele#getType().
	 */
	private Telephone type;
	/**
	 * le numero de telephone qu'est de type
	 * String.
	 * @see ClasseTele#ClasseTele()
	 * @see ClasseTele#getNum()
	 */
	private String num;

	/**.
	 * Constructor ClasseTele qu'inisialise @see type par le type et
	 * @see num par num.
	 * @param type1  le type de telephone qui eqt une enum.
	 * @param num1   le numero de telephone .
	 */
	public ClasseTele(final Telephone type1, final
			String num1) {
		this.num = num1;
		this.type = type1;
	}

	/**
	 * Retourne Le type de telephone.
	 * @return type.
	 * @see type
	 */
	public final Telephone getType() {
		return type;
	}

	/**
	 * Retourne Le numero de telephone.
	 * @return numero.
	 * @see num.
	 */
	public final String getNum() {
		return num;
	}

}
