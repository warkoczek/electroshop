package pl.pozsda19.electroshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Group;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;

import java.util.Optional;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);
    Optional<Product> findByName(String name);
    Optional<Product> findByImageURL(String imageURL);
    Set<Product> findProductsByCategory(Category category);
    Set<Product> findProductsBySubcategory(Subcategory subcategory);
    Set<Product> findProductsByGroupo(Group groupo);
    boolean existsByCode(String code);

}
