package cn.edu.nuc.shop.service.interfaces;

import java.util.List;

import cn.edu.nuc.shop.entiry.Product;

public interface ProductService {
	
	List<Product> listProduct();
	
	int addProduct(Product product);
	
	int deleteProduct(Product product);
	
	Product findById(int pid);
	
	int updateProduct(Product product);
	
	List<Product> findByName(String pname);
	
	
	 /**列出最新的10条商品
     * @return list
     */
    List<Product> frontlistNew();
    
    
    /**列出最热的10条商品
     * @return list
     */
    List<Product> frontlistHot();
	
}
