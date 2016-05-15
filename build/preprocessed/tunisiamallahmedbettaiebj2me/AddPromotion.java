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
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Lenovo
 */
public class AddPromotion extends MIDlet implements CommandListener,Runnable{
  Display disp = Display.getDisplay(this);
    //Form 1
    Form f1 = new Form("Inscription");
    TextField nom = new TextField("nom", null, 100, TextField.ANY);
    TextField reduction = new TextField("reduction", null, 100, TextField.ANY);
     DateField dateDebut = new DateField("Date Debut",DateField.DATE_TIME);
     DateField dateFin = new DateField("Date Fin",DateField.DATE_TIME);

    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/TunisiaMallFinalVersion/web/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public void startApp() {
        f1.append(nom);
        f1.append(reduction);
         f1.append(dateDebut);
      f1.append(dateFin);

        f1.addCommand(cmdValider);
        f1.setCommandListener(this);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
        disp.setCurrent(f1);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdValider) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack) {
            
            disp.setCurrent(f1);
        }
    }

    public void run() {
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
}
