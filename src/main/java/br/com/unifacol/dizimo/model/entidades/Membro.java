package br.com.unifacol.dizimo.model.entidades;

import br.com.unifacol.dizimo.model.enums.Sexo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "membros")
public class Membro{

    private String nome;
    @Id
    private String cpf;
    private Integer idade;
    private LocalDate dataDeNascimento;
    private Sexo sexo;
    private Integer senha;
    @OneToOne
    private Endereco endereco;

    public Membro(String nome, String cpf, Integer idade, LocalDate dataDeNascimento, Sexo sexo, Integer senha, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Membro() {
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
