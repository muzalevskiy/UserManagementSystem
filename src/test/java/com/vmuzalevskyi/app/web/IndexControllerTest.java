package com.vmuzalevskyi.app.web;

import com.vmuzalevskyi.SpringBootDemoApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 5/29/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        classes=SpringBootDemoApplication.class)
@WebIntegrationTest(randomPort=true)
@ActiveProfiles("test")
public class IndexControllerTest {

    private static FirefoxDriver browser;
    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        browser = new FirefoxDriver();
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }
}
