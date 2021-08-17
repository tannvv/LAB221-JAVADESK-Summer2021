package services;

import daos.RegistrationDAO;
import dtos.RegistrationDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author LTD
 */
public class RegistrationServerImpl extends UnicastRemoteObject implements RegistrationInterface {

    private final String fileName = "RegistrationData.txt";

    //constructor
    public RegistrationServerImpl() throws RemoteException {

    }

    @Override
    public boolean createRegistration(RegistrationDTO dto) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list;
            list = RegistrationDAO.readFile(fileName);
            if (list.add(dto)) {
                RegistrationDAO.writeFile(fileName, list);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RegistrationDTO findByRegistrationID(String id) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = RegistrationDAO.readFile(fileName);
            for (RegistrationDTO x : list) {
                if (x.getRegistrationID().equalsIgnoreCase(id)) {
                    return x;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = RegistrationDAO.readFile(fileName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeRegistration(String id) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = RegistrationDAO.readFile(fileName);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getRegistrationID().equalsIgnoreCase(id)) {
                    list.remove(i);
                    RegistrationDAO.writeFile(fileName, list);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws RemoteException {
        ArrayList<RegistrationDTO> list = RegistrationDAO.readFile(fileName);
        String id = dto.getRegistrationID();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistrationID().equals(id)) {
                list.get(i).setRegistrationID(dto.getRegistrationID());
                list.get(i).setFullName(dto.getFullName());
                list.get(i).setAge(dto.getAge());
                list.get(i).setGender(dto.isGender());
                list.get(i).setEmail(dto.getEmail());
                list.get(i).setPhone(dto.getPhone());
                list.get(i).setAddress(dto.getAddress());
                list.get(i).setNumberOfPet(dto.getNumberOfPet());
                list.get(i).setSymptoms(dto.getSymptoms());
                RegistrationDAO.writeFile(fileName, list);
                return true;
            }
        }
        return false;
    }
}
