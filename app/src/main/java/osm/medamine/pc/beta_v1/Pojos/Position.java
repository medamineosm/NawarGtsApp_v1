package osm.medamine.pc.beta_v1.Pojos;

/**
 * Created by PC on 26/08/2015.
 */

public class Position {

    private String identifiant;
    private String latitude;
    private String longitude;

    public Position() {}

    public Position(String identifiant, String latitude, String longitude) {
        this.identifiant = identifiant;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Position{" +
                "identifiant='" + identifiant + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
