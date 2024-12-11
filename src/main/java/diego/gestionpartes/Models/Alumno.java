package diego.gestionpartes.Models;

import javax.persistence.CascadeType;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_alum")
    private long id_alum;
    @Column(name = "puntos_acumulados")
    private int puntos_acumulados;
    @Column(name = "nombre_alum")
    private String nombre_alum;
    @Column(name = "numero_expediente")
    private int numero_expediente;

    @ManyToOne
    @JoinColumn(name="id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupo;
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Parte> partes;

    public Alumno() {}

    @Override
    public String toString() {
        return nombre_alum;
    }

    public long getId_alum() {
        return id_alum;
    }

    public int getPuntos_acumulados() {
        return puntos_acumulados;
    }

    public String getNombre_alum() {
        return nombre_alum;
    }

    public int getNumero_expediente() {
        return numero_expediente;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPuntos_acumulados(int puntos_acumulados) {
        this.puntos_acumulados = puntos_acumulados;
    }

    public void setNombre_alum(String nombre_alum) {
        this.nombre_alum = nombre_alum;
    }

    public void setNumero_expediente(int numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
