/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author wided
 */
public class Produit {
    
    public int id;
    public String nom;
    public String image;
    public int quantite;
    public double prix;
    public int categorie_id;

    public Produit(int id, String nom, String image, int quantite, double prix, int categorie_id) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie_id = categorie_id;
    }
        
    public Produit(int id) {
        this.id = id;
    }
        
    public Produit() {
       
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", image=" + image + ", quantite=" + quantite + ", prix=" + prix + ", categorie_id=" + categorie_id + '}';
    }
    
    
}
