/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Authentification;
import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;

/**
 * @author adouni
 */
public class Midlet_auth extends MIDlet {

    Display disp = Display.getDisplay(this);
    Image splash;
    Alert sp = new Alert("Bonjour");
public static MIDlet midlet;

    public Midlet_auth() {
 try {
            midlet =this;
            splash = Image.createImage("/icons/logo-Tunisia-Mall.jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }    }
    
    
    public void startApp() {
        sp.setImage(splash);
        sp.setTimeout(3000);
         disp.flashBacklight(2000);
       
       new Authentification(sp, disp);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
