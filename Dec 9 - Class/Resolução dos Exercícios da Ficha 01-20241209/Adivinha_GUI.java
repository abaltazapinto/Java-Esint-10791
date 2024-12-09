import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Adivinha_GUI {

    public static void main(String[] args) {

        Random gerador = new Random();

        final int MINIMO = 1;
        final int MAXIMO = 120;

        int topScore = Integer.MAX_VALUE;

        boolean pessoaQuerContinuarAJogar = true;

        while (pessoaQuerContinuarAJogar) {
            
            int numeroDeTentativas = 0;
            int numeroQueComputadorEstaAPensar = MINIMO + gerador.nextInt(MAXIMO);

            JOptionPane.showMessageDialog(null,"Olá, bem vind@ ao Jogo da Adivinha! ");
            JOptionPane.showMessageDialog(null,"Estou a pensar num número entre " + MINIMO + " e " + MAXIMO);
            
            boolean pessoaJaAdivinhou = false;
            while (!pessoaJaAdivinhou) {
                int tentativaDaPessoa;

                String tentativaDaPessoaStr = JOptionPane.showInputDialog(null, 
                "Introduza o seu palpite:",
                 "Jogo da adivinha",
                 JOptionPane.QUESTION_MESSAGE);

                 if (tentativaDaPessoaStr == null) {
                    // If the user cancels the input dialog, exit the game
                    JOptionPane.showMessageDialog(null, "Você cancelou o jogo.");
                    return;
                }

                try {
                    tentativaDaPessoa = Integer.parseInt(tentativaDaPessoaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Por favor, insiraum número válido");
                    continue;
                }
                
                numeroDeTentativas++;
                if (tentativaDaPessoa > numeroQueComputadorEstaAPensar) {
                    JOptionPane.showMessageDialog(null,"Não... é menor");
                } else if (tentativaDaPessoa < numeroQueComputadorEstaAPensar) {
                    JOptionPane.showMessageDialog(null, "Nope... é maior ;)");
                } else {
                    pessoaJaAdivinhou = true;
                }
                
            }

            JOptionPane.showMessageDialog(null, "PARABÉNS! Acertou... O número era " + numeroQueComputadorEstaAPensar);

            if (numeroDeTentativas < topScore) {
                JOptionPane.showMessageDialog(null,"E bateu o recorde do jogo! Neste momento, está em " + numeroDeTentativas + " tentativas");
            }



            // leitor.nextLine();

            // String intencaoDoJogador = leitor.nextLine();

            String intencaoDoJogador = JOptionPane.showInputDialog(
                null,
                "Continuar?",            // The message to display
                "Quão viciado está você?", // The title of the dialog
                JOptionPane.QUESTION_MESSAGE // The type of dialog (e.g., QUESTION_MESSAGE)
        );

            if (intencaoDoJogador.toLowerCase().charAt(0) == 's') pessoaQuerContinuarAJogar = true;
            if (intencaoDoJogador.toLowerCase().charAt(0) == 'n') pessoaQuerContinuarAJogar = false;

        } while (pessoaQuerContinuarAJogar);

        JOptionPane.showMessageDialog(null, "Então adeus! Foi um gosto.");
    }
}

