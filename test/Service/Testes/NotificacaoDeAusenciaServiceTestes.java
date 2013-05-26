/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Testes;

import DataMapper.AusenciaJpaController;
import DataMapper.ProfessorJpaController;
import Dominio.Professor;
import Service.NotificacaoDeAusenciaService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Leticia
 */
public class NotificacaoDeAusenciaServiceTestes {
    
    private NotificacaoDeAusenciaService serviceEmTeste;
    private EntityManagerFactory emf;
    
    @BeforeClass
    public static void classSetUp(){
        //emf = Persistence.createEntityManagerFactory("ProSubPU");
        
        
    }
    
    @Before
    public void setUp() {
        
        
        serviceEmTeste = new NotificacaoDeAusenciaService();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testeDeveSerPossivelNotificarUmaAusencia() {
         
         ProfessorJpaController controller = new ProfessorJpaController(emf);
         
         List<Professor> professores = controller.findProfessorEntities();
         
         String dataInicio = "20/05/2013";
         String dataFim = "24/05/2013";
         String motivo = "Problemas pessoais";
         
         serviceEmTeste.notificarAusencia(professores.get(0).getId(), dataInicio, dataFim, motivo, professores.get(1));
         
         //AusenciaJpaController controller = new AusenciaJpaController(emf);
         
         
         
     }
}