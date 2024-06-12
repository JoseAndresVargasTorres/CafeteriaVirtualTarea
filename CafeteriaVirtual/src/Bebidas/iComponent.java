package Bebidas;

/**
 * Interfaz iComponent para componentes de bebidas.
 * Esta interfaz define métodos esenciales que deben ser implementados por cualquier componente de bebida,
 * lo que permite obtener el precio y la descripción de la bebida.
 *
 * @author José Andrés Vargas Torres
 * @author Melissa Vásquez
 */
public interface iComponent {

    /**
     * Método para obtener el precio del componente de bebida.
     * @return El precio del componente como un entero.
     */
    int getPrecio();

    /**
     * Método para obtener la descripción del componente de bebida.
     * @return La descripción del componente como una cadena de texto.
     */
    String getDescripcion();
}
