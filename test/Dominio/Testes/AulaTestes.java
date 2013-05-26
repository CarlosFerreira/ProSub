/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Testes;

import Dominio.Aula;
import Dominio.AulaComparator;
import Dominio.Periodo;
import Dominio.Professor;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leticia
 */
public class AulaTestes {
    
    private Aula objetoEmTeste;
    private Periodo periodo;
    private Periodo periodo2;
    
    Calendar limiteInfP1;
    Calendar limiteSupP1;
    Calendar limiteInfP2;
    Calendar limiteSupP2;
    
    public AulaTestes() {
    }
    
    @Before
    public void setUp() {
        
        //periodo = EasyMock.createMock(Periodo.class);
        
        limiteInfP1 = Calendar.getInstance();
        limiteSupP1 = Calendar.getInstance();
        limiteInfP1.set(0, 0, 0, 20, 0);
        limiteSupP1.set(0, 0, 0, 20, 50);
        
        periodo = new Periodo(limiteInfP1, limiteSupP1);
        //EasyMock.expect(periodo.getLimiteInferior()).andReturn(limiteInfP1);
        //EasyMock.expect(periodo.getLimiteSuperior()).andReturn(limiteSupP1);
        
        //periodo2 = EasyMock.createMock(Periodo.class);

        limiteInfP2 = Calendar.getInstance();
        limiteSupP2 = Calendar.getInstance();
                
        limiteInfP2.set(0, 0, 0, 20, 20);
        limiteSupP2.set(0, 0, 0, 21, 0);
        
        periodo2 = new Periodo(limiteInfP2, limiteSupP2);
        
        //EasyMock.expect(periodo2.getLimiteInferior()).andReturn(limiteInfP2);
        //EasyMock.expect(periodo2.getLimiteSuperior()).andReturn(limiteSupP2);
        
        objetoEmTeste = new Aula(Calendar.MONDAY, periodo);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void deveSerInicializadaComDiaDaSemanaEPeriodo() {
        
        Assert.assertEquals(objetoEmTeste.getDiaDaSemana(), Calendar.MONDAY);
        Assert.assertEquals(objetoEmTeste.getPeriodo(), periodo);
    }
    
    @Test
    public void testeDeveSerPossivelOrdenarPeriodosPorComparator(){
        
        Calendar limiteInfP1 = Calendar.getInstance();
        Calendar limiteSupP1 = Calendar.getInstance();
        limiteInfP1.set(0, 0, 0, 22, 40);
        limiteSupP1.set(0, 0, 0, 23, 59);
        
        
        Periodo p1 = new Periodo(limiteInfP1, limiteSupP1);
        
        Calendar limiteInfP2 = Calendar.getInstance();
        Calendar limiteSupP2 = Calendar.getInstance();
        
        limiteInfP2.set(0, 0, 0, 20, 40);
        limiteSupP2.set(0, 0, 0, 21, 40);
        
        Periodo p2 = new Periodo(limiteInfP2, limiteSupP2);
        
        Calendar limiteInfP3 = Calendar.getInstance();
        Calendar limiteSupP3 = Calendar.getInstance();
        
        limiteInfP3.set(0, 0, 0, 19, 45);
        limiteSupP3.set(0, 0, 0, 20, 59);
                
        Periodo p3 = new Periodo(limiteInfP3, limiteSupP3);
        
        
        Calendar limiteInfP4 = Calendar.getInstance();
        Calendar limiteSupP4 = Calendar.getInstance();
        
        limiteInfP4.set(0, 0, 0, 19, 15);
        limiteSupP4.set(0, 0, 0, 20, 00);
        
        Periodo p4 = new Periodo(limiteInfP4, limiteSupP4);
        
        Aula aula1 = new Aula(Calendar.MONDAY, p1);
        Aula aula2 = new Aula(Calendar.MONDAY, p2);
        Aula aula3 = new Aula(Calendar.MONDAY, p3);
        Aula aula4 = new Aula(Calendar.MONDAY, p4);
        
        List<Aula> aulas = new LinkedList<Aula>();
        
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);
        aulas.add(aula4);
        
        Collections.sort(aulas, new AulaComparator());
        
        junit.framework.Assert.assertEquals(aulas.toArray()[0], aula4);
        junit.framework.Assert.assertEquals(aulas.toArray()[1], aula3);
        junit.framework.Assert.assertEquals(aulas.toArray()[2], aula2);
        junit.framework.Assert.assertEquals(aulas.toArray()[3], aula1);
     
    }
    
    @Test
    public void testeDeveSerPossivelVerSeDuasAulasBatemNosDiasOuHorarios(){
        
        Aula aula2 = new Aula(Calendar.MONDAY, periodo2);
        
        Assert.assertTrue(objetoEmTeste.bateCom(aula2));
        
        

    }
}