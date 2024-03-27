package sg.edu.nus.iss.ibfb4ssfassessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;
import sg.edu.nus.iss.ibfb4ssfassessment.util.Utils;

@Service
public class DatabaseService {

    // writing straight to db from service
    @Autowired
    @Qualifier(Utils.REDIS_ONE)
    RedisTemplate<String, String> template;

    ObjectMapper objectMapper = new ObjectMapper();

    HashOperations<String, String, String> hashOps;

    //save movies to redis
    public void saveRecord(Movie movie) {
        hashOps = template.opsForHash();
        try {
            hashOps.put(Utils.KEY_MOVIES, String.valueOf(movie.getMovieID()), objectMapper.writeValueAsString(movie));
        } catch (JsonProcessingException e) {
            // catch various errors
            e.printStackTrace();
        }
        
    }

    public long getNumberOfEvents() {
        hashOps = template.opsForHash();

        return hashOps.size(Utils.KEY_MOVIES);
    }

    // public Movie getMovie(Integer index) {
    // return repo.getMovie(index);
    // }

    // TODO: Task 4 (Map)
    public Movie getMovieById(Integer movieId) throws JsonProcessingException {
        hashOps = template.opsForHash();

        return objectMapper.readValue(hashOps.get(Utils.KEY_MOVIES, movieId.toString()), Movie.class);
    }

    // // TODO: Task 5
    // public List<Movie> getAllMovies() {

    // }
}
