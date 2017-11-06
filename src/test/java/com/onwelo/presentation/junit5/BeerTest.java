package com.onwelo.presentation.junit5;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitJupiterWebConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringJUnitJupiterWebConfig(classes = {BeerStoreConfiguration.class, PersistenceConfiguration.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BeerTest {

}
