package Bebidas;

/**
 * Clase abstracta AbstractDecorator que implementa la interfaz iComponent.
 * Esta clase se usa para añadir nuevas funcionalidades (decoraciones) a las bebidas.
 * Extiende las propiedades de la bebida con precio y descripción adicionales.
 */
public class AbstractDecorator implements iComponent {

    // Componente base que será decorado
    protected iComponent bebida;

    // Precio adicional de la decoración
    int precio;

    // Descripción de la decoración
    String descripcion;

    // Constructor de la clase AbstractDecorator
    public AbstractDecorator(iComponent bebida, int precio, String descripcion){
        this.bebida = bebida;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Método que retorna el precio de la bebida incluyendo el precio de la decoración
    @Override
    public int getPrecio(){
        return bebida.getPrecio() + this.precio;
    }

    // Método que retorna la descripción de la bebida incluyendo la descripción de la decoración
    @Override
    public String getDescripcion() {
        return bebida.getDescripcion() + " + " + this.descripcion;
    }
}

/**
 * Clase LecheDeslactosada que extiende de AbstractDecorator
 * Añade leche deslactosada a la bebida.
 */
class LecheDeslactosada extends AbstractDecorator{
    public LecheDeslactosada(iComponent bebida) {
        super(bebida, 200, "Leche Deslactosada");
    }
}

/**
 * Clase LecheEntera que extiende de AbstractDecorator
 * Añade leche entera a la bebida.
 */
class LecheEntera extends AbstractDecorator{
    public LecheEntera(iComponent bebida) {
        super(bebida, 300, "Leche Entera");
    }
}

/**
 * Clase LechesinLactosa que extiende de AbstractDecorator
 * Añade leche sin lactosa a la bebida.
 */
class LechesinLactosa extends AbstractDecorator{
    public LechesinLactosa(iComponent bebida) {
        super(bebida, 200, "Leche sin lactosa");
    }
}

/**
 * Clase Stevia que extiende de AbstractDecorator
 * Añade stevia como edulcorante a la bebida.
 */
class Stevia extends AbstractDecorator {
    public Stevia(iComponent bebida) {
        super(bebida, 50, "Stevia");
    }
}

/**
 * Clase Miel que extiende de AbstractDecorator
 * Añade miel a la bebida.
 */
class Miel extends AbstractDecorator {
    public Miel(iComponent bebida) {
        super(bebida, 150, "Miel");
    }
}

/**
 * Clase Azucar que extiende de AbstractDecorator
 * Añade azúcar a la bebida.
 */
class Azucar extends AbstractDecorator {
    public Azucar(iComponent bebida) {
        super(bebida, 50, "Azúcar");
    }
}

/**
 * Clase Sirope que extiende de AbstractDecorator
 * Añade sirope a la bebida.
 */
class Sirope extends AbstractDecorator {
    public Sirope(iComponent bebida) {
        super(bebida, 100, "Sirope");
    }
}

/**
 * Clase Vanilla que extiende de AbstractDecorator
 * Añade vainilla a la bebida.
 */
class Vanilla extends AbstractDecorator {
    public Vanilla(iComponent bebida) {
        super(bebida, 100, "Vanilla");
    }
}

/**
 * Clase Caramelo que extiende de AbstractDecorator
 * Añade caramelo a la bebida.
 */
class Caramelo extends AbstractDecorator {
    public Caramelo(iComponent bebida) {
        super(bebida, 100, "Caramelo");
    }
}

/**
 * Clase Canela que extiende de AbstractDecorator
 * Añade canela a la bebida.
 */
class Canela extends AbstractDecorator {
    public Canela(iComponent bebida) {
        super(bebida, 50, "Canela");
    }
}

/**
 * Clase CremaBatida que extiende de AbstractDecorator
 * Añade crema batida a la bebida.
 */
class CremaBatida extends AbstractDecorator {
    public CremaBatida(iComponent bebida) {
        super(bebida, 200, "Crema Batida");
    }
}

/**
 * Clase ChispasDeChocolate que extiende de AbstractDecorator
 * Añade chispas de chocolate a la bebida.
 */
class ChispasDeChocolate extends AbstractDecorator {
    public ChispasDeChocolate(iComponent bebida) {
        super(bebida, 200, "Chispas de Chocolate");
    }
}
