package projet_coda.serveur;

import java.io.OutputStreamWriter;

public class ClientInfo {
    String ip_adresse ;
    String nom ;
    String etat;
    String bloquer ;
    OutputStreamWriter sortie ;


    public ClientInfo(String ip_adresse, String nom, String etat, String bloquer) {
        this.ip_adresse = ip_adresse;
        this.nom = nom;
        this.etat = etat;
        this.bloquer = bloquer;
    }

    public ClientInfo(String ip_adresse, String nom, String etat, String bloquer, OutputStreamWriter sortie) {
        this.ip_adresse = ip_adresse;
        this.nom = nom;
        this.etat = etat;
        this.bloquer = bloquer;
        this.sortie = sortie;
    }

    public String getIp_adresse() {
        return ip_adresse;
    }

    public void setIp_adresse(String ip_adresse) {
        this.ip_adresse = ip_adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getBloquer() {
        return bloquer;
    }

    public void setBloquer(String bloquer) {
        this.bloquer = bloquer;
    }

    public OutputStreamWriter getSortie() {
        return sortie;
    }

    public void setSortie(OutputStreamWriter sortie) {
        this.sortie = sortie;
    }
}
