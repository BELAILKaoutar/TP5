package entities;

import metier.ProductDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(HibernateConfig.class)) {

            // Spring va récupérer le bean ProductDaoImpl
            ProductDaoImpl productDao = context.getBean(ProductDaoImpl.class);

            Product product = new Product();
            product.setName("Produit 1");
            product.setPrice(100.0);

            productDao.create(product);

            System.out.println("Produit sauvegardé : " + product.getName());
        }
    }
}
