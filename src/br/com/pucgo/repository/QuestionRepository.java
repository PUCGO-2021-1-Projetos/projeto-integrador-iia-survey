
package br.com.pucgo.repository;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;

import br.com.pucgo.model.Question;

public class QuestionRepository {
    protected Connection connection;

    public QuestionRepository(Connection conn) {
        this.connection = conn;
    }

    public ArrayList<Question> findAll() {
        ArrayList<Question> collection = new ArrayList<Question>();

        String query = "SELECT * FROM question ORDER BY id ASC";

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

    public Question find(Integer id) {
        String query = "SELECT * FROM question WHERE id=" + id;

        Question item = null;

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

    protected Question getInstance(ResultSet row) {
        Question item = null;

        try {
            Integer id = row.getInt("id");
            String title = row.getString("title");
            Timestamp created = row.getTimestamp("created_at");

            item = new Question(id, title, created.toString());

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return item;
    }
}
