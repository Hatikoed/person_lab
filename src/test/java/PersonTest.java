import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void input() {
        Person person = new Person();
        boolean actual = true;
        boolean expected = person.input();
        Assert.assertEquals(actual,expected);
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