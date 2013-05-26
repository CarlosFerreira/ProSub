/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dominio.EstadoAusencia;
import Dominio.Professor;
import java.util.Calendar;

/**
 *
 * @author Thiago
 */
public class AusenciaModel {
    public Professor professorAusente;
    public Professor professorSubstituto;
    public Calendar dataInicio;
    public Calendar dataFim;
    public EstadoAusencia estado;
    public Long id;
    
    public String toStringProfessorAusente(){
        return ""+professorAusente+"";
    }
    public String toStringProfessorSubstituto() {
        return ""+professorSubstituto+"";
    }
    public String toStringDataInicio() {
        return ""+dataInicio+"";
    }
    public String toStringDataFim() {
        return ""+dataFim+"";
    }
    public String toStringEstado() {
        return ""+estado+"";
    }
    public String toStringId() {
        return ""+id+"";
    }
}
