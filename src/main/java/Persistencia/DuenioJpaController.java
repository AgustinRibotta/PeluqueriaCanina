package Persistencia;

import Logica.Duenio;
import javax.persistence.*;
import java.util.List;

public class DuenioJpaController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PeluCaninaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Create
    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDuenio(duenio.getId_duenio()) != null) {
                System.out.println("Dueño con ID " + duenio.getId_duenio() + " ya existe.");
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Read
    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

    public List<Duenio> findAllDuenios() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Duenio> query = em.createQuery("SELECT d FROM Duenio d", Duenio.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Update
    public void edit(Duenio duenio) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDuenio(duenio.getId_duenio()) == null) {
                throw new Exception("El dueño con ID " + duenio.getId_duenio() + " no existe.");
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Delete
    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId_duenio(); // Ensure it exists
            } catch (EntityNotFoundException enfe) {
                throw new Exception("El dueño con ID " + id + " no existe.", enfe);
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
