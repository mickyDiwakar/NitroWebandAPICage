package com.test.configuration.configManager;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:bootstrap.properties","classpath:WebApplicationConfiguration.properties"})
public interface IPropertiesConfigurator extends Config{

    @Key("defaultBroswer")@DefaultValue("Chrome")
    String defaultBrowser();

    @Key( "grid.run" )@DefaultValue("true")
    Boolean Gridrun();
    @Key("browser")
    String browser();
    @Key("broswerVersion")
    String broswerVersion();

    @Key("environment")
    String environment();
    @Key("hubUrl")
    String hubUrl();
    @Key("implicit.timeout")
    Long implicitTimeout();

    @Key("PortalURL")
    String protalUrl();

}
