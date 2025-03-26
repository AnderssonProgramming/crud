package edu.eci.cvds.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.junit.jupiter.api.Assertions.*;




@DataMongoTest
public class ProductoRepositoryTest {

    @Autowired
    private ProductoRepository productoRepository;
    
}