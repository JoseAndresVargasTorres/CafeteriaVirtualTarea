package Bebidas;

// Importaciones necesarias para utilizar componentes de Swing y AWT.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase InterfazUsuario que extiende JFrame para crear una interfaz gráfica de usuario.
 * Permite al usuario seleccionar bebidas y añadir ingredientes adicionales.
 */
public class InterfazUsuario extends JFrame {
    private Carrito carrito; // Carrito para manejar las bebidas agregadas
    private JComboBox<String> bebidasBox; // ComboBox para seleccionar la bebida base
    private Map<String, JCheckBox> ingredientesCheckboxes; // Mapa para almacenar checkboxes de ingredientes
    private JButton agregarBtn, finalizarBtn; // Botones para agregar bebidas al carrito y finalizar la compra
    private JTextArea descripcionArea; // Área de texto para mostrar descripción de bebidas en el carrito
    private JLabel precioLabel; // Etiqueta para mostrar el precio total

    /**
     * Constructor que inicializa la ventana y la interfaz de usuario.
     */
    public InterfazUsuario() {
        super("Personalizador de Bebidas"); // Titulo de la ventana
        this.carrito = new Carrito(); // Inicialización del carrito
        initUI(); // Método que inicializa los componentes de la interfaz
    }

    /**
     * Método para inicializar los componentes de la interfaz de usuario.
     */
    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre por defecto
        setSize(600, 400); // Establece el tamaño de la ventana
        setLayout(new BorderLayout()); // Establece el layout manager

        // Panel para la selección de bebidas
        JPanel bebidasPanel = new JPanel(); // Panel para contener el JComboBox
        bebidasBox = new JComboBox<>(new String[]{"Cafe Americano", "Cafe Expresso", "Cafe Helado", "Cafe Moca", "Capuchino", "Chocolate Caliente", "Latte Vainilla", "Te Verde con Hierbabuena"});
        bebidasPanel.add(bebidasBox); // Añade el ComboBox al panel
        add(bebidasPanel, BorderLayout.NORTH); // Añade el panel al norte de la ventana

        // Panel para checkboxes de ingredientes
        JPanel ingredientesPanel = new JPanel(new GridLayout(0, 1)); // Usa GridLayout para organizar checkboxes
        ingredientesCheckboxes = new HashMap<>(); // Inicializa el mapa de checkboxes
        String[] ingredientes = {"Leche Deslactosada", "Leche Entera", "Leche sin Lactosa", "Stevia", "Miel", "Azúcar", "Sirope", "Vanilla", "Caramelo", "Canela", "Crema Batida", "Chispas de Chocolate"};
        for (String ingrediente : ingredientes) { // Itera sobre el array de ingredientes
            JCheckBox checkBox = new JCheckBox(ingrediente); // Crea un checkbox para cada ingrediente
            ingredientesPanel.add(checkBox); // Añade el checkbox al panel
            ingredientesCheckboxes.put(ingrediente, checkBox); // Almacena el checkbox en el mapa
        }
        add(new JScrollPane(ingredientesPanel), BorderLayout.CENTER); // Añade el panel con un JScrollPane al centro

        // Botones para agregar bebida al carrito y finalizar compra
        agregarBtn = new JButton("Agregar a Carrito"); // Botón para agregar bebidas al carrito
        agregarBtn.addActionListener(new ActionListener() { // Añade un ActionListener al botón
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarBebidaAlCarrito(); // Llama al método cuando el botón es presionado
            }
        });
        finalizarBtn = new JButton("Finalizar Compra"); // Botón para finalizar la compra
        finalizarBtn.addActionListener(new ActionListener() { // Añade un ActionListener al botón
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra(); // Llama al método cuando el botón es presionado
            }
        });
        JPanel botonesPanel = new JPanel(); // Panel para contener los botones
        botonesPanel.add(agregarBtn); // Añade el botón de agregar al panel
        botonesPanel.add(finalizarBtn); // Añade el botón de finalizar al panel
        add(botonesPanel, BorderLayout.SOUTH); // Añade el panel de botones al sur de la ventana

        // Área de texto y etiqueta para mostrar la descripción y precio
        descripcionArea = new JTextArea(5, 20); // Crea el área de texto para la descripción
        descripcionArea.setEditable(false); // Hace que el área de texto no sea editable
        precioLabel = new JLabel("Precio Total: $0"); // Crea la etiqueta para el precio
        JPanel descripcionPanel = new JPanel(new BorderLayout()); // Panel para descripción y precio
        descripcionPanel.add(new JScrollPane(descripcionArea), BorderLayout.CENTER); // Añade el área de texto con JScrollPane
        descripcionPanel.add(precioLabel, BorderLayout.SOUTH); // Añade la etiqueta de precio al sur
        add(descripcionPanel, BorderLayout.EAST); // Añade el panel de descripción al este

        setVisible(true); // Hace visible la ventana
    }

    /**
     * Método para agregar una bebida seleccionada y sus ingredientes al carrito.
     */
    private void agregarBebidaAlCarrito() {
        iComponent bebida = seleccionarBebidaBase(); // Obtiene la bebida base seleccionada
        for (Map.Entry<String, JCheckBox> entry : ingredientesCheckboxes.entrySet()) { // Itera sobre todos los checkboxes
            if (entry.getValue().isSelected()) { // Verifica si el checkbox está seleccionado
                bebida = agregarIngrediente(bebida, entry.getKey()); // Añade el ingrediente a la bebida
            }
        }
        carrito.agregarBebida(bebida); // Agrega la bebida finalizada al carrito
        actualizarCarrito(); // Actualiza la visualización del carrito
    }

    /**
     * Método para seleccionar la bebida base de acuerdo al ítem seleccionado en el JComboBox.
     * @return iComponent que representa la bebida seleccionada.
     */
    private iComponent seleccionarBebidaBase() {
        String bebidaSeleccionada = (String) bebidasBox.getSelectedItem(); // Obtiene la bebida seleccionada del ComboBox
        // Retorna una nueva instancia de la bebida seleccionada usando un switch
        switch (bebidaSeleccionada) {
            case "Cafe Americano": return new CafeAmericano();
            case "Cafe Expresso": return new CafeExpresso();
            case "Cafe Helado": return new CafeHelado();
            case "Cafe Moca": return new CafeMoca();
            case "Capuchino": return new Capuchino();
            case "Chocolate Caliente": return new ChocolateCaliente();
            case "Latte Vainilla": return new LatteVainilla();
            case "Te Verde con Hierbabuena": return new TeVerdeconHierbabuena();
            default: return new CafeAmericano(); // Valor por defecto por si no se selecciona nada
        }
    }

    /**
     * Método para agregar un ingrediente a la bebida.
     * @param bebida Bebida base a la que se añadirá el ingrediente.
     * @param ingrediente Nombre del ingrediente a añadir.
     * @return iComponent con el ingrediente añadido.
     */
    private iComponent agregarIngrediente(iComponent bebida, String ingrediente) {
        // Retorna una nueva instancia de la bebida con el ingrediente añadido usando un switch
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

    /**
     * Método para finalizar la compra, muestra un mensaje con la descripción y el total del precio.
     */
    private void finalizarCompra() {
        JOptionPane.showMessageDialog(this, "Compra finalizada. Descripción: " + carrito.getDescripcionTotal() + "\nTotal: $" + carrito.getPrecioTotal());
        carrito = new Carrito(); // Reinicia el carrito para nuevas compras
        actualizarCarrito(); // Actualiza la interfaz gráfica para reflejar el carrito vacío
    }

    /**
     * Método para actualizar la interfaz gráfica con la información del carrito.
     */
    private void actualizarCarrito() {
        descripcionArea.setText(carrito.getDescripcionTotal()); // Actualiza el texto de descripción
        precioLabel.setText("Precio Total: $" + carrito.getPrecioTotal()); // Actualiza el texto del precio
    }

    /**
     * Método principal para iniciar la interfaz gráfica.
     */
    public static void main(String[] args) {
        new InterfazUsuario(); // Crea una instancia de la interfaz y la muestra
    }
}
