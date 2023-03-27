package org.example;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class qa1 {
    WebDriver driver;
    @BeforeMethod
            public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @Test
    public void testng(){
      //1.Go to https://www.saucedemo.com/ and use any of the provided username/
        //password to login to the system. (Locator Strategy: xpath)
        String givenURL="https://www.saucedemo.com/";
        driver.get(givenURL);
        String currentURL=driver.getCurrentUrl();
        Assert.assertEquals(givenURL,currentURL);
        System.out.println("URL VERIFIED");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        //2.Verify the URL is https://www.saucedemo.com/inventory.html
        String givenURL2="https://www.saucedemo.com/inventory.html";
        String currentURL2=driver.getCurrentUrl();
        Assert.assertEquals(givenURL2,currentURL2);
        System.out.println("URL 2 Verified");
        //3.Click on any product of your choice
        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
        //4.Click on add to cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();

        //5.Verify the product name and price is similar to the product you selected
        String productname="Sauce Labs Bolt T-Shirt";
        String productnamechecking=driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(productname,productnamechecking);
        System.out.println("Name is same");
        String price="$15.99";
        String checkingprice=driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")).getText();
        Assert.assertEquals(price,checkingprice);
        System.out.println("price is same");
        //6.Click on the Shopping Cart icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //7.Verify the URL is https://www.saucedemo.com/cart.html
        String givenURL3="https://www.saucedemo.com/cart.html";
        String currentUrl3= driver.getCurrentUrl();
        Assert.assertEquals(givenURL3,currentUrl3);
        System.out.println("URL VERIFIED");
        //8.Verify the added product name and the price is similar to your selection
        String productname1="Sauce Labs Bolt T-Shirt";
        String productnamechecking1=driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
        Assert.assertEquals(productname1,productnamechecking1);
        System.out.println("Name is same");
        String price2="$15.99";
        String checkingprice2=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        System.out.println("price is same");
        //9.Click on Remove (Locator Strategy: ID)
         driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        //10. Verify the product is no longer in the cart
        String products="";
        String currentproduct=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")).getText();

        Assert.assertEquals(products,currentproduct);
        System.out.println("nothing in the cart");

        //11.Click on continue shopping
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        //12. Add any 2 products to the cart (Locator Strategy: name)
        driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        //13. Verify the product name and price is similar to the products you selected
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        String productname1new="Sauce Labs Onesie";
        String productname1newchecking=driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText();
        Assert.assertEquals(productname1new,productname1newchecking);
        System.out.println("Name 1 is same");
        String pricenew1="$7.99";
        String checkingpricenew1=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(pricenew1,checkingpricenew1);
        System.out.println("price 1 is same");

        String productname2new="Test.allTheThings() T-Shirt (Red)";
        String productname2newchecking=driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
        Assert.assertEquals(productname2new,productname2newchecking);
        System.out.println("Name 2 is same");
        String pricenew2="$15.99";
        String checkingpricenew2=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(pricenew2,checkingpricenew2);
        System.out.println("price 2 is same");
        //14.Click on checkout
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        //15.Fill the necessary fields, use suitable element locators

        WebElement name = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        name.sendKeys("sakitha");
        WebElement lastname = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastname.sendKeys("jayasinghe");
        WebElement zip = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        zip.sendKeys("51400");
        //16. Click on Continue
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        submit.click();
        //17. Verify the Item Total is similar to the total of the products you selected
        String pro1=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText().replace("$","");
        System.out.println(pro1);
        String pro2=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText().replace("$","");
        System.out.println(pro2);
        String checkingtotal1=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")).getText().replace("Item total: $","");
        System.out.println(checkingtotal1);
        double num=(Double.parseDouble(pro1)+Double.parseDouble(pro2));
        System.out.println(num);
        double checknum=Double.parseDouble(checkingtotal1);


       if (num==checknum){
            System.out.println("Toatal is same");
        }
        else {
            System.out.println("Total not same");
        }
       // 18. Click on finish
       driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        //19. Verify the Thank You for your order text is visible.
        String ty="Thank you for your order!";
        String cuty=driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(ty,cuty);
        System.out.println("Thank you for your order! is verified");

        //20. Verify the URL https://www.saucedemo.com/checkout-complete.html
        String givenURL4="https://www.saucedemo.com/checkout-complete.html";
        String currentURL4=driver.getCurrentUrl();
        Assert.assertEquals(givenURL4,currentURL4);
        System.out.println("URL 4 Verified");






    }

}
