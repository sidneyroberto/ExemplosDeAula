package br.edu.ifms.lp3.util;

import br.edu.ifms.lp3.model.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaUtil {
    
    private JpaUtil(){}
    
    public static EntityManager criaEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        return emf.createEntityManager();
    }
    
}
