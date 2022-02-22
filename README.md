# API_Sample

Java-TestNG sample to upload terminal logs onto the LambdaTest automation dashboard using the terminal logs API.

This sample upon execution will fail, giving an output of the following exception which will be uploaded to the dashboard under Terminal logs.



`no such element: Unable to locate element: {"method":"css selector","selector":"*[name='li']"}
  (Session info: chrome=88.0.4324.104)
For documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-LJ1ID1U', ip: '192.168.0.108', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_211'
Driver info: org.openqa.selenium.remote.RemoteWebDriver
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 88.0.4324.104, chrome: {chromedriverVersion: 87.0.4280.20 (c99e81631faa0..., userDataDir: C:\Users\ltuser\AppData\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:63251}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true, webdriver.remote.sessionid: 3d77671b3e07c40aafb1a712af1...}
Session ID: 3d77671b3e07c40aafb1a712af15fde3
*** Element info: {Using=name, value=li}
`

### Environment Setup

1. Global Dependencies
    * Install [Maven](https://maven.apache.org/install.html)

2. Lambdatest Credentials
    * Set LambdaTest username and access key in environment variables. It can be obtained from [LambdaTest dashboard](https://automation.lambdatest.com/)    
    example:
    - For linux/mac
    ```
    export LT_USERNAME="YOUR_USERNAME"
    export LT_ACCESS_KEY="YOUR ACCESS KEY"
    
    ```
    - For Windows
    ```
    set LT_USERNAME="YOUR_USERNAME"
    set LT_ACCESS_KEY="YOUR ACCESS KEY"
    
    ```
