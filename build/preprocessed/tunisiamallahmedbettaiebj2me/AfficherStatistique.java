/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiamallahmedbettaiebj2me;

import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Lenovo
 */
public class AfficherStatistique extends MIDlet implements Runnable{
        Display disp = Display.getDisplay(this);

         Form loadingDialog = new Form("Please Wait");
          Form f = new Form("Affichage Statistique ");
              Statistique[] statistique;

         StringBuffer sb = new StringBuffer();

  
    
    
        


    public void startApp() {
                disp.setCurrent(f);
Thread th = new Thread(this);
            th.start();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void run() {
       try {
            // this will handle our XML
            StatistiqueHandler statisuqehandler = new StatistiqueHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/tunisiamallfinalversion/web/xmlStatistique.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, statisuqehandler);
            // display the result
            statistique = statisuqehandler.getPersonne();

            if (statistique.length > 0) {
                for (int i = 0; i < statistique.length; i++) {
                    f.append("Nouvelle Visite : "+statistique[i].getNouveau()+"\n"
                           +"Visiteur Retourné : "+statistique[i].getRetourne()+"\n"
                            +"Visite Totale : "+statistique[i].getTotale());
                           

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(f);
    }
}
