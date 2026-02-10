package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;

public class WebDriverProvider {
    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    public WebDriverConfig getConfig() {
        return config;
    }

    public void configure() {
        Configuration.browser = config.browserName().toString();

        var browserVersion = config.browserVersion();
        if (Objects.nonNull(browserVersion)) {
            Configuration.browserVersion = config.browserVersion();
        }

        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();
        Configuration.timeout = config.timeout();

        var options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-features=CookieControls");
        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        Configuration.browserCapabilities = options;

        if (config.isRemote()) {
            Configuration.remote = getRemoteUrl();
            Configuration.browserCapabilities = getCapabilities();
        }
    }

    private String getRemoteUrl() {
        var url = config.remoteUrl();
        var remoteUsername = System.getProperty("remoteUsername");
        var remotePassword = System.getProperty("remotePassword");
        if (Objects.nonNull(remoteUsername) && Objects.nonNull(remotePassword)) {
            url = url.replace("://", "://" + remoteUsername + ":" + remotePassword + "@");
        }
        return url;
    }

    private DesiredCapabilities getCapabilities() {
        var capabilities = new DesiredCapabilities();

        capabilities.setCapability(
                "selenoid:options",
                Map.of(
                        "enableVNC", config.enableVnc(),
                        "enableVideo", config.enableVideo()
                )
        );

        return capabilities;
    }
}