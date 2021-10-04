
package br.com.pucgo.repository;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;

import br.com.pucgo.model.Question;
import br.com.pucgo.model.Answer;

public class AnswerRepository {
    protected Connection connection;

    public AnswerRepository(Connection conn) {
        this.connection = conn;
    }

    public ArrayList<Answer> findAll() {
        ArrayList<Answer> collection = new ArrayList<Answer>();

        String query = "SELECT a.id AS answer_id, a.text AS answer, a.created_at AS answer_created,";
            query += " q.id AS question_id, q.title AS question, q.created_at AS question_created";
            query += " FROM answer a";
            query += " INNER JOIN question q ON q.id = a.question_id";
            query += " ORDER BY a.created_at ASC";

        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(query);
           
            while (res.next()) {
                collection.add(
                    this.getInstance(res)
                );
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return collection;
    }

    public Answer find(Integer id) {
        String query = "SELECT * FROM question WHERE id=" + id;

        Answer item = null;

        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(query);
            res.next();

            item = this.getInstance(res);

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return item;
    }

    protected Answer getInstance(ResultSet row) {
        Answer item = null;
        Question question = null;

        try {
            Integer questionId = row.getInt("question_id");
            String questionText = row.getString("question");
            Timestamp questionCreated = row.getTimestamp("question_created");

            question = new Question(questionId, questionText, questionCreated.toString());

            Integer answerId = row.getInt("question_id");
            String answerText = row.getString("question");
            Timestamp answerCreated = row.getTimestamp("question_created");

            item = new Answer(answerId, answerText, answerCreated.toString(), question);


        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return item;
    }
}
