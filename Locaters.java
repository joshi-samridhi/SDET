🔑 The 8 Selenium Locators (Java)

1. 🆔 ID
What it is: Every element can have a unique id attribute. This is the fastest and most reliable locator.
java// HTML: <input id="username" type="text"/>
WebElement usernameField = driver.findElement(By.id("username"));
usernameField.sendKeys("john@example.com");


Real Industry Example: Login page username/password fields almost always have IDs.
✅ Interview Tip: "ID is the most preferred locator because it is unique and fast."


2. 📛 Name
What it is: Uses the name attribute of an element.
// HTML: <input name="password" type="password"/>
WebElement passwordField = driver.findElement(By.name("password"));
passwordField.sendKeys("MyPassword123");


Real Industry Example: Form fields like search boxes (Google's search box has name="q").
✅ Interview Tip: "Name is used when ID is not available, commonly seen in form elements."

3. 🔗 linkText
What it is: Used only for anchor (<a>) tags. Matches the exact full text of the link.
java// HTML: <a href="/logout">Logout</a>
WebElement logoutLink = driver.findElement(By.linkText("Logout"));
logoutLink.click();
Real Industry Example: Navigation menus — "Home", "About Us", "Contact Us" links.
✅ Interview Tip: "linkText works only on hyperlinks and requires an exact match of the visible text."
  

4. 🔗 partialLinkText
What it is: Like linkText but matches partial text of a link.
java// HTML: <a href="/offers">View All Special Offers Here</a>
WebElement offersLink = driver.findElement(By.partialLinkText("Special Offers"));
offersLink.click();
Real Industry Example: Long navigation links in e-commerce sites like Amazon or Flipkart.
✅ Interview Tip: "Use partialLinkText when link text is too long or dynamic."

  
5. 🏷️ tagName
What it is: Finds elements by their HTML tag like <input>, <button>, <a>, etc.
java// Get the page title using <h1> tag
WebElement heading = driver.findElement(By.tagName("h1"));
System.out.println(heading.getText());

// Get ALL links on a page
List<WebElement> allLinks = driver.findElements(By.tagName("a"));
System.out.println("Total links: " + allLinks.size());
Real Industry Example: Checking how many links exist on a page (broken link testing).
✅ Interview Tip: "tagName is mostly used with findElements (plural) to get a list of elements, rarely used to find a single element."

  
6. 🎨 className
What it is: Uses the class attribute of an element.
java// HTML: <button class="btn-primary">Submit</button>
WebElement submitBtn = driver.findElement(By.className("btn-primary"));
submitBtn.click();
⚠️ Important: If an element has multiple classes like class="btn btn-primary large", use just one class name, not all.
java// Use only one class at a time
driver.findElement(By.className("btn-primary")); // ✅ Correct
driver.findElement(By.className("btn btn-primary")); // ❌ Wrong - will throw error
Real Industry Example: Error messages, success banners, styled buttons in any web app.
✅ Interview Tip: "className fails if the element has multiple classes with spaces — use CSS Selector instead in that case."

  

7. 🎯 CSS Selector
What it is: Uses CSS styling rules to locate elements. Very powerful and widely used in industry.

// By ID:        #idName
// By Class:     .className
// By Attribute: [attribute='value']

// HTML: <input id="email" class="input-field" type="email"/>

// Using ID
driver.findElement(By.cssSelector("#email"));

// Using Class
driver.findElement(By.cssSelector(".input-field"));

// Using attribute
driver.findElement(By.cssSelector("input[type='email']"));

// Using tag + class (most common in projects)
driver.findElement(By.cssSelector("input.input-field"));

Real Industry Example: Used heavily in Page Object Model (POM) projects to locate dynamic elements.
✅ Interview Tip: "CSS Selector is faster than XPath and preferred when ID/Name are not available. Syntax: tagName#id or tagName.className"

  8. 🛤️ XPath
What it is: Uses the XML path of the element. Most flexible locator — can find any element even without ID or class.
Two types:
Absolute XPath (not recommended ❌):
java// Starts from root, breaks easily if page structure changes
driver.findElement(By.xpath("/html/body/div/form/input[1]"));
Relative XPath (recommended ✅):
java// HTML: <input type="text" placeholder="Enter Email"/>

// Basic
driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));

// Using text()
// HTML: <button>Login</button>
driver.findElement(By.xpath("//button[text()='Login']"));

// Using contains() — great for dynamic text
driver.findElement(By.xpath("//button[contains(text(),'Log')]"));
driver.findElement(By.xpath("//input[contains(@id,'user')]"));

// Parent-child relationship
driver.findElement(By.xpath("//div[@class='login-form']//input[@type='password']"));
Real Industry Example: Used when elements have no ID/class, or attributes are dynamic (like auto-generated IDs in Angular/React apps).
✅ Interview Tip: "Always prefer Relative XPath over Absolute XPath. Use contains() for dynamic elements — this is asked in almost every SDET interview."



📊 Quick Comparison Table
LocatorSpeedReliabilityWhen to UseID⚡ Fastest⭐⭐⭐ BestAlways first choiceName⚡ Fast⭐⭐ GoodForms without IDlinkTextMedium⭐⭐ GoodExact link textpartialLinkTextMedium⭐⭐ GoodPartial/long link texttagNameMedium⭐ LowCounting elementsclassNameMedium⭐⭐ GoodStyled elementsCSS Selector⚡ Fast⭐⭐⭐ BestNo ID/Name availableXPath🐢 Slowest⭐⭐⭐ BestDynamic/complex elements

🎤 Top 5 Interview Questions on Locators
Q1. Which is the best locator in Selenium and why?

"ID is the best locator because it is unique on a page and gives the fastest performance. If ID is not available, CSS Selector is the next best choice."

Q2. Difference between CSS Selector and XPath?

"CSS Selector is faster and cleaner in syntax. XPath is more powerful — it can traverse up the DOM (find parent from child), which CSS Selector cannot do."

Q3. What is the difference between findElement and findElements?

"findElement returns a single WebElement and throws NoSuchElementException if not found. findElements returns a List of WebElements and returns an empty list if nothing is found."

Q4. How do you handle dynamic elements?

"I use XPath with contains() or starts-with() functions to handle elements with dynamic IDs or classes."

Q5. What is the priority order you follow for locators?

"ID → Name → CSS Selector → XPath. Always prefer ID first, then move to more complex locators only when needed."


💡 Golden Rule for SDET Interviews

"Always prefer locators in this order: ID > Name > CSS Selector > XPath. Never use Absolute XPath in real projects."
  
