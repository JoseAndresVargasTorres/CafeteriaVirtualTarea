package Bebidas;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<iComponent> bebidas;

    public Carrito() {
        this.bebidas = new ArrayList<>();
    }

    public void agregarBebida(iComponent bebida) {
        bebidas.add(bebida);
    }

    public void removerBebida(iComponent bebida) {
        bebidas.remove(bebida);
    }

    public int getPrecioTotal() {
        return bebidas.stream().mapToInt(iComponent::getPrecio).sum();
    }

    public String getDescripcionTotal() {
        return bebidas.stream().map(iComponent::getDescripcion).reduce("", (a, b) -> a + "\n" + b);
    }
}
