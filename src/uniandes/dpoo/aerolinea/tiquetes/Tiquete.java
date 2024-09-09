package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase agrupa la información de un tiquete, expedido para un vuelo específico en una cierta fecha, y que fue comprado por un cliente. 
 * 
 * Cuando se crea, un tiquete no está usado. 
 * 
 * Después de que se haya realizado el vuelo, el tiquete debe quedar marcado como usado.
 */
public class Tiquete 
{
	/**
	 * El cliente que compró el tiquete
	 */
	private Cliente cliente;
	
	/**
	 * El cliente que compró el tiquete
	 */
	private String codigo;
	
	/**
	 * El valor que debió pagar el cliente por este tiquete
	 */
	private int tarifa;
	
	/**
	 * Este atributo indica si un tiquete ya fue usado o no
	 */
	private boolean usado;
	
	/**
	 * El vuelo en el que se usará el tiquete
	 */
	private Vuelo vuelo;

    /**
     * Crea un nuevo tiquete con los parámetros recibidos y se lo agrega al cliente que lo compró
     */
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) 
	{
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.vuelo = vuelo;
		this.usado = false;
		
		clienteComprador.agregarTiquete(this);
	}
	
	public Cliente getCliente() 
	{
		return cliente;
	}

	public String getCodigo() 
	{
		return codigo;
	}

	public int getTarifa() 
	{
		return tarifa;
	}

	public Vuelo getVuelo() 
	{
		return vuelo;
	}
	
	/**
	 * Indica si el tiquete ya fue usado
	 */
	public boolean esUsado() 
	{
		return usado;
	}
	
	/**
	 * Cambia el estado del tiquete para marcarlo como usado
	 */
	public void marcarComoUsado() 
	{
		this.usado = true;
	}
}
