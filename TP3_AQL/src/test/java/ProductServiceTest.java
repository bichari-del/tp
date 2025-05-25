import org.example.Product;
import org.example.ProductApiClient;
import org.example.ProductService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() throws Exception {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService service = new ProductService(mockClient);

        Product expectedProduct = new Product("p123", "Laptop");
        when(mockClient.getProduct("p123")).thenReturn(expectedProduct);

        Product result = service.getProduct("p123");

        assertEquals(expectedProduct, result);
        verify(mockClient).getProduct("p123");
    }

    @Test
    public void testGetProduct_InvalidFormat() throws Exception {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService service = new ProductService(mockClient);

        when(mockClient.getProduct("badId")).thenThrow(new RuntimeException("Invalid response format"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.getProduct("badId");
        });

        assertEquals("Invalid response format", exception.getMessage());
        verify(mockClient).getProduct("badId");
    }

    @Test
    public void testGetProduct_ApiFailure() throws Exception {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService service = new ProductService(mockClient);

        when(mockClient.getProduct("failId")).thenThrow(new Exception("API unavailable"));

        Exception exception = assertThrows(Exception.class, () -> {
            service.getProduct("failId");
        });

        assertEquals("API unavailable", exception.getMessage());
        verify(mockClient).getProduct("failId");
    }
}
