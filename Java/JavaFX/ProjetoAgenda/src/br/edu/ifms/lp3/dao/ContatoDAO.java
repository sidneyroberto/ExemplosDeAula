package br.edu.ifms.lp3.dao;

import br.edu.ifms.lp3.model.Contato;
import br.edu.ifms.lp3.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ContatoDAO {

    public boolean salva(Contato contato) {
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            EntityTransaction transacao = em.getTransaction();
            transacao.begin();
            em.persist(contato);
            transacao.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Contato atualiza(Contato contato) {
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            EntityTransaction transacao = em.getTransaction();
            transacao.begin();
            contato = em.merge(contato);
            transacao.commit();
            em.close();
            return contato;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean remove(Contato contato) {
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            EntityTransaction transacao = em.getTransaction();
            transacao.begin();
            contato = em.find(Contato.class, contato.getId());
            em.remove(contato);
            transacao.commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Contato> recuperaPorNome(String nome, int inicio, int quantidade) {
        List<Contato> contatos = new ArrayList<>();
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            Query query = em.createNamedQuery(Contato.RECUPERA_POR_NOME);
            query.setParameter("nome", "%" + nome + "%");
            query.setFirstResult(inicio);
            query.setMaxResults(quantidade);
            contatos = query.getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contatos;
    }

    public Long contaQuantidade(String nome) {
        Long quantidade = 0L;
        try {
            EntityManager em = JpaUtil.criaEntityManager();
            Query query = em.createNamedQuery(Contato.CONTA_QUANTIDADE);
            query.setParameter("nome", "%" + nome + "%");
            quantidade = (Long) query.getSingleResult();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quantidade;
    }
}
