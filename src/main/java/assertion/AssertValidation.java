package assertion;

import org.junit.Assert;

public class AssertValidation {
    public void textAssert(String expected, String Actual){
        Assert.assertEquals(Actual,expected);
    }
}
