package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase abstracta define el contrato para las posibles calculadoras de tarifa e implementa algunos métodos que pueden ser utilizadas en varias implementaciones.
 */
public abstract class CalculadoraTarifas 
{
	/**
	 * El porcentaje que corresponde al impuesto sobre la costo base
	 */
	static double IMPUESTO = 0.28;

	public CalculadoraTarifas() 
	{

	}
	
	/**
	 * Este método calcula cuál debe ser el costo base dado el vuelo y el cliente.
	 * @param vuelo
	 * @param cliente
	 */
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	/**
	 * Calcula el porcentaje de descuento que se le debería dar a un cliente dado su tipo y/o su historia.
	 * @param cliente
	 */
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	/**
	 * Calcula la distancia aproximada en kilómetros para una ruta
	 * @param ruta
	 */
	protected int calcularDistanciaVuelo(Ruta ruta) 
	{
		return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino()); 
	}
	
	/**
	 * Este método calcula cuál debe ser la tarifa total para un vuelo, dado el vuelo y el cliente.
	 * @param vuelo
	 * @param cliente
	 */
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) 
	{
		int costoBase = calcularCostoBase(vuelo, cliente);
		
		double descuento = calcularPorcentajeDescuento(cliente) * costoBase;
		int impuestos = calcularValorImpuestos(costoBase);
		
		return (int) ((costoBase + impuestos) - descuento);
	}
	
	/**
	 * Calcula el valor de los impuestos para un tiquete, dado el costo base.
	 * @param costoBase
	 */
	protected int calcularValorImpuestos(int costoBase) 
	{
		return (int) (costoBase * IMPUESTO);
	}
}
