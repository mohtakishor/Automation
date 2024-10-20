package APITest;

import Utils.ApiFactory;
import Utils.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Log;

public class getWidgetAPITest extends ApiFactory {

    String baseURI = Constants.BaseURL;
    String pathUrl = Constants.basePath;

    @Test
    public void getWidgetAPITest() {
        Log.info("Calling the API, Get Method");
        Response validateResponse = getMethod(baseURI, pathUrl);
        String response = validateResponse.getBody().asString();
        Log.info("Response of the Request is : " + response);
        Assert.assertTrue(response.contains("EMPTY_API_KEY"));
        Log.info("Validating Response status code");
        Assert.assertEquals(validateResponse.getStatusCode(), 400);
    }

    @Test
    public void negativeWidgetAPITest() {
        Log.info("Calling the API, Get Method");
        Response validateResponse = getMethod(baseURI, pathUrl);
        Log.info("Validating Response status code");
        Assert.assertFalse(validateResponse.getStatusCode() == 200);
    }
}
