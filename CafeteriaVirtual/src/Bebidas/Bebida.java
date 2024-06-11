package Bebidas;

public abstract class Bebida implements iComponent {

    int precio;

    String descripcion;


    public Bebida(int precio,String descripcion){
        this.precio = precio;
        this.descripcion = descripcion;
    }



    @Override
    public int getPrecio(){
        return this.precio;
    }

    @Override
    public String getDescripcion(){
        return this.descripcion;
    }
}

class CafeAmericano extends Bebida{

    public CafeAmericano(){
        super(2000,"Cafe Americano");
    }
}

class CafeExpresso extends Bebida {

    public CafeExpresso(){
        super(2500, "Cafe Expresso");
    }
}

class CafeHelado extends Bebida {

    public CafeHelado(){
        super(2300, "Cafe Helado");
    }
}

class CafeMoca extends Bebida {

    public CafeMoca(){
        super(2700, "Cafe Moca");
    }
}

class Capuchino extends Bebida {

    public Capuchino(){
        super(2600, "Capuchino");
    }
}

class ChocolateCaliente extends Bebida {

    public ChocolateCaliente(){
        super(2200, "Chocolate Caliente");
    }
}

class LatteVainilla extends Bebida {

    public LatteVainilla(){
        super(2800, "Latte Vainilla");
    }
}

class TeVerdeconHierbabuena extends Bebida {

    public TeVerdeconHierbabuena(){
        super(2000, "Te Verde con Hierbabuena");
    }
}