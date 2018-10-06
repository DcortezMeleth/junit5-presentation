package com.onwelo.presentation.junit5;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Junit4ParametrizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{0,0}, {1,1}, {2,2}});
    }

    private int input;

    private int output;

    public Junit4ParametrizedTest(int input, int output) {
        this.input = input;
        this.output = output;
    }

    @Test
    public void test() {
        Assert.assertEquals(input, output);
    }
}
