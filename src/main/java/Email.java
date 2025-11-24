public class Email {

    public boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (email.contains(" ")) {
            return false;
        }

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) return false;

        String local = parts[0];
        String domain = parts[1];

        if (local.startsWith(".") || local.endsWith(".")) {
            return false;
        }

        if (local.contains("..")) {
            return false;
        }

        if (!local.matches("[A-Za-z0-9._-]+")) {
            return false;
        }

        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\\.");
        if (domainParts.length < 2) return false;

        String domainName = domainParts[0];
        String extension = domainParts[domainParts.length - 1];

        if (domainName.length() < 2) {
            return false;
        }

        if (extension.length() < 2) {
            return false;
        }

        return true;
    }
}
