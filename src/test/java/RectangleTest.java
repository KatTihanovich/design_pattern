import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.factory.impl.RectangleFactoryImpl;
import com.pattern.shape.model.Rectangle;
import com.pattern.shape.model.RectangleState;
import com.pattern.shape.factory.RectangleFactory;
import com.pattern.shape.service.RectangleService;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RectangleTest {
    private final RectangleFactory rectangleFactory = new RectangleFactoryImpl();

    @Test
    public void testCreateRectangle_ValidRectangle() throws InvalidDataException {
        Double[][] sides = {{3.0, 4.0, 3.0, 4.0}};
        List<Rectangle> rectangles = rectangleFactory.createRectangle(sides);
        Assert.assertEquals(rectangles.get(0).getRectangleState(), RectangleState.REGULAR);
    }

    @Test
    public void testCreateRectangle_EmptyArray() {
        RectangleFactoryImpl rectangleFactory = new RectangleFactoryImpl();
        Double[][] sides = {};
        List<Rectangle> rectangles = rectangleFactory.createRectangle(sides);
        Assert.assertTrue(rectangles.isEmpty());
    }

    @Test
    public void testCreateRectangle_Square() {
        RectangleFactoryImpl rectangleFactory = new RectangleFactoryImpl();
        Double[][] sides = {{5.0, 5.0, 5.0, 5.0}};
        List<Rectangle> rectangles = rectangleFactory.createRectangle(sides);
        Assert.assertEquals(rectangles.get(0).getRectangleState(), RectangleState.SQUARE);
    }

    @Test
    public void testCreateRectangle_InvalidRectangle() {
        RectangleFactoryImpl rectangleFactory = new RectangleFactoryImpl();
        Double[][] sides = {{3.0, 1.0, 2.0, 5.0}};
        List<Rectangle> rectangles = rectangleFactory.createRectangle(sides);
        Assert.assertEquals(rectangles.get(0).getRectangleState(), RectangleState.INVALID);
    }

    @Test
    public void testRectangleService_Perimeter() {
        RectangleService rectangleService = new RectangleService();
        Rectangle rectangle = new Rectangle(3.0, 4.0, 3.0, 4.0);
        double expectedPerimeter = 14.0;
        double actualPerimeter = rectangleService.perimeter(rectangle);
        Assert.assertEquals(actualPerimeter, expectedPerimeter);
    }

    @Test
    public void testRectangleService_Square() {
        RectangleService rectangleService = new RectangleService();
        Rectangle rectangle = new Rectangle(3.0, 4.0, 3.0, 4.0);
        double expectedSquare = 12.0;
        double actualSquare = rectangleService.square(rectangle);
        Assert.assertEquals(actualSquare, expectedSquare);
    }


}