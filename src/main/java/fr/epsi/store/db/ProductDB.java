package fr.epsi.store.db;

import fr.epsi.store.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private List<Product> productList;

    public ProductDB() {
        this.productList = new ArrayList<>();
        addToProductList();
    }

    private void addToProductList() {
        productList.add(new Product(1,"Product 1", "Lorem ipsum dolor sit amet", "99", "150", "This is the latest and greatest product from Derp corp.", "http://placehold.it/300x300/999/CCC%22"));
        productList.add(new Product(2,"Product 2", "Voiture pour enfant", "10", "400", "C'est une mini voiture", "http://voiture/sss%22"));
        productList.add(new Product(3,"Product 3", "Playstation 5", "500", "10", "La toute nouvelle playstation sortie cette année", "http://playstation5.com/rgfj%22"));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getOneProduct(int id) {
        for ( Product product : productList ) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getOneProductName(String name) {
        List<Product> productL = new ArrayList<>();
        for ( Product product : productList ) {
            if (product.getName().contains(name)) {
                productL.add(product);
            }
        }
        return productL;
    }

    public Product addProduct(Product p){
        p.setId(productList.size() + 1);
        productList.add(p);
        return p;
    }

    public String postOneProduct(int id, String name, String detail, String price, String quantity, String info, String image) {
        int cpt = 0;
        for ( Product product : productList ) {
            if (product.getId() == id) {
                cpt ++;
            }
        }
        if (cpt == 0){
            Product productCreated = new Product(id, name, detail, price, quantity, info, image);
            productList.add(productCreated);
            return "Produit créer avec l'id " + id;
        }
        return "Produit avec l'id " + id + " est déjà créer";
    }

    public String buyProduct(int id, int quantity ) {
        for ( Product product : productList ) {
            String quantityProduct = product.getQuantity();
            int verifQttInt = Integer.parseInt(quantityProduct) - quantity;
            String verifQttStr = String.valueOf(Integer.parseInt(quantityProduct) - quantity);

            if (product.getId() == id) {
                if(verifQttInt < 0){
                    return "La quantité demandé est trop importante," +
                            " la quantité actuelle de ce produit est de " + quantityProduct;
                }
                else{
                    product.setQuantity(verifQttStr);
                    return "Produit avec l'id " + id + " a été mis à jour, sa quantité est maintenant de "
                            + product.getQuantity();
                }
            }
        }
        return "Le produit avec l'id " + id +" n'existe pas";
    }

    public String deleteOneProduct(int id) {
        if(productList.removeIf(product -> product.getId() == id)){
            return "Product delete";
        }
        return "Unknown product";
    }

}
