package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas 
{
	/**
	 * El costo por kilómetro en temporada baja para clientes corporativos
	 */
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	
	/**
	 * El costo por kilómetro en temporada baja para personas naturales
	 */
	protected int COSTO_POR_KM_NATURAL = 600;
	
	/**
	 * El descuento que se le puede aplicar a empresas grandes
	 */
	protected double DESCUENTO_GRANDES = 0.2;
	
	/**
	 * El descuento que se le puede aplicar a empresas medianas
	 */
	protected double DESCUENTO_MEDIANAS = 0.1;
	
	/**
	 * El descuento que se le puede aplicar a empresas pequeñas
	 */
	protected double DESCUENTO_PEQ = 0.02;
	
	
	public CalculadoraTarifasTemporadaBaja() 
	{

	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) 
	{
		int distancia = super.calcularDistanciaVuelo(vuelo.getRuta());
		String tipo = cliente.getTipoCliente();
		
		if ( tipo.equals("Corporativo") ) {
			return COSTO_POR_KM_CORPORATIVO * distancia;
		}
		else if ( tipo.equals("Natural") ) {
			return COSTO_POR_KM_NATURAL * distancia;
		}
		
		return 0;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) 
	{
		String tipo = cliente.getTipoCliente();
		double descuento = 0;
		
		if ( tipo.equals("Corporativo") ) {
			ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
			
			int tamanoEmpresa = clienteCorporativo.getTamanoEmpresa();
			
			if ( tamanoEmpresa == 3 ) {
				descuento = DESCUENTO_PEQ;
			}
			else if ( tamanoEmpresa == 2 ) {
				descuento = DESCUENTO_MEDIANAS;
			}
			else if ( tamanoEmpresa == 1 ) {
				descuento = DESCUENTO_GRANDES;
			}
			
		}
		
		return descuento;
	}

}
