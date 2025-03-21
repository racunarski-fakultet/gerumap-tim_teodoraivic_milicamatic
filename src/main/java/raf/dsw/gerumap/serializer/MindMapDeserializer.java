package raf.dsw.gerumap.serializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.io.IOException;
import java.util.List;

public class MindMapDeserializer extends JsonDeserializer<MindMap>{


    @Override
        public MindMap deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);

            MindMap obj = new MindMap("MindMap", MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());

            obj.setDrawColor(node.get("drawColor").asInt());

            return obj;

    }
}
