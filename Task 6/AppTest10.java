package pvt;
import org.junit.Assert;
import org.junit.Test;

public class AppTest10 {
   private String A = "Stay ";
   private String B = "Calm";

    @Test
    public void testsummaAB() {
        App app = new App();
        String actual = app.summaAB(A,B);
        String expected = "Stay Calm";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testotherWiseAB() {
        App app = new App();
        String actual = app.summaAB(B,A);
        String expected = "CalmStay ";
        Assert.assertEquals(actual,expected);
    }
}