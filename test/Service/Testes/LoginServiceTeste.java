/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Testes;

import DataMapper.PopulateDB;
import DataMapper.UsuarioJpaController;
import DataMapper.exceptions.NonexistentEntityException;
import Dominio.Usuario;
import Service.LoginService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rick
 */
public class LoginServiceTeste {
    
    Usuario user;
    LoginService LgnService;
    List<Usuario> ListaUser;
    UsuarioJpaController UserController;
    
    
    public LoginServiceTeste() {
    }
    
    @Before
    public void setUp() {
        
        PopulateDB.recreateDB();
        
        user = new Usuario("Calebe","123456");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProSubPU");
        UserController = new UsuarioJpaController(emf);
        UserController.create(user);
        
        LgnService = new LoginService();
    }
    
    @After
    public void tearDown() {
        try {
            UserController.destroy(user.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LoginServiceTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testeValidaUsuarioeSenha(){

        
        Assert.assertTrue(LgnService.VerificarUsuarioESenha("Calebe", "123456"));
        Assert.assertFalse(LgnService.VerificarUsuarioESenha("Calebe", ""));
        Assert.assertFalse(LgnService.VerificarUsuarioESenha("noEcsiste", ""));
        
    }
    
}