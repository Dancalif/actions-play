package com.sqa.du.actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsClass {
	public static WebDriver driver;
	public static String baseURL = "http://jqueryui.com";

	@BeforeClass
	public void setupDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(enabled = true)
	public void testDraggable() throws InterruptedException, IOException {
		driver.get(baseURL + "/draggable/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement box = driver.findElement(By.id("draggable"));
		// File scrFile = ((TakesScreenshot)
		// this.driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(scrFile, new File("draggable-01.png"));
		Action dragAction = action.clickAndHold(box).moveByOffset(373, 154).release().build();
		dragAction.perform();
		Thread.sleep(5000);
		// scrFile = ((TakesScreenshot)
		// this.driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(scrFile, new File("draggable-02.png"));
	}

	@Test(enabled = true)
	public void testDroppable() throws InterruptedException {
		driver.get(baseURL + "/droppable/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);
		WebElement box = driver.findElement(By.id("draggable"));
		Action draggingAction = action.dragAndDropBy(box, 156, 39).build();
		draggingAction.perform();
		Thread.sleep(5000);
	}

	@Test(enabled = true)
	public void testResizable() throws InterruptedException {
		driver.get(baseURL + "/resizable/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions action = new Actions(driver);
		WebElement box = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		Thread.sleep(3000);
		Action resAction = action.clickAndHold(box).moveByOffset(390, 299).release().build();
		resAction.perform();
		// action.clickAndHold(box).moveByOffset(390, 299).release().perform();
		Thread.sleep(5000);

	}

	@Test(enabled = true)
	public void testSelectable() throws InterruptedException {
		driver.get(baseURL + "/selectable/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions actions = new Actions(driver);
		WebElement box = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
		WebElement box1 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		WebElement box2 = driver.findElement(By.xpath("//*[@id='selectable']/li[5]"));
		Action selMultiAction = actions.keyDown(Keys.CONTROL).click(box).click(box1).click(box2).build();
		selMultiAction.perform();
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void testSortable() throws InterruptedException {
		driver.get(baseURL + "/sortable/");
		Thread.sleep(3000);

		Thread.sleep(3000);
	}
}
