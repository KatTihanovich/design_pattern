import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.factory.impl.RectangleFactoryImpl;
import com.pattern.shape.model.Rectangle;
import com.pattern.shape.model.RectangleState;
import com.pattern.shape.factory.RectangleFactory;
import com.pattern.shape.reader.FileReader;
import com.pattern.shape.service.RectangleService;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.util.List;

import static com.pattern.shape.validator.Validator.isValidRectangle;

public class RectangleTest {
    private static final String FILE_PATH = "src/test/resources/rectangles_test.txt";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty_file.txt";
    private static final String INVALID_FILE_PATH = "src/test/resources/invalid_data.txt";
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

    @Test
    public void testReadSides_ValidFile() {
        Double[][] sides = FileReader.readSides(FILE_PATH);
        int expected_number = 2;
        Assert.assertEquals(expected_number, sides.length);
    }

    @Test
    public void testReadSides_EmptyFile() {
        Double[][] sides = FileReader.readSides(EMPTY_FILE_PATH);
        Assert.assertEquals(sides.length, 0);
    }

    @Test
    public void testReadSides_InvalidData() {
        Double[][] sides = FileReader.readSides(INVALID_FILE_PATH);
        Assert.assertEquals(sides.length, 0);
    }

    @Test
    public void testValidator_IsValid() throws InvalidDataException {
        Rectangle rectangle = new Rectangle(1.1, 2.0, 1.1, 2.0);
        Assert.assertTrue(isValidRectangle(rectangle));
    }

    @Test
    public void testValidator_IsSquare() throws InvalidDataException {
        Rectangle rectangle = new Rectangle(1.1, 1.1, 1.1, 1.1);
        Assert.assertTrue(isValidRectangle(rectangle));
    }
}