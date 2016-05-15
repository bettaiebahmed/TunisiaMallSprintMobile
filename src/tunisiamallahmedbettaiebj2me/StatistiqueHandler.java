/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunisiamallahmedbettaiebj2me;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class StatistiqueHandler extends DefaultHandler{
    private Vector statistique;
    String idTag = "close";
    String retourne = "close";
    String nouveau = "close";
    String totale = "close";


    public StatistiqueHandler() {
        statistique = new Vector();
    }

    public Statistique[] getPersonne() {
        Statistique[] statistiques = new Statistique[statistique.size()];
        statistique.copyInto(statistiques);
        return statistiques;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Statistique currentPersonne;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("projet")) {
            currentPersonne = new Statistique();
            //2ème methode pour parser les attributs
            currentPersonne.setId(attributes.getValue("id"));
            currentPersonne.setNouveau(attributes.getValue("new"));
            currentPersonne.setRetourne(attributes.getValue("retu"));
            currentPersonne.setTotale(attributes.getValue("totale"));

            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("new")) {
            nouveau = "open";
            } else if (qName.equals("retu")) {
            retourne = "open";
        } else if (qName.equals("totale")) {
            totale = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("projet")) {
            // we are no longer processing a <reg.../> tag
            statistique.addElement(currentPersonne);
            currentPersonne = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("new")) {
            nouveau = "close";
        } else if (qName.equals("retu")) {
            retourne = "close";
        
        } else if (qName.equals("totale")) {
            totale = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentPersonne != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentPersonne.setId(id);
            } else
                if (nouveau.equals("open")) {
                String nv = new String(ch, start, length).trim();
                currentPersonne.setNouveau(nv);
            } else
                    if (retourne.equals("open")) {
                String ret = new String(ch, start, length).trim();
                currentPersonne.setRetourne(ret);
            }
             else
                    if (totale.equals("open")) {
                String tot = new String(ch, start, length).trim();
                currentPersonne.setTotale(tot);
            }
        }
    }
    
}
