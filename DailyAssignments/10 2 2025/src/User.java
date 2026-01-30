public class User {
    public String name;
    protected String email;
    protected String userID;
    private String password;

    public void login() {
        System.out.printf("%s logged in\n", name);
    }
    public void logout() {
        System.out.printf("%s logged out\n", name);
    }
    public String getEmail() {
        return email;
    }
}