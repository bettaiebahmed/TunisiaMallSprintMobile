/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.DataInputStream;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author adouni
 */
public class Authentification implements CommandListener {

    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/J2m-MOBILE/Inscription.php";
    StringBuffer sb = new StringBuffer();
    int ch;
    Display disp;

    Form authForm = new Form("Authentification");
    TextField tfNom = new TextField("nom", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("prenom", null, 100, TextField.ANY);
    TextField tfauthentifiant = new TextField("Authentifiant", null, 100, TextField.ANY);
    TextField tfMail = new TextField("Mail", null, 100, TextField.ANY);
    TextField tfpass = new TextField("Mot de passe", null, 100, TextField.ANY);
    TextField tfconfpass = new TextField("Confirmer mot de passe", null, 100, TextField.ANY);
    String[] choix = {"Client", "Responsable"};
    ChoiceGroup choice = new ChoiceGroup("Role", Choice.EXCLUSIVE, choix, null);

    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);
    Image img;
    ImageItem imgit;

    public Authentification(Alert sp, Display disp) {
        this.disp = disp;
        this.startApp();
        this.disp.setCurrent(authForm);
    }

    public void startApp() {
        disp.flashBacklight(2000);
        try {
            img = Image.createImage("/icons/logo-Tunisia-Mall.jpg");
            imgit = new ImageItem("tunisiaMall", img, ImageItem.LAYOUT_CENTER, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        authForm.append(tfNom);
        authForm.append(tfPrenom);
        authForm.append(tfauthentifiant);
        authForm.append(tfMail);
        authForm.append(tfpass);
        authForm.append(tfconfpass);
        authForm.append(choice);
        authForm.addCommand(cmdValider);
        authForm.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
