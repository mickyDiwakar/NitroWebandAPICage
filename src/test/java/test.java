//import com.test.configuration.ConfigFileReader;
import com.google.gson.JsonObject;
import com.test.configuration.configManager.IPropertiesConfigurator;
import com.test.configuration.configManager.ManageConfig;
import com.test.pages.CommonPages.CommonMethod;
import com.test.utils.ExcelUtil;
import org.aeonbits.owner.ConfigCache;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class test {
    String finalvalue;
    public static void main(String[] args) throws IOException {
    //   IPropertiesConfigurator p= ConfigCache.getOrCreate(IPropertiesConfigurator.class);
        System.out.println(ManageConfig.getPropertiesConfigurator().protalUrl());
       // ManageConfig.getPropertiesConfigurator().protalUrl();
    // JSONObject jsonObject=new JSONObject();


        ExcelUtil ex=new ExcelUtil();
        ex.start();
      // finalvalue= ExcelUtil.readExcelData("feature1");
        System.out.println( Thread.currentThread().getId()+":"+ExcelUtil.readExcelData("feature1"));
        ExcelUtil ex1=new ExcelUtil();
        ex1.start();
        System.out.println( Thread.currentThread().getId()+":"+ExcelUtil.readExcelData("feature2"));
    }
}
