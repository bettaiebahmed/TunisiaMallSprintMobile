/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParsingXML;

import Handler.ProduitHandler;
import entity.Produit;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Houssem Eddine
 */
public class MidletParsingXml extends MIDlet implements CommandListener, Runnable {

    Display disp = Display.getDisplay(this);
    Command cmdParse = new Command("AFICHER", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    Produit[] personnes;
    List lst = new List("Produit", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Infos Produit");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();

    public void startApp() {
        f.append("Click ici");
        f.addCommand(cmdParse);
        f.setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        disp.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdParse) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Produit: \n");
            form.append(showPersonne(lst.getSelectedIndex()));
            disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            disp.setCurrent(lst);
        }

    }

    public void run() {
        try {
            // this will handle our XML
            ProduitHandler personnesHandler = new ProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/J2m-MOBILE/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, personnesHandler);
            // display the result
            personnes = personnesHandler.getProduit();

            if (personnes.length > 0) {
                for (int i = 0; i < personnes.length; i++) {
                    lst.append(personnes[i].getReference() + " ", null);
                        //    + personnes[i].getNom() + " "
                         //   + personnes[i].getDescription() + ""
                         //   + personnes[i].getType() + " "
                         //   + personnes[i].getPrixDetaille() + " "
                         //   + personnes[i].getPrix() + " "
                         //   + personnes[i].getPrixGros() + " "
                          //  + personnes[i].getQuantite() + " "
                           // + personnes[i].getCategorie() + " ", null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lst);
    }

    private String showPersonne(int i) {
        String res = "";
        if (personnes.length > 0) {
            sb.append("* ");
            sb.append(personnes[i].getReference());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getNom());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getDescription());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getType());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getPrixDetaille());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getPrix());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getPrixGros());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getQuantite());
            sb.append("\n");
            sb.append("* ");
            sb.append(personnes[i].getCategorie());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}