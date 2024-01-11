package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ClearJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

public class ClearJsonReaderTest {
    ObjectMapper mapper = new ObjectMapper();
    ClassLoader classLoader = ClearJsonReaderTest.class.getClassLoader();
    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("clear.json")) {
            ClearJson clear = mapper.readValue(is, ClearJson.class);
            ClearJson.Contact cg = clear.getPerson().get("Joe").get(0);
            Assertions.assertEquals("Jackson", cg.getLastName());
            Assertions.assertEquals("7349282382", cg.getPhoneNum());
            Assertions.assertEquals("male", cg.getGender());
            Assertions.assertEquals("28", cg.getAge());
        }
    }
    @Test
    void jsonFileParsingTest2() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("clear.json")) {
            ClearJson clear = mapper.readValue(is, ClearJson.class);
            ClearJson.Contact cg = clear.getPerson().get("James").get(0);
            Assertions.assertEquals("Smith", cg.getLastName());
            Assertions.assertEquals("5678568567", cg.getPhoneNum());
            Assertions.assertEquals("male", cg.getGender());
            Assertions.assertEquals("32", cg.getAge());
        }
    }
    @Test
    void jsonFileParsingTest3() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("clear.json")) {
            ClearJson clear = mapper.readValue(is, ClearJson.class);
            ClearJson.Contact cg = clear.getPerson().get("Emily").get(0);
            Assertions.assertEquals("Jones", cg.getLastName());
            Assertions.assertEquals("456754675", cg.getPhoneNum());
            Assertions.assertEquals("female", cg.getGender());
            Assertions.assertEquals("24", cg.getAge());
        }
    }

}
