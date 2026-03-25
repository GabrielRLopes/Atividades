package com.bn.exercicios.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NomeDepartamento")
    private String nome;

    @Column(name="LocalizacaoDepartamento")
    private String localizacao;

    public Departamento(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
