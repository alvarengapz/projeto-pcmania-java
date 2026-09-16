package br.inatel.pcmania.modelo;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, HardwareBasico[] hardwares, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = hardwares;
        this.sistemaOperacional = sistemaOperacional;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        for (int i = 0; i < hardwares.length; i++) {
            if (hardwares[i] != null) {
                String unidade = hardwares[i].getNome().contains("Processador") ? " Mhz" : " Gb";
                System.out.println("  - " + hardwares[i].getNome() + " (" + (int) hardwares[i].getCapacidade() + unidade + ")");
            }
        }
        System.out.println("  - OS: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        if (memoriaUSB != null) {
            String unidade = memoriaUSB.getNome().toLowerCase().contains("hd") ? " Tb" : " Gb";
            System.out.println("  - Acompanha: " + memoriaUSB.getNome() + " " + memoriaUSB.getCapacidade() + unidade);
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) { this.memoriaUSB = musb; }
    public float getPreco() { return preco; }
}