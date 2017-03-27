package data;


import model.Bottom;
import model.Toppings;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CakeMapperTest {

    public CakeMapperTest() {
    }

    CakeMapper cm;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        cm = new CakeMapper();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBottombyName() {
        Bottom b = cm.getBottom("Chocolate");
        int price = b.getPrice();
        int exp = 5;
        assertEquals(exp, price);
        System.out.println(exp);
        System.out.println(price);
    }

    @Test
    public void getToppingbyName() {
        Toppings t = cm.getTopping("Chocolate");
        int price = t.getPrice();
        int exp = 5;
        assertEquals(exp, price);
        System.out.println(exp);
        System.out.println(price);
    }

    @Test
    public void getPasswordbyUsername() {
        User u = cm.getUser("abe");
        String password = u.getPassword();
        String exp = "monkey";
        assertEquals(exp, password);
        System.out.println(exp);
        System.out.println(password);
    }

    @Test
    public void getBalancebyUsername() {
        User u = cm.getUser("abe");
        double balance = u.getBalance();
        double exp = 20;
        System.out.println(exp);
        System.out.println(balance);
    }

}
