/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataMapper.AusenciaJpaController;
import DataMapper.exceptions.NonexistentEntityException;
import Dominio.Aula;
import Dominio.Ausencia;
import Dominio.Periodo;
import Dominio.Professor;
import java.util.Calendar;

/**
 *
 * @author Thiago Lima
 */
public class NotificacaoService {
    
    private Ausencia ausencia;
    private Periodo periodo;
    private Professor professorAusente;
    private Professor professorSubstituto;
    private Calendar dataInicio;
    private Calendar dataFim;
    private Aula aulaInicio;
    private Aula aulaFim;
    private String motivo;
    private AusenciaJpaController ausenciaJpaController;
    
    
    private NotificacaoService(){
        
    }
    
    public void SalvarNotificacao(Professor professorAusente, Professor professorSubstituto, Calendar dataInicio, Calendar dataFim, Aula aulaInicio, Aula aulaFim, String motivo) {
        periodo = new Periodo(dataInicio, dataFim);
        ausencia = new Ausencia(periodo, professorAusente, motivo);
        
        if (professorSubstituto != null) {
            ausencia.indicarSubstituto(professorSubstituto);
        }
        
        ausenciaJpaController.create(ausencia);
    }
    
    public void EditarNotificacao(Professor professorAusente, Professor professorSubstituto, Calendar dataInicio, Calendar dataFim, Aula aulaInicio, Aula aulaFim, String motivo, Long id) throws NonexistentEntityException, Exception {
        periodo = new Periodo(dataInicio, dataFim);
        ausencia = new Ausencia(periodo, professorAusente, motivo);
        
        ausencia.setId(id);
        
        ausenciaJpaController.edit(ausencia);
    }
}
