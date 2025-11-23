package com.mycompany.service;

import com.mycompany.entity.Customer;
import com.mycompany.jpa.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class CustomerService {

    public List<Customer> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createNamedQuery("Customer.findAll", Customer.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public Customer getById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public void insert(Customer c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Customer c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, id);
            if (c != null) em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void clearAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Customer").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Customer findByNama(String nama) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Customer> list = em.createNamedQuery("Customer.findByNama", Customer.class)
                                    .setParameter("nama", nama)
                                    .getResultList();
            return list.isEmpty() ? null : list.get(0);
        } finally {
            em.close();
        }
    }

}
