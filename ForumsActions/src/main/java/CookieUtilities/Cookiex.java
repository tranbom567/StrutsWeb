/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CookieUtilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author PC
 */
public class Cookiex {
    public static String getCookieValue(String name,HttpServletRequest request,String defVal){
        Cookie[]allCookies=request.getCookies();
        if(allCookies!=null){
        for(Cookie c:allCookies){
            
            if(c.getName().equalsIgnoreCase(name)){
                return c.getValue();
            }
        }
        }
        return defVal;
    }
    public static Cookie oneYearCookie(String name,String value){
        Cookie c=new Cookie(name, value);
        c.setMaxAge(31536000);
        return c;
    }
}
