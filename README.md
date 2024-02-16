# Web Inventory System

This project was an opportunity for me to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.

Through it, I was able to:

* Migrate a "legacy" ecommerce backend to customizable inventory system used for different industries

* Add built-in purchase, min-max boundary features, and Thymeleaf views

* Improve the application by implementing ConstraintValidator classes and adding JUnit testing

## BASIC INSTRUCTIONS

Clone the project:

`git clone https://github.com/saksben/d287-java-frameworks.git`

Open in IDE (built for IntelliJ)

Run the program

Navigate to `http://localhost:8080/`

## USE INSTRUCTIONS

Click the About Us button at the top left to navigate to the About Us page.

The main screen shows all parts and products in the database. The program is designed for a hypothetical car dealership so that they can associate specific parts to a product.

The parts section displays that part's name, price, inventory, maximum inventory, minimum inventory, date created, and action buttons (update and delete).

The product section displays that product's name, price, inventory, date created, and action buttons (update, buy now, and delete).

You can make a search for a specific part or product in the database by using the search box above the respective section and clicking `Search` (it is case sensitive)

To add a part or product, click the button for `Add Inhouse Part`, `Add Outsourced Part`, or `Add Product`. Enter the prompted information and click the `Submit` button.

To update a part or product, click the `Update` button next to the desired part or product, and fill in the information according to the info prompted, then click the `Submit` button.

To delete a part or product, click the `Delete` button next to the desired part or product. If a part is associated with a product, the part cannot be deleted.

Clicking the `Buy Now` button next to a product will decrement that product by 1.
