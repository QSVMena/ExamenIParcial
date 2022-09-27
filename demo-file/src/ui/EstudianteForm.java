package ui;

import java.util.Date;
import java.util.Scanner;
import dol.Estudiante;
import misc.DateUtil;

public class EstudianteForm {

	Scanner scan;
	Estudiante estudiante;
	
	public EstudianteForm(Scanner scanner) {
		scan = scanner;
	}
	
	public EstudianteForm(Estudiante es) {
		estudiante = es;
	}
	
	public Estudiante catchEstudents() {
		
		Estudiante e = new Estudiante();
		
		System.out.println("Primer nombre: ");
		e.setFirstName(scan.next());
		
		System.out.println("Segundo nombre: ");
		e.setMiddleName(scan.next());
		
		System.out.println("Primer apellido: ");
		e.setSurName(scan.next());
		
		System.out.println("Segundo apellido: ");
		e.setSecondSurname(scan.next());
		
		System.out.println("Género: ");
		e.setGender(scan.next());
		
		System.out.println("Numero de Carnet: ");
		e.setNumerodeCarnet(scan.next());
		
		Date date = DateUtil.catchValidDate(scan, "Fecha de inscripcion (dd/MM/yyyy): ");
		e.setFechadeInscripcion(date);
			
		return e;
	}
	
	public void showEstudents() {
		
        System.out.printf("Primer nombre: %s\n" , estudiante.getFirstName());		
		
		System.out.printf("Segundo nombre: %s\n", estudiante.getMiddleName());
		
		System.out.printf("Primer apellido: %s\n", estudiante.getSurName());
		
		System.out.printf("Segundo apellido: %s\n", estudiante.getSecondSurname());
		
		System.out.printf("Género: %s\n", estudiante.getGender());
		
		System.out.printf("Numero de Carnet: %s\n",estudiante.getNumerodeCarnet());
		
		System.out.printf("Fecha de nacimiento: %s\n", DateUtil.dateToString(estudiante.getFechadeInscripcion(), "dd/MM/yyyy"));	
	}
}
