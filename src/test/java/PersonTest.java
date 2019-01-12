import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void input() throws IOException, NoSuchAlgorithmException {
        Person person = new Person();
        Program program = new Program();
        Map<String,String> file = program.open_file("C:\\Users\\mihai\\Desktop\\data_person.txt");
        String user = "Hatikoed";
        String password = "1705";
        Assert.assertEquals(true,person.input(file, user, password));
    }

    @Test
    public void register() {
        Person person = new Person();
        boolean actual = true;
        boolean expected = person.register();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void delete() {
        Person person = new Person();
        boolean actual = true;
        boolean expected = person.delete();
        Assert.assertEquals(actual,expected);
    }
}