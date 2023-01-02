package raf.dsw.gerumap.serializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Connection;

import java.io.IOException;

public class ConnectionDeserializer extends JsonDeserializer<Connection> {
    @Override
    public Connection deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        // Read the JSON data and create a MyObject instance
        Connection obj = new Connection("Concept", MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
        obj.setName(node.get("name").asText());
        obj.setY2(node.get("y2").asInt());
        obj.setY1(node.get("y1").asInt());
        obj.setX1(node.get("x1").asInt());
        obj.setX2(node.get("x2").asInt());
        //obj.setFromConcept(node.get("fromConcept").);

        return obj;

    }
}
