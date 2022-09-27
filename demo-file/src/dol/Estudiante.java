package dol;
import java.util.Date;

public class Estudiante extends Person{

	private String NumerodeCarnet;
	private Date FechadeInscripcion;
	
    public Estudiante() {
		
	}
	
	public Estudiante(String NumerodeCarnet,Date FechadeInscripcion){
		super();
		this.NumerodeCarnet = NumerodeCarnet;
		this.FechadeInscripcion = FechadeInscripcion;
	}
	
	public String getNumerodeCarnet() {
		return NumerodeCarnet;
	}
	public void setNumerodeCarnet(String numerodeCarnet) {
		NumerodeCarnet = numerodeCarnet;
	}
	public Date getFechadeInscripcion() {
		return FechadeInscripcion;
	}
	public void setFechadeInscripcion(Date fechadeInscripcion) {
		FechadeInscripcion = fechadeInscripcion;
	}
	
	
}
