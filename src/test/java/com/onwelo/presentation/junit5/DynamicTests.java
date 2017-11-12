package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DynamicTests {

    @TestFactory
    @DisplayName("Is Even")
    Stream<DynamicTest> dynamicTests() {
        Random random = new Random();
        return IntStream.range(0, random.nextInt(10)).mapToObj( i ->
            DynamicTest.dynamicTest("Testing i = " + i, () -> Assertions.assertTrue(i % 2 == 0))
        );
    }
}
