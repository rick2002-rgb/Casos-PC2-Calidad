import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    @Test
    void agregarItemNuevo() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    @Test
    void agregarCantidadNegativa() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () ->
                manager.addItem("Mouse", -1)
        );
    }

    @Test
    void agregarNombreVacio() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                manager.addItem("", 5)
        );
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void nombreMuyCorto() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () ->
                manager.addItem("A", 10)
        );
    }

    @Test
    void cantidadMayorPermitida() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () ->
                manager.addItem("Cajas", 1500)
        );
    }

    @Test
    void sumarAProductoExistente() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        manager.addItem("Laptop", 3);
        assertAll(
                () -> assertTrue(manager.getStock("Laptop") == 8),
                () -> assertEquals(8, manager.getStock("Laptop"))
        );
    }
    @Test
    void agregarNombreNulo() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () ->
                manager.addItem(null, 5)
        );
    }

    @Test
    void nombreDemasiadoLargo() {
        InventoryManager manager = new InventoryManager();
        String nombreLargo = "A".repeat(51); // 51 caracteres
        assertThrows(IllegalArgumentException.class, () ->
                manager.addItem(nombreLargo, 10)
        );
    }




}

