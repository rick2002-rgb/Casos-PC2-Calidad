public class TextProcessor {

    public static String reverseAndCapitalize(String input) {

        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        if (trimmed.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        StringBuilder reversed = new StringBuilder(trimmed).reverse();
        return reversed.toString().toUpperCase();
    }
}