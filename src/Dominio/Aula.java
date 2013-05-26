/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Leticia
 */
@Entity
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Periodo periodo;
    
    private int diaDaSemana;
    
    protected Aula(){
        
    }

    public Aula(int diaDaSemana, Periodo periodo) {
        
        this.periodo = periodo;
        this.diaDaSemana = diaDaSemana;
        
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
        //hash += (id != null ? id.hashCode() : 0);
        hash += periodo.hashCode() + diaDaSemana*31;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Aula)) {
//            return false;
//        }
//        Aula other = (Aula) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
        
        Aula other = (Aula) object;
        if(this.diaDaSemana == other.diaDaSemana && this.periodo.equals(other.periodo) )
            return true;
        else
            return false; 
    }

    @Override
    public String toString() {
        return "Dominio.Aula[ id=" + id + " ]";
    }

    /**
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @return the diaDaSemana
     */
    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    public boolean bateCom(Aula aula2) {
        
        if(this.diaDaSemana != aula2.getDiaDaSemana()){
            return false;
        }
        
        Periodo p1 = this.getPeriodo();
        Periodo p2 = aula2.getPeriodo();
        
        if((p1.getLimiteSuperior().after(p2.getLimiteInferior()) && p1.getLimiteSuperior().before(p2.getLimiteSuperior()))  ||    
                ( p1.getLimiteInferior().after(p2.getLimiteInferior()) && p1.getLimiteInferior().before(p2.getLimiteSuperior())  )
          ){
            return true;  
          }
        
        return false;

    }
    
}
