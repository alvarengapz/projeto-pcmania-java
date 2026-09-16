package br.inatel.pcmania;

import br.inatel.pcmania.modelo.*;
import br.inatel.pcmania.util.ProcessarPedido;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float matricula = 9851;

        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente("Aluno", "111.222.333-44");

        System.out.println("=== Bem-vindo a PCMania! ===");
        boolean rodando = true;
        int pcsComprados = 0;

        while (rodando) {
            System.out.println("\nEscolha uma promoção: 1 (Apple), 2 (Samsung), 3 (Dell) ou 0 (Finalizar)");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    rodando = false;
                    break;
                case 1:
                    cliente.adicionaComputador(criaPromo1(matricula));
                    pcsComprados++;
                    System.out.println("[OK] PC Apple adicionado ao carrinho!");
                    break;
                case 2:
                    cliente.adicionaComputador(criaPromo2(matricula));
                    pcsComprados++;
                    System.out.println("[OK] PC Samsung adicionado ao carrinho!");
                    break;
                case 3:
                    cliente.adicionaComputador(criaPromo3(matricula));
                    pcsComprados++;
                    System.out.println("[OK] PC Dell adicionado ao carrinho!");
                    break;
                default:
                    System.out.println("Código inválido! Digite 1, 2, 3 ou 0.");
            }
        }

        System.out.println("\n-----------------------------------");
        ProcessarPedido.helper(cliente.getComputadores());
        System.out.println("Resumo do pedido para: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");

        for (Computador pc : cliente.getComputadores()) {
            if (pc != null) {
                System.out.println("\nPC:");
                pc.mostraPCConfigs();
            }
        }

        System.out.println("\nTotal a pagar: R$ " + cliente.calculaTotalCompra());
        entrada.close();
    }

    private static Computador criaPromo1(float matricula) {
        HardwareBasico[] hw = new HardwareBasico[]{
                new HardwareBasico("Processador Core i5", 2200),
                new HardwareBasico("Memória RAM", 8),
                new HardwareBasico("HD", 500)
        };
        Computador pc = new Computador("Apple", matricula, hw, new SistemaOperacional("macOS Sequoia", 64));
        pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
        return pc;
    }

    private static Computador criaPromo2(float matricula) {
        HardwareBasico[] hw = new HardwareBasico[]{
                new HardwareBasico("Processador Core i7", 3370),
                new HardwareBasico("Memória RAM", 16),
                new HardwareBasico("HD", 1000)
        };
        Computador pc = new Computador("Samsung", matricula + 1, hw, new SistemaOperacional("Windows 8", 64));
        pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
        return pc;
    }

    private static Computador criaPromo3(float matricula) {
        HardwareBasico[] hw = new HardwareBasico[]{
                new HardwareBasico("Processador Core i7", 4500),
                new HardwareBasico("Memória RAM", 32),
                new HardwareBasico("HD", 2000)
        };
        Computador pc = new Computador("Dell", matricula + 2, hw, new SistemaOperacional("Windows 10", 64));
        pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1));
        return pc;
    }
}