package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
	/**
	 * La constante usada para identificar el tipo de cliente
	 */
    static String CORPORATIVO = "Corporativo";
    
    /**
     * La constante utilizada para indicar que la empresa es grande
     */
    static int GRANDE = 1;
    
    /**
     * La constante utilizada para indicar que la empresa es mediana
     */
    static int MEDIANA = 2;
    
    /**
     * La constante utilizada para indicar que la empresa es pequena
     */
    static int PEQUENA = 3;
    
    /**
     * El nombre de la empresa
     */
    private String nombreEmpresa;
    
    /**
     * El tamaño de la empresa.
     */
    private int tamanoEmpresa;
   
    /**
     * Construye un nuevo ClienteCorporativo e inicializa sus atributos usando los parámetros
     */
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
    	super();
		this.nombreEmpresa = nombreEmpresa;
		this.tamanoEmpresa = tamanoEmpresa;
	}

    /**
     * Retorna el nombre de la empresa
     */
	public String getNombreEmpresa() 
	{
		return nombreEmpresa;
	}

	/**
	 * Retorna el tamaño de la empresa: PEQUENA, MEDIANA, GRANDE
	 */
	public int getTamanoEmpresa() 
	{
		return tamanoEmpresa;
	}

	@Override
	public String getTipoCliente() 
	{
		return CORPORATIVO;
	}
	
	@Override
	public String getIdentificador() 
	{
		return null;
	}

	/**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
