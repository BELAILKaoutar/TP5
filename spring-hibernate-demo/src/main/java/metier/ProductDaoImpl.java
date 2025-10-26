package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository // <- indispensable !
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Product product) {
        sessionFactory.getCurrentSession().persist(product);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Product product) {
        sessionFactory.getCurrentSession().remove(product);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        sessionFactory.getCurrentSession().merge(product);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession()
                .createSelectionQuery("from Product", Product.class)
                .getResultList();
    }
}
