/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.model.dao;

import br.edu.ifms.lp3.model.Pais;
import br.edu.ifms.lp3.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author sidneysousa
 */
public class PaisDAO {
    
    public List<Pais> recuperaTudo() {
        List<Pais> paises = new ArrayList<>();
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            Query consulta = em.createNamedQuery(Pais.RECUPERA_TUDO);
            paises = consulta.getResultList();
            em.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return paises;
    }
    
}
