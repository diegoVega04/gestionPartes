package diego.gestionpartes.Models;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "puntuacion_partes")
public class Puntos_partes {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_punt_partes")
    private int id_punt_partes;
    @Column(name = "puntos")
    private int puntos;
    @Column(name="tipo_parte")
    private String tipo_parte;

    @OneToMany(mappedBy = "puntos_partes")
    private List<Parte> partes;

    public Puntos_partes() {
    }

    public int getPuntos() {
        return puntos;
    }

    public String getTipo_parte() {
        return tipo_parte;
    }

    public List<Parte> getPartes() {
        return partes;
    }
}
