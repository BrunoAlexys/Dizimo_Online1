package br.com.unifacol.dizimo.model.enums;

public enum Sexo {
    M("Masculino"),
    F("Feminino");

    private final String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo fromChar(char c) {
        if (c == 'm' || c == 'M') {
            return M;
        } else if (c == 'f' || c == 'F') {
            return F;
        } else {
            throw new IllegalArgumentException("Sexo inválido: " + c);
        }
    }
}

