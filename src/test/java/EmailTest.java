import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testCorreoNulo() {
        Email email = new Email();
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                email.isValidEmail(null)
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    void testCorreoVacio() {
        Email email = new Email();
        assertThrows(IllegalArgumentException.class, () ->
                email.isValidEmail("")
        );
    }

    @Test
    void testCorreoSinArrobaODominio() {
        Email email = new Email();
        assertAll(
                () -> assertFalse(email.isValidEmail("usuario.gmail.com")),
                () -> assertFalse(email.isValidEmail("usuario@com"))
        );
    }

    @Test
    void testCorreoValido() {
        Email email = new Email();
        assertTrue(email.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void testCorreoConDosPuntos() {
        Email email = new Email();
        assertFalse(email.isValidEmail("us..er@correo.com"));
    }

    @Test
    void testExtensionInvalida() {
        Email email = new Email();
        assertFalse(email.isValidEmail("cliente@web.c"));
    }

    @Test
    void testCorreoConEspacio() {
        Email email = new Email();
        assertFalse(email.isValidEmail("cliente 123@correo.com"));
    }

    @Test
    void testCorreoMuyCorto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("a@b.c"));
    }

    @Test
    void testLocalParteComienzaConPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail(".usuario@correo.com"));
    }

    @Test
    void testLocalConCaracterInvalido() {
        Email email = new Email();
        assertFalse(email.isValidEmail("us*ario@correo.com"));
    }

    @Test
    void testDominioSinPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("usuario@dominio"));
    }

    @Test
    void testDominioTerminaEnPunto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("usuario@correo."));
    }

    @Test
    void testDominioNameMuyCorto() {
        Email email = new Email();
        assertFalse(email.isValidEmail("cliente@a.com"));
    }






}
