package Persistencia;

import Logica.Duenio;
import Logica.Mascotas;

public class ControladoraPersistencia {
    
//     Generamos construcores de la persistencia
    DuenioJpaController duenioControler = new DuenioJpaController();
    MascotasJpaController mascotaControler = new MascotasJpaController();

//    Generamos los datos de Duenio y Mascota
    public void guardar(Duenio duenio, Mascotas masco) {
        duenioControler.create(duenio);
        mascotaControler.create(masco);
    }
    
    
}
