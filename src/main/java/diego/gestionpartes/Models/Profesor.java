package diego.gestionpartes.Models;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_profesor")
    private long id_profesor;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name="nombre")
    private String nombre;
    @Column(name = "numero_asignado")
    private int numero_asignado;
    @Column(name="tipo")
    private String tipo;

    @OneToMany(mappedBy = "profesor")
    private List<Parte> partes;

    public Profesor() {
    }

    @Override
    public String toString() {
        return nombre;
    }

    public long getId_profesor() {
        return id_profesor;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getNombre() {
        return nombre;
    }
    public int getNumero_asignado() {
        return numero_asignado;
    }
    public String getTipo() {
        return tipo;
    }
    public List<Parte> getPartes() {
        return partes;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNumero_asignado(int numero_asignado) {
        this.numero_asignado = numero_asignado;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
