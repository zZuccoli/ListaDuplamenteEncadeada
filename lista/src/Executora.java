public class Executora {
    public static void main(String[] args) {
        Main.ListaDuplamenteEncadeada lista = new Main.ListaDuplamenteEncadeada();

        lista.adicionarFim(10);
        lista.adicionarFim(20);
        lista.adicionarFim(30);
        lista.exibirElementos();

        lista.adicionarInicio(5);
        lista.exibirElementos();

        lista.adicionarPosicao(10, 4);
        lista.exibirElementos();

        lista.removerElemento(1);
        lista.exibirElementos();

        lista.removerTodasOcorrencias(10);
        lista.exibirElementos();
        lista.buscar(5);

        System.out.println("Maior elemento: " + lista.maior());
        System.out.println("Menor elemento: " + lista.menor());
        System.out.println("Média dos elementos: " + lista.media());
        System.out.println("Quantidade de elementos: " + lista.quantidade());
    }
}
