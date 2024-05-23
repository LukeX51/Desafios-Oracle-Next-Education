import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        double quantia = 0;
        String moedaPrincipal = "";
        String moedaDestino = "";
        Gson gson = new Gson();
        Conversor conversor = new Conversor();
        do {
            System.out.println("""
                    *******************************************************
                                            
                            Seja Bem-Vindo/a ao Conversor de Moedas
                            
                            1) Dólar -> Real
                            2) Real -> Dólar
                            3) Boliviano -> Real 
                            4) Real Brasileiro -> Boliviano
                            5) Peso Argentino -> Real
                            6) Real -> Peso Argentino
                            7) Sair
                            
                            Escolha uma opção válida:
                    *******************************************************
                    """);
            opcao = sc.nextInt();

            if (opcao == 7) {
                break;
            } else if (opcao >= 1 && opcao <= 6) {

                System.out.println("Digite o valor que deseja converter: ");
                quantia = sc.nextDouble();

                switch (opcao) {
                    case 1:
                        moedaPrincipal = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 2:
                        moedaPrincipal = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 3:
                        moedaPrincipal = "BOB";
                        moedaDestino = "BRL";
                        break;
                    case 4:
                        moedaPrincipal = "BRL";
                        moedaDestino = "BOB";
                        break;
                    case 5:
                        moedaPrincipal = "ARS";
                        moedaDestino = "BRL";
                        break;
                    case 6:
                        moedaPrincipal = "BRL";
                        moedaDestino = "ARS";
                        break;
                    default:
                        System.out.println("Digite uma opção válida:");
            }
                Moeda resultadoConversao = conversor.buscarRequisicao(moedaPrincipal, moedaDestino, quantia);
                System.out.println("Conversão realizada! Resultado: " + resultadoConversao);

            }else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        System.out.println("Fechando aplicativo...");

        sc.close();
    }
}