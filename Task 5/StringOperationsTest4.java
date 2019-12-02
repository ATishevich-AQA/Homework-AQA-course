import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperationsTest4 {
    @DataProvider
    public Object[][] dataProviderTestGetLength() {
        return new Object[][]{{"abc", 3}, {"", 0}, {"  hhh  ", 7}};
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
    }

    @BeforeClass
    public void beforClass() {
        System.out.println("Smth");
    }

    @Test
    public void testgetReversSum() {                     // Positive test
        StringOperations stringOperations = new StringOperations();
        String Actual = StringOperations.getReversSum("First ", " Second ", " Third");
        String Expected = " Third Second First ";
        Assert.assertEquals(Actual, Expected);
    }

    @Test
    public void testgetReversSum2() {                     // Negative test
        StringOperations stringOperations = new StringOperations();
        String Actual = StringOperations.getReversSum("", "", "-1");
        String Expected = "-1";
        Assert.assertEquals(Actual, Expected);
    }

    @Test(enabled = false)                      // Ignored test method
    public void testgetSum() {
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }

    @Test(expectedExceptions = {ArithmeticException.class})   // Exlude test
    public void testGetReversSum() {
        int actual = 2;
        int expected = actual / 0;
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetLength")    // Paramth test
    public void testGetLength(String line, int expected) {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getLength(line);
        Assert.assertEquals(actual, expected);
    }
}