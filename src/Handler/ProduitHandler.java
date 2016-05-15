package Handler;

import entity.Produit;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProduitHandler extends DefaultHandler {

    private Vector produites;

    public ProduitHandler() {
        produites = new Vector();
    }

    public Produit[] getProduit() {
        Produit[] produitss = new Produit[produites.size()];
        produites.copyInto(produitss);
        return produitss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Produit currentPersonne;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("produit")) {
            currentPersonne = new Produit();
            //2ème methode pour parser les attributs
            currentPersonne.setReference(attributes.getValue("ref"));
            currentPersonne.setNom(attributes.getValue("nomProduit"));
            currentPersonne.setDescription(attributes.getValue("Description"));
            currentPersonne.setType(attributes.getValue("TypeProduit"));
            currentPersonne.setPrixDetaille(Double.parseDouble(attributes.getValue("prixdetaille")));
            currentPersonne.setPrix(Double.parseDouble(attributes.getValue("prix")));
            currentPersonne.setPrixGros(Double.parseDouble(attributes.getValue("prixGros")));
            currentPersonne.setQuantite(Integer.parseInt(attributes.getValue("QuantiteStock")));
            currentPersonne.setCategorie(attributes.getValue("nom_categorie"));
            /**
             * *
             */

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("produit")) {
            // we are no longer processing a <reg.../> tag
            produites.addElement(currentPersonne);
            currentPersonne = null;
            
        }
    }

}
