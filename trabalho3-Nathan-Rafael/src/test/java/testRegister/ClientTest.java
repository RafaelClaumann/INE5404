package testRegister;

import control.ClientControl;
import exceptions.EDuplicateClient;
import model.BlackCard;
import model.Client;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ClientTest {

    private ClientControl clientControl;

    @Before
    public void begin() throws EDuplicateClient {
        clientControl = new ClientControl();
        clientControl.insertClient(new Client("nathan", 123, new BlackCard(), 2000));
    }

    @Test
    public void clientAmountTest() throws EDuplicateClient {
        int amountCounter = clientControl.clientAmout();
        assertEquals(1, amountCounter);
    }

    @Test(expected = EDuplicateClient.class)
    public void equalClients() throws EDuplicateClient {
        clientControl.insertClient(new Client("nathan", 123, new BlackCard(), 2000));
    }
}
