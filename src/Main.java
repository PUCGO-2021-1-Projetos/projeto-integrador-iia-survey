import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import br.com.pucgo.dao.Connector;
import br.com.pucgo.model.*;
import br.com.pucgo.repository.*;


/**
 * @see README.md
 * @author Grupo 08 - PUC ADS
 * @author Leonardo Carvalho
 * @author Hugo Seabra
 * @author Gisely Meneses
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        // ========================
        // === Código principal ===
        // ========================
        clearConsole();

        System.out.println("Olá, responda as perguntas abaixo:\n");
        
        // Repositório que resgata perguntas da persistência
        QuestionRepository questionRepo = new QuestionRepository(
            Connector.create().connect()
        );

        ArrayList<Answer> answers = new ArrayList<Answer>();

        // Objeto que será usado para capturar o input do usuário
        Scanner scanner = new Scanner(System.in);

        Integer counter = 1;
        for (Question item : questionRepo.findAll()) {
            String pergunta = item.getTitle();
            
            if (!pergunta.endsWith("?")) {
                pergunta += "?";
            }

            System.out.println("Pergunta "+counter+": "+ pergunta +"\n");
            String input = scanner.nextLine();

            Answer answer = new Answer(input, item);
            answers.add(answer);
            
            System.out.println("\n\n");

            counter++;
        }

        // Salva respostas no banco de dados
        // Repositório que resgata perguntas da persistência
        AnswerRepository answerRepo = new AnswerRepository(
            Connector.create().connect()
        );

        for(Answer answer : answers) {
            answerRepo.saveNew(answer);
        }

        System.out.println("Obrigado!");
        
        scanner.close();
    }

    //Este método detecta qual sistema operacional em uso e utiliza o comando apropriado para limpar o console
    protected static void clearConsole() throws IOException {

        try {

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        } catch (IOException | InterruptedException ex) {
        }
    }
}