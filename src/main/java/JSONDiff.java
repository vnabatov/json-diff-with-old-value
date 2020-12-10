import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flipkart.zjsonpatch.JsonDiff;
import com.flipkart.zjsonpatch.JsonPatch;

public class JSONDiff {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode sourceNode = mapper.readTree(getResourceFileAsString("source.json"));
            JsonNode patchedFieldsNode = mapper.readTree(getResourceFileAsString("patch.json"));

            JsonNode targetNode = JsonPatch.apply(JsonDiff.asJson(mapper.readTree("{}"), patchedFieldsNode), sourceNode);

            JsonNode diffNode = JsonDiff.asJson(sourceNode, targetNode);

            for (JsonNode node : diffNode) {
                String op = node.get("op").textValue();
                System.out.println(node);

                switch (op) {
                    case "move":
                        ((ObjectNode) node).put(
                                "oldValue",
                                sourceNode.at(node.get("from").textValue()));
                        break;
                    case "remove":
                    case "replace":
                        ((ObjectNode) node).put(
                                "oldValue",
                                sourceNode.at(node.get("path").textValue()));
                        break;
                }
                result.add(node.toString());
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null) return null;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }
}
