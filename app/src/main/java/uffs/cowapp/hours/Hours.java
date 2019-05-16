package uffs.cowapp.hours;

import java.sql.Time;

public class Hours {
    private Long id;
    private Time hora_inicial;
    private Time hora_final;
    private Integer id_dia_semana;
    private Integer idAmbiente;
    private Float valor_hora;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(Time hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public Time getHora_final() {
        return hora_final;
    }

    public void setHora_final(Time hora_final) {
        this.hora_final = hora_final;
    }

    public Integer getId_dia_semana() {
        return id_dia_semana;
    }

    public void setId_dia_semana(Integer id_dia_semana) {
        this.id_dia_semana = id_dia_semana;
    }

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Float valor_hora) {
        this.valor_hora = valor_hora;
    }
}
