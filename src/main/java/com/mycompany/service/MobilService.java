package com.mycompany.service;

import com.mycompany.entity.Mobil;
import com.mycompany.jpa.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MobilService {

    public void insert(Mobil m) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Mobil m) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Mobil m = em.find(Mobil.class, id);

        if (m != null) {
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
        }
        em.close();
    }

    public Mobil getById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Mobil m = em.find(Mobil.class, id);
        em.close();
        return m;
    }

    public List<Mobil> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Mobil> q = em.createNamedQuery("Mobil.findAll", Mobil.class);
        List<Mobil> list = q.getResultList();
        em.close();
        return list;
    }
}
