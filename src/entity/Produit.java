/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.InputStream;

/**
 *
 * @author adouni
 */
public class Produit {

    private int id;
    private String reference;
    private String Nom;
    private String description;
    private double prix;
    private double  prixDetaille;
    private double  prixGros;
    private int quantite;
    private String type;
    private int idCat;
    private String categorie;
    private String image;

    public Produit() {
    }

    public Produit(String reference, String Nom, String description, double  prix, int quantite, String type, String categorie) {
        this.reference = reference;
        this.Nom = Nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.type = type;
        this.categorie = categorie;
    }

    public Produit(String reference, String Nom, String description, double prix, double prixDetaille, double prixGros, int quantite, String type, int idCat, String categorie, String image) {
        this.reference = reference;
        this.Nom = Nom;
        this.description = description;
        this.prix = prix;
        this.prixDetaille = prixDetaille;
        this.prixGros = prixGros;
        this.quantite = quantite;
        this.type = type;
        this.idCat = idCat;
        this.categorie = categorie;
        this.image = image;
    }

    public Produit(int id, String reference, String Nom, String description, double  prix, double  prixDetaille, double  prixGros, int quantite, String type, int idCat, String categorie, String image) {
        this.id = id;
        this.reference = reference;
        this.Nom = Nom;
        this.description = description;
        this.prix = prix;
        this.prixDetaille = prixDetaille;
        this.prixGros = prixGros;
        this.quantite = quantite;
        this.type = type;
        this.idCat = idCat;
        this.categorie = categorie;
        this.image = image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double  getPrixDetaille() {
        return prixDetaille;
    }

    public void setPrixDetaille(double prixDetaille) {
        this.prixDetaille = prixDetaille;
    }

    public double  getPrixGros() {
        return prixGros;
    }

    public void setPrixGros(double  prixGros) {
        this.prixGros = prixGros;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  
    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + (this.reference != null ? this.reference.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
  
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double  getPrix() {
        return prix;
    }

    public void setPrix(double  prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Produit(String reference, String Nom, String description, double  prix, int quantite, String type, String categorie, String image) {
        this.reference = reference;
        this.Nom = Nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.type = type;
        this.categorie = categorie;
   
    }

    public String toString() {
        return "Produit{" + "id=" + id + ", reference=" + reference + ", Nom=" + Nom + ", description=" + description + ", prix=" + prix + ", prixDetaille=" + prixDetaille + ", prixGros=" + prixGros + ", quantite=" + quantite + ", type=" + type + ", idCat=" + idCat + ", categorie=" + categorie + ", image=" + image + '}';
    }

 

    

    




}
