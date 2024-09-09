package uniandes.dpoo.aerolinea.modelo;

/**
 * En esta clase se organiza la información básica de los aviones que realizan los vuelos.
 */
public class Avion 
{
	/**
	 * La capacidad del avión
	 */
	private int capacidad;
	
	/**
	 * El nombre con el que se identifica al avión
	 */
	private String nombre;
	
	/**
	 * Construye un avión con un determinado nombre y capacidad
	 */
	public Avion(String nombre, int capacidad) 
	{
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	public String getNombre() 
	{	
		return nombre;
	}
	
	public int getCapacidad() 
	{
		return capacidad;
	}
}
