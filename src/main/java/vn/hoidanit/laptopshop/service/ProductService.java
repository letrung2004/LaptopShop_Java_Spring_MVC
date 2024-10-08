package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // luu product
    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    // lấy danh sách tất cả các product để hiển thi lên trang user detail
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // public Product getProductById(long id) {
    // return productRepository.findById(id);
    // }

    // xóa product
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    // public Optional<Product> fetchProductById(long id) {
    // return this.productRepository.findById(id);
    // }
    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

}
