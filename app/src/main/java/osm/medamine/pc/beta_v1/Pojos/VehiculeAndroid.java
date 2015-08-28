package osm.medamine.pc.beta_v1.Pojos;

/**
 * Created by PC on 27/08/2015.
 */
public class VehiculeAndroid {
    private int id_vehicule;
    private String intitule;
    private String matricule;
    private String type;
    private String modele;
    private String groupe;
    private String chauffeur;

    public VehiculeAndroid() {}

    public VehiculeAndroid(int id_vehicule, String intitule, String matricule, String type, String modele, String groupe, String chauffeur) {
        this.id_vehicule = id_vehicule;
        this.intitule = intitule;
        this.matricule = matricule;
        this.type = type;
        this.modele = modele;
        this.groupe = groupe;
        this.chauffeur = chauffeur;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(String chauffeur) {
        this.chauffeur = chauffeur;
    }

    @Override
    public String toString() {
        return "VehiculeAndroid{" +
                "id_vehicule=" + id_vehicule +
                ", intitule='" + intitule + '\'' +
                ", matricule='" + matricule + '\'' +
                ", type='" + type + '\'' +
                ", modele='" + modele + '\'' +
                ", groupe='" + groupe + '\'' +
                ", chauffeur='" + chauffeur + '\'' +
                '}';
    }
}
