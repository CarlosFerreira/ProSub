/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Leticia
 */
@Entity
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar limiteInferior;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar limiteSuperior;
    
    protected Periodo(){   
    }

    public Periodo(Calendar limiteInf, Calendar limiteSup) {
        
        if(!limiteInf.before(limiteSup)){
            throw new IllegalStateException("Limite superior vem antes do limite inferior");
        }
        
        this.limiteInferior = limiteInf;
        this.limiteSuperior = limiteSup;
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
//        hash += (id != null ? id.hashCode() : 0);
        hash += this.limiteInferior.hashCode() + this.limiteSuperior.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Periodo)) {
//            return false;
//        }
//        Periodo other = (Periodo) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
        
        Periodo other = (Periodo) object;
        
        if(this.limiteInferior.equals(other.limiteInferior) && this.limiteSuperior.equals(other.limiteSuperior)){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public String toString() {
        return "Dominio.Periodo[ id=" + id + " ]";
    }

    /**
     * @return the limiteInferior
     */
    public Calendar getLimiteInferior() {
        return limiteInferior;
    }

    /**
     * @return the limiteSuperior
     */
    public Calendar getLimiteSuperior() {
        return limiteSuperior;
    }
}
