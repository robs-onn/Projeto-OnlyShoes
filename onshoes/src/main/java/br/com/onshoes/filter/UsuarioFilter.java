package br.com.onshoes.filter;

import java.time.LocalDate;
// CORREÇÃO: O import foi alterado de 'Status' para 'StatusUsuario'.
import br.com.onshoes.model.Usuario.StatusUsuario;
import br.com.onshoes.model.Usuario.TipoUsuario;

public class UsuarioFilter {

    private String nome;
    private String username;
    private String email;
    private TipoUsuario papel;
    // CORREÇÃO: O tipo do campo foi alterado de 'Status' para 'StatusUsuario'.
    private StatusUsuario status;
    private LocalDate dataCriacaoInicio;
    private LocalDate dataCriacaoFim;

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getPapel() {
        return papel;
    }

    public void setPapel(TipoUsuario papel) {
        this.papel = papel;
    }

    // CORREÇÃO: O tipo foi alterado nos métodos get/set.
    public StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }

    public LocalDate getDataCriacaoInicio() {
        return dataCriacaoInicio;
    }

    public void setDataCriacaoInicio(LocalDate dataCriacaoInicio) {
        this.dataCriacaoInicio = dataCriacaoInicio;
    }

    public LocalDate getDataCriacaoFim() {
        return dataCriacaoFim;
    }

    public void setDataCriacaoFim(LocalDate dataCriacaoFim) {
        this.dataCriacaoFim = dataCriacaoFim;
    }
}