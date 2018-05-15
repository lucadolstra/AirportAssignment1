package com.capgemini.airport1;



import com.capgemini.airport1.controller.AirplaneController;
import com.capgemini.airport1.model.Airplane;
import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
import org.springframework.web.bind.annotation.PathVariable;

public class AirplaneControllerTests {


    private AirplaneController airplaneController;

    @Before
    public void setUp() {
        this.airplaneController = new AirplaneController();
    }}
//
//
//    @Test
//    public void testAddAirplane() {
//        Airplane actual = this.airplaneController.addAirplane("newPlane");
//
//        Airplane expected = A
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testSubtract() {
//        int actual = this.calculator.subtract(4,3);
//
//        Assert.assertEquals(1, actual);
//    }
//
//    @After
//    public void tearDown() {
//        this.calculator = null;
//    }
//
//}
