package com.mycompany.service;

import com.mycompany.entity.UserLogin;
import javax.persistence.*;

public class UserLoginService {

    private final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("ShowroomPU");

    // LOGIN
    public UserLogin login(String username, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM UserLogin u WHERE u.username = :u AND u.password = :p", UserLogin.class)
                    .setParameter("u", username)
                    .setParameter("p", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    // CARI USERNAME
    public UserLogin findByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                "SELECT u FROM UserLogin u WHERE u.username = :uname",
                UserLogin.class
            )
            .setParameter("uname", username)
            .getResultStream()
            .findFirst()
            .orElse(null);
        } finally {
            em.close();
        }
    }

    // CARI EMAIL
    public UserLogin findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                "SELECT u FROM UserLogin u WHERE u.email = :email",
                UserLogin.class
            )
            .setParameter("email", email)
            .getResultStream()
            .findFirst()
            .orElse(null);
        } finally {
            em.close();
        }
    }

    // UPDATE PASSWORD
    public void updatePassword(UserLogin user, String newPassword) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            user.setPassword(newPassword);
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // REGISTER USER DENGAN EMAIL
    public void registerUser(String username, String password, String barang) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        UserLogin u = new UserLogin();
        u.setUsername(username);
        u.setPassword(password);
        u.setBarangDiMeja(barang); // field baru

        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
}
