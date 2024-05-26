import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    private List<Item> createList(Item...elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void everyBranchTest() {
        RuntimeException ex;

        //null allItems list
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //no discount
        assertTrue(SILab2.checkCart(createList(new Item("item", "1234", 100, 0)), 200));

        //item with null name, discount > 0, special discount condition, and sum greater than payment
        assertTrue(SILab2.checkCart(createList(new Item(null, "0123", 400, 0.1f)), 200));

        //item without barcode
        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(createList(new Item("item", null, 400, 0)), 400));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //invalid character in barcode
        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(createList(new Item("item", "12t3", 100, 0)),100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
    }

    @Test
    void multipleConditionTest() {
        //item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'

        RuntimeException ex;

        // true, true, true
        assertTrue(SILab2.checkCart(createList(new Item(null, "0123", 400, 0.1f)), 200));

        // true, true, false
        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(createList(new Item("item", "12t3", 100, 0)),100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        // true, false, x
        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(createList(new Item("item", null, 400, 0)), 400));
        assertTrue(ex.getMessage().contains("No barcode!"));

        // false, x, x
        assertTrue(SILab2.checkCart(createList(new Item("item", "1234", 100, 1.1f)),200));
    }
}
