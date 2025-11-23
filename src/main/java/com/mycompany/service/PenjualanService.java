package com.mycompany.service;

import com.mycompany.entity.Penjualan;
import com.mycompany.jpa.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PenjualanService {

    public void insert(Penjualan p) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Penjualan p) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Penjualan p = em.find(Penjualan.class, id);

        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
        em.close();
    }

    public Penjualan getById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Penjualan p = em.find(Penjualan.class, id);
        em.close();
        return p;
    }

    public List<Penjualan> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Penjualan> q = em.createNamedQuery("Penjualan.findAll", Penjualan.class);
        List<Penjualan> list = q.getResultList();
        em.close();
        return list;
    }
}
