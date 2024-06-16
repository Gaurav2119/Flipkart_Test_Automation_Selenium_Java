# Flipkart Automation Tests

This project contains automation tests for the Flipkart website using Selenium, Java, TestNG, and Maven.

## Prerequisites

- Java JDK 8 or later
- Maven

## Setup

1. **Clone the repository:**

git clone <repository-url>

2. **Install dependencies:**

mvn clean install

3. **Run the tests:**

mvn test

## Test Cases

### Test Case 1: Home page visible
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully

### Test Case 2: Verify Home Page Title
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Verify home page title

### Test Case 3: Travels page visible
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to travels page
5. Verify that user landed on travel page successfully

### Test Case 4: Search one way flight
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to travels page
5. Verify that user landed on travel page successfully
6. Click one way and verify one way button is clicked
7. Search flight for one way
8. Verify that desired result is visible

### Test Case 5: Search round trip flight
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to travels page
5. Verify that user landed on travel page successfully
6. Click round trip and verify round trip button is clicked
7. Search flight for round trip
8. Verify that desired result is visible

### Test Case 6: Book one way flight
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to travels page
5. Verify that user landed on travel page successfully
6. Search flight for one way
7. Verify that desired result is visible
8. Click on book button
9. Verify that login is required

### Test Case 7: Book round trip flight
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to travels page
5. Verify that user landed on travel page successfully
6. Search flight for round trip
7. Verify that desired result is visible
8. Click on book button
9. Verify that login is required

### Test Case 8: Verify support page topics
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to support page
5. Verify that user landed on support page successfully
6. Click help topic delivery related and verify delivery related topic is visible
7. Click help topic refund related and verify refund related topic is visible

### Test Case 9: Verify seller page is visible and title is as expected
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to seller page
5. Verify seller page is visible to the user
6. Verify the page title is as expected

### Test Case 10: Verify required field and seller dashboard title is visible
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to seller dashboard
5. Verify dashboard title
6. Verify required fields are displayed

### Test Case 11: Search Product
1. Launch browser
2. Navigate to url 'https://www.flipkart.com/'
3. Verify that home page is visible successfully
4. Enter product name in search input and click search button
5. Verify 'SEARCHED PRODUCTS' is visible
6. Sort the 'SEARCHED PRODUCTS' by 'Price -- Low to High'
6. Verify all the products are sorted accordingly

### Test Case 12: Verify Terms And Condition Page Title
1. Launch browser
2. Navigate to url 'https://www.flipkart.com/'
3. Verify that home page is visible successfully
4. Navigate to Terms of Use page
5. Verify that page is visible to user
6. Verify the page title is as expected

### Test Case 13: verify mobile phone page product details
1. Launch browser
2. Navigate to url 'https://www.flipkart.com/'
3. Verify that home page is visible successfully
4. Navigate to Mobile Phone page
5. Verify page is visible
6. Navigate to first phone details page
7. Verify that detail is visible: product name, price

### Test Case 14: Verify Appliance page is visible
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to appliance page
5. Verify that user landed on appliance page successfully

### Test Case 15: Search grocery item in grocery page
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to grocery page
5. Verify that user landed on grocery page successfully
6. Search grocery item
7. Verify that desired result is visible

### Test Case 16: Sort Product by price Low to High
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to grocery page
5. Verify that user landed on grocery page successfully
6. Search product
7. Verify that desired result is visible
8. Sort the 'SEARCHED PRODUCT' by 'Price -- Low to High'
9. Verify all the products are sorted accordingly

### Test Case 17: Verify cart page
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Navigate to cart page
5. Verify that Login button is displayed

### Test Case 18: Product wishlist requires login
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Search product
5. Verify that desired result is visible
6. Add product to wishlist
7. Verify wishlist cannot be added without login

### Test Case 19: Add product to cart
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Enter product name in search input and click search button
5. Verify 'SEARCHED PRODUCTS' is visible
6. Click on first product
7. Verify that detail is visible: product name, price
8. Add product to cart
9. Verify that cart page is visible
10. Verify that product added to cart

### Test Case 20: Place order for added product in cart
1. Launch browser
2. Navigate to "https://www.flipkart.com/"
3. Verify that home page is visible successfully
4. Enter product name in search input and click search button
5. Verify 'SEARCHED PRODUCTS' is visible
6. Click on first product
7. Verify that detail is visible: product name, price
8. Add product to cart
9. Verify that cart page is visible
10. Verify that product added to cart
11. Click on place order button
12. Verify place order requires details