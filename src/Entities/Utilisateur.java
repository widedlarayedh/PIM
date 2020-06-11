/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Mohamed
 */
public class Utilisateur {
    
    private Integer id;
    private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private Integer enabled;
    private String salt;
    private String password;
    private Date lastLogin;
    private String confirmationToken;
    private Date passwordRequestedAt;
    private String roles;
    private String nomUser;
    private String prenomUser;
    private String image;

    public Utilisateur(Integer id, String username, String usernameCanonical, String email, 
            String emailCanonical, Integer enabled, String salt, String password, Date lastLogin, 
            
            String confirmationToken, Date passwordRequestedAt, String roles, String nomUser, String prenomUser, String image) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.image = image;
    }

    public Utilisateur(String username, String email, Integer enabled, String roles, String image) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
        this.image = image;
    }
        public Utilisateur(int id,String username, String email, Integer enabled, String roles, String image) {
            this.id=id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
        this.image = image;
    }
        public Utilisateur(int id) {
            this.id=id;
     
    }

    public Utilisateur(Integer id, String username, String usernameCanonical, String email, String emailCanonical, Integer enabled, String salt, String password, String confirmationToken, String roles, String nomUser, String prenomUser, String image) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.image = image;
    }
    public Utilisateur(String username, String email, String password, String confirmationToken, String roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
    }
    
    public Utilisateur(String username, String email, String password, String confirmationToken, String roles, String nomUser, String prenomUser) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
    }
    
    public Utilisateur(Integer id,String username, String email, String password, String confirmationToken, String nomUser, String prenomUser) {
        
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmationToken = confirmationToken;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        
    }
    

    public Utilisateur() {
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", username=" + username + ", usernameCanonical=" + usernameCanonical + ", email=" + email + ", emailCanonical=" + emailCanonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + lastLogin + ", confirmationToken=" + confirmationToken + ", passwordRequestedAt=" + passwordRequestedAt + ", roles=" + roles + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}