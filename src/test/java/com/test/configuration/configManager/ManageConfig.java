package com.test.configuration.configManager;

import org.aeonbits.owner.ConfigCache;

public class ManageConfig {
   public static  IPropertiesConfigurator iPropertiesConfigurator;
   /* private static ManageConfig manageConfig=null;
    private ManageConfig(){};



    public static synchronized ManageConfig getManageConfigInstance(){
       return  ( manageConfig==null)?new ManageConfig():manageConfig;

    }*/
    public static IPropertiesConfigurator getPropertiesConfigurator() {
        if (iPropertiesConfigurator == null) {
            iPropertiesConfigurator = ConfigCache.getOrCreate(IPropertiesConfigurator.class);
            return iPropertiesConfigurator;
        }else{
            return iPropertiesConfigurator;
        }


    }
}
