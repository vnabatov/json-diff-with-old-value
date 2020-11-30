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

public class JSONDiff {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode source = mapper.readTree(getResourceFileAsString("source.json"));
            JsonNode target = mapper.readTree(getResourceFileAsString("target.json"));
            JsonNode patch = JsonDiff.asJson(source, target);

            JsonNode sourceJson = new ObjectMapper().readTree(source.toString());
            JsonNode obj = new ObjectMapper().readTree(patch.toString());
            ArrayList<String> result = new ArrayList<String>();

            for (JsonNode node : obj) {
                String op = node.get("op").textValue();
                System.out.println(node);

                switch (op) {
                    case "move":
                        ((ObjectNode) node).put(
                                "oldValue",
                                sourceJson.at(node.get("from").textValue()));
                        break;
                    case "remove":
                    case "replace":
                        ((ObjectNode) node).put(
                                "oldValue",
                                sourceJson.at(node.get("path").textValue()));
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
