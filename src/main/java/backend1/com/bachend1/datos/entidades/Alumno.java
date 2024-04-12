package backend1.com.bachend1.datos.entidades;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalumno")
    private Integer idalumno;
    
    @Column(name = "documento")
    private Integer documento;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "edad")
    private Integer edad;

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    
    
}
