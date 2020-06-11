/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package Myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import Entities.Utilisateur;
import Service.userService;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;

/**
 * The Login form
 *
 * @author Shai Almog
 */
public class register extends Form {
    public register(Resources theme) {
        
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Veuiller entrer, ", "WelcomeWhite"),
                new Label("Vos Infos", "WelcomeBlue")
        );
        System.out.println("login");
        getTitleArea().setUIID("Container");
        
        /*Image profilePic = theme.getImage("p2.jpg");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());*/
        
        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR) ;
        TextField email = new TextField("", "Email", 20, TextField.EMAILADDR) ;
        TextField nom = new TextField("", "Nom", 20, TextField.EMAILADDR) ;
        TextField prenom = new TextField("", "Prenom", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD) ;
        TextField confirmer = new TextField("", "Confirmer", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        
        
        
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        Label EmailIcon = new Label("", "TextField");
        Label NomIcon = new Label("", "TextField");
        Label PrenomIcon = new Label("", "TextField");
        Label ConfirmerIcon = new Label("", "TextField");
        
        
        
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        EmailIcon.getAllStyles().setMargin(RIGHT, 0);
        NomIcon.getAllStyles().setMargin(RIGHT, 0);
        PrenomIcon.getAllStyles().setMargin(RIGHT, 0);
        ConfirmerIcon.getAllStyles().setMargin(RIGHT, 0);
        
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(EmailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(NomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(PrenomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(ConfirmerIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        
        
        Button loginButton = new Button("Enregistrer");
        loginButton.setUIID("LoginButton");
        
        
        /**************************************************************************************************/
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((password.getText().length()==0)||(login.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                       
                  String Role="ROLE_CLIENT";
                      Utilisateur t = new Utilisateur(login.getText(),email.getText(),password.getText(),confirmer.getText(),Role,nom.getText(),prenom.getText());
                        if( userService.getInstance().createUser(t)){
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            new LoginForm(theme).show();
                        }
                                
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "telephone must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }


        });
        /**************************************************************************************************/
        
       
        
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(
                welcome,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                 BorderLayout.center(email).
                        add(BorderLayout.WEST, EmailIcon),
                  BorderLayout.center(nom).
                        add(BorderLayout.WEST, NomIcon),
                   BorderLayout.center(prenom).
                       add(BorderLayout.WEST, PrenomIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                BorderLayout.center(confirmer).
                        add(BorderLayout.WEST, ConfirmerIcon),
                loginButton
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
        
        
       
        
        
        
        
    }
}
