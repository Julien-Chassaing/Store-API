package fr.epsi.store.ressource;

import fr.epsi.store.db.ProductDB;
import fr.epsi.store.model.Product;

import javax.ws.rs.*;
import java.util.List;

@Path("/product")
public class ProductRessources {

    ProductDB productDB = new ProductDB();

    @GET
    @Produces("text/json")
    @Path("{id}")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/product/2
    public Product getById(@PathParam("id") int id) {
        return productDB.getOneProduct(id);
    }

    @POST
    @Path("{id}")
    @Produces("text/json")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/product/4?name=PC&detail=PC gamer&price=1500&quantity=1200&info=RTX 3060&image=https://images.stockx.com/images/NVIDIA-GeForce-RTX-3060-Ti-Graphics-Card-900-1G142-2520-000.jpg?fit=fill%26bg=FFFFFF%26w=700%26h=500%26auto=format,compress%26q=90%26dpr=2%26trim=color%26updated_at=1606944737
    public String postOneProduct(@PathParam("id") int id, @QueryParam("name") String name, @QueryParam("detail") String detail, @QueryParam("price") String price, @QueryParam("quantity") String quantity, @QueryParam("info") String info, @QueryParam("image") String image) {
        return productDB.postOneProduct(id, name, detail, price, quantity, info, image);
    }

    @DELETE
    @Path("{id}")
    @Produces("text/json")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/product/1
    public String deleteWithId(@PathParam("id") int id) {
       return productDB.deleteOneProduct(id);
    }

    @GET
    @Produces("text/json")
    @Path("search/{name}")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/product/search/Product%202
    public List<Product> getById(@PathParam("name") String name) {
        return productDB.getOneProductName(name);
    }

    @POST
    @Path("buy/{id}/{quantity}")
    @Produces("text/json")
    //http://localhost:8082/store-1.0-SNAPSHOT/api/product/buy/1/20
    public String buyProduct(@PathParam("id") int id, @PathParam("quantity") int quantity) {
        return productDB.buyProduct(id, quantity);
    }
}
