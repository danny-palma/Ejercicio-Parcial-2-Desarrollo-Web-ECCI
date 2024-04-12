package backend1.com.bachend1.negocito;

import backend1.com.bachend1.datos.entidades.Alumno;
import backend1.com.bachend1.datos.repositorios.RepositorioAlumnos;
import backend1.com.bachend1.servicio.objetosrespuesta.AlumnoRespuesta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelegadoAlumnos {

    @Autowired
    private RepositorioAlumnos repo_alumnos;

    public List<AlumnoRespuesta> consultarTodosLosAlumnitos() {
        List<AlumnoRespuesta> respuesta = new ArrayList<AlumnoRespuesta>();
        List<Alumno> entidades = repo_alumnos.findAll();

        for (Alumno alumno : entidades) {
            AlumnoRespuesta ralumno = new AlumnoRespuesta();
            ralumno.setClave(alumno.getClave());
            ralumno.setDocumento(alumno.getDocumento());
            ralumno.setEdad(alumno.getEdad());
            ralumno.setIdalumno(alumno.getIdalumno());
            ralumno.setNombre(alumno.getNombre());

            respuesta.add(ralumno);
        }
        return respuesta;
    }

    public AlumnoRespuesta registrarNuevoAlumno(AlumnoRespuesta alumno_nuevo) {
        Alumno alumnito_nuevito = new Alumno();
        alumnito_nuevito.setClave(alumno_nuevo.getClave());
        alumnito_nuevito.setDocumento(alumno_nuevo.getDocumento());
        alumnito_nuevito.setEdad(alumno_nuevo.getEdad());
        alumnito_nuevito.setNombre(alumno_nuevo.getNombre());

        alumnito_nuevito = repo_alumnos.save(alumnito_nuevito);

        if (alumnito_nuevito != null) {
            alumno_nuevo.setIdalumno(alumnito_nuevito.getIdalumno());

        }
        
        return alumno_nuevo;
    }

    public List<AlumnoRespuesta> ObtenerAlumnoPorRangoDeEdad(Integer Desde, Integer Hasta) {
        List<Alumno> alumnos = repo_alumnos.findByEdadBetween(Desde, Hasta);
        List<AlumnoRespuesta> respuesta = new ArrayList<>();

        for (Alumno alumno : alumnos) {
            AlumnoRespuesta ralumno = new AlumnoRespuesta();
            ralumno.setClave(alumno.getClave());
            ralumno.setDocumento(alumno.getDocumento());
            ralumno.setEdad(alumno.getEdad());
            ralumno.setIdalumno(alumno.getIdalumno());
            ralumno.setNombre(alumno.getNombre());
            respuesta.add(ralumno);
        }

        return respuesta;
    }
    
}
