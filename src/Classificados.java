import java.util.Arrays;
import java.util.Scanner;

public class Classificados {

    public static double media(int[] pontos) {
        double soma = 0;
        for(int i=0; i < pontos.length; i++) {
            soma += pontos[i];
        }
        soma /= pontos.length;
        return soma;
    }
    public static double desvioPadrao(int[] pontos) {
        double somatorio = 0;
        double media = media(pontos);
        for (int i=0; i<pontos.length; i++) {
            somatorio += Math.abs(pontos[i] - media) * Math.abs(pontos[i] - media);
        }
        double desvioPadrao = Math.sqrt(somatorio / pontos.length);
        return desvioPadrao;
    }

    public static int qtClassificados(int[] pontos, int classificados) {
        int valor = pontos[classificados - 1];
        int novoClassificados = classificados;
        for(int i = classificados; i<pontos.length; i++) {
            if (pontos[i] == valor) {
                novoClassificados++;
            }
        }
        return novoClassificados;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int competidores;
        int classificados;
        int[] pontos;

        competidores = entrada.nextInt();
        classificados = entrada.nextInt();

        pontos = new int[competidores];

        for (int i = 0; i < competidores; i++) {
            pontos[i] = entrada.nextInt();
        }

        Arrays.sort(pontos);


        classificados = qtClassificados(pontos, classificados);
        int[] pontosClassificados = new int[classificados];

        for (int i=0; i<classificados; i++) {
            pontosClassificados[i] = pontos[pontos.length - 1 - i];
        }

        System.out.printf("%d\n", classificados);
        System.out.printf("%.2f\n", desvioPadrao(pontosClassificados));
        System.out.printf("%.2f\n", media(pontosClassificados));
        System.out.printf("%.2f\n", desvioPadrao(pontos));
        System.out.printf("%.2f\n", media(pontos));

    }
}
