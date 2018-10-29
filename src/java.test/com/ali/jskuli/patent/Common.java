package com.ali.jskuli.patent;

import com.ali.jskuli.Operate;
import com.ali.jskuli.TempData;
import com.ali.jskuli.common.productline.infop.InfopBasicCommon;
import com.ali.jskuli.listener.WebDriverFactory;
import com.opera.core.systems.OperaDriver;
import org.jtester.module.database.util.SqlRunner;
import org.jtester.spec.annotations.Named;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import util.GetUrlParameter;
import util.KeysOprate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static org.jtester.core.IJTester.db;
import static sun.reflect.misc.FieldUtil.getField;
import static webdriver.constants.CommonConstants.BILLD;

public class Common {

	public static void login(WebDriver driver, String user, String password) throws Exception {
		driver.findElement(By.name("domainAccount")).sendKeys(new CharSequence[]{user});
		driver.findElement(By.name("password")).sendKeys(new CharSequence[]{password});
		//driver.findElement(By.id("loginAccountInput")).sendKeys(new CharSequence[]{user});
		//driver.findElement(By.id("loginPassword")).sendKeys(new CharSequence[]{password});
		driver.findElement(By.xpath("//*[@id=\"App\"]/div/div[2]/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	}

	//审批
	public static void audit(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
//		GetUrlParameter.frameElement("cgIfm");
//		GetUrlParameter.frameElement("centerPageFrame");
		Thread.sleep(1000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
		//输入-申请单号
//		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input"));
		Thread.sleep(2000);
		driver.findElement(By.id("billId")).sendKeys(billId);
//		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("//*[@id=\"btnQuery\"]")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[12]/a")).click();
		Thread.sleep(20000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}

		InfopBasicCommon.wheelDown(s, 34);
		Thread.sleep(500);

//        //财务初审需要选择“是否新增、新修订的收入模板合同”
//        if(AuditAgreement.getUser().equals("yan.zhuy")) {
//
//            //点击-是否新增、新修订的收入模板合同（是）
//            driver.findElement(By.xpath("//*[@id=\"isNewTemplate\"]")).click();
//            InfopBasicCommon.wheelDown(s, 2);
//            Thread.sleep(500);
//
//            //审批意见
//            WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
//            webElement3.sendKeys("audit opinion");
//            //点击-通过
//            driver.findElement(By.xpath("//*[@id=\"agreeBtn\"]")).click();
//            //点击-关闭页面
//            InfopBasicCommon.clickImg(s, imgDir + "close_detail.png", null, null, null, true, null, null);
//        }
//        //普通审批通过流程
//        else{

		//审批意见
		Thread.sleep(4000);
		WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
		webElement3.sendKeys("audit opinion");
		Thread.sleep(2000);
		//点击-通过
		driver.findElement(By.xpath("//*[@id=\"agreeBtn\"]")).click();
		Thread.sleep(2000);
		//点击-确定
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
		//点击-查看详情
		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div[1]/a")).click();
		//InfopBasicCommon.clickImg(s, imgDir + "page_close.png", null, null, null, true, null, null);
//        }
		Thread.sleep(2000);

	}

	//  ipr ---  审批
	public static void audit1(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
//		GetUrlParameter.frameElement("cgIfm");
//		GetUrlParameter.frameElement("centerPageFrame");
		Thread.sleep(1000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
		//输入-申请单号
//		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input"));
		Thread.sleep(2000);
		driver.findElement(By.id("billId")).sendKeys(billId);
//		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("//*[@id=\"btnQuery\"]")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[12]/a")).click();
		Thread.sleep(6000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}

		InfopBasicCommon.wheelDown(s, 4);
		Thread.sleep(500);

//        //财务初审需要选择“是否新增、新修订的收入模板合同”
//        if(AuditAgreement.getUser().equals("yan.zhuy")) {
//
//            //点击-是否新增、新修订的收入模板合同（是）
//            driver.findElement(By.xpath("//*[@id=\"isNewTemplate\"]")).click();
//            InfopBasicCommon.wheelDown(s, 2);
//            Thread.sleep(500);
//
//            //审批意见
//            WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
//            webElement3.sendKeys("audit opinion");
//            //点击-通过
//            driver.findElement(By.xpath("//*[@id=\"agreeBtn\"]")).click();
//            //点击-关闭页面
//            InfopBasicCommon.clickImg(s, imgDir + "close_detail.png", null, null, null, true, null, null);
//        }
//        //普通审批通过流程
//        else{
		//审批意见
		WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
		webElement3.sendKeys("audit opinion");
		//点击-通过
		driver.findElement(By.xpath("//*[@id=\"ipr-agreeBtn\"]")).click();

		//点击-确定
		//driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[2]/div/a")).click();
         //点击-查看详情
		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div[1]/a")).click();
		//InfopBasicCommon.clickImg(s, imgDir + "page_close.png", null, null, null, true, null, null);
//        }
		Thread.sleep(2000);

	}


	//  归档审批
	public static void audit2(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
//		GetUrlParameter.frameElement("cgIfm");
//		GetUrlParameter.frameElement("centerPageFrame");
		Thread.sleep(1000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
		//输入-申请单号
//		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input"));
		Thread.sleep(2000);
		driver.findElement(By.id("billId")).sendKeys(billId);
//		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("//*[@id=\"btnQuery\"]")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[12]/a")).click();
		Thread.sleep(20000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}

		InfopBasicCommon.wheelDown(s, 38);
		Thread.sleep(500);

//
		//点击-归档

		//driver.findElement(By.tagName("//*[@id=\"agreeBtn\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/p/input")).click();

		//点击-确定
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
		//点击-查看详情
		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div[1]/a")).click();
		//InfopBasicCommon.clickImg(s, imgDir + "page_close.png", null, null, null, true, null, null);
//        }
		Thread.sleep(2000);

	}

	//申请人确认
	public static void confirm(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();

		//输入-申请单号

		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input"));

		//WebElement webElement = driver.findElement(By.xpath("//*[@id=\"billId\"]"));
		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("//*[@id=\"btnQuery\"]")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[12]/a")).click();
		Thread.sleep(6000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}

		InfopBasicCommon.wheelDown(s, 5);
		Thread.sleep(500);

		//点击-是否对方先盖章（是）
		driver.findElement(By.xpath("//*[@id=\"contractSeal\"]")).click();

		//审批意见
		WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
		webElement3.sendKeys("audit opinion");
		//点击-通过
		driver.findElement(By.xpath("//*[@id=\"agreeBtn\"]")).click();
		//点击-关闭页面
		InfopBasicCommon.clickImg(s, imgDir + "page_close.png", null, null, null, true, null, null);
		Thread.sleep(2000);}

	//归档
	//归档在归档中心
	public static void pigeonhole(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();

		//输入-申请单号
		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[2]/input"));
		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[6]/td/input")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td[12]/a")).click();
		Thread.sleep(6000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}

		InfopBasicCommon.wheelDown(s, 4);
		Thread.sleep(500);

		//点击-盖章且归档
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/input[2]")).click();
		Thread.sleep(1000);

		Operate.clickAfterApper(s, imgDir + "pigeonhole_confirm.png");
		Thread.sleep(1000);
	}

	public static void loginBogda(Screen s, String user, String password)
			throws FindFailed, InterruptedException {

		Thread.sleep(500);
		Operate.clickAfterApper(s, "src/java.test/img/username.png");
		s.paste(user);
		Thread.sleep(500);
		Operate.clickAfterApper(s, "src/java.test/img/login.png");
		/*Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/experience.png");
		Thread.sleep(5000);*/

	}
    private static String imgDir = "http://10.101.92.146/jskuli/bogdacommon/";

	// 上传附件
	public static void uploadFile(Screen s, String img) throws IOException,
			InterruptedException {
		File f = new File("");
		String projectPath = f.getCanonicalPath();
		File targetFile = new File(projectPath + "/src/java.test/img/");
		Thread.sleep(3000);
		s.paste(targetFile.getCanonicalPath() + "\\" + img);
		s.type(Key.ENTER);
		Thread.sleep(1000);
	}


	//加签在前--审批人
	public static void AddSign(WebDriver driver,Screen s) throws Exception {
		String imgDir = "http://10.101.92.146/jskuli/bogdacommon/";
		Thread.sleep(6000L);
		InfopBasicCommon.clickImg(s, imgDir + "number1.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, (String)null, (Float)null, (Integer)null, (Integer)null, (String)null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		Thread.sleep(3000L);
		InfopBasicCommon.clickImg(s, imgDir + "do.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		Thread.sleep(5000L);
		s.type("\ue005");
		String[] handles  = new String[driver.getWindowHandles().size()];//定义数组，所有窗口的句柄；
		driver.getWindowHandles().toArray(handles);
		WebDriver childWindow = driver.switchTo().window(handles[1]);//根据句柄切换至你想切换的窗口
		//切换窗口
		String CurrentUrl=driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		Thread.sleep(2000);
		InfopBasicCommon.wheelDown(s, Integer.valueOf(5));
		driver.findElement(By.id("dynaAppendBtn")).click();
		driver.findElement(By.xpath("//*[@id=\"dyna_append_person_div\"]/div/div/ol/li/input")).sendKeys("49363");
		Thread.sleep(2000);
		InfopBasicCommon.keyPress(s,Key.ENTER);
		driver.findElement(By.xpath("//*[@id=\"appendTagContent\"]/tr[1]/td[1]/label/s")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"appendTagContent\"]/tr[1]/td[2]/div[2]/input[1]")).click();
		//driver.findElement(By.name("appendTagBtn")).click();
		Thread.sleep(2000);
		InfopBasicCommon.clickImg(s, imgDir + "preSign_submit.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/div/div[3]/div[1]/a")).click();
//		driver.switchTo().alert().accept();
//		driver.findElement(By.id("doDynamicAppendTag")).click();

//		driver.findElement(By.cssSelector("49363")).click();
//		Operate.clickAfterApper(s, "src/java.test/img/preSign.png");
//	    Operate.clickAfterApper(s, "src/java.test/img/preSign_cancel.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_add.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_select.png");
//		s.paste("49363");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_go.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_get.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_ok.png");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_reason.png");
//		s.paste("addsign");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_submit.png");
	}
	public static void cancelContract(WebDriver driver, Screen s) throws Exception {
		String imgDir = "http://10.101.92.146/jskuli/bogdacommon/";
		Thread.sleep(6000L);
		InfopBasicCommon.clickImg(s, imgDir + "number1.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, (String) null, (Float) null, (Integer) null, (Integer) null, (String) null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
		Thread.sleep(3000L);
		InfopBasicCommon.clickImg(s, imgDir + "detail.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
		Thread.sleep(5000L);
		s.type("\ue005");
		String[] handles = new String[driver.getWindowHandles().size()];//定义数组，所有窗口的句柄；
		driver.getWindowHandles().toArray(handles);
		WebDriver childWindow = driver.switchTo().window(handles[1]);//根据句柄切换至你想切换的窗口
		//切换窗口
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		Thread.sleep(1000);
		InfopBasicCommon.wheelDown(s, Integer.valueOf(3));
		driver.findElement(By.id("btnCancle")).click();
		//InfopBasicCommon.clickImg(s, imgDir + "cancelContract.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		InfopBasicCommon.clickImg(s, imgDir + "sign_close.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
		InfopBasicCommon.clickImg(s, imgDir + "cancel_reason.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
		InfopBasicCommon.inputValue(s, "cancelContract", (String) null, (Float) null, (Integer) null, (Integer) null, (String) null);
		driver.findElement(By.id("btnCancle")).click();
		driver.switchTo().alert().accept();
		//InfopBasicCommon.clickImg(s, imgDir + "cancelContract.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		//InfopBasicCommon.clickImg(s, imgDir + "sign_ok.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
	}
	//审批处理【集团】
	public static void auditno(final @Named("login") String login, WebDriver driver, Screen s) throws Exception {

		try {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = WebDriverFactory.createChromeWebDriver();
			String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?APP_NAME=bogda&CONTEXT_PATH=bogda&BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcompany%2Fpersonal%2Fpending.htm%3Fspm%3D0.0.0.0.IZz2DQ_0.0.0.0.OUTUWm&CANCEL_CERT=true";
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(1000);
			Common.login(driver, login, "");
			//防止页面报错
			Thread.sleep(3000);
			String newUrl = driver.getCurrentUrl();
			for (int i = 0; i < 3; i++) {
				if (newUrl.endsWith("csrfError.htm")) {
					driver.navigate().back();
					Thread.sleep(1000);
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
					Thread.sleep(2000);
					driver.manage().window().maximize();
					driver.get(url);
					Thread.sleep(1000);
					Common.login(driver, login, "");
					Thread.sleep(3000);
				}
				break;
			}
			//==============截止===============================

			Thread.sleep(5000);
			//获取单号
			TempData data = new TempData();
			String billId = data.getData("billId").toString();
			/**
			 * 个人中心--待办事项页面
			 * 输入申请单号
			 */
			//GetUrlParameter.frameElement("centerPageFrame");
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input")).click();

			//driver.findElement(By.xpath("//*[@id='billId']")).click();
			InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
			System.out.println("----billId-----billId----billId----billId-------billId------------"+billId);
			//查找记录
			driver.findElement(By.xpath("//*[@id='btnQuery']")).click();
			Thread.sleep(4000);
			//点击处理按钮
			driver.findElement(By.xpath("//*[@id='u_l_table']/tbody/tr/td[12]/a")).click();

			Thread.sleep(2000);
			//切换窗口
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				System.out.println("+++" + winHandle);
				driver.switchTo().window(winHandle);
			}
			InfopBasicCommon.wheelDown(s, 7);
			//输入审批意见
			driver.findElement(By.xpath("//*[@id='J-at']")).click();
			InfopBasicCommon.inputValue(s, "tankTest_yewushenpi_agree222", null, null, null, null, null);
			Thread.sleep(2000);
			InfopBasicCommon.wheelDown(s, 7);
			//通过按钮
			driver.findElement(By.xpath("//*[@id='disagreeBtn']")).click();
			Thread.sleep(2000);
			driver.switchTo().window(winHandleBefore);
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			throw e;
		} finally {


			driver.quit();
		}
	}

	public static void ReapplyNoConfirmUpload(final @Named("login") String login,WebDriver driver,Screen s) throws Exception {
		try {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = WebDriverFactory.createChromeWebDriver();
			String url = "https://login-test.alibaba-inc.com/ssoLogin.htm?BACK_URL=http%3A%2F%2Fbogda.alitest.com%2Fbogda%2Fcompany%2Fpersonal%2Fmyapply.htm%3Fspm%3D0.0.0.0.D5jzyB_0.0.0.0.VnkfAp&CONTEXT_PATH=bogda&APP_NAME=bogda&CANCEL_CERT=true";
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(1000);
			Common.login(driver, login, "");
			//防止页面报错
			Thread.sleep(3000);
			String newUrl = driver.getCurrentUrl();
			for (int i = 0; i < 3; i++) {
				if (newUrl.endsWith("csrfError.htm")) {
					driver.navigate().back();
					Thread.sleep(1000);
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
					Thread.sleep(2000);
					driver.manage().window().maximize();
					driver.get(url);
					Thread.sleep(1000);
					Common.login(driver, login, "");
					Thread.sleep(3000);
				}
				break;
			}
			//==============截止===============================
			String imgDir = "http://10.101.92.146/jskuli/bogdacommon/";
			Thread.sleep(2000L);
			driver.findElement(By.id("billId")).click();
			//InfopBasicCommon.clickImg(s, imgDir + "number1.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
			TempData data = new TempData();
			String billId = data.getData("billId").toString();
			InfopBasicCommon.inputValue(s, billId, (String) null, (Float) null, (Integer) null, (Integer) null, (String) null);
			Thread.sleep(3000L);
			driver.findElement(By.id("btnQuery")).click();
			//InfopBasicCommon.clickImg(s, imgDir + "search.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
			Thread.sleep(3000L);
			//driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[13]/a")).click();
			InfopBasicCommon.clickImg(s, imgDir + "detail.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
			Thread.sleep(5000L);
			//s.type("\ue005");
			String[] handles = new String[driver.getWindowHandles().size()];//定义数组，所有窗口的句柄；
			driver.getWindowHandles().toArray(handles);
			WebDriver childWindow = driver.switchTo().window(handles[1]);//根据句柄切换至你想切换的窗口
			//切换窗口
			String CurrentUrl = driver.getCurrentUrl();
			System.out.println(CurrentUrl);
			Thread.sleep(1000);
			InfopBasicCommon.wheelDown(s, Integer.valueOf(5));
			driver.findElement(By.id("btnReSubmit")).click();
			//InfopBasicCommon.clickImg(s, imgDir + "reapply.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
			Thread.sleep(5000L);
			InfopBasicCommon.wheelDown(s, Integer.valueOf(3));
			InfopBasicCommon.clickImg(s, imgDir + "upload.png", (Float) null, (Integer) null, (Integer) null, Boolean.valueOf(true), (Integer) null, (String) null);
			uploadFile(s, "test.jpg");
			InfopBasicCommon.wheelDown(s, Integer.valueOf(3));
			//driver.getWindowHandle(); //此行代码用来定位当前页面
//		InfopBasicCommon.clickImg(s, imgDir + "submit.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
			Thread.sleep(3000L);
			driver.findElement(By.id("btnSubmit")).click();//提交
			Thread.sleep(1000L);
			driver.switchTo().alert().accept();//点击自带“确认”框
			Thread.sleep(30000L);

			//InfopBasicCommon.clickImg(s, imgDir + "sign_ok.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
			//Thread.sleep(30000L);
			Thread.sleep(2000);
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			throw e;
		} finally {


			driver.quit();
		}
	}
	//转交
	public static void forward(WebDriver driver,Screen s) throws Exception {
		String imgDir = "http://10.101.92.146/jskuli/bogdacommon/";
		Thread.sleep(6000L);
		InfopBasicCommon.clickImg(s, imgDir + "number1.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, (String)null, (Float)null, (Integer)null, (Integer)null, (String)null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		Thread.sleep(3000L);
		InfopBasicCommon.clickImg(s, imgDir + "do.png", (Float)null, (Integer)null, (Integer)null, Boolean.valueOf(true), (Integer)null, (String)null);
		Thread.sleep(5000L);
		s.type("\ue005");
		String[] handles  = new String[driver.getWindowHandles().size()];//定义数组，所有窗口的句柄；
		driver.getWindowHandles().toArray(handles);
		WebDriver childWindow = driver.switchTo().window(handles[1]);//根据句柄切换至你想切换的窗口
		//切换窗口
		String CurrentUrl=driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		Thread.sleep(2000);
		InfopBasicCommon.wheelDown(s, Integer.valueOf(5));
		driver.findElement(By.id("redirectBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"redirectDiv\"]/div[2]/table/tbody/tr[1]/td[2]/div/div/ol/li/input")).sendKeys("WB201560");
		Thread.sleep(1000);
		InfopBasicCommon.keyPress(s,Key.ENTER);
		driver.findElement(By.id("J-at-redirect")).sendKeys("转交给何颐弢");
		Thread.sleep(1000);
		driver.findElement(By.id("redirectSubBtn")).click();
		//driver.findElement(By.name("appendTagBtn")).click();
		Thread.sleep(2000);

//		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
		//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
//		Operate.clickAfterApper(s, "src/java.test/img/center.png");
//		Thread.sleep(5000);
//		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
//		TempData data = new TempData();
//		String billId = data.getData("billId").toString();
//		s.paste(billId);
//		Thread.sleep(2000);
//		Operate.clickAfterApper(s, "src/java.test/img/search.png");
//        Thread.sleep(2000);
//		Operate.clickAfterApper(s, "src/java.test/img/do.png");
//		Thread.sleep(2000);
//		s.type(Key.PAGE_DOWN);
//		Operate.clickAfterApper(s, "src/java.test/img/forward.png");
//		Operate.clickAfterApper(s, "src/java.test/img/forward_person.png");
//		s.paste("49363");
//	//	s.paste("34076");
//		Operate.clickAfterApper(s, "src/java.test/img/preSign_get.png");
//		Operate.clickAfterApper(s, "src/java.test/img/forward_reason.png");
//		s.paste("forward");
//		Operate.clickAfterApper(s, "src/java.test/img/submit.png");
//		Thread.sleep(1000);
	}

//	// 上传附件
//	public static void uploadFile(Screen s, String img) throws IOException, InterruptedException {
//		File f = new File("");
//		String projectPath = f.getCanonicalPath();
//		File targetFile = new File(projectPath + "/src/java.test/img/");
//		Thread.sleep(1000);
//		s.paste(targetFile.getCanonicalPath() + "\\" + img);
//		s.type(Key.ENTER);
//		Thread.sleep(1000);
//	}

	// 加签在前--审批人
	public static void AddSign(Screen s) throws Exception {

		Thread.sleep(5000);

		InfopBasicCommon.clickImg(s, imgDir + "number1.png", null, null, null, true, null, null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", null, null, null, true, null, null);
		Thread.sleep(3000);
		InfopBasicCommon.clickImg(s, imgDir + "do.png", null, null, null, true, null, null);
		Thread.sleep(3000);
		// 保存申请单号
		s.find("src/java.test/img/number.png").offset(30, 0).doubleClick();
		s.type(Key.PAGE_DOWN);
		s.type(Key.PAGE_DOWN);
		InfopBasicCommon.clickImg(s, imgDir + "auditopinion.png", null, null, null, true, null, null);
		InfopBasicCommon.inputValue(s, "Add Sign", null, null, null, null, null);

		s.type(Key.PAGE_DOWN);
		InfopBasicCommon.clickImg(s, imgDir + "addSign.png", null, null, null, true, null, null);

		InfopBasicCommon.clickImg(s, imgDir + "preSigeperson2.png", null, null, null, true, null, null);
		InfopBasicCommon.inputValue(s, "49363", null, null, null, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "clickPerson.png", null, null, null, true, null, null);

		InfopBasicCommon.clickImg(s, imgDir + "one.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "preSign2.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "Bluresure.png", null, null, null, true, null, null);
        /*
         * InfopBasicCommon.clickImg(s, imgDir + "preSignonly_get.png", null, null, null, true, null, null);
         * InfopBasicCommon.clickImg(s, imgDir + "preSignonly_reason.png", null, null, null, true, null, null);
         */

		// InfopBasicCommon.inputValue(s, "addsign", null, null, null, null, null);

		// InfopBasicCommon.clickImg(s, imgDir + "submit.png", null, null, null, true, null, null);
		Thread.sleep(3000);
	}

	//催签--申请人
	public static void ReminderSign(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/center.png");
	//	Thread.sleep(2000);
	//	Operate.clickAfterApper(s, "src/java.test/img/myApply.png");
		Thread.sleep(3000);
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(1000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(2000);	        
		Operate.clickAfterApper(s, "src/java.test/img/detail.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/ReminderSign.png");
		Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/sign_close.png");
	}
	//撤消申请--申请人
	public static void Cancel(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		/*Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	 	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
		Thread.sleep(3000);
	 	Operate.clickAfterApper(s, "src/java.test/img/center.png");
	 	Thread.sleep(3000);	 
	 	Operate.clickAfterApper(s, "src/java.test/img/myApply.png");
		Thread.sleep(3000);*/
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(2000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
		Operate.clickAfterApper(s, "src/java.test/img/detail.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
	//	Operate.clickAfterApper(s, "src/java.test/img/cancel.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/sign_close.png");
		Operate.clickAfterApper(s, "src/java.test/img/cancel_reason.png");
		s.paste("Cancel");
		Operate.clickAfterApper(s, "src/java.test/img/cancel.png");
		Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/sign_close.png");
	}
	
	public static void cancelContract(Screen s) throws Exception {
		
		Thread.sleep(6000);
		InfopBasicCommon.clickImg(s, imgDir + "number1.png", null, null, null, true, null, null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", null, null, null, true, null, null);
        Thread.sleep(3000);	        
		InfopBasicCommon.clickImg(s, imgDir + "detail.png", null, null, null, true, null, null);
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		InfopBasicCommon.clickImg(s, imgDir + "cancelContract.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "sign_close.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "cancel_reason.png", null, null, null, true, null, null);
	    InfopBasicCommon.inputValue(s, "cancelContract", null, null, null, null, null);
		//s.paste("cancelContract");
		InfopBasicCommon.clickImg(s, imgDir + "cancelContract.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "sign_ok.png", null, null, null, true, null, null);
		Thread.sleep(3000);	
	}
	
	//加签在前--审批人
//	public static void AddSign(Screen s) throws Exception {
//
//		Thread.sleep(5000);
//
//		InfopBasicCommon.clickImg(s, imgDir + "number1.png", null, null, null, true, null, null);
//		TempData data = new TempData();
//		String billId = data.getData("billId").toString();
//		InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
//		InfopBasicCommon.clickImg(s, imgDir + "search.png", null, null, null, true, null, null);
//        Thread.sleep(3000);
//		InfopBasicCommon.clickImg(s, imgDir + "do.png", null, null, null, true, null, null);
//		Thread.sleep(1000);
//		InfopBasicCommon.clickImg(s,imgDir + "auditopinion.png", null, null, null, true, null, null);
//		InfopBasicCommon.inputValue(s, "Add Sign", null, null, null, null, null);
//
//		s.type(Key.PAGE_DOWN);
//		InfopBasicCommon.clickImg(s, imgDir + "addSign.png", null, null, null, true, null, null);
//
//		InfopBasicCommon.clickImg(s, imgDir + "preSigeperson2.png", null, null, null, true, null, null);
//		InfopBasicCommon.inputValue(s, "49363", null, null, null, null, null);
//		InfopBasicCommon.clickImg(s, imgDir + "clickPerson.png", null, null, null, true, null, null);
//
//		InfopBasicCommon.clickImg(s, imgDir + "one.png", null, null, null, true, null, null);
//		InfopBasicCommon.clickImg(s, imgDir + "preSign2.png", null, null, null, true, null, null);
//		InfopBasicCommon.clickImg(s, imgDir + "Bluresure.png", null, null, null, true, null, null);
///*		InfopBasicCommon.clickImg(s, imgDir + "preSignonly_get.png", null, null, null, true, null, null);
//		InfopBasicCommon.clickImg(s, imgDir + "preSignonly_reason.png", null, null, null, true, null, null);*/
//
//		//InfopBasicCommon.inputValue(s, "addsign", null, null, null, null, null);
//
//	//	InfopBasicCommon.clickImg(s, imgDir + "submit.png", null, null, null, true, null, null);
//		Thread.sleep(3000);
//	}
	

	
	
	//分配--法务总监
	public static void Assign(Screen s,WebDriver driver) throws Exception {
		Thread.sleep(8000);
//		GetUrlParameter.frameElement("cgIfm");
//		GetUrlParameter.frameElement("centerPageFrame");
		Thread.sleep(1000);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
		//输入-申请单号
//		WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/table/tbody/tr[1]/td[4]/input"));
		Thread.sleep(2000);

		driver.findElement(By.id("billId")).sendKeys(billId);
//		webElement.sendKeys(billId);
		//点击-查找
		driver.findElement(By.xpath("//*[@id=\"btnQuery\"]")).click();
		Thread.sleep(1000);
		//点击-处理
		driver.findElement(By.xpath("//*[@id=\"u_l_table\"]/tbody/tr/td[12]/a")).click();
		Thread.sleep(6000);

		//进入审批详情页
		int count = 1;
		for(String p : driver.getWindowHandles()){
			if(count == driver.getWindowHandles().size()){
				driver.switchTo().window(p);
			}
			count++;
		}
		//Common.wheelDown(s, 4);
		InfopBasicCommon.wheelDown(s, 37);
		Thread.sleep(500);

//        //财务初审需要选择“是否新增、新修订的收入模板合同”
//        if(AuditAgreement.getUser().equals("yan.zhuy")) {
//
//            //点击-是否新增、新修订的收入模板合同（是）
//            driver.findElement(By.xpath("//*[@id=\"isNewTemplate\"]")).click();
//            InfopBasicCommon.wheelDown(s, 2);
//            Thread.sleep(500);
//
//            //审批意见
//            WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
//            webElement3.sendKeys("audit opinion");
//            //点击-通过
//            driver.findElement(By.xpath("//*[@id=\"agreeBtn\"]")).click();
//            //点击-关闭页面
//            InfopBasicCommon.clickImg(s, imgDir + "close_detail.png", null, null, null, true, null, null);
//        }
//        //普通审批通过流程
//        else{
		//审批意见
		WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"J-at\"]"));
		webElement3.sendKeys("audit opinion");

		//选择分派人
		driver.findElement(By.xpath("//*[@id=\"s2id_somes\"]/a/span[1]")).click();
		Thread.sleep(8000);
		s.type(Key.ENTER);
		//driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div/div/div/span")).click();
		//点击分派
		driver.findElement(By.xpath("//*[@id=\"approveBtnDiv\"]/p/input[1]")).click();
		Thread.sleep(2000);
		//点击-确定
		//driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[2]/div/a")).click();

		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div[1]/a")).click();
		//InfopBasicCommon.clickImg(s, imgDir + "page_close.png", null, null, null, true, null, null);
//        }
		Thread.sleep(2000);


/*
		Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
		Operate.clickAfterApper(s, "src/java.test/img/center.png");
		Thread.sleep(5000); 		
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
		Operate.clickAfterApper(s, "src/java.test/img/do.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/Assign.png");
		Operate.clickAfterApper(s, "src/java.test/img/assign_person.png");
		Operate.clickAfterApper(s, "src/java.test/img/submit.png");
*/
	}
	//转交---法务审批人
	public static void forward(Screen s) throws Exception {
		
		Thread.sleep(5000);
	//	InfopBasicCommon.clickImg(s, imgDir + "have.png", null, null, null, true, null, null);
	//	InfopBasicCommon.clickImg(s, imgDir + "apply.png", null, null, null, true, null, null);
	//	InfopBasicCommon.clickImg(s, imgDir + "center.png", null, null, null, true, null, null);
	//	Thread.sleep(1000);	 		
		InfopBasicCommon.clickImg(s, imgDir + "number1.png", null, null, null, true, null, null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", null, null, null, true, null, null);
        Thread.sleep(3000);	        
		InfopBasicCommon.clickImg(s, imgDir + "do.png", null, null, null, true, null, null);
		Thread.sleep(3000);	
		InfopBasicCommon.clickImg(s,imgDir + "auditopinion.png", null, null, null, true, null, null);
		InfopBasicCommon.inputValue(s, "Forward", null, null, null, null, null);
		s.type(Key.PAGE_DOWN);
		InfopBasicCommon.clickImg(s, imgDir + "forward.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "forward_person.png", null, null, null, true, null, null);
		InfopBasicCommon.inputValue(s, "34076", null, null, null, null, null);
		//s.paste("34076");
		InfopBasicCommon.clickImg(s, imgDir + "forward_get.png", null, null, null, true, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "forward_reason.png", null, null, null, true, null, null);
		InfopBasicCommon.inputValue(s, "forward_reason", null, null, null, null, null);
		//s.paste("forward_reason");
		InfopBasicCommon.clickImg(s, imgDir + "submit.png", null, null, null, true, null, null);
		Thread.sleep(3000);	      
	}
	//审批驳回
	public static void rejectSign(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		/*Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
		Thread.sleep(3000);
		Operate.clickAfterApper(s, "src/java.test/img/center.png");
		Thread.sleep(5000);*/
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
	 	Operate.clickAfterApper(s, "src/java.test/img/do.png");
		Thread.sleep(2000);
		s.type(Key.PAGE_DOWN);
		//Operate.clickAfterApper(s, "src/java.test/img/rejectSign.png");
		Operate.clickAfterApper(s, "src/java.test/img/rejectnote.png");
		s.paste("rejectSign");
		Operate.clickAfterApper(s, "src/java.test/img/rejectSign.png");
		Thread.sleep(1000);	
		Operate.clickAfterApper(s, "src/java.test/img/reject_close.png");
		Thread.sleep(1000);	
	}
	//重新提交--审批驳回后
	public static void Reapply(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		/*Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	 	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
	 	Operate.clickAfterApper(s, "src/java.test/img/center.png");
	 	Thread.sleep(5000);
	  	Operate.clickAfterApper(s, "src/java.test/img/myApply.png");
		Thread.sleep(3000);*/
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
		Operate.clickAfterApper(s, "src/java.test/img/detail.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/reapply.png");
		Operate.clickAfterApper(s, "src/java.test/img/upload.png");
		Common.uploadFile(s, "test.jpg");
	//	Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
		Operate.clickAfterApper(s, "src/java.test/img/submit.png");
		Thread.sleep(1000);	
		Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
		Thread.sleep(15000);		

	}
	//暂存--审批驳回后
	public static void save(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		/*Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	 	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
 		Operate.clickAfterApper(s, "src/java.test/img/center.png");
 		Thread.sleep(5000);
 		Operate.clickAfterApper(s, "src/java.test/img/myApply.png");
		Thread.sleep(3000);*/
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
		Operate.clickAfterApper(s, "src/java.test/img/detail.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/reapply.png");
		Operate.clickAfterApper(s, "src/java.test/img/upload.png");
		Common.uploadFile(s, "test.jpg");
	//	Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
		Operate.clickAfterApper(s, "src/java.test/img/save.png");
		Thread.sleep(1000);	
	//	Operate.clickAfterApper(s, "src/java.test/img/save_close.png");
	}
	//确认--申请人
	public static void confirm(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
		Operate.clickAfterApper(s, "src/java.test/img/center.png");
		Thread.sleep(5000);	 
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(3000);	        
		Operate.clickAfterApper(s, "src/java.test/img/do.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/confirm_yes.png");
		Operate.clickAfterApper(s, "src/java.test/img/confirm_ok.png");
		Operate.clickAfterApper(s, "src/java.test/img/sign_ok.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/save_close.png");
	}

	public static void Auditdepart(Screen s,WebDriver driver) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
		Operate.clickAfterApper(s, "src/java.test/img/center.png");
		Thread.sleep(3000);	 		
		Operate.clickAfterApper(s, "src/java.test/img/number1.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(1000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search.png");
        Thread.sleep(2000);	        
		Operate.clickAfterApper(s, "src/java.test/img/do.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		Operate.clickAfterApper(s, "src/java.test/img/auditopinion.png");
		s.paste("audit opinion");
		Operate.clickAfterApper(s, "src/java.test/img/agree.png");
		Operate.clickAfterApper(s, "src/java.test/img/confirm.png");
		Operate.clickAfterApper(s, "src/java.test/img/save_close.png");
	}
    //归档
	public static void pigeonhole(Screen s) throws IOException,
	InterruptedException {
		Thread.sleep(2000);
		Operate.clickAfterApper(s, "src/java.test/img/Isearch.png");
	//	Operate.clickAfterApper(s, "src/java.test/img/apply.png");
		Operate.clickAfterApper(s, "src/java.test/img/center.png");
		Thread.sleep(3000);	 
		Operate.clickAfterApper(s, "src/java.test/img/pigeonhole.png");
		Operate.clickAfterApper(s, "src/java.test/img/scanner.png");
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		s.paste(billId);
		Thread.sleep(1000);	 
		Operate.clickAfterApper(s, "src/java.test/img/search1.png");
        Thread.sleep(2000);	        
		Operate.clickAfterApper(s, "src/java.test/img/do.png");
		Thread.sleep(2000);	
		s.type(Key.PAGE_DOWN);
		
//		Operate.clickAfterApper(s, "src/java.test/img/auditopinion.png");
//		s.paste("audit opinion");
		Operate.clickAfterApper(s, "src/java.test/img/Stamped.png");
		Operate.clickAfterApper(s, "src/java.test/img/Stamp_confirm.png");
		Operate.clickAfterApper(s, "src/java.test/img/close.png");
	}	

	public static void rejectSignChangeOther(Screen s) throws Exception {
		
		Thread.sleep(6000);

		InfopBasicCommon.clickImg(s, imgDir + "number1.png", null, null, null, true, null, null);
		TempData data = new TempData();
		String billId = data.getData("billId").toString();
		InfopBasicCommon.inputValue(s, billId, null, null, null, null, null);
		InfopBasicCommon.clickImg(s, imgDir + "search.png", null, null, null, true, null, null);
        Thread.sleep(3000);	        
		InfopBasicCommon.clickImg(s, imgDir + "do.png", null, null, null, true, null, null);
		Thread.sleep(5000);			
		InfopBasicCommon.wheelDown(s, 5);
		InfopBasicCommon.clickImg(s, imgDir + "rejectnote.png", null, null, null, true, null, null);
	    InfopBasicCommon.inputValue(s, "rejectSign", null, null, null, null, null);
	    InfopBasicCommon.wheelDown(s, 2);	
		//s.paste("rejectSign");
		InfopBasicCommon.clickImg(s, imgDir + "rejectSign.png", null, null, null, true, null, null);
		Thread.sleep(1000);	
	//	InfopBasicCommon.clickImg(s, imgDir + "sign_ok.png", null, null, null, true, null, null);
	//	Thread.sleep(1000);	
	}


}
