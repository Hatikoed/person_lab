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
    public void register() throws IOException, NoSuchAlgorithmException {
        Person person = new Person();
        Program program = new Program();
        String path = "C:\\Users\\mihai\\Desktop\\data_person.txt";
        Map<String,String> file = program.open_file(path);
        String user = "Hatikoed";
        String password = "1705";
        boolean actual = true;
        boolean expected = person.register(file, user, password,path);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void delete() throws IOException, NoSuchAlgorithmException {
        Person person = new Person();
        Program program = new Program();
        String path = "C:\\Users\\mihai\\Desktop\\data_person.txt";
        Map<String,String> file = program.open_file(path);
        String user = "Hatikoed";
        String password = "1705";
        boolean actual = true;
        boolean expected = person.delete(file, user, password,path);
        Assert.assertEquals(actual,expected);
    }
}