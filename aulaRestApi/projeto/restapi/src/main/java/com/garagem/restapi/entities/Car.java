package com.garagem.restapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Seguindo estrutura da tabela carro // 

@Entity // indica que essa classe são entidades

public class Car {
    @Id // Indica que o campo abaixo é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o campo será auto incrimental. 
    private int id;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String opcionais;
    
    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private int status;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getOpcionais() {
        return opcionais;
    }
    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}
