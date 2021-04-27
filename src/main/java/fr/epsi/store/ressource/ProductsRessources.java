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
    public Product addProduct(Product p){
        return productDB.addProduct(p);
    }
}