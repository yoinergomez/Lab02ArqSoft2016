/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



public class CaptchaBean {

    private boolean captchaInvalido;
    
    public CaptchaBean() {
    }
    
    @PostConstruct
    public void init() {
        captchaInvalido=true;
    }

    public boolean isCaptchaInvalido() {
        return captchaInvalido;
    }

    public void setCaptchaInvalido(boolean captchaInvalido) {
        this.captchaInvalido = captchaInvalido;
    }
    
     public void check(){
          captchaInvalido=false;
          FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(FacesMessage.SEVERITY_INFO,"Su codigo es correcto",null));
          
          
          
 
    }  

}
