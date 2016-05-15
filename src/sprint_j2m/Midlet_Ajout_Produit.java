/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint_j2m;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author adouni
 */
public class Midlet_Ajout_Produit extends MIDlet implements CommandListener {

    Display disp = Display.getDisplay(this);
    
   Command cmdNexT = new Command("Next", Command.OK, 0);
    Command cmdExit = new Command("Quitter", Command.EXIT, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    
    
    Form f1 = new Form("Ajouter produit ");
    TextField tfref = new TextField("ref ", null, 100, TextField.ANY);
    TextField tfnom = new TextField("nom", null, 100, TextField.ANY);
    TextField tfdescp = new TextField("description", null, 100, TextField.ANY);
   
    String[] tab_type = {"Homme", "Femme", "Enfant"};
    List lsttype = new List("ma LIST", List.EXCLUSIVE, tab_type, null);
   ChoiceGroup conver=new ChoiceGroup("type Produit", ChoiceGroup.EXCLUSIVE); 
    TextField tfprixd = new TextField("prixdétaille", null, 100, TextField.NUMERIC);
    TextField tfprix = new TextField("prix", null, 100, TextField.NUMERIC);
    TextField tfprixG = new TextField("prixG", null, 100, TextField.NUMERIC);
    Gauge  gaVolume = new Gauge("Quntite", true, 20, 0);
  
    String[] tab_catg = {};
    List lstcatg = new List("ma LIST", List.IMPLICIT, tab_catg, null);
    
    public void startApp() {
        
        f1.append(tfref);
        f1.append(tfnom);
        f1.append(tfdescp);
        
       f1.append(tfprix);
       f1.append(tfprixd);
       f1.append(tfprixG);
       f1.append(gaVolume);
   conver.append("Homme", null);
   conver.append("Femme", null);
   conver.append("Enfant", null);
   f1.append(conver);
       f1.setCommandListener(this);
       disp.setCurrent(f1);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
