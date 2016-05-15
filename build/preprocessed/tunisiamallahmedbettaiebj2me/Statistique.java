/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunisiamallahmedbettaiebj2me;

/**
 *
 * @author Lenovo
 */
public class Statistique {
 int id;
 int nouveau;
 int retourne;
 int totale;

    public Statistique() {
    }

    public Statistique(int id, int nouveau, int retourne, int totale) {
        this.id = id;
        this.nouveau = nouveau;
        this.retourne = retourne;
        this.totale = totale;
    }
    

    public int getId() {
        return id;
    }

    public int getNouveau() {
        return nouveau;
    }

    public int getRetourne() {
        return retourne;
    }

    public int getTotale() {
        return totale;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setNouveau(String nouveau) {
        this.nouveau = Integer.parseInt(nouveau);
    }

    public void setRetourne(String retourne) {
        this.retourne = Integer.parseInt(retourne);
    }

    public void setTotale(String totale) {
        this.totale = Integer.parseInt(totale);
    }

   
 
 
}
