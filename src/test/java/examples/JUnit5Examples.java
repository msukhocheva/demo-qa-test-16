package examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Examples {
    @BeforeAll
    static void beforeAll(){
        //open("google.com");
        System.out.println("### beforeAll()");
    }
    @AfterAll
    static void afterAll(){
        //open("google.com");
        System.out.println("### afterAll()");
    }

    @BeforeEach
    void beforeEach(){
        //open("google.com");
        System.out.println("### beforeEach()");
    }

    @AfterEach
    void afterEach(){

        System.out.println("### afterEach()");
    }

    @Test
    void firstTest() {
        System.out.println("### FirstTest()");
        assertTrue(3>2);
    }

    @Test
    void secondTest() {
        System.out.println("### secondTest()");
       // assertFalse(3>2);
    }
}
