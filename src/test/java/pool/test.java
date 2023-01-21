package test.java.pool;

import main.java.pool.pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
    @Test
    public void test1(){
        pool pool1 = new pool();
        assertEquals(1, pool1.testCode());
    }
}
