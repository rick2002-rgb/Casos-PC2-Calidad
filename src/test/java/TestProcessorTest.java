import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void textoValido() {
        String result = TextProcessor.reverseAndCapitalize(" hola ");
        assertEquals("ALOH", result);
    }

    @Test
    void textoNulo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                TextProcessor.reverseAndCapitalize(null)
        );
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    void textoVacioOLlenoDeEspacios() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                TextProcessor.reverseAndCapitalize("   ")
        );
        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    @Test
    void textoMuyLargo() {
        String largo = "a".repeat(1001);
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                TextProcessor.reverseAndCapitalize(largo)
        );
        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    @Test
    void textoConCaracteresEspeciales() {
        assertEquals("AS@C", TextProcessor.reverseAndCapitalize("c@sa"));
    }

    @Test
    void textoMinimoValido() {
        assertEquals("X", TextProcessor.reverseAndCapitalize("x"));
    }

    @Test
    void testConstructor() {
        new TextProcessor();
    }

}

