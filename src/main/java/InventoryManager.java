
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {


        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }


        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
        }


        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad excede el máximo permitido (1000)");
        }


        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}
