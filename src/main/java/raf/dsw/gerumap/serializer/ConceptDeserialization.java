package raf.dsw.gerumap.serializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Concept;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.io.IOException;
import java.util.List;

public class ConceptDeserialization extends JsonDeserializer<Concept>{

    
    @Override
    public Concept deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Concept obj = new Concept("Concept", MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
        obj.setName(node.get("name").asText());
        obj.setX(node.get("x").asInt());
        obj.setY(node.get("y").asInt());
        obj.setHeight(node.get("height").asInt());
        obj.setWidth(node.get("width").asInt());
        obj.setStroke(node.get("stroke").asInt());
        obj.setColour(node.get("colour").asInt());

        
        return obj;
        
    }
}
