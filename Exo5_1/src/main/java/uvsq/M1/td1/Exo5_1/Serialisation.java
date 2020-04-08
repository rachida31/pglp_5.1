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
import java.time.LocalDateTime;
public abstract class Serialisation<T extends Serializable> {

	public void write(String string) {
			System.out.println(LocalDateTime.now() + " :  " + string);
		}
		

		public void writeFile(T obj, String filename) {
			ObjectOutputStream	oos = null;
			try {
				final BufferedOutputStream fichier =new BufferedOutputStream(new FileOutputStream(filename));
			      oos = new ObjectOutputStream(fichier);

				oos.writeObject(obj);
				write("Objet " + obj.getClass() + " est créé!");
				oos.flush();

			} catch (IOException e) {
				write(e.getMessage());
			}finally 
			{
				closeFile(oos);
			}
		}
		public void closeFile(ObjectOutputStream oos) {
			try {
		        if (oos != null) {
		          oos.flush();
		          oos.close();
		        }
		      } catch (final IOException ex) {
		        ex.printStackTrace();
		      }}
		
		
		public void deleteFile(String filename) {
			File file = new File(filename); 
			if(exists(filename)) {
	        if(file.delete()) write("Objet supprimé!"); 
	        else write("Suppression impossible");
		}else
		{
		write("Le fichier n\'existe pas");

			}
		}
		
		private boolean exists(String filename) {
			File file = new File(filename); 
	        return file.exists();
		}
		
		public T findFile(String filename) {
			ObjectInputStream in =null;
			try {
				in=new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(filename)));
				T obj = (T) in.readObject();
				write("Objet " + obj.getClass() + " est lu!");
				return obj;
			} catch (ClassNotFoundException | IOException e) {
				write(e.getMessage());
				return null;
			}
		}
		
		public T createFile(T obj, String filename) {
			if (exists(filename)) {
				write("Création impossible");
				return null;
			}
			else {
				writeFile(obj, filename);
				return obj;
			}
		}
		
		public void  updateFile(T obj, String filename,String s1) {
			if (!exists(filename)) {
				write("Mise à jour impossible");
			}
			else {
				deleteFile(filename);
				writeFile(obj, s1);
		
		
			}}
		
		
		
		
		
		
	}

