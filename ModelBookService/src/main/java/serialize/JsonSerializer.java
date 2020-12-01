package serialize;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
public class JsonSerializer<T> implements Serializer<T> {
    private static ObjectMapper mapper;
    private Class<T> clazz;

    public JsonSerializer(Class<T> type) {
        this.clazz=type;
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void toFile(T book, File file) {

        // Convert object to JSON string and save into file directly
        try {
            mapper.writeValue(file, book);

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(book);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public T fromFile(File file) throws IOException {
        return mapper.readValue(file, clazz);
    }
    @Override
    public String toString(T book)  {
        try {
            return mapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        // Convert object to JSON string and pretty print
        //    jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        //    System.out.println(jsonInString);
    }
    @Override
    public T fromString(String string) throws IOException {
        try {
            return mapper.readValue(string, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
