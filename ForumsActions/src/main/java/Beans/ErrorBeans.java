/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author PC
 */
public class ErrorBeans {
    private String nameError,passwordError,emailError,bornError;
    public void setNameError(String baseError){
        nameError=baseError;
    }
        public void setPasswordError(String baseError){
        passwordError=baseError;
    }
            public void setEmailError(String baseError){
        emailError=baseError;
    }
                public void setBornError(String baseError){
        bornError=baseError;
    }
                public String getNameError(){
                    return nameError;
                }
                    public String getPasswordError(){
                    return passwordError;
                }
                        public String getEmailError(){
                    return emailError;
                }
                            public String getBornError(){
                    return bornError;
                }
}
