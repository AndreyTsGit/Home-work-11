package guru.qa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class JsonParser {
    public static void main(String[] args) {
        String jsonFilePath = "Json_mas.json";
        parseJsonFile(jsonFilePath);
    }

    public static <ObjectMapper, JsonNode> void parseJsonFile(String jsonFilePath) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();


            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));


            JsonNode peopleArray = rootNode.get("people");


            Iterator<JsonNode> peopleIterator = peopleArray.iterator();
            while (peopleIterator.hasNext()) {
                JsonNode personNode = peopleIterator.next();


                String firstName = personNode.get("firstName").asText();
                String lastName = personNode.get("lastName").asText();
                String gender = personNode.get("gender").asText();
                int age = personNode.get("age").asInt();
                String number = personNode.get("number").asText();

            }
        }
    }
}



