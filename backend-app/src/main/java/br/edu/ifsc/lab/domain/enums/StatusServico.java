package br.edu.ifsc.lab.domain.enums;

public enum StatusServico {

	ANALISE(1, "Analise"), MANUTENCAO(2, "Manutenção"), CONCLUIDO(3, "Concluido");

	private int cod;
	private String descricao;

	private StatusServico(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusServico toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusServico x : StatusServico.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);

	}

}
