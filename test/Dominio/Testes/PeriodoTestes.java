/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Testes;

import Dominio.Periodo;
import Dominio.AulaComparator;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leticia
 */
public class PeriodoTestes {
    
    private Periodo objetoEmTeste;
    private Calendar limiteInf;
    private Calendar limiteSup;
    
    public PeriodoTestes() {
    }
    
    @Before
    public void setUp() {
        int anoInf = 113;
        int mesInf = 05;
        int diaInf = 10;
        int horaInf = 15;
        int minInf = 10;
        
        int anoSup = 113;
        int mesSup = 07;
        int diaSup = 10;
        int horaSup = 15;
        int minSup = 10;
        
        
        limiteInf = Calendar.getInstance();
        limiteInf.set(anoInf + 1900, mesInf, diaInf, horaInf, minInf);
        
        limiteSup = Calendar.getInstance();
        limiteSup.set(anoSup + 1900, mesSup, diaSup, horaSup, minSup );
        
        objetoEmTeste = new Periodo(limiteInf, limiteSup);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testeDeveSerPossivelCriarUmPeriodoComLimiteInferiorELimiteSuperior() {
        
        Assert.assertEquals(objetoEmTeste.getLimiteInferior(), limiteInf);
        Assert.assertEquals(objetoEmTeste.getLimiteSuperior(), limiteSup);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testeSohEhInstanciaValidaSeLimiteInferiorVierAntesDeLimiteSuperior(){

        int mesSupErrado = 04;
        
        limiteSup.set(Calendar.MONTH, mesSupErrado);
        
        Periodo outro = new Periodo(limiteInf, limiteSup);
    }
    

        
}
