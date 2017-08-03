package control;

import exceptions.EDuplicateClient;
import java.util.HashSet;
import java.util.Set;
import model.Client;

/**
 *
 * @author nathancezar
 */
public class ClientControl {

    private Set<Client> clientsList = new HashSet<>();
    private static ClientControl instance;

    public static ClientControl getClientControl() {
        if (ClientControl.instance == null) {
            ClientControl.instance = new ClientControl();
        }
        return ClientControl.instance;
    }

    public Client newClient() {
        return new Client();
    }

    public String returnClients() {
        return clientsList.toString();
    }

    public void insertClient(Client client) throws EDuplicateClient {
        isUnique(client);
        clientsList.add(client);
    }

    public void insertClientSet(Set<Client> clientInputSet) {
        this.clientsList = clientInputSet;
    }

    public Set returnClientSet() {
        return clientsList;
    }

    public void isUnique(Client client) throws EDuplicateClient {
        for (Client c : clientsList) {
            if (client.getCpf() == c.getCpf()) {
                throw new EDuplicateClient();
            }
        }
    }

    public Client returnClient(int cpf) throws NullPointerException {
        for (Client c : clientsList) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        throw new NullPointerException();
    }

    public int clientAmout() {
        return this.clientsList.size();
    }

}
