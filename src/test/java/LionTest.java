import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Objects;

@RunWith(Parameterized.class)
public class LionTest {
    private final boolean expectedRes;
    private final String sex;

    @Mock
    Feline feline;

    public LionTest(String sex, boolean expectedRes) {
        this.sex = sex;
        this.expectedRes = expectedRes;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Error", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        try {
            Mockito.when(feline.getKittens()).thenReturn(1);
            Lion lion = new Lion(feline, sex);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void doesHaveManeTest() throws Exception {
        try {
            Lion lion = new Lion(feline, sex);
            Assert.assertEquals(expectedRes, lion.doesHaveMane());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        try {
            Lion lion = new Lion(feline, sex);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}