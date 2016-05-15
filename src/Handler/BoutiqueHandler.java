package Handler;



import entity.*;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BoutiqueHandler extends DefaultHandler {

    private Vector boutiques;

    public BoutiqueHandler() {
        boutiques = new Vector();
    }

    public Boutique[] getBoutique() {
        Boutique[] produitss = new Boutique[boutiques.size()];
        boutiques.copyInto(produitss);
        return produitss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Boutique currentBoutique;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("bsetoutique")) {
            currentBoutique = new Boutique();
            //2ème methode pour parser les attributs
            currentBoutique.setId(Integer.parseInt(attributes.getValue("id")));
            currentBoutique.setLibelle(attributes.getValue("Libelle"));
            currentBoutique.setMail(attributes.getValue("Mail"));
            
            /**
             * *
             */

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("boutique")) {
            // we are no longer processing a <reg.../> tag
            boutiques.addElement(currentBoutique);
            currentBoutique = null;
            
        }
    }

}
