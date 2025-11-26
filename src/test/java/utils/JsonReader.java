package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonReader {

    public static List<Operation> readOperations(String resourcePath) {
        try (InputStream is = JsonReader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new TypeReference<List<Operation>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON resource: " + resourcePath, e);
        }
    }
}
