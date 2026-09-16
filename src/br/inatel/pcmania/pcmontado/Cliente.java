package br.inatel.pcmania.pcmontado;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int qtdComprada;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
        this.qtdComprada = 0;
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] != null) {
                total += computadores[i].getPreco();
            }
        }
        return total;
    }

    public void adicionaComputador(Computador pc) {
        if (qtdComprada < computadores.length) {
            computadores[qtdComprada] = pc;
            qtdComprada++;
        } else {
            System.out.println("Carrinho cheio!");
        }
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Computador[] getComputadores() { return computadores; }
}
