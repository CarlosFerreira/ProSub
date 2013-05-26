/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import DataMapper.AusenciaJpaController;
import DataMapper.PeriodoJpaController;
import DataMapper.ProfessorJpaController;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Leticia
 */
public class TesteDasEntities {
    
    public static void main (String[] args){
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProSubPU");
        
        ProfessorJpaController profController = new ProfessorJpaController(emf);
        AusenciaJpaController ausenciaController = new AusenciaJpaController(emf);
        PeriodoJpaController periodoController = new PeriodoJpaController(emf);
        
        Professor p = new Professor("calebe");
        Professor p2 = new Professor("bob");
        
        profController.create(p);
        profController.create(p2);
        
        Calendar limiteInf = Calendar.getInstance();
        limiteInf.set(1900 + 113, 05, 24, 10, 40);
        
        Calendar limiteSup = Calendar.getInstance();
        limiteSup.set(1900 + 113, 05, 25, 10, 40);
        
        Periodo periodo = new Periodo(limiteInf, limiteSup);
        periodoController.create(periodo);
        
        Ausencia ausencia = new Ausencia(periodo, p, "Dor de barriga");
        
        ausenciaController.create(ausencia);

    }
    
}
