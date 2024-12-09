import java.util.Random;
import java.util.Scanner;

public class Adivinha {
    public static void main(String[] args) {

        Random gerador = new Random();
        Scanner leitor = new Scanner(System.in);

        final int MINIMO = 1;
        final int MAXIMO = 120;

        int topScore = Integer.MAX_VALUE;

        boolean jogarNovamente = true;

        while (jogarNovamente) {
            int numeroQueComputadorEstaAPensar = MINIMO + gerador.nextInt(MAXIMO - MINIMO + 1);
            int numeroTentativas = 0;

            System.out.println("Olá, bem-vind@: ");
            System.out.println("Estou a pensar num número entre " + MINIMO + " e " + MAXIMO);
            System.out.println("Tente adivinhar!");

            boolean pessoaJaAdivinhou = false;

            while (!pessoaJaAdivinhou) {
                int tentativaDaPessoa = leitor.nextInt();
                numeroTentativas++;

                if (tentativaDaPessoa > numeroQueComputadorEstaAPensar) {
                    System.out.println("Não é... menor!");
                } else if (tentativaDaPessoa < numeroQueComputadorEstaAPensar) {
                    System.out.println("Nope... é maior!");
                } else {
                    pessoaJaAdivinhou = true;
                    System.out.println("PARABÉNS! Acertou. O número era " + numeroQueComputadorEstaAPensar);
                    System.out.println("Você conseguiu em " + numeroTentativas + " tentativas!");

                    if (numeroTentativas < topScore) {
                        topScore = numeroTentativas;
                        System.out.println("E bateu o recorde do jogo! Novo recorde: " + topScore + " tentativas.");
                    }
                }
            }

            System.out.println("Deseja jogar novamente? (s/n)");
            char resposta = leitor.next().toLowerCase().charAt(0);
            jogarNovamente = (resposta == 's');
        }

        leitor.close();
        System.out.println("Obrigado por jogar! Até a próxima.");
    }
}
