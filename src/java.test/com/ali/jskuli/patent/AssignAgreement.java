package com.ali.jskuli.patent;

import org.jtester.spec.JSpec;
import org.jtester.spec.annotations.Given;
import org.jtester.spec.annotations.Named;
import org.jtester.spec.annotations.When;
import org.jtester.spec.scenario.JSpecScenario;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.ali.jskuli.common.bogdacommon.BogdaCommon;
import com.ali.jskuli.listener.WebDriverFactory;
import com.ali.jskuli.log.StepLog;

/**
 * @author jiezhang bogda-合同用印申请-收费合同-履行中合同---分派 model_define_id = ALI.FORM.4305
 */

public class AssignAgreement extends JSpec {

    private Screen        s = new Screen();
    private WebDriver     driver;
    private static String user;

    public static String getUser() {
        return user;
    }

    public static void setUser(String name) {
        user = name;
    }

    @Given
    public void initTestData() throws Exception {

        StepLog.log("start0 sucessfull");
    }

    @When
    public void testVerify(final @Named("login") String login) throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = WebDriverFactory.createChromeWebDriver();
            String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcompany%2Fpersonal%2Fpending.htm%3Fspm%3D0.0.0.0.HLE6NI&CONTEXT_PATH=bogda&APP_NAME=bogda&CANCEL_CERT=true";
            String user = login;
            //setUser(login);
            String password = "";
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(1000);

            // driver = WebDriverFactory.createChromeWebDriver();
            // String url =
            // "https://login-test.alibaba-inc.com/ssoLogin.htm?APP_NAME=bogda&CONTEXT_PATH=bogda&BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcomm%2FmainPage.htm%3Fspm%3D0.0.0.0.H0eXWs%26pid%3D100016332&CANCEL_CERT=true";
            // user = login;
            // String password = "";
            // driver.manage().window().maximize();
            // driver.get(url);
            // Thread.sleep(1000);
            Common.login(driver, user, password);
            Common.Assign(s,driver);

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            throw e;

        } finally {
            driver.quit();
        }

    }

    @When
    public void testVerify2(final @Named("login") String login) throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = WebDriverFactory.createChromeWebDriver();
            String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcompany%2Fpersonal%2Fpending.htm%3Fspm%3D0.0.0.0.HLE6NI&CONTEXT_PATH=bogda&APP_NAME=bogda&CANCEL_CERT=true";
            String user = login;
            //setUser(login);
            String password = "";
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(1000);
            //BogdaCommon.login(driver, user, password);
            Common.login(driver, user, password);
            // BogdaCommon.audit(s);

            //防止页面报错
            Thread.sleep(2000);
            String newUrl = driver.getCurrentUrl();
            for(int i=0;i<3;i++){
                if(newUrl.endsWith("csrfError.htm")){
                    driver.navigate().back();
                    Thread.sleep(1000);
                    driver.manage().deleteAllCookies();
                    driver.navigate().refresh();
                    Thread.sleep(2000);
                    driver.manage().window().maximize();
                    driver.get(url);
                    Thread.sleep(1000);
                    Common.login(driver, user, password);
                    Thread.sleep(3000);
                }
                break;
            }
            //========================截止============================
//            Map<String, Object> object1 = SqlRunner.queryMap("select * from workflow_bill");
//            billId = object1.get("business_id").toString();
//            billId = db.query("select business_id from workflow_bill order by gmt_create desc ").toString();
            Common.audit1(s,driver);

/*
    @When
    public void auditVerify(final @Named("login") String login) throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = WebDriverFactory.createChromeWebDriver();
            String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?APP_NAME=bogda&CONTEXT_PATH=bogda&BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcomm%2FmainPage.htm%3Fspm%3D0.0.0.0.H0eXWs%26pid%3D100016332&CANCEL_CERT=true";
            user = login;
            String password = "";
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(1000);
            //BogdaCommon.login(driver, user, password);
            //BogdaCommon.audit(s);
            Common.audit(s,driver);
*/
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            throw e;

        } finally {
            driver.quit();
        }

    }
    // @Then
    // public void checkResult(final @Named("expected") DataMap expected)
    // throws Exception {
    // TempData data = new TempData();
    // String billId = data.getData("billId").toString();
    // db.useDB("bogda")
    // .query("select * from BOGDA_SUMMARY where BILL_ID ='" + billId + "'").reflectionEqMap(1, new DataMap() {
    //
    // {
    //
    // }
    // }, EqMode.IGNORE_ORDER);
    // db.useDB("bogda").table("BOGDA_SUMMARY").queryWhere("BILL_ID='" + billId + "'")
    // .reflectionEqMap(1, new DataMap() {
    //
    // {
    // this.put("STATUS", expected.get("STATUS").toString());
    // this.put("APPLICATION_NAME", expected.get("APPLICATION_NAME").toString());
    // }
    // }, EqMode.IGNORE_ORDER);
    // }

    @Test(description = "xxxxxx", dataProvider = "story", groups = { "jskuli" })
    public void runStory(JSpecScenario scenario) throws Throwable {
        this.run(scenario);

    }

}
