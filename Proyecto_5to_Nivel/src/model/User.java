package model;
public class User {
    private String user;
    private String pass;
    private int perfil;
    
    public User() {
        this.user = "";
        this.pass = "";
    }

    public User(String user, String pass, int perfil) {
        this.user = user;
        this.pass = pass;
        this.perfil = perfil;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    
}
