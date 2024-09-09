package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase tiene la información de un vuelo particular que cubre una ruta y se lleva a cabo en una cierta fecha. 
 * 
 * Los vuelos son las unidades a las cuales están asociadas las ventas de tiquetes.
 */
public class Vuelo 
{
	/**
	 * El avión utilizado para realizar el vuelo
	 */
	private Avion avion;
	
	/**
	 * La fecha para el vuelo, expresada como una cadena de la forma YYYY-MM-DD
	 */
	private String fecha;
	
	/**
	 * La ruta que tiene el vuelo
	 */
	private Ruta ruta;
	
	/**
	 * Los tiquetes que ya fueron vendidos para el vuelo
	 */
	private Map<String, Tiquete> tiquetes;

	/**
	 * Crea un nuevo vuelo con los parámetros dados.
	 */
	public Vuelo(Avion avion, String fecha, Ruta ruta) 
	{
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = new HashMap<String, Tiquete>( );
	}
	
	public Avion getAvion() 
	{
		return avion;
	}

	public String getFecha() 
	{
		return fecha;
	}

	public Ruta getRuta() 
	{
		return ruta;
	}

	public Collection<Tiquete> getTiquetes() 
	{
		return tiquetes.values();
	}
	
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(avion, other.avion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(ruta, other.ruta);
	}
	
	/**
	 * Vende una determinada cantidad de tiquetes para el vuelo y los deja registrados en el mapa de tiquetes
	 */
	 public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) 
	 {
		 int valorTotal = 0;
		 
		 for (int i = 0; i < cantidad; i++) {
			 int tarifa = calculadora.calcularTarifa(this, cliente);
			 
			 Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			 this.tiquetes.put(tiquete.getCodigo(), tiquete);
			 
			 valorTotal += tarifa;
		 }
		 
		 return valorTotal;
	 }
}
