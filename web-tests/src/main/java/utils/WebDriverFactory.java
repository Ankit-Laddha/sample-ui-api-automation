package utils;

import org.openqa.selenium.WebDriver;

import static java.lang.ThreadLocal.withInitial;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized void init(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println(" ABC creating chrome instance " );
            tlDriver = withInitial(() -> DriverManager.getChrome());
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" ABC creating firefox instance " );
            tlDriver = withInitial(() -> DriverManager.getFireFox());
        }
        else {
            System.out.println(" ABC creating no instance " );
            throw new IllegalArgumentException("Not Supported");
        }
        /*
        switch (browser.toUpperCase()){
            case "CHROME":
                tlDriver = withInitial(() -> DriverManager.getChrome());
                break;
            case "FIREFOX":
                tlDriver = withInitial(() -> DriverManager.getFireFox());
                break;
            default:
                throw new IllegalArgumentException("Not Supported");
        }*/
        //return tlDriver.get();

    }

    public static synchronized WebDriver getCurrentDriver() {
        return tlDriver.get();
    }

    public static synchronized void terminate(){
        tlDriver.remove();
    }
}
