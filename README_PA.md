D287 Java Frameworks PA - Benjamin Saks

***C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.***
File name: mainscreen.html
Line: 14, 19, 21, 53
Change description: changed the title, headline, and section headlines to my custom design. Will add the sample names in section E.
Change: 
14 <title>My Classic Car Store</title>
19 <h1>Classic Auto Store</h1>
21 <h2>Car Parts</h2>
53 <h2>Classic Cars</h2>

***D. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.***
File name: 
Line: 
Change description: 
Change: 

***E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.***
**Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.**
File name: 
Line: 
Change description: 
Change: 

***F. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:***
**The “Buy Now” button must be next to the buttons that update and delete products.**
**The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.**
**Display a message that indicates the success or failure of a purchase.**
File name: 
Line: 
Change description: 
Change: 

***G. Modify the parts to track maximum and minimum inventory by doing the following:***
**Add additional fields to the part entity for maximum and minimum inventory.**
**Modify the sample inventory to include the maximum and minimum fields.**
**Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.**
**Rename the file the persistent storage is saved to.**
**Modify the code to enforce that the inventory is between or at the minimum and maximum value.**
File name: 
Line: 
Change description: 
Change: 

***H. Add validation for between or at the maximum and minimum fields. The validation must include the following:***
**Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.**
**Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.**
**Display error messages when adding and updating parts if the inventory is greater than the maximum.**
File name: 
Line: 
Change description: 
Change: 

***I. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.***
File name: 
Line: 
Change description: 
Change: 

***J. Remove the class files for any unused validators in order to clean your code.***
File name: 
Line: 
Change description: 
Change: 