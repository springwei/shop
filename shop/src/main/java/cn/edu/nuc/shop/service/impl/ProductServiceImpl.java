package cn.edu.nuc.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.shop.dao.ProductMapper;
import cn.edu.nuc.shop.entiry.Product;
import cn.edu.nuc.shop.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> listProduct() {

		return productMapper.listProduct();
	}

	@Override
	public int addProduct(Product product) {

		return productMapper.insert(product);
	}

	@Override
	public int deleteProduct(Product product) {

		return productMapper.deleteByPrimaryKey(product.getPid());
	}

	@Override
	public Product findById(int pid) {

		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int updateProduct(Product product) {

		return productMapper.updateByPrimaryKey(product);
	}

	@Override
	public List<Product> findByName(String pname) {

		return productMapper.findByPname(pname);
	}

	@Override
	public List<Product> frontlistNew() {

		return productMapper.frontlistNew();
	}

	@Override
	public List<Product> frontlistHot() {

		return productMapper.frontlistHot();
	}

}
