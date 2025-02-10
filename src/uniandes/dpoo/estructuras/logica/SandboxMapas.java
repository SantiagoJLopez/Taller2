package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	Object[] arregloCadenas = mapaCadenas.values().toArray();
        List<String> listaCadenas = new LinkedList<String>( );
        Arrays.sort(arregloCadenas);
        for (int pos=0; pos<arregloCadenas.length; pos++)
        {
        	listaCadenas.addLast(arregloCadenas[pos].toString());
        }
        return listaCadenas;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	Object[] arregloCadenas = mapaCadenas.keySet().toArray();
        List<String> listaCadenas = new LinkedList<String>( );
        for (int pos=0; pos<arregloCadenas.length; pos++)
        {
        	listaCadenas.addLast(arregloCadenas[pos].toString());
        }
        Collections.sort(listaCadenas, Collections.reverseOrder());
        return listaCadenas;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if (mapaCadenas.keySet().size() > 0)
    	{
    		List<String> listaCadenas = getLlavesComoListaInvertida( );
        	return listaCadenas.getLast();
    	}
    	else
    	{
    		return null;
    	}
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if (mapaCadenas.keySet().size() > 0)
    	{
    		List<String> listaCadenas = getValoresComoLista( );
        	return listaCadenas.getLast();
    	}
    	else
    	{
    		return null;
    	}
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Object[] collectionLlaves =  mapaCadenas.keySet().toArray();
    	Collection<String> collectionMayus = new LinkedList<String>();
    	for (Object llave : collectionLlaves)
    	{
    		collectionMayus.add(llave.toString().toUpperCase());
    	}
    	return collectionMayus;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	Object[] arregloCadenas = mapaCadenas.keySet().toArray();
    	List<String> listaCadenas = new LinkedList<String>( );
    	for (int pos=0; pos<arregloCadenas.length; pos++)
    	{
    		listaCadenas.addLast(arregloCadenas[pos].toString());
    	}
    	return listaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String anedac = "";
    	for (int i = 0; i < cadena.length(); i++)
    	{
    		anedac = cadena.charAt(i) + anedac;
    	}
    	mapaCadenas.put(anedac, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	if (mapaCadenas.containsKey(llave))
    	{
    		mapaCadenas.remove(llave);
    	}
    	
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	if (mapaCadenas.containsValue(valor))
    	{
    		String anedac = "";
        	for (int i = 0; i < valor.length(); i++)
        	{
        		anedac = valor.charAt(i) + anedac;
        	}
        	mapaCadenas.remove(anedac, valor);
    	}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	for (int i=0; i<objetos.size(); i++)
    	{
    		agregarCadena(objetos.get(i).toString());
    	}
    	
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Object[] arregloCadenas = mapaCadenas.keySet().toArray();
    	Map<String, String> copiaCadenas = new HashMap<String, String>( );
    	for (int pos=0; pos<arregloCadenas.length; pos++)
    	{
    		String cadena = mapaCadenas.get(arregloCadenas[pos]);
    		copiaCadenas.put(arregloCadenas[pos].toString().toUpperCase(), cadena);
    	}
    	mapaCadenas = copiaCadenas;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean completo = true;
    	for (int pos=0; pos<otroArreglo.length; pos++)
    	{
    		if (mapaCadenas.containsValue(otroArreglo[pos]) == false)
    		{
    			completo = false;
    		}
    	}
    	return completo;
    }

}
