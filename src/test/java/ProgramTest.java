import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramTest {

    @Test
    public void open_file() {
        Program program = new Program();
        boolean actual = true;
        boolean expected = program.open_file();
        Assert.assertEquals(actual,expected);
    }
}