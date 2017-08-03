/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.EDuplicateClient;
import model.Client;

/**
 *
 * @author rafael
 */
public interface IClientControl {

    public void insertClient(Client client) throws EDuplicateClient;

    public boolean isUnique(Client client);

    public Client returnClient(int cpf);

    public int clientAmout();

}
