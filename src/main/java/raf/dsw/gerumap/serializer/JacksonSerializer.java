package raf.dsw.gerumap.serializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.repository.implementation.*;

import java.io.*;
import java.util.List;

public class JacksonSerializer implements Serializer {


    private Gson json= new Gson();

    ObjectMapper mapper = new ObjectMapper();
    String result;

    SimpleModule module = new SimpleModule();

    @Override
    public Project loadProject(File file) throws IOException {



        FileReader fr = new FileReader(file);

        module.addDeserializer(Element.class, new ElementDeserializer());
        module.addDeserializer(Concept.class, new ConceptDeserialization());
        module.addDeserializer(Connection.class, new ConnectionDeserializer());
        mapper.registerModule(module);

        return mapper.readValue(fr, Project.class);

    }

    @Override
    public void saveProject(Project project) throws IOException {



        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE);
           result= mapper.writeValueAsString(project);
            writer.write(result);


        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);

    }
}
