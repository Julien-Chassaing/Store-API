package fr.epsi.store.ressource;

import fr.epsi.store.db.ProductDB;
import fr.epsi.store.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductsRessources {

    ProductDB productDB = new ProductDB();

    @GET
    @Produces("text/json")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/products
    public List<Product> get() {
        return productDB.getAllProducts();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //http://localhost:8082/store-1.0-SNAPSHOT/api/products/add
    // Body -> Raw -> Json
    //{
    //    "detail": "test",
    //    "image": "test.png",
    //    "info": "test",
    //    "name": "test",
    //    "price": 100,
    //    "quantity": 20
    //}
    public Product addProduct(Product p){
        return productDB.addProduct(p);
    }
}