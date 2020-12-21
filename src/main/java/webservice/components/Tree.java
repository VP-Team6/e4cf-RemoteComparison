package webservice.components;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tree {
    public JsonNode value1;

    public Tree(JsonNode value) {
        this.value1 = value;
    }

    @Override
    public String toString() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.value1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
