package osm.medamine.pc.beta_v1.Pojos;

/**
 * Created by PC on 26/08/2015.
 */
public class User {
    private String matricule;
    private String password;
    public User (){}

    public User(String matricule,String password)
    {
        this.matricule = matricule;
        this.password = password;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "matricule='" + matricule + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}