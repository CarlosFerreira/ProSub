/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Leticia
 */
@Entity
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    
    @OneToMany
    @ElementCollection
    private List<Aula> grade;
    
    
    protected Professor(){}

    public Professor(String nome) {
        this.nome = nome;
        this.grade = new LinkedList<Aula>();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Professor[ id=" + id + " ]";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the grade
     */
    public List<Aula> getGrade() {
        return grade;
    }

    public void adicionarAula(Aula aula) {
        
        if(aula == null){
            throw new IllegalStateException("Aula inválida.");
        }
        if(grade.contains(aula)){
            throw new IllegalStateException("Professor já contem esta aula em sua grade");
        }
        
        grade.add(aula);
        
    }

    public boolean  EhCompativelCom(List<Aula> aulas) {
        
        Collections.sort(this.grade, new AulaComparator());
        
        boolean ehCompativel = true;

        for(Aula aulaIntruso : aulas){
            for(Aula minhaAula : this.getGrade()) {
                if(minhaAula.bateCom(aulaIntruso) || aulaIntruso.bateCom(minhaAula) ){
                    ehCompativel = false;
                    break;
                }
            } 
        }
        return ehCompativel;

    }

    public List<Aula> verificarAulasPerdidasNoPeriodo(Periodo periodoAusencia) {
        
        int diasEntre = this.diasEntre(periodoAusencia);
        
        Calendar data = periodoAusencia.getLimiteInferior();
        Calendar finalAusencia = periodoAusencia.getLimiteSuperior();
        
        finalAusencia.set(Calendar.HOUR_OF_DAY, 23);
        finalAusencia.set(Calendar.MINUTE, 59);
        
        List<Aula> aulasComprometidas = new LinkedList<Aula>();
        
        while(data.before(periodoAusencia.getLimiteSuperior())){
            
            for(Aula aula : this.grade){
                if(data.get(Calendar.DAY_OF_WEEK) == aula.getDiaDaSemana()){
                    aulasComprometidas.add(aula);
                }
            }
            
            data.add(Calendar.DAY_OF_MONTH, 1);
            
            if(aulasComprometidas.size() == this.grade.size()){
                break;
            }   
        }
        
        return aulasComprometidas;
    }
   
    private int diasEntre(Periodo periodo){
        
        Calendar comeco = periodo.getLimiteInferior();
        Calendar fim = periodo.getLimiteSuperior();
        
        Calendar data = (Calendar)comeco.clone();
        
        int diasEntre = 0;
        
        if(comeco.equals(fim)){
            diasEntre = 2; //Contando os extremos
        }else{
            diasEntre = 1;
        }
        
        while(data.before(fim)){
            data.add(Calendar.DAY_OF_MONTH, 1);
            diasEntre++;
        }
        
        return diasEntre;
    }
    
}
