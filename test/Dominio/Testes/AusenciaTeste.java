package Dominio.Testes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Dominio.Ausencia;
import Dominio.EstadoAusencia;
import Dominio.Periodo;
import Dominio.Professor;
import java.lang.reflect.Field;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.easymock.*;

/**
 *
 * @author Leticia
 */
public class AusenciaTeste {
    
    private Professor professor;
    private Professor professorSubstituto;
    private Periodo periodo;
    private Ausencia ausencia;
    private String motivo;
    private EstadoAusencia estado;
    
    public AusenciaTeste() {
    }
    
    @Before
    public void setUp() {
        
        professor = EasyMock.createMock(Professor.class);
        professorSubstituto = EasyMock.createMock(Professor.class);
        motivo = "Congresso internacional";
        ausencia = new Ausencia(periodo, professor, motivo);
        estado = EstadoAusencia.Alocacao_Pendente;
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testeDeveSerInicializadoComPeriodoProfessorMotivoESemProfessorSubstituto() {
        Assert.assertEquals(ausencia.getPeriodo(), periodo);
        Assert.assertEquals(ausencia.getProfessor(), professor);
        Assert.assertEquals(ausencia.getMotivo(), motivo);
        Assert.assertEquals(ausencia.getIndicacaoSubstituto(), null);
        Assert.assertEquals(ausencia.getEstado(), estado);
    }
    
    @Test
    public void testeDeveSerPossívelIndicarProfessorSubstitutoEmUmaAusencia(){
        ausencia.indicarSubstituto(professorSubstituto);
        
        Assert.assertEquals(ausencia.getIndicacaoSubstituto(), professorSubstituto);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testeNaoEhPossivelIndicarProprioProfessorAusenteComoSubstituto(){
        ausencia.indicarSubstituto(professor);
    }
}