package Persistencia;

import Logica.Mascotas;
import javax.persistence.*;
import java.util.List;

public class MascotasJpaController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Create
    public void create(Mascotas mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMascota(mascota.getNum_cliente()) != null) {
                System.out.println("Mascota con ID " + mascota.getNum_cliente() + " ya existe.");
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Read
    public Mascotas findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascotas.class, id);
        } finally {
            em.close();
        }
    }

    public List<Mascotas> findAllMascotas() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Mascotas> query = em.createQuery("SELECT m FROM Mascotas m", Mascotas.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Update
    public void edit(Mascotas mascota) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(mascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMascota(mascota.getNum_cliente()) == null) {
                throw new Exception("La mascota con ID " + mascota.getNum_cliente() + " no existe.");
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
            Mascotas mascota;
            try {
                mascota = em.getReference(Mascotas.class, id);
                mascota.getNum_cliente(); // Ensure it exists
            } catch (EntityNotFoundException enfe) {
                throw new Exception("La mascota con ID " + id + " no existe.", enfe);
            }
            em.remove(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
