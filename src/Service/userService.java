/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author youssef
 */
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hazem
 */
public class userService {
    private ConnectionRequest req;
         public static userService  instance=null;
  public ArrayList<Utilisateur> tasks;
               public Utilisateur ti=new Utilisateur();
public boolean resultOK;
    private userService() {
         req = new ConnectionRequest();
    }
    
     public static userService getInstance() {
        if (instance == null) {
            instance = new userService();
        }
        return instance;
    }
     
         public ArrayList<Utilisateur> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                Utilisateur t = new Utilisateur();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                
                
                t.setUsername(obj.get("username").toString());
                t.setEmail(obj.get("email").toString());
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
     
          public Utilisateur parseUser(String jsonText){
       
                Utilisateur t = new Utilisateur();
              try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
          //  System.out.println(tasksListJson.get(0));
           
                if(tasksListJson.isEmpty()==false)
           {
               
                float id = Float.parseFloat(tasksListJson.get("id").toString());
                System.out.println(id);
                t.setId((int)id);
               
                t.setUsername(tasksListJson.get("username").toString());
                t.setEmail(tasksListJson.get("email").toString());
                t.setPassword(tasksListJson.get("password").toString());
                t.setRoles(tasksListJson.get("roles").toString());
                tasks.add(t);
           }
            
        } catch (IOException ex) {
            
        }
        return t;
    }

     
         public Utilisateur getUser(String username){
        String url ="http://127.0.0.1:8000/user/find/"+username;
       System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                ti = parseUser(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ti;
    }

         public boolean createUser(Utilisateur user) {
        String url = "http://127.0.0.1:8000/user/mobile_register?email="+user.getEmail()+"&username="+user.getUsername()+"&type="+user.getRoles()+"&password="+user.getPassword()+"&password_confirmation="+user.getConfirmationToken()+"&nom="+user.getNomUser()+"&prenom="+user.getPrenomUser();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
          
          public boolean updateUser(Utilisateur user, int id) {
       String url = "http://127.0.0.1:8000/user/updateusermobile?id="+id+"&email="+user.getEmail()+"&username="+user.getUsername()+"&password="+user.getPassword()+"&password_confirmation="+user.getConfirmationToken()+"&nom="+user.getNomUser()+"&prenom="+user.getPrenomUser();
 
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
          
          
          
    
}


