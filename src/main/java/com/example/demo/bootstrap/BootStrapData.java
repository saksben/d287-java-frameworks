package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        Set<Product> sampleProducts = new HashSet<Product>();
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

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " +productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
