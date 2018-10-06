package com.onwelo.presentation.junit5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Junit4ParametrizedTest {

    private int input;

    private int output;

    public Junit4ParametrizedTest(int input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 2}});
    }

    @Test
    public void test() {
        Assert.assertEquals(input, output);
    }
}
