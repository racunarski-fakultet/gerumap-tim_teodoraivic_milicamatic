package raf.dsw.gerumap.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Json {
    // nisam sig za ovu klasu

    private static ObjectMapper objectMapper=getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }
    public static JsonNode parse(String src) throws IOException {
       return objectMapper.readTree(src);
    }

}
