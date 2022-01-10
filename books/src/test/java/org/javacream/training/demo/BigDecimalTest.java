package org.javacream.training.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test public void testDouble(){
        Double d1 = 0.1;
        Double d2 = 0.9;
        Double d3 = d1 + d2;
        Assertions.assertEquals(1.0, d3);

    }

    @Test public void testBigDecimal(){
        //BigDecimal d1 = new BigDecimal(0.1); -> immer noch ungenau
        //BigDecimal d1 = new BigDecimal("0.1"); exakt, aber unpraktisch
        BigDecimal d1 = BigDecimal.valueOf(0.1);//exakt und nachvollziehbar
        BigDecimal d2 = BigDecimal.valueOf(0.9);
        //BigDecimal d3 = d1 + d2; -> geht nicht, kein Überladen von Operatoren in Java
        BigDecimal d3 = d1.add(d2);
        Assertions.assertEquals(BigDecimal.valueOf(1.0), d3);

    }

}
