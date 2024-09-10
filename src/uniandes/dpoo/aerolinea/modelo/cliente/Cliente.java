package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase abstracta define e implementa los aspectos que son comunes para todos los tipos de clientes de la Aerolínea 
 * 
 * Cada cliente, sin importar su tipo, tiene una lista de tiquetes usados y sin usar.
 */
public abstract class Cliente 
{
	/**
	 * La lista de tiquetes sin usar del cliente
	 */
	public List<Tiquete> tiquetesSinUsar;
	
	/**
	 * La lista de tiquetes usados del cliente
	 */
	public List<Tiquete> tiquetesUsados;
	
	/**
	 * Inicializa las listas de tiquetes del cliente
	 */
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete>( );
		this.tiquetesUsados = new ArrayList<Tiquete>( );
	}
	
	/**
	 * Retorna el tipo de cliente
	 */
	public abstract String getTipoCliente();
	
	/**
	 * Retorna el identificador del cliente
	 */
	public abstract String getIdentificador();
	
	/**
	 * Agrega un nuevo tiquete a la lista de tiquetes (sin usar) que ha comprado el cliente
	 * @param tiquete
	 */
	public void agregarTiquete(Tiquete tiquete) 
	{
		this.tiquetesSinUsar.add(tiquete);
	}
	
	/**
	 * Calcula el valor total de los tiquetes que ha comprado un cliente
	 */
	public int calcularValorTotalTiquetes() 
	{
		int valorTotal = 0;
		
		for (Tiquete tiquete : tiquetesSinUsar) {
			valorTotal += tiquete.getTarifa();
		}
		
		for (Tiquete tiquete : tiquetesUsados) {
			valorTotal += tiquete.getTarifa();
		}
		
		return valorTotal;
	}
	
	/**
	 * Marca como usados todos los tiquetes del cliente que se hayan realizado en el vuelo que llega por parámetro, 
	 * 
	 * moviéndolos de la lista de tiquetes sin usar a la lista de tiquetes usados
	 * @param vuelo
	 */
	public void usarTiquetes(Vuelo vuelo) 
	{
		Collection<Tiquete> tiquetesVuelo = vuelo.getTiquetes();
		
		for ( Tiquete tiquete : tiquetesVuelo ) {
			tiquete.marcarComoUsado();
			
			if ( tiquetesSinUsar.contains(tiquete) ) {
				tiquetesSinUsar.remove(tiquete);
			}
			
			tiquetesUsados.add(tiquete);
		}
	}
}
