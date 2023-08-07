package com.example.springapi.springapi.api.controller;

import com.example.springapi.springapi.api.exepction_handling.NoSuchProductsException;
import com.example.springapi.springapi.api.model.Products;
import com.example.springapi.springapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class SpringRestController {
    @Autowired
    private ProductsService productsService;
    @GetMapping("/products")
    @ResponseBody
    public CollectionModel<EntityModel<Products>> all(){
        List<EntityModel<Products>> products = productsService.getAllProducts().stream()
                .map(product -> EntityModel.of(product,
                        linkTo(methodOn(SpringRestController.class).one(product.getId())).withSelfRel(),
                        linkTo(methodOn(SpringRestController.class).all()).withRel("products")))
                .collect(Collectors.toList());

        return CollectionModel.of(products, linkTo(methodOn(SpringRestController.class).all()).withSelfRel());
    }

    @GetMapping("/products/{id}")
    @ResponseBody  /* This will work */
    public EntityModel<Products> one(@PathVariable long id) {
        Products products = productsService.getProducts(id);

        if(products == null) {
            throw new NoSuchProductsException("There is no products with ID = "+ id+" in DB ");
        }

        return EntityModel.of(products, //
                linkTo(methodOn(SpringRestController.class).one(id)).withSelfRel(),
                linkTo(methodOn(SpringRestController.class).all()).withRel("products"));
    }


    //    @GetMapping("/products")
//    @ResponseBody
//    public List<Products> showAllProducts(){
//        List<Products> allProducts = productsService.getAllProducts();
//        return allProducts;
//    }

//    @GetMapping("/products/{id}")
//    @ResponseBody
//    public Products getProductsId(@PathVariable int id) {
//        Products products = productsService.getProducts(id);
//        if(products == null) {
//            throw new NoSuchProductsException("There is no products with ID = "+ id+" in DB ");
//        }
//        return  products;
//    }

// ерунда, это надо исправить
    @GetMapping("/products/category/{category}")
    @ResponseBody  /* This will work */
    public Products getProductsCategory(@PathVariable String category) {

        return  productsService.getAllProductsCategory(category);
    }

    @DeleteMapping("deleteProducts/{id}")
    @ResponseBody
    public String deleteProducts(@PathVariable int id){

        Products products = productsService.getProducts(id);
        if(products == null) {
            throw new NoSuchProductsException ("There is no products with ID = "+ id+" in DB ");
        }
        productsService.deleteProducts(id);
        return "Products id = " + id+ " deleted";
    }

    @PostMapping("create")
    @ResponseBody
    public Products saveProducts(@RequestBody Products products){
    productsService.saveProducts(products);
    return products;
    }
//    @PostMapping("create")
//    @ResponseBody
//    ResponseEntity<?> newEmployee(@RequestBody Products newProducts) {
//
//        EntityModel<Products> entityModel = EntityModel.of(productsService.saveProducts(newProducts), //
//                linkTo(methodOn(SpringRestController.class).one().withSelfRel(),
//                linkTo(methodOn(SpringRestController.class).all()).withRel("products"));
//        return ResponseEntity //
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
//                .body(entityModel);
//    }

    @PutMapping("products/update")
    @ResponseBody
    public Products newProducts(@RequestBody Products products){
        productsService.saveProducts(products);
        return products;
    }

}
