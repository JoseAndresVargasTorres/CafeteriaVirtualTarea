package Bebidas;


/**
 *
 * @author José Andrés Vargas Torres
 * @author Melissa Vásquez
 */

public class AbstractDecorator implements iComponent {

    protected iComponent bebida;

    int precio;

    String descripcion;

    public AbstractDecorator(iComponent bebida,int precio,String descripcion){

        this.bebida = bebida;
        this.precio = precio;
        this.descripcion = descripcion;

    }

   @Override
   public int getPrecio(){
       return bebida.getPrecio() + this.precio;
   }

    @Override
    public String getDescripcion() {
        return bebida.getDescripcion() + " + " + this.descripcion;

    }
}


class LecheDeslactosada extends AbstractDecorator{

    public LecheDeslactosada(iComponent bebida) {
        super(bebida, 200,"Leche Deslactosada");
    }
}

class LecheEntera extends AbstractDecorator{

    public LecheEntera(iComponent bebida) {
        super(bebida, 300,"Leche Entera");
    }
}

class LechesinLactosa extends AbstractDecorator{

    public LechesinLactosa(iComponent bebida) {
        super(bebida, 200,"Leche sin lactosa");
    }
}

class Stevia extends AbstractDecorator {

    public Stevia(iComponent bebida) {
        super(bebida, 50, "Stevia");
    }
}

class Miel extends AbstractDecorator {

    public Miel(iComponent bebida) {
        super(bebida, 150, "Miel");
    }
}

class Azucar extends AbstractDecorator {

    public Azucar(iComponent bebida) {
        super(bebida, 50, "Azúcar");
    }
}

class Sirope extends AbstractDecorator {

    public Sirope(iComponent bebida) {
        super(bebida, 100, "Sirope");
    }
}

class Vanilla extends AbstractDecorator {

    public Vanilla(iComponent bebida) {
        super(bebida, 100, "Vanilla");
    }
}

class Caramelo extends AbstractDecorator {

    public Caramelo(iComponent bebida) {
        super(bebida, 100, "Caramelo");
    }
}

class Canela extends AbstractDecorator {

    public Canela(iComponent bebida) {
        super(bebida, 50, "Canela");
    }
}

class CremaBatida extends AbstractDecorator {

    public CremaBatida(iComponent bebida) {
        super(bebida, 200, "Crema Batida");
    }
}

class ChispasDeChocolate extends AbstractDecorator {

    public ChispasDeChocolate(iComponent bebida) {
        super(bebida, 200, "Chispas de Chocolate");
    }
}
