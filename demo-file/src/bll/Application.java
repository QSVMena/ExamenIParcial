package bll;
import java.util.Scanner;
import dal.Estudentsdal;
import dal.PersonDal;
import ui.EstudianteForm;
import ui.PersonForm;

public class Application {
	private Scanner scan;
	
	public Application() {
		 scan = new Scanner(System.in);
	}
	
	public void displayOptions() {
		System.out.println("1: Gestionar personas");
		System.out.println("2: Gestionar Estudiante");
		System.out.println("3: Salir");
		int Opcion=0;
    	Opcion= scan.nextInt();
	    
	    do {
	    	switch(Opcion) {
	    	case 1:
	    		do {
	    			System.out.println("Gestionar personas");
			    	System.out.println("1. Agregar");
					System.out.println("2. Mostrar");
					System.out.println("3. Volver");
					Opcion = scan.nextInt();
					
					switch (Opcion) {
					case 1:
						save();
						break;
					case 2:
						open();
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Opción no válida.");
						break;
				   }	
	    			
	    		}while(Opcion!= 3);
	    		
				
	    	case 2:
	    		do {
	    			System.out.println("Gestionar Estudiantes");
			    	System.out.println("1. Agregar");
					System.out.println("2. Mostrar");
					System.out.println("3. Volver");
					Opcion = scan.nextInt();
					
					switch (Opcion) {
					case 1:
						EstudianteForm ef = new EstudianteForm(scan);
						Estudentsdal ed = new Estudentsdal();
						ed.setPerson(ef.catchEstudents());
						
						System.out.println("Por favor indica la ruta para guardar el archivo: ");
						String filePath = scan.next();
						System.out.println("Por favor indica el nombre del archivo: ");
						String fileName = scan.next();
						
						ed.setFilePath(filePath);
						ed.setFileName(fileName);
						ed.save();
						break;
					case 2:
						System.out.println("Por favor indica la ruta del archivo a abrir");
						String FilePath = scan.next();
						Estudentsdal eds = new Estudentsdal();
						eds.setFilePath(FilePath);
						EstudianteForm efs = new EstudianteForm(eds.open());
						efs.showEstudents();
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Opción no válida.");
						break;
		    	   }
	    		}while(Opcion!= 3);
	    		
	    	}
	    		
	    }while(Opcion!= 3);
		
	}

	public void save() {
		PersonForm pf = new PersonForm(scan);
		PersonDal pd = new PersonDal();
		pd.setPerson(pf.catchPerson());
		
		System.out.println("Por favor indica la ruta para guardar el archivo: ");
		String filePath = scan.next();
		System.out.println("Por favor indica el nombre del archivo: ");
		String fileName = scan.next();
		
		pd.setFilePath(filePath);
		pd.setFileName(fileName);
		pd.save();
	}
	
	public void open() {
			
		System.out.println("Por favor indica la ruta del archivo a abrir");
		String filePath = scan.next();
		PersonDal pd = new PersonDal();
		pd.setFilePath(filePath);
		PersonForm pf = new PersonForm(pd.open());
		pf.showPerson();
		
	}

}
