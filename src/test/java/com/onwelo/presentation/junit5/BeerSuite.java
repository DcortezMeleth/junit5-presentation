package com.onwelo.presentation.junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {SaveBeerTest.class, BeerConversionServiceTest.class})
class BeerSuite {
}
