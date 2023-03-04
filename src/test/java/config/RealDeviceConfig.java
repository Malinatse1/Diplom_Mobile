package config;

import org.aeonbits.owner.Config;

@RealDeviceConfig.LoadPolicy(RealDeviceConfig.LoadType.MERGE)
@Config.Sources(
        {"system:properties",
                "classpath:conf.properties"})
public interface RealDeviceConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appiumServer")
    String getAppiumServer();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}