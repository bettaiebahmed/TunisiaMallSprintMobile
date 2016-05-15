/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint_j2m;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
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
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author adouni
 */
public class Midlet_reclamation extends MIDlet implements CommandListener, Runnable {

    Display disp = Display.getDisplay(this);
    Command cmdValider = new Command("Valider", Command.OK, 0);
    // Command cmdExit = new Command("Quitter", Command.EXIT, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);

    //Form 1
    Form f1 = new Form("Réclamation ");
    TextField tfmail = new TextField("Entrez votre email ", null, 100, TextField.ANY);
    TextField tfobjet = new TextField("Objet", null, 100, TextField.ANY);
    DateField myDate = new DateField("date de réclamation ", DateField.DATE_TIME);
    TextField text = new TextField("Veuillez remplir votre réclamation", null, 500, TextField.ANY);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

//Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/J2m-MOBILE/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public void startApp() {
        f1.append(tfmail);
        f1.append(tfobjet);
        f1.append(myDate);

        f1.append(text);
        f1.addCommand(cmdValider);
        f1.addCommand(cmdBack);
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
            System.out.println(tfmail.getString().trim() + getDateString(myDate.getDate()) + tfobjet.getString().trim() + text.getString().trim());
            hc = (HttpConnection) Connector.open(url + "?mailRec=" + tfmail.getString().trim() + "&dateRec=" + getDateString(myDate.getDate()) + "&objRec=" + tfobjet.getString().trim() + "&texteRec=" + text.getString().trim());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("OK".equals(sb.toString().trim())) { //success
                System.out.println("email envoyé");
            } else {

                System.out.println("email non envoyé");
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
