package sg.edu.nus.iss.ibfb4ssfassessment.service;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;

@Service
public class FileService {

    public List<Movie> readFile(String fileName) {
        List<Movie> moveList = new LinkedList<>();

        JsonReader jReader = Json.createReader(new StringReader(fileName));
        JsonArray jArray = jReader.readArray();

        for (int x = 0; x < jArray.size(); x++) {
            moveList.add(new Movie(jArray.get(x).asJsonObject().getInt("Id"),
                                    jArray.get(x).asJsonObject().getString("Title"),
                                    jArray.get(x).asJsonObject().getString("Year"),
                                    jArray.get(x).asJsonObject().getString("Rated"),
                                    (long) jArray.get(x).asJsonObject().getInt("Released"),
                                    jArray.get(x).asJsonObject().getString("Runtime"),
                                    jArray.get(x).asJsonObject().getString("Genre"),
                                    jArray.get(x).asJsonObject().getString("Director"),
                                    Double.parseDouble(jArray.get(x).asJsonObject().get("Rating").toString()),
                                    jArray.get(x).asJsonObject().getInt("Count")));
        }

        return moveList;
    }

}
