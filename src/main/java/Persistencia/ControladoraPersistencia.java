package Persistencia;

import Logica.Duenio;
import Logica.Mascotas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
//     Generamos construcores de la persistencia
    DuenioJpaController duenioControler = new DuenioJpaController();
    MascotasJpaController mascotaControler = new MascotasJpaController();

//    Generamos los datos de Duenio y Mascota
    public void guardar(Duenio duenio, Mascotas masco) {
        duenioControler.create(duenio);
        mascotaControler.create(masco);
    }

    public List<Mascotas> traerMascotas() {
        return mascotaControler.findAllMascotas();
    }

    public void borrarMascota(int num_cliente) {

        try {
            mascotaControler.destroy(num_cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Mascotas buscarMascota(int num_cliente) {
        return mascotaControler.findMascota(num_cliente);
    }

    public void modificarMascota(Mascotas masco) {
        try {
            mascotaControler.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioControler.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioControler.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
