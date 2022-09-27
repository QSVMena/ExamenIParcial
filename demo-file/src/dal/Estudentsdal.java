package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dol.Estudiante;
import dol.Person;

public class Estudentsdal extends PersonDal {
	private Estudiante estudiante;
	private String filePath;
	private String fileName;
	
	public Estudentsdal() {
		super();
	}
	
	public void save() {
		if(fileName.trim().length()==0) {
			fileName = estudiante.getNumerodeCarnet().trim() + estudiante.getFechadeInscripcion() + ".dat";
		}
		
		File file = new File(filePath + "\\" + fileName);

        ObjectOutputStream w;
		try {
			w = new ObjectOutputStream(new FileOutputStream(file));
	        w.writeObject(getPerson());
	        w.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public Estudiante open() {
        try{
        	File file = new File(filePath);
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            return (Estudiante)ois.readObject();
        }
        catch(FileNotFoundException e){
        	e.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
        	ex.printStackTrace();
        }
        return null;
	}

}
