package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.repository.implementation.Project;

import java.io.*;

public class JacksonSerializer implements Serializer {


    private Gson json= new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return json.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            json.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
