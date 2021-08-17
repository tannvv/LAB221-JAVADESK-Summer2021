package services;

import dtos.RegistrationDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author LTD
 */
public interface RegistrationInterface extends Remote {

    boolean createRegistration(RegistrationDTO dto) throws RemoteException;

    RegistrationDTO findByRegistrationID(String id) throws RemoteException;

    ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException;

    boolean removeRegistration(String id) throws RemoteException;

    boolean updateRegistration(RegistrationDTO dto) throws RemoteException;
}
