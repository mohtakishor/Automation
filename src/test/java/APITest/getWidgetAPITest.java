package APITest;

import Utils.ApiFactory;
import Utils.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getWidgetAPITest extends ApiFactory {

    String baseURI = Constants.BaseURL;
    String pathUrl = Constants.basePath;

    @Test
    public void getWidgetAPITest() {
        Response validateResponse = getMethod(baseURI, pathUrl);
        String response = validateResponse.getBody().asString();
        Assert.assertTrue(response.contains( "EMPTY_API_KEY"));
        Assert.assertEquals(validateResponse.getStatusCode(), 400);
    }

    @Test
    public void negativeWidgetAPITest() {
        Response validateResponse = getMethod(baseURI, pathUrl);
        Assert.assertFalse(validateResponse.getStatusCode() == 200);
    }
}
