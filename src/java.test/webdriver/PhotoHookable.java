package webdriver;

import org.jtester.spec.scenario.JSpecScenario;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import util.FileUtil;

import java.io.File;

import static webdriver.constants.CommonConstants.PICTURE_FILE;

/**
 * Created by wb-zyc239372 on 2017/3/16.
 */
public class PhotoHookable implements IHookable{
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object instance = testResult.getInstance();
        Object[] parameters = testResult.getParameters();
        JSpecScenario senario = (JSpecScenario) parameters[0];
        String path = PICTURE_FILE + File.separator + instance.getClass().getName() + File.separator + senario.getScenario() + "_" +senario.getScenarioId();
        FileUtil.createDir(path);
        PathCache.setPath(path);
        callBack.runTestMethod(testResult);
    }
}
