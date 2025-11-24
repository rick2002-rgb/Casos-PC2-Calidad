import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testPasswordNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidator.isValid(null)
        );
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void testPasswordVacia() {
        assertThrows(IllegalArgumentException.class, () ->
                PasswordValidator.isValid("")
        );
    }

    @Test
    void testPasswordValida() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    void testSinRequisitos() {
        assertFalse(PasswordValidator.isValid("nosecura"));
    }

    @Test
    void testConEspacio() {
        assertFalse(PasswordValidator.isValid("Abc 123!"));
    }

    @Test
    void testSinEspecial() {
        boolean r = PasswordValidator.isValid("Abcde123");
        assertAll(
                () -> assertFalse(r),
                () -> assertEquals(false, r)
        );
    }

    @Test
    void testPasswordMuyLarga() {
        String larga = "A".repeat(65);
        assertFalse(PasswordValidator.isValid(larga));
    }

    @Test
    void testCaracterNoPermitido() {
        assertFalse(PasswordValidator.isValid("Abc123!💀"));
    }


    @Test
    void testSinMayuscula() {
        assertFalse(PasswordValidator.isValid("abc123!@"));
    }

    @Test
    void testSinMinuscula() {
        assertFalse(PasswordValidator.isValid("ABC123!@"));
    }

    @Test
    void testSinDigito() {
        assertFalse(PasswordValidator.isValid("Abcdef!!"));
    }

    @Test
    void testPasswordConEspacioFinal() {
        assertFalse(PasswordValidator.isValid("Abc123! "));
    }

    @Test
    void testPasswordConEspacioInicio() {
        assertFalse(PasswordValidator.isValid(" Abc123!"));
    }

    @Test
    void testCaracterEspecialDosPuntos() {
        assertTrue(PasswordValidator.isValid("Abc1234:"));
    }
    @Test
    void testCaracterEspecialInterrogacion() {
        assertTrue(PasswordValidator.isValid("Abc1234?"));
    }

    @Test
    void testConstructor() {
        new PasswordValidator();
    }

    @Test
    void testCaracterRealmenteInvalido() {
        assertFalse(PasswordValidator.isValid("Abc123¡"));
    }








}

