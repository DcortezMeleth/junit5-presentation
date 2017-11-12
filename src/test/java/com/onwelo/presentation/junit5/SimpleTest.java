package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Some simple tests!")
class SimpleTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.debug("BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        logger.debug("BeforeEach");
    }

    @AfterAll
    static void afterAll() {
        logger.debug("AfterAll");
    }

    @AfterEach
    void afterEach() {
        logger.debug("AfterEach");
    }

    @Test
    @DisplayName("TEST 1")
    void test1(TestInfo testInfo) {
        logger.debug("Test1");
        Assertions.assertEquals("TEST 1", testInfo.getDisplayName());
    }

    @Test
    @Tag("integration")
    void test2(TestInfo testInfo) {
        logger.debug("Test2");
        Assertions.assertTrue(testInfo.getTags().contains("integration"));
    }
}
