package Bebidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class InterfazUsuario extends JFrame {
    private Carrito carrito;
    private JComboBox<String> bebidasBox;
    private Map<String, JCheckBox> ingredientesCheckboxes;
    private JButton agregarBtn, finalizarBtn;
    private JTextArea descripcionArea;
    private JLabel precioLabel;

    public InterfazUsuario() {
        super("Personalizador de Bebidas");
        this.carrito = new Carrito();
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para selección de bebidas
        JPanel bebidasPanel = new JPanel();
        bebidasBox = new JComboBox<>(new String[]{"Cafe Americano", "Cafe Expresso", "Cafe Helado", "Cafe Moca", "Capuchino", "Chocolate Caliente", "Latte Vainilla", "Te Verde con Hierbabuena"});
        bebidasPanel.add(bebidasBox);
        add(bebidasPanel, BorderLayout.NORTH);

        // Panel para checkboxes de ingredientes
        JPanel ingredientesPanel = new JPanel();
        ingredientesPanel.setLayout(new GridLayout(0, 1)); // Cambia según el número de ingredientes
        ingredientesCheckboxes = new HashMap<>();
        String[] ingredientes = {"Leche Deslactosada", "Leche Entera", "Leche sin Lactosa", "Stevia", "Miel", "Azúcar", "Sirope", "Vanilla", "Caramelo", "Canela", "Crema Batida", "Chispas de Chocolate"};
        for (String ingrediente : ingredientes) {
            JCheckBox checkBox = new JCheckBox(ingrediente);
            ingredientesPanel.add(checkBox);
            ingredientesCheckboxes.put(ingrediente, checkBox);
        }
        add(new JScrollPane(ingredientesPanel), BorderLayout.CENTER);

        // Botón para agregar bebida al carrito
        agregarBtn = new JButton("Agregar a Carrito");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarBebidaAlCarrito();
            }
        });

        // Botón para finalizar la compra
        finalizarBtn = new JButton("Finalizar Compra");
        finalizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(agregarBtn);
        botonesPanel.add(finalizarBtn);
        add(botonesPanel, BorderLayout.SOUTH);

        // Área de texto para descripción y precio
        descripcionArea = new JTextArea(5, 20);
        descripcionArea.setEditable(false);
        precioLabel = new JLabel("Precio Total: $0");
        JPanel descripcionPanel = new JPanel(new BorderLayout());
        descripcionPanel.add(new JScrollPane(descripcionArea), BorderLayout.CENTER);
        descripcionPanel.add(precioLabel, BorderLayout.SOUTH);
        add(descripcionPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void agregarBebidaAlCarrito() {
        iComponent bebida = seleccionarBebidaBase();
        for (Map.Entry<String, JCheckBox> entry : ingredientesCheckboxes.entrySet()) {
            if (entry.getValue().isSelected()) {
                bebida = agregarIngrediente(bebida, entry.getKey());
            }
        }
        carrito.agregarBebida(bebida);
        actualizarCarrito();
    }

    private iComponent seleccionarBebidaBase() {
        String bebidaSeleccionada = (String) bebidasBox.getSelectedItem();
        switch (bebidaSeleccionada) {
            case "Cafe Americano": return new CafeAmericano();
            case "Cafe Expresso": return new CafeExpresso();
            case "Cafe Helado": return new CafeHelado();
            case "Cafe Moca": return new CafeMoca();
            case "Capuchino": return new Capuchino();
            case "Chocolate Caliente": return new ChocolateCaliente();
            case "Latte Vainilla": return new LatteVainilla();
            case "Te Verde con Hierbabuena": return new TeVerdeconHierbabuena();
            default: return new CafeAmericano(); // Default, por si acaso
        }
    }

    private iComponent agregarIngrediente(iComponent bebida, String ingrediente) {
        switch (ingrediente) {
            case "Leche Deslactosada": return new LecheDeslactosada(bebida);
            case "Leche Entera": return new LecheEntera(bebida);
            case "Leche sin Lactosa": return new LechesinLactosa(bebida);
            case "Stevia": return new Stevia(bebida);
            case "Miel": return new Miel(bebida);
            case "Azúcar": return new Azucar(bebida);
            case "Sirope": return new Sirope(bebida);
            case "Vanilla": return new Vanilla(bebida);
            case "Caramelo": return new Caramelo(bebida);
            case "Canela": return new Canela(bebida);
            case "Crema Batida": return new CremaBatida(bebida);
            case "Chispas de Chocolate": return new ChispasDeChocolate(bebida);
            default: return bebida; // No debería pasar, pero por si acaso
        }
    }

    private void finalizarCompra() {
        JOptionPane.showMessageDialog(this, "Compra finalizada. Descripción: " + carrito.getDescripcionTotal() + "\nTotal: $" + carrito.getPrecioTotal());
        carrito = new Carrito(); // Reiniciar el carrito
        actualizarCarrito();
    }

    private void actualizarCarrito() {
        descripcionArea.setText(carrito.getDescripcionTotal());
        precioLabel.setText("Precio Total: $" + carrito.getPrecioTotal());
    }

    public static void main(String[] args) {
        new InterfazUsuario();
    }
}
