package raf.dsw.gerumap.serializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.repository.implementation.*;

import java.io.*;

public class JacksonSerializer implements Serializer {


    private Gson json= new Gson();

    ObjectMapper mapper = new ObjectMapper();
    String result;

    SimpleModule module = new SimpleModule();
//    module.addDeserializer(MindMap.class, new MindMapDeserializer());
//        module.addDeserializer(Concept.class, new ConceptDeserialization());
//        mapper.registerModule(module);




    //File file =  new File();

    @Override
    public Project loadProject(File file) throws IOException {


        // String result = new ObjectMapper();
        FileReader fr = new FileReader(file);
        //project

//        module.addDeserializer(MapNode.class,new MapNodeDeserializer());
//        module.addDeserializer(MindMap.class, new MindMapDeserializer());
        module.addDeserializer(Element.class, new ElementDeserializer());
        module.addDeserializer(Concept.class, new ConceptDeserialization());
        module.addDeserializer(Connection.class, new ConnectionDeserializer());
        mapper.registerModule(module);

        return mapper.readValue(fr, Project.class);

        //return p;

//        try (FileReader fileReader = new FileReader(file)) {
//            return json.fromJson(fileReader, Project.class);
//        } catch (IOException e) {
//            e.printStackTrace();
        //    return null;
//        }
    }

    @Override
    public void saveProject(Project project) throws IOException {


       // result = mapper.writeValueAsString(project);
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE);
           result= mapper.writeValueAsString(project);
            writer.write(result);
           // mapper.writeValue(writer,project);

        }
        catch (IOException e) {
            e.printStackTrace();
        }


       // mapper.writeValue(new File("myobject.json"), project);

        System.out.println(result);




//        try (FileWriter writer = new FileWriter(project.getFilePath())) {
//            json.toJson(project, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
