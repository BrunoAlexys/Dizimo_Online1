package br.com.unifacol.dizimo.model.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "membro")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer senha;
    @OneToOne
    private DadosPessoais dadosPessoais;


    public Membro(Long id,Integer senha, DadosPessoais dadosPessoais) {
        this.id = id;
        this.senha = senha;
        this.dadosPessoais = dadosPessoais;
    }

    public Membro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }


    @Override
    public String toString() {
        return "\nID: " + this.getId() + "\nSenha: " + this.getSenha() +  this.getDadosPessoais().toString();
    }
}
