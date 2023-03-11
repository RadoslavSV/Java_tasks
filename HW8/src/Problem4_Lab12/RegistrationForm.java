package Problem4_Lab12;

public class RegistrationForm {
    private String username;
    private String phone;
    private String email;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Username: %s | Phone: %s | Email: %s | Password: %s\n", username, phone, email, password);
    }
}
