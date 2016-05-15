/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiamallmohamed;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MidletAjout extends MIDlet implements CommandListener, Runnable{

    Display disp = Display.getDisplay(this);
    //Form 1
    Form f1 = new Form("Ajout Boutique");
    TextField tfLibelle = new TextField("Libelle", null, 100, TextField.ANY);
    TextField tfMail = new TextField("Mail", null, 100, TextField.ANY);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/parsing/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public void startApp() {
        f1.append(tfLibelle);
        f1.append(tfMail);
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
            
                hc = (HttpConnection) Connector.open(url+"?nom="+tfLibelle.getString().trim()+"&prenom="+tfMail.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) { //success
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
