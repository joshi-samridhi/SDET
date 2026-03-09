1️⃣ Locate an input field using its label
HTML
<label>Email</label>
<input type="text" id="email">
Question

How would you locate the input field for Email using XPath?

Best XPath
//label[text()='Email']/following-sibling::input
Why this is good

Uses visible text

Uses DOM relationship

Works even if the input id changes

Interview Tip

Say something like:

I used following-sibling because the input field comes right after the label in the DOM.


  
2️⃣ Locate a button using partial text
HTML
<button>Login to Account</button>
XPath
//button[contains(text(),'Login')]
Why use contains()

Sometimes the text might change to:

Login
Login Now
Login to Account

Using contains() makes it flexible.


  
3️⃣ Locate an element with dynamic ID
HTML
<input id="user_34897234" type="text">

Dynamic IDs change every refresh.

XPath
//input[contains(@id,'user')]
Interview Explanation

Since the ID is dynamic, I used contains() to match the stable part of the attribute.


  
4️⃣ Select the second element from multiple elements
HTML
<input type="text">
<input type="text">
<input type="text">
XPath

Second element:

(//input[@type='text'])[2]
Explanation

() groups all results and [2] selects the second element.


  
5️⃣ Locate element using parent-child relationship
HTML
<div class="login-form">
    <input type="text" name="username">
</div>
XPath
//div[@class='login-form']//input
Explanation

First find the div

Then find input inside it

This helps when multiple inputs exist on the page.

⭐ One Advanced Interview Question
HTML
<label>Password</label>
<div>
   <input type="password">
</div>
XPath
//label[text()='Password']/following::input[1]
Explanation

following:: finds the next input anywhere after the label.

🔥 Interview Trick Question

Interviewer may ask:

Which locator is fastest in Selenium?

Correct order:

1️⃣ id
2️⃣ name
3️⃣ CSS selector
4️⃣ XPath

XPath is powerful but slightly slower than CSS.

💡 Since your goal is to become an SDET, here's something important

In real automation frameworks, we prefer:

1️⃣ ID
2️⃣ CSS Selector
3️⃣ Relative XPath

Absolute XPath is almost never used in production frameworks.
