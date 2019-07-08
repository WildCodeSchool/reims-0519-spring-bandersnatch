package com.wildcodeschool.bandersnatch.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.bandersnatch.entities.Score;

public class ScoreRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/bandersnatch_db?serverTimezone=GMT";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "@AdminEcho1234";

    public static List<Score> selectByNickname(String nickname) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM scores WHERE nickname LIKE ?"
            );
        ) {
            statement.setString(1, nickname);

            try(
                ResultSet resulSet = statement.executeQuery();
            ) {
                List<Score> scores = new ArrayList<Score>();

                while(resulSet.next()){
                    int id = resulSet.getInt("id");
                    nickname = resulSet.getString("nickname");
                    int user_score = resulSet.getInt("user_score");
                    scores.add(new Score(id, nickname, user_score));
                }

                return scores;
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
    public static List<Score> selectScores() {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM scores ORDER BY user_score LIMIT 0, 5;"
            );
            ResultSet resulSet = statement.executeQuery();
        ) {
            List<Score> scores = new ArrayList<Score>();

            while(resulSet.next()){
                int id = resulSet.getInt("id");
                String nickname = resulSet.getString("nickname");
                int user_score = resulSet.getInt("user_score");
                scores.add(new Score(id, nickname, user_score));
            }

            return scores;
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

    public static Score selectById(int id) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM scores WHERE id=?"
            );
        ) {
            statement.setInt(1, id);

            try(
                ResultSet resulSet = statement.executeQuery();
            ) {
                if(resulSet.next()){
                    String nickname = resulSet.getString("nickname");
                    int user_score = resulSet.getInt("user_score");
                    return new Score(id, nickname, user_score);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "unknown id in table scores"
                    );
                }
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
    public static int insert(
        String nickname,
        int user_score
    ) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO scores (nickname, user_score) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            statement.setString(1, nickname);
            statement.setInt(2, user_score);
    
            if(statement.executeUpdate() != 1) {
                throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "failed to insert data"
                );
            }
    
            try(
                ResultSet generatedKeys = statement.getGeneratedKeys();
            ) {
                if(generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "failed to get inserted id"
                    );
                }
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
}