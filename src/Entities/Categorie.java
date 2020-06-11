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
public class Categorie {
    
    public int id;
    public String nomCategorie;
    public String descrioption;

    public Categorie(int id, String nomCategorie, String descrioption) {
        this.id = id;
        this.nomCategorie = nomCategorie;
        this.descrioption = descrioption;
    }

    public int getId() {
        return id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public String getDescrioption() {
        return descrioption;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setDescrioption(String descrioption) {
        this.descrioption = descrioption;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nomCategorie=" + nomCategorie + ", descrioption=" + descrioption + '}';
    }
    
    
    
    
}
