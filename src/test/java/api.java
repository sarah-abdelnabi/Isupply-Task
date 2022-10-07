import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class api {
    @Test
    public void  responseCode()
    {
        Response resp =RestAssured.get("https://alexwohlbruck.github.io/cat-facts/docs/endpoints/facts.html");
         int code =  resp.getStatusCode();
        Assert.assertEquals(code,200);
    }
}
