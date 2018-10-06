package com.onwelo.presentation.junit5;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {SimpleTest.class, SaveBeerTest.class})
@ExcludeTags("integration")
class BeerSuite {
}
