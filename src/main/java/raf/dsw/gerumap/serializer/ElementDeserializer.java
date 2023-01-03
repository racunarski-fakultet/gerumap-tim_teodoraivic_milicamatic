package raf.dsw.gerumap.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Connection;
import raf.dsw.gerumap.repository.implementation.Element;

import java.io.IOException;

public class ElementDeserializer extends JsonDeserializer<Element> {

    @Override
    public Element deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        // Read the "type" field from the JSON data to determine which concrete subclass to use
        String type = node.get("type").asText();
        if (type.equals("concept")) {
            return jsonParser.getCodec().treeToValue(node, Concept.class);
        } else if(type.equals("connection")) {
            return jsonParser.getCodec().treeToValue(node, Connection.class);
        }
        return null;
        }
}
