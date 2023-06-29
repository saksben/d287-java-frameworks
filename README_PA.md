D287 Java Frameworks PA - Benjamin Saks

***C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.***
**File name:** mainscreen.html
**Line:** 14, 19, 21, 53
**Change description:** changed the title, headline, and section headlines to my custom design. Will add the sample names in section E.
**Change:** 
14 <title>My Classic Car Store</title>
19 <h1>Classic Auto Store</h1>
21 <h2>Car Parts</h2>
53 <h2>Classic Cars</h2>

***D. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.***
**File name:** AboutController.java
**Line:** 1-15
**Change description:** creates a Controller for the About page that routes the url "/about" to the about.html view template file.
**Change:**
package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping
    public String showAbout() {
        return "about";
    }
}

**File name:** About.html
**Line:** 1-17
**Change description:** creates the view template file to be shown when a user clicks on the About Us button on the Mainscreen. Gives a little paragraph with some background on the company.
**Change:** 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
</head>
<body>
  <h1>About Us</h1>
  <p>Classic Auto Store was born when a Software Engineering student's
    love for classic cars crossed with the need for a class project idea. Before
    he knew it, WHAM! The idea hit him like a truck, and it became an overnight success.
    Now Classic Auto Cars is known as the coolest hangout and car enterprise in all
    the land.
  </p>
  <a href="http://localhost:8080">Back to the Mainscreen</a>
</body>
</html>

**File name:** Mainscreen.html
**Line:** 20
**Change description:** adds the About Us link to the Mainscreen template view file as a button style link using Thymeleaf to communicate with the controller.
**Change:** 
20 <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About Us</a>

***E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.***
**Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.**
**File name:** BootStrapData
**Line:** 3, 17, 70-152, 154, 156
**Change description:** creates sample inventory for Products and Parts. Creates Set for deduplication. Creates multi-pack name change for duplicates. Improves readability for print statements.
**Change:** 
3 import com.example.demo.domain.InhousePart;

17 import java.util.*;

70      Set<Product> sampleProducts = new HashSet<Product>();
        Set<Part> sampleParts = new HashSet<>();

        Product camaro = new Product(1, "Chevrolet Camaro", 27795.00, 7);
        Product mustang = new Product(2, "Ford Mustang", 27770.00, 5);
        Product challenger = new Product(3, "Dodge Challenger", 30545.00, 4);
        Product gto = new Product(4, "Pontiac GTO", 20200.00, 2);
        Product corvette = new Product(5, "Chevrolet Corvette", 64500.00, 3);

        sampleProducts.add(camaro);
        sampleProducts.add(mustang);
        sampleProducts.add(challenger);
        sampleProducts.add(gto);
        sampleProducts.add(corvette);

        System.out.println("Set: " + sampleProducts);

//        Part tire = new InhousePart("Tire", 249.99, 25);
//        Part stereo = new InhousePart("Stereo", 99.97, 9);
//        Part steering = new InhousePart("Steering Wheel", 79.99, 11);
//        Part spoiler = new InhousePart("Spoiler", 99.97, 7);
//        Part engine = new InhousePart("V8 Engine", 6999.97, 5);

        InhousePart tire = new InhousePart();
        tire.setId(1);
        tire.setName("Tire");
        tire.setPrice(249.99);
        tire.setInv(25);

        InhousePart stereo = new InhousePart();
        stereo.setId(2);
        stereo.setName("Stereo");
        stereo.setPrice(249.99);
        stereo.setInv(25);

        InhousePart steering = new InhousePart();
        steering.setId(3);
        steering.setName("Steering");
        steering.setPrice(249.99);
        steering.setInv(25);

        InhousePart spoiler = new InhousePart();
        spoiler.setId(4);
        spoiler.setName("Spoiler");
        spoiler.setPrice(249.99);
        spoiler.setInv(25);

        InhousePart engine = new InhousePart();
        engine.setId(5);
        engine.setName("Engine");
        engine.setPrice(249.99);
        engine.setInv(25);

        sampleParts.add(tire);
        sampleParts.add(stereo);
        sampleParts.add(steering);
        sampleParts.add(spoiler);
        sampleParts.add(engine);



        if (partRepository.count() == 0 && productRepository.count() == 0) {
            for (Product product : sampleProducts) {
                productRepository.save(product);
            }

            for (Part part : sampleParts) {
                partRepository.save(part);
            }

//            productRepository.save(camaro);
//            productRepository.save(mustang);
//            productRepository.save(challenger);
//            productRepository.save(gto);
//            productRepository.save(corvette);
//
//            partRepository.save(tire);
//            partRepository.save(stereo);
//            partRepository.save(steering);
//            partRepository.save(spoiler);
//            partRepository.save(engine);
        }

154      System.out.println("Number of Products: " +productRepository.count());

156      System.out.println("Number of Parts: "+partRepository.count());

**File name:** Product.java
**Line:** 50-53
**Change description:** multi pack - product
**Change:** 
50
    public void multiProduct() {
        this.setName(this.getName() + " (multi)");
    }

**File name:** AddProductController.java
**Line:** 18, 20, 36-38, 91-106
**Change description:** multi pack - product
**Change:** 
18 import java.util.HashSet;

20 import java.util.Set;

36  
    private Set<Product> listProducts = new HashSet<>();
    private boolean verify = false;

91          for (Product thing : listProducts) {
                if (thing.getName().equals(product.getName())) {
                    verify = true;
                } else {
                    verify = false;
                }
            }

            if (verify == true) {
                product.multiProduct();
                listProducts.add(product);
            } else {
                listProducts.add(product);
            }

**File name:** Part.java
**Line:** 53-56
**Change description:** 
**Change:** 
53  public void multiPart() {
        this.setName(this.getName() + " (multi)");
    }

**File name:** AddOutsourcedPartController
**Line:** 21, 22, 32-34, 55-70
**Change description:** 
**Change:** 
21 import java.util.HashSet;

22 import java.util.Set;

32  private Set<Part> listParts = new HashSet<>();
    private boolean verify = false;

55          for (Part thing : listParts) {
                if (thing.getName().equals(part.getName())) {
                    verify = true;
                } else {
                    verify = false;
                }
            }

            if (verify == true) {
                part.multiPart();
                listParts.add(part);
            } else {
                listParts.add(part);
            }

**File name:** AddInhousePartController
**Line:** 20, 21, 31-33, 54-69
**Change description:** 
**Change:** 
20 import java.util.HashSet;
21 import java.util.Set;

31  private Set<Part> listParts = new HashSet<>();
    private boolean verify = false;

54 
            for (Part thing : listParts) {
                if (thing.getName().equals(part.getName())) {
                    verify = true;
                } else {
                    verify = false;
                }
            }

            if (verify == true) {
                part.multiPart();
                listParts.add(part);
            } else {
                listParts.add(part);
            }

***F. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:***
**The “Buy Now” button must be next to the buttons that update and delete products.**
**The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.**
**Display a message that indicates the success or failure of a purchase.**
**File name:** confirmationbuynow.html
**Line:** 1-12
**Change description:** creates purchase confirmation page
**Change:** 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmation Buy Now</title>
</head>
<body>
<h1>Classic Auto Store</h1>
  <p>Congratulations! Your purchase was successful.</p>
  <a href="http://localhost:8080">Back to the Mainscreen</a>
</body>
</html>

**File name:** unsuccessfulbuynow.html
**Line:** 1-12
**Change description:** creates unsuccessful purchase page
**Change:** 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Unsuccessful Buy Now</title>
</head>
<body>
<h1>Classic Auto Store</h1>
  <p>You did not successfully buy this product because its inventory is 0.</p>
  <a href="http://localhost:8080">Back to the Mainscreen</a>
</body>
</html>

**File name:** mainscreen.html
**Line:** 84
**Change description:** creates the Buy Now button
**Change:** 
84                <a th:href="@{/decrementProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>

**File name:** AddProductController.java
**Line:** 131-144
**Change description:** creates method for decrementing product's inventory by 1 from the database and validating it
**Change:** 
131 @GetMapping("/decrementProduct")
    public String decrementProduct(@RequestParam("productID") int theId, Model theModel) {
        ProductService repo = context.getBean(ProductServiceImpl.class);
        Product product3 = repo.findById(theId);
        int inv = product3.getInv();
        if (inv > 0) {
            product3.setInv(inv - 1);
            repo.save(product3);
            return "confirmationbuynow";
        } else {
            return "unsuccessfulbuynow";
        }
    }
    
***G. Modify the parts to track maximum and minimum inventory by doing the following:***
**Add additional fields to the part entity for maximum and minimum inventory.**
**Modify the sample inventory to include the maximum and minimum fields.**
**Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.**
**Rename the file the persistent storage is saved to.**
**Modify the code to enforce that the inventory is between or at the minimum and maximum value.** 
**File name:** Part.java
**Line:** 4, 21, 34-38, 60-76, 114-129
**Change description:** sets up max/min inventory columns/variables/constructors/getters/setters, applies validator
**Change:** 
4 import com.example.demo.validators.ValidMinMax;
21 @ValidMinMax
34  @Column(name = "MAX_INV")
    int max_inv;
    @Column(name = "MIN_INV")
    int min_inv;
60 
    public Part(String name, double price, int inv, int max_inv, int min_inv) {
    this.name = name;
    this.price = price;
    this.inv = inv;
    this.max_inv = max_inv;
    this.min_inv = min_inv;
    }

    public Part(long id, String name, double price, int inv, int max_inv, int min_inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.max_inv = max_inv;
        this.min_inv = min_inv;
    }

114 public int getMax_inv() {
        return max_inv;
    }

    public void setMax_inv(int max_inv) {
        this.max_inv = max_inv;
    }

    public int getMin_inv() {
        return min_inv;
    }

    public void setMin_inv(int min_inv) {
        this.min_inv = min_inv;
    }


**File name:** mainscreen.html
**Line:** 39-40, 49-50
**Change description:** Added Max/Min Inventory to table and its fields
**Change:** 
39          <th>Max Inventory</th>
            <th>Min Inventory</th>

49          <td th:text="${tempPart.max_inv}">1</td>
            <td th:text="${tempPart.min_inv}">1</td>

**File name:** BootStrapData.java
**Line:** 98-99, 106-107, 114-115, 122-123, 130-131
**Change description:** adds max/min inventory to sample data
**Change:** 
98      tire.setMax_inv(100);
        tire.setMin_inv(1);

106     stereo.setMax_inv(100);
        stereo.setMin_inv(1);

114     steering.setMax_inv(100);
        stereo.setMin_inv(1);

122     spoiler.setMax_inv(100);
        spoiler.setMin_inv(1);

130     engine.setMax_inv(100);
        engine.setMin_inv(1);

**File name:** InhousePartForm.html
**Line:** 24-27, 30-31
**Change description:** adds max/min inventory fields to form, displays validation error
**Change:** 
24  <p><input type="text" th:field="*{max_inv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>

26  <p><input type="text" th:field="*{min_inv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p>

30  <p th:each="err : ${#fields.allErrors()}" th:text="${err}"></p>


**File name:** OutsourcedPartForm.html
**Line:** 25-28, 31-32
**Change description:** adds max/min inventory fields to form, displays validation error
**Change:** 
25  <p><input type="text" th:field="*{max_inv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>

    <p><input type="text" th:field="*{min_inv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p>

31  <p th:each="err : ${#fields.allErrors()}" th:text="${err}"></p>

**File name:** application.properties
**Line:** 6
**Change description:** changes name of database file
**Change:** 
spring.datasource.url=jdbc:h2:file:~/classic-auto-store

**File name:** MinMaxValidator.java
**Line:** 1-26
**Change description:** creates validator class
**Change:** 
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {


    @Override
    public void initialize(ValidMinMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() <= part.getMax_inv() && part.getInv() >= part.getMin_inv()) {
            return true;
        } else {
            return false;
        }
    }

}

**File name:** ValidMinMax.java
**Line:** 1-14
**Change description:** creates validator annotation
**Change:** 
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {MinMaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinMax {
    String message() default "Inventory must be between min and max";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}

***H. Add validation for between or at the maximum and minimum fields. The validation must include the following:***
**Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.**
**Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.**
**Display error messages when adding and updating parts if the inventory is greater than the maximum.**
**File name:** MinMaxValidator.java
**Line:** 17-47
**Change description:** comments out previous catch-all validation, creates validation that specifies min and max
**Change:** 
17//  @Override
//    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
//        if (part.getInv() <= part.getMax_inv() && part.getInv() >= part.getMin_inv()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        return constraintMin(part, constraintValidatorContext) && constraintMax(part, constraintValidatorContext);
    }

    public boolean constraintMin(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() < part.getMin_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be greater than min.").addConstraintViolation();
            return false;
        }
        return true;
    }

    public boolean constraintMax(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() > part.getMax_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be less than max.").addConstraintViolation();
            return false;
        }
        return true;
    }

***I. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.***
**File name:** 
**Line:** 
**Change description:** 
**Change:** 

***J. Remove the class files for any unused validators in order to clean your code.***
**File name:** 
**Line:** 
**Change description:** 
**Change:** 