package com.ali.jskuli.patent;

import org.jtester.hamcrest.matcher.property.reflection.EqMode;
import org.jtester.spec.JSpec;
import org.jtester.spec.annotations.Given;
import org.jtester.spec.annotations.Named;
import org.jtester.spec.annotations.Then;
import org.jtester.spec.annotations.When;
import org.jtester.spec.scenario.JSpecScenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Env;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.ali.jskuli.TempData;
import com.ali.jskuli.common.bogdacommon.BogdaCommon;
import com.ali.jskuli.common.productline.infop.InfopBasicCommon;
import com.ali.jskuli.listener.WebDriverFactory;
import com.ali.jskuli.log.StepLog;
import util.GetUrlParameter;
import util.KeysOprate;


import static oracle.net.aso.C00.t;

/**
 * @author Xueshi.Liu 知识产权事务申请-专利申请
 */

public class TestAgreement extends JSpec {
    //@FindBy(xpath = "//*[@id=\"kuma_form2\"]")
   // private WebElement xiayi;//下移
    private Screen        s      = new Screen();
    private WebDriver     driver;
    private static String imgDir = "http://10.101.92.146/jskuli/bogdacommon/group/jskuli.intellectual.patent/";
    @FindBy(xpath = "//*[@id=\"stage\"]")

    private WebElement stage;//基本信息暂存
    @Given
    public void initTestData() throws Exception {

        StepLog.log("start0 sucessfull");
        // String tokenURL = "'http://10.218.141.252/bogda/comm/pub/workflow'";
        // String contractID = "'%ALI.FORM.7019%'";
        // db.useDB("fer")
        // .execute(
        // "update FM_MDWS set URL =" + tokenURL
        // + " WHERE model_define_id LIKE"
        // + contractID).commit();
    }


    @When
    public void testVerify() throws Exception {

        try {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = WebDriverFactory.createChromeWebDriver();
            String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fintellprop%2FproposalApply.htm%3Fspm%3D0.0.0.0.tBuLOe&CONTEXT_PATH=bogda&APP_NAME=bogda&CANCEL_CERT=true";
            String user = "peng.gongp";
            String password = "";
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(1000);
            Common.login(driver, user, password);
            Thread.sleep(2000);

            //专利名字
            driver.findElement(By.xpath("//*[@id=\"proposalName\"]")).sendKeys("专利申请");
            Thread.sleep(5000);
            //国家地区
            driver.findElement(By.xpath("//*[@id=\"kuma_form2\"]/table/tbody/tr[3]/td[2]/div[1]")).click();
            //选择中国
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]")).click();
           //输入理由
            driver.findElement(By.xpath("//*[@id=\"applyExplainId\"]")).sendKeys("专利申请理由");
            Thread.sleep(3000);
            //输入发明人
            driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("3");
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[5]/ul/div/a")).click();//全选
            Thread.sleep(2000);
            s.type(Key.TAB);//第一发明人选择
            s.type(Key.ENTER);
            s.type(Key.ENTER);
            Thread.sleep(2000);
            //driver.findElement(By.xpath("//*[@id=\"s2id_firstInventor\"]/a/span[1]")).sendKeys("孙彤宇");
          //  driver.findElement(By.xpath("//*[@id=\"s2id_firstInventor\"]/a/span[1]")).click();//第一发明人点击
           // driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div/div/div/span")).sendKeys("孙彤宇");//第一发明人选择
        ;//*[@id="s2id_firstInventor"]/a/span[1]
            s.type(Key.TAB);//主要联系人选择
            s.type(Key.ENTER);
            s.type(Key.ENTER);
            Thread.sleep(2000);


            GetUrlParameter.frameElement("cgIfm");
            GetUrlParameter.frameElement("centerPageFrame");
           // stage.click();

           //driver.findElement(By.xpath("//*[@id=\"stage\"]")).click();//暂存
           // Thread.sleep(3000);
         ///  driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td/input")).click();//暂存关闭
            Thread.sleep(3000);

            WebElement next = driver.findElement(By.xpath("//*[@id=\"next\"]"));
            next.click();//下一步
            Thread.sleep(6000);
            WebElement termExplain=  driver.findElement(By.xpath("//*[@id=\"termExplain\"]"));//背景信息页面术语解释
            WebElement keyWord=  driver.findElement(By.xpath("//*[@id=\"keyWord\"]"));////背景信息页面关键字
            WebElement usePlanProduct=  driver.findElement(By.xpath("//*[@id=\"usePlanProduct\"]"));//应用本方案的产品
            WebElement planBackground=  driver.findElement(By.xpath("//*[@id=\"planBackground\"]"));//方案背景
            WebElement competitor=  driver.findElement(By.xpath("//*[@id=\"competitor\"]"));//相关竞品
            WebElement sensitive=  driver.findElement(By.xpath("//*[@id=\"sensitive\"]"));///敏感信息
            WebElement similarPlan=  driver.findElement(By.xpath("//*[@id=\"similarPlan\"]"));///相似方案缺点
            WebElement next1 = driver.findElement(By.xpath("//*[@id=\"next\"]"));
            //背景信息页面
            termExplain.sendKeys("输入背景信息页面中术语解释");//输入背景信息页面中术语解释
            Thread.sleep(1000);
            keyWord.sendKeys("输入背景信息页面中关键字");//输入背景信息页面中关键字
            Thread.sleep(1000);
            usePlanProduct.sendKeys("输入背景信息页面中的应用本方案的产品");//输入背景信息页面中的应用本方案的产品
            Thread.sleep(1000);
            planBackground.sendKeys("输入方案背景");//输入方案背景
            Thread.sleep(1000);
            competitor.sendKeys("输入竞争产品");//输入竞争产品
            Thread.sleep(1000);
            sensitive.sendKeys("敏感信息");//敏感信息
            Thread.sleep(1000);
            similarPlan.sendKeys("输入相似方案");//输入相似方案
            Thread.sleep(5000);
            InfopBasicCommon.wheelDown(s, 34);

            next1.click();//点击下一步
            Thread.sleep(4000);
            //创新内容页面
            WebElement attachImages=  driver.findElement(By.xpath("//*[@id=\"pic-upload\"]/div/div/label/input"));//添加图片
            Thread.sleep(2000);
            attachImages.sendKeys("D:\\patentceshi\\图片\\index.gif");//附图添加
           // GetUrlParameter.frameElement("editor_ifr");
            driver.switchTo().frame(0);
            Thread.sleep(2000);
            WebElement plainImageDesc=  driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));//富文本编辑页
            Thread.sleep(2000);
           plainImageDesc.sendKeys("富文本编辑页");
            driver.switchTo().defaultContent();
            WebElement otherPlan=  driver.findElement(By.xpath("//*[@id=\"otherPlan\"]"));////其他方案
            Thread.sleep(2000);
            GetUrlParameter.frameElementexit("centerPageFrame");
            Thread.sleep(2000);
            otherPlan.sendKeys("/其他方案");//其他方案

            WebElement effectiveness=  driver.findElement(By.xpath("//*[@id=\"effectiveness\"]"));//技术效果
            Thread.sleep(2000);
            effectiveness.sendKeys("技术效果");//技术效果

            WebElement innovation=  driver.findElement(By.xpath("//*[@id=\"innovation\"]"));//技术创新点
             Thread.sleep(2000);
            innovation.sendKeys("技术创新点");//技术创新点

            WebElement source=  driver.findElement(By.xpath("//*[@id=\"source\"]"));//软件是否开源
            Thread.sleep(2000);
            source.sendKeys("是否开源");//是否开源
            WebElement note=  driver.findElement(By.xpath("//*[@id=\"note\"]"));//备注
            Thread.sleep(2000);
            note.sendKeys("备注");//备注

            WebElement submit=  driver.findElement(By.xpath("//*[@id=\"submit\"]"));//提交
            Thread.sleep(2000);
            submit.click();
            Thread.sleep(20000);
            //保存申请单号

            String a  = driver.findElement(By.className("m_oddnum")).getText();
            System.out.println(a);
            //String aa = a.substring(a.indexOf("1"),14);
            TempData data = new TempData();
            Thread.sleep(500);
            data.saveTempData("billId", a);
            Thread.sleep(1000);

            //*[@id="container"]/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[3]/span[2]

        //  String xiangqing=  driver.findElement(By.className("m_oddnum")).getText();
/*
//保存申请单号
            s.find(xiangqing).offset(30, 0).doubleClick();
            //s.find("src/java.test/img/number.png").offset(30, 0).doubleClick();
            s.mouseUp();
            s.keyDown(Key.CTRL);
            s.type("c");
            s.keyUp(Key.CTRL);
            Thread.sleep(500);
            String content = Env.getClipboard();
            TempData data = new TempData();
            Thread.sleep(1000);
            data.saveTempData("billId", content);

            s.type(Key.PAGE_DOWN, 5);

*/
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            throw e;

        } finally {
            driver.quit();
        }

    }

    @Then
    public void checkResult(final @Named("expected") DataMap expected) throws Exception {
        TempData data = new TempData();
        String billId = data.getData("billId").toString();
        // System.out.println(billId);
        db.useDB("bogda").query("select * from BOGDA_SUMMARY where BILL_ID ='" + billId
                                + "'").reflectionEqMap(1, new DataMap() {

                                    {

                                    }
                                }, EqMode.IGNORE_ORDER);
        db.useDB("bogda").table("BOGDA_SUMMARY").queryWhere("BILL_ID='" + billId + "'").reflectionEqMap(1,
                                                                                                        new DataMap() {

                                                                                                            {
                                                                                                                this.put("STATUS",
                                                                                                                         expected.get("STATUS").toString());
                                                                                                                this.put("APPLICATION_NAME",
                                                                                                                         expected.get("APPLICATION_NAME").toString());
                                                                                                            }
                                                                                                        },
                                                                                                        EqMode.IGNORE_ORDER);
    }

    @Test(description = "xxxxxx", dataProvider = "story", groups = { "jskuli" })
    public void runStory(JSpecScenario scenario) throws Throwable {
        this.run(scenario);

    }

}
