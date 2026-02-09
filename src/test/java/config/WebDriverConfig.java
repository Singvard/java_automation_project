package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${config.file}.properties"
})

public interface WebDriverConfig extends Config {
    String CHROME = "CHROME";
    String FULL_HD = "1920x1080";
    String FALSE = "false";
    String BASE_URL = "https://automationexercise.com";
    String TIMEOUT = "10000";

    @Key("browserName")
    @DefaultValue(CHROME)
    Browser browserName();

    @Key("browserVersion")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue(FULL_HD)
    String browserSize();

    @Key("remote.condition")
    @DefaultValue(FALSE)
    boolean isRemote();

    @Key("remote.url")
    String remoteUrl();

    @Key("enable.vnc")
    boolean enableVnc();

    @Key("enable.video")
    boolean enableVideo();

    @Key("base.url")
    @DefaultValue(BASE_URL)
    String baseUrl();

    @Key("timeout")
    @DefaultValue(TIMEOUT)
    long timeout();
}
