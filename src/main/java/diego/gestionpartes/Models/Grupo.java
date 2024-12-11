package diego.gestionpartes.Models;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_grupo")
    private long id_grupo;
    @Column(name = "nombre_grupo")
    private String nombre_grupo;

    @OneToMany(mappedBy = "grupo")
    private List<Alumno> alumnos;

    public Grupo() {}

    @Override
    public String toString() {
        return nombre_grupo;
    }

    public long getId_grupo() {
        return id_grupo;
    }
    public String getNombre_grupo() {
        return nombre_grupo;
    }
    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
