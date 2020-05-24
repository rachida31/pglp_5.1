package uvsq.M1.td1.Exo5_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * implemantation de la classe abstract Serialisation .
 * @param <T> .
 * @author rachida ouchene.
 */
public abstract class Serialisation<T extends Serializable> {
	/**
	 * Elle permet d'ecrire d'un fichier l'objet passer en
	 * parametre si tout est bien passé l'objet saura ecrit
	 * ensuite le fichier saura fermé sinon une exception se generera.
	 * @param obj L'objet à ecrire qu'est de type Personnel ou de tye
	 * CompositePersonnel .
	 * @param filename .
	 * @exception IOException
	 */
	public final void writeFile(final T obj, final String filename) {
		ObjectOutputStream oos = null;
		try {
			final BufferedOutputStream fichier = new
					BufferedOutputStream(new
							FileOutputStream(
							filename));
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(obj);
			oos.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			closeFile(oos);
		}
	}

	/**
	 * Elle permet de fermer un fichier si toutes est bien
	 * passe le fichier saura
	 * fermer sinon un exception se generera.
	 * @param oos est le flux de fichier a fermer.
	 * @exception IOException.
	 */
	public final void closeFile(final ObjectOutputStream oos) {
		try {
			if (oos != null) {
				oos.flush();
				oos.close();
			}
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Elle permit de supprimer un fichier si il existe sinon
	 * une exception est géneré .
	 * @param filename Le nom de fichier que on veut supprimer .
	 * @throws InExistFille .
	 */
	public final void deleteFile(final String filename)
			throws InExistFille {
		File file = new File(filename);
		if (exists(filename)) {
			if (file.delete()) {
				System.out.println("Objet supprimé!"); }
			else {
				throw new InExistFille();
			}
		} else {
			throw new InExistFille();
		}
	}

	/**
	 * Retourne un boolean 1 si le fichier existe 0 sinon .
	 * @param filename le nom de fichier que on verifier
	 * si il existe ou non.
	 * @return return un booleen si le file existe ou non.
	 */
	private  boolean exists(final String filename) {
		File file = new File(filename);
		return file.exists();
	}

	/**
	 * Elle lit le contenue d'un fichier en suite renvoit cette
	 * objet lu qu'est de type Personnel ou de type
	 * CompositePersonnel si tous est bien sinon elle genere une exception .
	 * @exception ClassNotFoundException
	 * @exception IOException
	 * @param filename Le nom de fichier que on va lire.
	 * @return obj qu'est l'Objet lu .
	 * @see type
	 */
	public final T readFile(final String filename) {
		ObjectInputStream in = null;
		System.out.println(filename);
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(filename)));
			return (T) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Elle permit de crer un fichier puis appler pa fonction
	 * writeFile pour ecrire le contenue de obj dans le fichier .
	 * @param obj est un objet de type Personnel ou CompisitePersonnel.
	 * @param filename Le nom de fichier a cree.
	 */
	public final void createFile(final T obj, final String filename) {
		if (exists(filename)) {
			System.out.println("Création impossible");
		} else {
			writeFile(obj, filename);
		}
	}

	/**
	 * elle permet de modifier un fichier si le fichier
	 * n'existe pas elle genere une excepetion de type
	 * InExistFille qui est definie.
	 * @param obj  est un objet soit de type Personnel soit de type
	 * compositePersonnel.
	 * @param filename Le nom de fichier que on generer un nouveau .
	 * @param file Le nom de fichier que on veut modifier.
	 * @exception InExistFille .
	 */
	public final void updateFile(final T obj, final String filename, final
			String file) throws InExistFille {
		if (!exists(file)) {
			throw new InExistFille();
		} else {
			deleteFile(file);
			writeFile(obj, filename);

		}
	}

}
