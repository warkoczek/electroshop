package pl.pozsda19.electroshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pozsda19.electroshop.domain.Product;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);
    Optional<Product> findByName(String name);
    Optional<Product> findByImageURL(String imageURL);

}
