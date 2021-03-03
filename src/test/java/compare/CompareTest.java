package compare;


import org.junit.Assert;
import org.junit.Test;

public class CompareTest {

    @Test
    public void compare(){
        String act ="{ " +
                "  \"Content\":\"EXTERNAL FILE\",\n" +
                "  \"Icon\":\"4\" \n" +
                "  \"Id\":\"4\" \n" +
                "  \"Deleted\":\"true\" \n"+
                "}";

        String exp = "{ " +
                "  \"Content\":\"EXTERNAL FILE\",\n" +
                "  \"Icon\":\"4\" \n" +
                "  \"Id\":\"5\" \n" +
                "  \"Deleted\":\"true\" \n"+
                "}";
        Assert.assertEquals("Incorrecto",exp,act);
    }




}
