import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;


public class uploadfile {
    public String username = System.getenv("LT_USERNAME");    //lambda UserName
    public String accesskey = System.getenv("LT_ACCESS_KEY"); //lambda accessKey
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status;
    String fileName;
    String gName;







    @Test(priority = 2)
    public void uploadFile() {           //uploading the logs to the terminal logs tab on lambdatest
     int n=0;




    File folder = new File("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Scholastic Project");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {

        if (listOfFiles[i].isFile()) {
            String fileName = listOfFiles[i].getName();
            if (fileName.endsWith(".txt")) {
               // System.out.println("File ---------------------------->" + fileName);
                String gName = fileName;
                gName= gName.replaceAll("[-]","");
               // System.out.print("replacegname:"+gName);
               gName = gName.substring(6, 38);

               //System.out.print("GNAME substring:------------>"+gName);
               String cName= fileName;
               cName=cName.replace("output","");
               cName=cName.replace("op","");
               String fName=cName.replace(".txt","");

             //System.out.print("cname===="+cName);
             // System.out.print("fname====="+fName);



                File testUploadFile = new File("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Scholastic Project\\"+"output"+cName+"");
               // System.out.print(testUploadFile);

                RestAssured.baseURI = "https://api.lambdatest.com/automation/api/v1/sessions/"+fName+"/terminal-logs";


                Response response = given().auth().basic(username, accesskey)
                        .multiPart(testUploadFile)
                        .when().post();

               // System.out.println(response.getStatusCode());
               // System.out.println(response.asString());

                //System.out.print("---------------->"+i);
            }
        }
    }




//
//        File testUploadFile = new File("D:\\API_Sample-master\\output"+gName+"op.txt");
//        System.out.print(testUploadFile);
//
//        RestAssured.baseURI = "https://api.lambdatest.com/automation/api/v1/sessions/"+gName+"/terminal-logs";
//
//
//        Response response = given().auth().basic(username, accesskey)
//                .multiPart(testUploadFile)
//                .when().post();
//
//        System.out.println(response.getStatusCode());
//        System.out.println(response.asString());








        /*File testUploadFile = new File("D:\\API_Sample-master\\output"+driver.getSessionId()+"op.txt"); //Specify your own location and file

        RestAssured.baseURI = "https://api.lambdatest.com/automation/api/v1/sessions/"+"8077cef009ee201018bf1463158df76"+"/terminal-logs";


        Response response = given().auth().basic(username, accesskey)
                .multiPart(testUploadFile)
                .when().post();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());*/














    }


    @AfterTest
    @org.testng.annotations.Parameters(value = {"platform", "browser", "version", "resolution"})
    public void tearDown(String platform, String browser, String version, String resolution) throws Exception {

        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }



}
