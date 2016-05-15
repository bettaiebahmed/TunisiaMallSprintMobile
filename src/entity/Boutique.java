package entity;

public class Boutique {

    private int id;
    private String libelle;
    private String mail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String toString() {
        return "Boutique{" + "id=" + id + ", libelle=" + libelle + ", mail=" + mail + '}';
    }


}
