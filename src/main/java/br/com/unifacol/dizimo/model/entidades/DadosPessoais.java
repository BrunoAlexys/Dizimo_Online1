package br.com.unifacol.dizimo.model.entidades;

import br.com.unifacol.dizimo.model.enums.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "dados_pessoais")
public class DadosPessoais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Id
    private String cpf;
    private Integer idade;
    private LocalDate dataDeNascimento;
    private Sexo sexo;
    @OneToOne
    private Endereco endereco;

    public DadosPessoais(String nome, String cpf, Integer idade, LocalDate dataDeNascimento, Sexo sexo, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public DadosPessoais() {
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

    @Override
    public String toString() {
        return "\nID: + " + "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nIdade: " + this.getIdade() +
                "\nData de nascimento: " + this.getDataDeNascimento() + "\nSexo: " + this.getSexo() +
                "Endereco: " + this.getEndereco().toString();
    }
}
