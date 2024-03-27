package sg.edu.nus.iss.ibfb4ssfassessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.ibfb4ssfassessment.model.Movie;
import sg.edu.nus.iss.ibfb4ssfassessment.service.DatabaseService;
import sg.edu.nus.iss.ibfb4ssfassessment.service.FileService;
import sg.edu.nus.iss.ibfb4ssfassessment.util.Utils;

@SpringBootApplication
public class IbfB4SsfAssessmentApplication implements CommandLineRunner{

	@Autowired
	FileService fileService;

	@Autowired
	DatabaseService dbService;

	public static void main(String[] args) {
		SpringApplication.run(IbfB4SsfAssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//read json string
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(Utils.MOVIES_LIST_PATH).toFile()))) {
			// build the json string
			StringBuilder strBuild = new StringBuilder();
			
			String lines = bufferedReader.readLine();
			while (lines != null) {
				strBuild.append(lines);
				lines = bufferedReader.readLine();
			}

			//printing list of movies to console
			for (Movie x : fileService.readFile(strBuild.toString())) {
				System.out.println(x.toString());

				dbService.saveRecord(x);
			};

        } catch (IOException io) {
            io.printStackTrace();
        }
		
	}

}
