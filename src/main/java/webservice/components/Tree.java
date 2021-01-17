package webservice.components;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Example for a server side tree implementation / tree parser
 * NOTE: Currently not functional! Only to showcase the application
 */
public class Tree {
    public JsonNode value1;

    /**
     * Constructs a Tree object from a given Json
     *
     * @param value JsonNode that contains the whole serialized tree as provided by the export functionality of the
     *              e4compareFramework
     */
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
