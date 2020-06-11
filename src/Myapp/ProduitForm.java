/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myapp;

import Entities.Produit;
import Service.ProduitService;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.models.XYSeries;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.views.CubicLineChart;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wided
 */    
  public class ProduitForm extends SideMenuBaseForm {
  Form currentForm;
  ArrayList<Map<String, Object>> data ;
  Resources res;
  
  
      public ProduitForm (Resources res) {
          
        super(new BorderLayout());
        System.out.println("produit");
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("Larayedh Wided.jpg");        
        Image tintedImage = Image.createImage(profilePic.getWidth(), profilePic.getHeight());
        Graphics g = tintedImage.getGraphics();
        g.drawImage(profilePic, 0, 0);
        g.drawImage(res.getImage("gradient-overlay.png"), 0, 0, profilePic.getWidth(), profilePic.getHeight());
        
        tb.getUnselectedStyle().setBgImage(tintedImage);
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Button settingsButton = new Button("");
        settingsButton.setUIID("Title");
        FontImage.setMaterialIcon(settingsButton, FontImage.MATERIAL_SETTINGS);
        
        Label space = new Label("", "TitlePictureSpace");
        space.setShowEvenIfBlank(true);
        Container titleComponent = 
                BorderLayout.north(
                    BorderLayout.west(menuButton).add(BorderLayout.EAST, settingsButton)
                ).
                add(BorderLayout.CENTER, space).
                add(BorderLayout.SOUTH, 
                        FlowLayout.encloseIn(
                                new Label("Wided ", "WelcomeBlue"),
                                new Label("LARAYEDH", "WelcomeWhite")
                                
                        ));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        Label separator = new Label("", "BlueSeparatorLine");
        separator.setShowEvenIfBlank(true);
        add(BorderLayout.NORTH, separator);
        

        XYMultipleSeriesDataset multi = new XYMultipleSeriesDataset();

        XYSeries seriesXY = new XYSeries("AAA", 0);
        multi.addSeries(seriesXY);
        seriesXY.add(3, 3);
        seriesXY.add(4, 4);
        seriesXY.add(5, 5);
        seriesXY.add(6, 4);
        seriesXY.add(7, 2);
        seriesXY.add(8, 5);

        seriesXY = new XYSeries("BBB", 0);
        multi.addSeries(seriesXY);
        seriesXY.add(3, 7);
        seriesXY.add(4, 6);
        seriesXY.add(5, 3);
        seriesXY.add(6, 2);
        seriesXY.add(7, 1);
        seriesXY.add(8, 4);

        
        setupSideMenu(res);
      
         // Form hi = new Form("Button");
    Button b = new Button("share");
    //hi.add(b);
    
      b.addActionListener((evt) -> {
            Display.getInstance().execute("https://www.facebook.com/sharer/sharer.php?u="
                    + "http://127.0.0.1:8000/produit/read");
        });
          this.res=res;
          currentForm=this;
        this.setLayout(new BorderLayout());
        
        addData(null);
        
  DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList mlTout = new MultiList(model);
  
  
  add(BorderLayout.NORTH,b);
  add(BorderLayout.CENTER, mlTout);
  
  mlTout.addActionListener(e->{
      HashMap <String,Object> m =  (HashMap <String,Object>) mlTout.getSelectedItem() ;
                Produit p = (Produit) m.get("produit");
                new ProduitInfoForm(res,currentForm,p).show();    
  });
       
    
  
    }
        
    @Override
    protected void showOtherForm(Resources res) {
        
    }
    
    private void addData(String cat){
        
       
      
  data = new ArrayList<>();
  int mm = Display.getInstance().convertToPixels(3);
  EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), true);
  String im ;
  for (Produit p : ProduitService.getInstance().getAllProduit()){
     
     //String URLIMAGE = "http://127.0.0.1:8000/Products/k9JrLFaoJumFNOscjigZt6W3a37Cbe.png";
         data.add(createListEntry(p));
      }
  }

    
    private Map<String, Object> createListEntry(Produit p) {
        
        
        
  Map<String, Object> entry = new HashMap<>();
  String URLIMAGE = p.getImage();
  URLIMAGE = "http://127.0.0.1:8001/public/images/"+p.getImage();
        //System.out.println(URLIMAGE);
      EncodedImage enc = null;
      try {
               enc = EncodedImage.create("/giphy.gif");
            } catch (IOException ex) {
                System.out.println("enc ERR");
            }
  Image imgg = URLImage.createToStorage(enc,URLIMAGE,URLIMAGE, URLImage.RESIZE_SCALE);
  entry.put("Line1", p.getNom());
  entry.put("Line2", p.getPrix()+" Dt");
  entry.put("icon", imgg);
  entry.put("produit",p);
  
  return entry;
}

}
    
    


