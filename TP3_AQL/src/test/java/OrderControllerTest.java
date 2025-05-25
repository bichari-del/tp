import org.example.Order;
import org.example.OrderController;
import org.example.OrderDao;
import org.example.OrderService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderService service = new OrderService(mockDao);

        OrderService spyService = spy(service);
        OrderController controller = new OrderController(spyService);

        Order order = new Order(1L, "Book");

        controller.createOrder(order);

        verify(spyService).createOrder(order);
        verify(mockDao).saveOrder(order);
    }
}
