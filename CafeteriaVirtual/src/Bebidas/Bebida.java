package Bebidas;

/**
 * Clase abstracta Bebida que implementa la interfaz iComponent.
 * Define la estructura básica de cualquier bebida con un precio y descripción.
 */
public abstract class Bebida implements iComponent {

    // Precio de la bebida
    int precio;

    // Descripción de la bebida
    String descripcion;

    /**
     * Constructor para crear una nueva bebida con precio y descripción.
     * @param precio Precio de la bebida
     * @param descripcion Descripción de la bebida
     */
    public Bebida(int precio, String descripcion){
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Método implementado de iComponent para obtener el precio de la bebida.
     * @return Precio de la bebida
     */
    @Override
    public int getPrecio(){
        return this.precio;
    }

    /**
     * Método implementado de iComponent para obtener la descripción de la bebida.
     * @return Descripción de la bebida
     */
    @Override
    public String getDescripcion(){
        return this.descripcion;
    }
}

/**
 * Clase CafeAmericano que extiende de Bebida.
 * Define un café americano con un precio específico y descripción.
 */
class CafeAmericano extends Bebida{

    public CafeAmericano(){
        super(2000, "Cafe Americano");
    }
}

/**
 * Clase CafeExpresso que extiende de Bebida.
 * Define un café expresso con un precio específico y descripción.
 */
class CafeExpresso extends Bebida {

    public CafeExpresso(){
        super(2500, "Cafe Expresso");
    }
}

/**
 * Clase CafeHelado que extiende de Bebida.
 * Define un café helado con un precio específico y descripción.
 */
class CafeHelado extends Bebida {

    public CafeHelado(){
        super(2300, "Cafe Helado");
    }
}

/**
 * Clase CafeMoca que extiende de Bebida.
 * Define un café moca con un precio específico y descripción.
 */
class CafeMoca extends Bebida {

    public CafeMoca(){
        super(2700, "Cafe Moca");
    }
}

/**
 * Clase Capuchino que extiende de Bebida.
 * Define un capuchino con un precio específico y descripción.
 */
class Capuchino extends Bebida {

    public Capuchino(){
        super(2600, "Capuchino");
    }
}

/**
 * Clase ChocolateCaliente que extiende de Bebida.
 * Define un chocolate caliente con un precio específico y descripción.
 */
class ChocolateCaliente extends Bebida {

    public ChocolateCaliente(){
        super(2200, "Chocolate Caliente");
    }
}

/**
 * Clase LatteVainilla que extiende de Bebida.
 * Define un latte de vainilla con un precio específico y descripción.
 */
class LatteVainilla extends Bebida {

    public LatteVainilla(){
        super(2800, "Latte Vainilla");
    }
}

/**
 * Clase TeVerdeconHierbabuena que extiende de Bebida.
 * Define un té verde con hierbabuena con un precio específico y descripción.
 */
class TeVerdeconHierbabuena extends Bebida {

    public TeVerdeconHierbabuena(){
        super(2000, "Te Verde con Hierbabuena");
    }
}
