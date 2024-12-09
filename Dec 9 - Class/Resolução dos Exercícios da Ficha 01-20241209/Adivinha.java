import java.util.Random;
import java.util.Scanner;

public class Adivinha {

    public static void main(String[] args) {

        Random gerador = new Random();
        Scanner leitor = new Scanner(System.in);

        final int MINIMO = 1;
        final int MAXIMO = 120;

        int topScore = Integer.MAX_VALUE;

        boolean pessoaQuerContinuarAJogar = true;

        int numeroDeTentativas = 0;
        do {

            int numeroQueComputadorEstaAPensar = MINIMO + gerador.nextInt(MAXIMO);

            System.out.println("Olá, bem vind@: ");
            System.out.println("Estou a pensar num número");
            System.out.println("Está entre " + MINIMO + " e " + MAXIMO);
            
            boolean pessoaJaAdivinhou = false;
            while (!pessoaJaAdivinhou) {

                System.out.println("Introduza o seu palpite: ");

                int tentativaDaPessoa = leitor.nextInt();
                if (tentativaDaPessoa > numeroQueComputadorEstaAPensar) {
                    System.out.println("Não... é menor");
                } else if (tentativaDaPessoa < numeroQueComputadorEstaAPensar) {
                    System.out.println("Nope... é maior ;)");
                }
                if (numeroQueComputadorEstaAPensar == tentativaDaPessoa)
                    pessoaJaAdivinhou = true;
                numeroDeTentativas++;
            }

            System.out.println("PARABÉNS! Acertou... O número era " + numeroQueComputadorEstaAPensar);

            if (numeroDeTentativas < topScore) {
                System.out.println(
                        "E bateu o recorde do jogo! Neste momento, está em " + numeroDeTentativas + " tentativas");
            }

            System.out.println("\nQuer continuar a jogar? (S/N)");

            leitor.nextLine();

            String intencaoDoJogador = leitor.nextLine();

            if (intencaoDoJogador.toLowerCase().charAt(0) == 's') pessoaQuerContinuarAJogar = true;
            if (intencaoDoJogador.toLowerCase().charAt(0) == 'n') pessoaQuerContinuarAJogar = false;

        } while (pessoaQuerContinuarAJogar);

        System.out.println("Então adeus! Foi um gosto.");

        leitor.close();
    }
}

