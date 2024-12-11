package diego.gestionpartes.Models;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="partes_incidencia")
public class Parte {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_parte")
    private long id_parte;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "sancion")
    private String sancion;

    @ManyToOne
    @JoinColumn(name="id_alum", referencedColumnName = "id_alum")
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupo;
    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    private Profesor profesor;
    @ManyToOne
    @JoinColumn(name = "id_punt_partes", referencedColumnName = "id_punt_partes")
    private Puntos_partes puntos_partes;

    public Parte() {
    }

    public int getExpediente_alumno() {
        return alumno != null ? alumno.getNumero_expediente() : 0;
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Puntos_partes getPuntos_partes() {
        return puntos_partes;
    }

    public void setPuntos_partes(Puntos_partes puntos_partes) {
        this.puntos_partes = puntos_partes;
    }

    public long getId_parte() {
        return id_parte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
