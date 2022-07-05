import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoapWithRestAssured {

    
    @Test
    void CountryISOCodeResult_FR() {
        var file = new File(getClass().getClassLoader().getResource("CountryISOCode_France.xml").getFile());

        Response response = RestAssured
                .given()
                .baseUri("http://webservices.oorsprong.org")
                .basePath("/websamples.countryinfo/CountryInfoService.wso")
                .header("SOAPAction", "http://www.oorsprong.org/websamples.countryinfo")
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(file)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();

        var xPathResult = response.xmlPath().get("//CountryISOCodeResult/text()");
        //var result = Integer.parseInt(String.valueOf(xPathResult));
        var result = String.valueOf(xPathResult);
        assertEquals("CH", result);

    }

    @Test
    void CountryISOCodeResult_FR_2() {
        var file = new File(getClass().getClassLoader().getResource("CountryISOCode_France.xml").getFile());

        Response response = RestAssured
                .given()
                .baseUri("http://webservices.oorsprong.org")
                .basePath("/websamples.countryinfo/CountryInfoService.wso")
                .header("SOAPAction", "http://www.oorsprong.org/websamples.countryinfo")
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(file)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();

        var xPathResult = response.xmlPath().get("//CountryISOCodeResult/text()");
        //var result = Integer.parseInt(String.valueOf(xPathResult));
        var result = String.valueOf(xPathResult);
        assertEquals("FR", result);

    }

    @Test
    void CountryISOCodeResult_Italy() {
        var file = new File(getClass().getClassLoader().getResource("CountryISOCode_Italy.xml").getFile());

        Response response = RestAssured
                .given()
                .baseUri("http://webservices.oorsprong.org")
                .basePath("/websamples.countryinfo/CountryInfoService.wso")
                .header("SOAPAction", "http://www.oorsprong.org/websamples.countryinfo")
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(file)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();

        var xPathResult = response.xmlPath().get("//CountryISOCodeResult/text()");
        //var result = Integer.parseInt(String.valueOf(xPathResult));
        var result = String.valueOf(xPathResult);
        assertEquals("IT", result);

    }

    // NOT READY
    @Disabled
    @Test
    void FullCountryInfo_Swiss()  {
        var file = new File(getClass().getClassLoader().getResource("FullCountryInfo.xml").getFile());

        Response response = RestAssured
                .given()
                .baseUri("http://webservices.oorsprong.org")
                .basePath("/websamples.countryinfo/CountryInfoService.wso")
                .header("SOAPAction", "http://www.oorsprong.org/websamples.countryinfo")
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(file)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();


        var xPathResult = response.body().xmlPath().get();
        String stringResponse = response.asString();
        XmlPath xmlPath = new XmlPath(stringResponse);
        String status = xmlPath.get("ncresponse.STATUS");

        System.out.println("---------------");
        var result = String.valueOf(xPathResult);
        System.out.println(result);
        assertEquals("IT", result);
        System.out.println("---------------");

        //var sName = response.xmlPath().get("//FullCountryInfoResult.sName");
//        var sCapitalCity = response.xmlPath().get("//sCapitalCity/text()");
//        var sPhoneCode = response.xmlPath().get("//sPhoneCode/text()");
//        var sContinentCode = response.xmlPath().get("//sContinentCode/text()");
//        var sCurrencyISOCode = response.xmlPath().get("//sCurrencyISOCode/text()");
//        var sCountryFlag = response.xmlPath().get("//sCountryFlag/text()");

        //var result = Integer.parseInt(String.valueOf(xPathResult));
        //var result = String.valueOf(sName);
        //assertEquals("IT", result);
       // assertEquals("IT", String.valueOf(sName));
       // assertEquals("IT", String.valueOf(sISOCode));

    }

}
