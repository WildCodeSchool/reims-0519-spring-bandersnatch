import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wildcodeschool.bandersnatch.repositories.ScoreRepository;

class Result {

   public static void tabContent() {
       // lire un fichier de template
       String result = "";
       try {
           result = new String(Files.readAllBytes(Paths.get("result.html")));
       } catch (IOException e) {
           e.printStackTrace();
       }
       

       // remplacer des identifiants par des valeurs

       String nicknameData = result.replace("${nickname}", ScoreRepository.selectScores().get(1).toString());
       String scoreData = result.replace("${userScore}", ScoreRepository.selectScores().get(2).toString());

   }
}