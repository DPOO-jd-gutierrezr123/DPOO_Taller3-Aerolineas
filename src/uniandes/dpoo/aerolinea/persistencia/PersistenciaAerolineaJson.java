package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteTiqueteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea 
{
    @Override
    public void cargarAerolinea( String archivo, Aerolinea aerolinea )
    {
        // No está implementado (y no es necesario para el taller)
    }

    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea )
    {
        // No está implementado (y no es necesario para el taller)
    }
    
}