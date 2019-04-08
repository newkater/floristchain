package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private JacksonUtils() {}

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
