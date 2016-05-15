/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiamallahmedbettaiebj2me;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * @author Lenovo
 */
public class Midlet extends MIDlet implements CommandListener {
     Display disp = Display.getDisplay(this);
     Form acceuil = new Form("Aceuil");
     private ChoiceGroup choix;
Form f1 = new Form("Inscription");
    TextField nom = new TextField("nom", null, 100, TextField.ANY);
    TextField reduction = new TextField("reduction", null, 100, TextField.ANY);
     DateField dateDebut = new DateField("Date Debut",DateField.DATE_TIME);
     DateField dateFin = new DateField("Date Fin",DateField.DATE_TIME);
     
 Form loadingDialog = new Form("Please Wait");
          Form f = new Form("Affichage Statistique ");
              Statistique[] statistique;

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
     HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/TunisiaMallFinalVersion/web/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;
     Command cmdNext = new Command("Suivant", Command.OK, 0);
     Command cmdExit = new Command("Quitter", Command.EXIT, 0);
Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);
     

    public void startApp() {
        
   acceuil.addCommand(cmdNext);
      acceuil.addCommand(cmdExit);
      acceuil.setCommandListener(this);
String items[] = {"Google Maps", "Statistique","Gestion Promotion"};
choix = new ChoiceGroup("Gender", Choice.POPUP,items, null);
acceuil.append(choix);
     acceuil.setCommandListener(this);
     

      disp.setCurrent(acceuil);
     
       // disp.setCurrent(new GoogleMap());
                
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
String getDateString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return new String(year + "-" + month + "-" + day);
    }
    public void commandAction(Command c, Displayable d) {
 if (c==cmdNext)
 {
   if (choix.getSelectedIndex()==0)
   {

      disp.setCurrent(new GoogleMap());
   
   }
    if (choix.getSelectedIndex()==1)
   {

       
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
    if (c == cmdBack) {
            
            disp.setCurrent(f1);
        }
     if (choix.getSelectedIndex()==2)
   {
  try {
               hc = (HttpConnection) Connector.open(url+"?nom="+nom.getString().trim()+"&reduction="+reduction.getString().trim()+"&dateDebut="+getDateString(dateDebut.getDate())+"&dateFin"+getDateString(dateFin.getDate()));
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(f2);
                }else{
                    disp.setCurrent(f3);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
   
   }
     
             
 }
    
    }
     
}
