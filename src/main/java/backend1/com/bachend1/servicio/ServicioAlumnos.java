package backend1.com.bachend1.servicio;

import backend1.com.bachend1.negocito.DelegadoAlumnos;
import backend1.com.bachend1.servicio.objetosrespuesta.AlumnoRespuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/alumnos")
public class ServicioAlumnos {

    @Autowired
    private DelegadoAlumnos dalumnos;

    @RequestMapping(value = "/ver", method = RequestMethod.GET)
    public ResponseEntity<List<AlumnoRespuesta>> verAlumnos() {
        /* */

        List<AlumnoRespuesta> listado = dalumnos.consultarTodosLosAlumnitos();

        return new ResponseEntity<List<AlumnoRespuesta>>(listado, HttpStatus.OK);
    }

    @RequestMapping(value = "/crearalumno", method = RequestMethod.POST)
    public ResponseEntity<AlumnoRespuesta> crearAlumno(@RequestBody AlumnoRespuesta alumno_nuevo) {

        alumno_nuevo = dalumnos.registrarNuevoAlumno(alumno_nuevo);

        return new ResponseEntity<AlumnoRespuesta>(alumno_nuevo, HttpStatus.OK);

    }

    @RequestMapping(value = "/buscaralumno", method = RequestMethod.GET)
    public ResponseEntity<List<AlumnoRespuesta>> BuscarAlumnoPorEdad(@RequestParam Integer desde, @RequestParam Integer hasta) {

        List<AlumnoRespuesta> alumnos = dalumnos.ObtenerAlumnoPorRangoDeEdad(desde, hasta);

        return new ResponseEntity<List<AlumnoRespuesta>>(alumnos, HttpStatus.OK);

    }

}
