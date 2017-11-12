package com.onwelo.presentation.junit5;

import com.onwelo.presentation.junit5.extensions.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitJupiterWebConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringJUnitJupiterWebConfig(classes = {
        BeerStoreConfiguration.class,
        PersistenceConfiguration.class
})
@ExtendWith(MockitoExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface BeerTest {

}
