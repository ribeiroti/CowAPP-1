package uffs.cowapp.placeLocation;

import java.sql.Time;
import java.util.Date;

public class PlaceLocation {
    private Long id;
    private Date data_entrada;
    private Date data_saida;
    private Time hora_entrada;
    private Time hora_saida ;
    private Float valor;
    private Integer idpessoa;
    private Integer idambiente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Time hora_saida) {
        this.hora_saida = hora_saida;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Integer getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(Integer idambiente) {
        this.idambiente = idambiente;
    }
}
