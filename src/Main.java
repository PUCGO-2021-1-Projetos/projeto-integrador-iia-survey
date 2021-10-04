import java.io.IOException;

import br.com.pucgo.dao.Connector;
import br.com.pucgo.model.*;
import br.com.pucgo.repository.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        QuestionRepository questionRepo = new QuestionRepository(
            Connector.create().connect()
        );



        for (Question item : questionRepo.findAll()) {
            System.out.println(item.getTitle());
        }

        AnswerRepository answerRepo = new AnswerRepository(
            Connector.create().connect()
        );

        for (Answer item : answerRepo.findAll()) {
            System.out.println(item.getTitle());
        }
    }
}