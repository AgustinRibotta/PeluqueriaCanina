package Persistencia;

import Logica.Duenio;
import Logica.Mascotas;
import java.util.List;

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
    
    
}
