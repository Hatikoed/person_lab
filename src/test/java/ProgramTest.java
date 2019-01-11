import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ProgramTest {

    @Test
    public void open_file() throws IOException {
        Program program = new Program();
        String actual = "12345678";
        Map<String,String> expected = program.open_file("C:\\Users\\mihai\\Desktop\\data_person.txt");
        Assert.assertEquals(actual,expected.get("Test_User"));
    }
}