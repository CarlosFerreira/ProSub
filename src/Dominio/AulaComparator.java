/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author Leticia
 */
public class AulaComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Aula aula1 = (Aula) o1;
        Periodo p1 = aula1.getPeriodo();
        
        Aula aula2 = (Aula) o2;
        Periodo p2 = aula2.getPeriodo();
        
        int flag = 0;
        
        if(aula1.getDiaDaSemana() > aula2.getDiaDaSemana() ){
            flag = -1;
        }else if(aula1.getDiaDaSemana() < aula2.getDiaDaSemana()){
            flag = 1;
        } else{
            if(p1.getLimiteInferior().before(p2.getLimiteInferior())){
                flag = -1;
            } else {
                if(p1.getLimiteInferior().after(p2.getLimiteInferior())){
                        flag = 1;
                }             
            }
        }   
        return flag;
            
    }
}
