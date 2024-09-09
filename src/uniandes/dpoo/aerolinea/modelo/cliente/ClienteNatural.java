package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente 
{
	/**
	 * La constante usada para identificar el tipo de cliente
	 */
	static String NATURAL = "Natural";
	
	/**
	 * El nombre del cliente
	 */
	private String nombre;

	/**
	 * Construye un nuevo cliente natural dado su nombre
	 */
	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}

	@Override
	public String getIdentificador() {
		return null;
	}

}
