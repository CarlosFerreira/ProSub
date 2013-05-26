/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Calendar;

/**
 *
 * @author Leticia
 */
public class TesteCalendar {
    
    public static void main (String[] args){
        
        Calendar um = Calendar.getInstance();
        Calendar dois = Calendar.getInstance();
        
        
        um.set(0, 0, 0, 20, 0);
        dois.set(0, 0, 0, 21, 40);
        
        if(dois.after(um))
            System.out.println("Dois vem depois de um");
    }
}
