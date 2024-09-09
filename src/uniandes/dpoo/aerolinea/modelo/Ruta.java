package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    /**
     * El código para la ruta
     */
    private String codigoRuta;
    
    /**
     * El aeropuerto destino de la ruta
     */
    private Aeropuerto destino;
    
    /**
     * La hora esperada de llegada, expresada con una cadena de cuatro dígitos.
     */
    private String horaLlegada;
    	
    /**
     * La hora esperada de salida, expresada con una cadena de cuatro dígitos.
     */
    private String horaSalida;
    
    /**
     * El aeropuerto origen de la ruta
     */
    private Aeropuerto origen;

    /**
     * Construye una nueva ruta con los parametros dados
     */
    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) 
    {
		this.origen = origen;
		this.destino = destino;	
    	this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.codigoRuta = codigoRuta;
	}
    
	public Aeropuerto getOrigen() 
	{
		return origen;
	}
	
	public Aeropuerto getDestino() 
	{
		return destino;
	}
	
	public String getHoraSalida() 
	{
		return horaSalida;
	}

	public String getHoraLlegada() 
	{
		return horaLlegada;
	}

	public String getCodigoRuta() 
	{
		return codigoRuta;
	}
	
	
    /**
     * Calcula la duración esperada del vuelo en minutos
     */
	public int getDuracion() 
	{
		int horas = getHoras( getHoraLlegada() ) - getHoras ( getHoraSalida() );
		int minutos = getMinutos ( getHoraLlegada() ) - getMinutos ( getHoraSalida() );
		
		return ( horas * 60 ) + minutos;
	}

	/**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

    
}
