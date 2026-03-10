package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectdropdown2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//      Pointing to the ID 		SELECTING DROP DOWN
//		<div id="divpaxinfo" class="paxinfo">1 Adult</div>
		
		
		driver.findElement(By.id("divpaxinfo")).click();
	
		
		Thread.sleep(2000L);
		
		
		
//		<span class="pax-add pax-enabled" id="hrefIncAdt">+</span>
//      Now we are giving ID for + icon 
		
		// If I want to click to select 5 Adults then writting 5 times below command is bad practice 
		// instead we will be using loops!
		
		int i =0;
		while(i<5) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
			
		}
					
// For Done button as well we have ID
// 	<input class="buttonN" id="btnclosepaxoption" value="Done" type="button">	
		
// If we will write only this it will not click on Do ne button	
//		driver.findElement(By.id("btnclosepaxoption"))		
		
		
// We want to click on Done button 		
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

}
