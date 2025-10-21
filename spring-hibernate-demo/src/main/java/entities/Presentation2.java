package entities;

import dao.IDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                HibernateConfig.class)) {

            // On utilise l'interface IDao, Spring trouvera l'implémentation appropriée
            @SuppressWarnings("unchecked")
            IDao<Product> productDao = (IDao<Product>) context.getBean(IDao.class);

            Product product = new Product();
            product.setName("Produit 1");
            product.setPrice(100.0);

            productDao.create(product);

            System.out.println("Produit sauvegardé : " + product.getName());
        }
    }
}
