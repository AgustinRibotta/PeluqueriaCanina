package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

//     Traemos datos de nuestra IGU
    public void guardar(String nombreMasco, String raza, String color,
            String obs, String nombreDuenio, String ceDuenio, String alergico,
            String atenEspecial) {
        
//        Generamos duenio con los datos traidos
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(ceDuenio);        
            
//        Generamos mascota con los datos traidos
        Mascotas masco = new Mascotas();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEspecial);
        masco.setObservaciones(obs);
        masco.setUnDuenio(duenio);

//         Enviamos los datos a la contrladora de persistencias
        controlPersis.guardar(duenio, masco);
    }

    public List<Mascotas> traerlMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascotas traerlMascotas(int num_cliente) {
        return controlPersis.buscarMascota(num_cliente);
    }

    public void modificarMascota(Mascotas masco, String nombreMasco,
            String raza, String color, String obs, String nombreDuenio,
            String ceDuenio, String alergico, String atenEspecial) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(obs);
        masco.setAtencion_especial(atenEspecial);
        masco.setAlergico(alergico);
        
//        Modifico la mascota
        controlPersis.modificarMascota(masco);
 
//        Modifico la duenio        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(ceDuenio);
        this.modificarDuenio(dueno);

    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

 
    
}