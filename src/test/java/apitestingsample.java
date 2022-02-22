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


public class apitestingsample {

    public String username = "";    //lambda UserName
    public String accesskey = ""; //lambda accessKey
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    public String sess;
    String status;
    public int b;



    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "resolution"})


    public void setUp(String browser, String version, String platform, String resolution) throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("resolution",resolution);
        capabilities.setCapability("build", "API_TESTING_SAMPLE_LAMBDATEST");
        capabilities.setCapability("console",true);
        //capabilities.setCapability("name","TestID12345");


        try {
            String url = "https://" + username + ":" + accesskey + gridURL;

            driver = new RemoteWebDriver(new URL(url), capabilities);


        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            System.out.println(f.getMessage());
        }
    }





    @Test(priority = 1)
    @org.testng.annotations.Parameters(value = {"platform", "browser", "version", "resolution"})


    public void sample() {
        String session="output"+driver.getSessionId();
        //System.out.print(session);



        try {
            //to save the console output on to a txt file

           System.setOut(new PrintStream(new FileOutputStream("/home/ubuntu/workspace/Internet Store Terminal Logs/"+session+".txt")));
//
//            File dir = new File("D:\\API_Sample-master\\output");
//            if(!dir.exists()) {
//                dir.mkdirs();
//            }
////            FileWriter fstream = new FileWriter(dir.getAbsolutePath() + "\\" + driver.getSessionId()+".txt", true);
//            System.setOut(new PrintStream(new FileOutputStream(dir.getAbsolutePath() + "\\" + driver.getSessionId()+".txt", true)));

            // Launch the app
            driver.get("https://lambdatest.github.io/sample-todo-app/");

            // Click on First Item
            driver.findElement(By.name("li")).click();

            // Click on Second Item
            driver.findElement(By.name("li2")).click();

            // Add new item is list
            driver.findElement(By.id("sampletodotext")).clear();
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();

            // Verify Added item
            String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
            status = "passed";
            b=b+1;

           // System.out.print("b---------------->"+b);

        }
        catch (Exception e) {
            status = "failed";
            System.out.println(e.getMessage());
        }
    }





//    @Test(priority = 2)
//    public void uploadFile() {           //uploading the logs to the terminal logs tab on lambdatest
//
//
//            File testUploadFile = new File("D:\\API_Sample-master\\output"+driver.getSessionId()+"op.txt"); //Specify your own location and file
//
//            RestAssured.baseURI = "https://api.lambdatest.com/automation/api/v1/sessions/"+driver.getSessionId()+"/terminal-logs";
//
//            String Name="out-"+driver.getSessionId()+".txt";
//            System.out.print("Name------>"+Name+"  -    ");
//            String current=Name.substring(3,40);
//            String x="-"+driver.getSessionId();
//            System.out.print("Current----->"+current+"-"+x+"  ");
//             int y = 0;
//
//
//
//
//
////              if(Name!=null)
////              { Response response = given().auth().basic(username,accesskey)
////                    .multiPart(testUploadFile)
////                    .when().post();
////
////                  System.out.println(response.getStatusCode());
////                  System.out.println(response.asString());
////                  y=y+1;
////                System.out.print("flag="+y+"");
////
////                 Name=null;
////
////                  //System.out.print("---1--"+Name+"");
////              }
//
//
//                  Response response = given().auth().basic(username,accesskey)
//                    .multiPart(testUploadFile)
//                    .when().post();
//
//                  System.out.println(response.getStatusCode());
//                  System.out.println(response.asString());
//                  y=y+1;
//                System.out.print("flag="+y+"");
//
//
//
//
////              else
////              {
////                  System.out.print("invalid session ID");
////                  //Name="output"+driver.getSessionId()+"op.txt";
////              }
//
//        }


    @AfterTest
    @org.testng.annotations.Parameters(value = {"platform", "browser", "version", "resolution"})
    public void tearDown(String platform, String browser, String version, String resolution) throws Exception {

        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

           // driver.quit();
        }
    }



}

