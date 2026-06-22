public class User {
    String name;
    String email;   
    String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters  
    public String getName() {
        return name;
    }   
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // add method login
    public boolean login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
}
