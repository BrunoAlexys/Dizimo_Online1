package br.com.unifacol.dizimo.model.service;

import br.com.unifacol.dizimo.model.entidades.Endereco;
import br.com.unifacol.dizimo.model.entidades.Membro;
import br.com.unifacol.dizimo.model.enums.Estado;
import br.com.unifacol.dizimo.model.enums.Sexo;
import br.com.unifacol.dizimo.model.interfaceService.IMembroService;
import br.com.unifacol.dizimo.model.repository.MembroRepository;
import br.com.unifacol.dizimo.model.validacao.ValidadorCPF;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MembroService implements IMembroService {

    private MembroRepository membroRepository;
    private ValidadorCPF validadorCPF = new ValidadorCPF();


    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @Override
    public void cadastrar() throws SQLException {
        String rua = JOptionPane.showInputDialog("Rua: ");
        Integer numero = Integer.valueOf(JOptionPane.showInputDialog("Numero: "));
        String bairro = JOptionPane.showInputDialog("Bairro: ");
        String cidade = JOptionPane.showInputDialog("Cidade: ");
        Estado estado = Estado.valueOf(JOptionPane.showInputDialog("Estado: "));

        Endereco endereco = new Endereco(rua,numero,bairro,cidade,estado);

        String nome = JOptionPane.showInputDialog("Nome: ");
        String cpf = JOptionPane.showInputDialog("CPF: ");
        Sexo sexo = Sexo.valueOf(JOptionPane.showInputDialog("Sexo: "));
        Integer senha = Integer.valueOf(JOptionPane.showInputDialog("Senha: "));

        do {

            if (!validadorCPF.verificarCpf(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido. Digite novamente.");
                cpf = JOptionPane.showInputDialog("CPF: ");
            }
        } while (!validadorCPF.verificarCpf(cpf));

        cpf = cpf;

        String dataDeNacimento = JOptionPane.showInputDialog("Data de nascimento (DD/MM/YYYY): ");
        LocalDate data = LocalDate.parse(dataDeNacimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();
        Integer idade = Period.between(data,dataAtual).getYears();

        Membro membro = new Membro(nome,cpf,idade,data,sexo,senha,endereco);
        membroRepository.cadastrarMembro(membro);
    }

    @Override
    public void alterar(Membro membro) throws SQLException {
        membroRepository.alterarMembro(membro);
    }

    @Override
    public void excluir(String cpf) throws SQLException {
        membroRepository.excluirMembro(cpf);
    }

    @Override
    public void listarTodos() throws SQLException {
        membroRepository.listarMembros();
    }

    @Override
    public void listarPorID(String cpf) throws SQLException {
        membroRepository.excluirMembro(cpf);
    }
}
