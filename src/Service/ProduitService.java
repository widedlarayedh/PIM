/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Produit;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wided
 */
public class ProduitService {
    
    public ArrayList<Produit> produits;
      
    public static ProduitService instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    
    private ProduitService() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }
    
        public ArrayList<Produit> parseProduit(String jsonText){
        try {
            produits=new ArrayList<>();
            
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Produit produit = new Produit();
                float id = Float.parseFloat(obj.get("id").toString());
                produit.setId((int)id);
                produit.setNom(obj.get("nom").toString());
                produit.setImage(obj.get("image").toString());
                produit.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                produit.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
                System.out.println(produit);
               produits.add(produit);
            }
        } 
        catch (IOException ex) {
        }
        return produits;
        }
        
        public ArrayList<Produit> getAllProduit(){
        String url = "http://127.0.0.1:8000/produit/read2";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            produits = parseProduit(new String(connectionRequest.getResponseData()));
            connectionRequest.removeResponseListener(this);
            }
        });
                NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return produits;
    }
            
       /* public boolean createProduit(Produit reclamation) {
        String url = "http://127.0.0.1:5050/islem/Pi/web/app_dev.php/create2Reclamation?titre="+reclamation.getTitre()+"&nom="+reclamation.getNom()+"&email="+reclamation.getEmail()+"&tel="+reclamation.getTel()+"&description="+reclamation.getDescription();
        connectionRequest.setUrl(url);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = connectionRequest.getResponseCode() == 200; //Code HTTP 200 OK
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return resultOK;
    }*/
}
    

