package com.product.repo;

import com.product.model.MyFile;
import org.springframework.data.repository.CrudRepository;

public interface FileRepo extends CrudRepository<MyFile,Integer> {
}
