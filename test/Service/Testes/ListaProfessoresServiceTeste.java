/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Testes;

import DataMapper.PopulateDB;
import DataMapper.ProfessorJpaController;
import Dominio.Professor;
import Modelos.ProfessorModel;
import Service.ListaProfessoresService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rick
 */
public class ListaProfessoresServiceTeste {
    
    private ListaProfessoresService serviceEmTeste;
    
    @Before
    public void setUp() {
        
        PopulateDB.fullSetupDB();
        serviceEmTeste = new ListaProfessoresService();
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testeDeveListarTodosOsProfessores() {
        
        List<ProfessorModel> modelos = serviceEmTeste.ListarProfessores();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProSubPU");
        ProfessorJpaController controller = new ProfessorJpaController(emf);
        
        List<Professor> professores = controller.findProfessorEntities();
        
        Assert.assertEquals(professores.size(), modelos.size());
        Assert.assertEquals("Calebe", modelos.get(0).Nome);
        Assert.assertEquals("Ana Claudia", modelos.get(1).Nome);
        
        
    }
}