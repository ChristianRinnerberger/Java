import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class SumOfTwo_1Test
{

    SumOfTwo_1 sot_1;

    @BeforeEach
    public void setup()
    {
        sot_1 = new SumOfTwo_1();
    }

    @Test
    @DisplayName("Test 1")
    public void test_1()
    {

        int[] a = {2, 1, 3, 6};
        int[] b = {10, 20, 30, 40};
        Assertions.assertTrue(sot_1.sumOfTwo(a, b, 42));
    }

    @Test
    @DisplayName("Test 2")
    public void test_2()
    {
        int[] a = {0, 0, -5, 30212};
        int[] b = {-10, 40, -3, 9};
        Assertions.assertTrue(sot_1.sumOfTwo(a, b, -8));
    }
}
