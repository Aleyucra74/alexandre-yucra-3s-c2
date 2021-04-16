package br.com.bandtec.lutalivreac2.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Lutador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 12)
    private String nome;

    @Positive
    private Double forcaGolpe;

    private Double vida;

    private Integer concentracoesRealizadas;

    private boolean vivo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForcaGolpe() {
        return forcaGolpe;
    }

    public void setForcaGolpe(Double forcaGolpe) {
        this.forcaGolpe = forcaGolpe;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Integer getConcentracoesRealizadas() {
        return concentracoesRealizadas;
    }

    public void setConcentracoesRealizadas(Integer concentracoesRealizadas) {
        this.concentracoesRealizadas = concentracoesRealizadas;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
