package pl.pozsda19.electroshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pozsda19.electroshop.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
