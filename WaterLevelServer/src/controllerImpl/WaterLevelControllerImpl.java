/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.WaterLevelController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import observer.WaterLevelObserver;

/**
 *
 * @author niroth
 */
public class WaterLevelControllerImpl extends UnicastRemoteObject implements WaterLevelController {

    private ArrayList<WaterLevelObserver> observers = new ArrayList<>();
    private int waterLevel;

    public WaterLevelControllerImpl() throws RemoteException {

    }

    @Override
    public void addWaterLevelObserver(WaterLevelObserver waterLevelObserver) throws RemoteException {
        observers.add(waterLevelObserver);
    }

    @Override
    public void removeWaterLevelObserver(WaterLevelObserver waterLevelObserver) throws RemoteException {
        observers.remove(waterLevelObserver);
    }

    @Override
    public void setWaterLevel(int waterLevel) throws RemoteException {
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifyWaterLevelObservers();
        }
    }

    private void notifyWaterLevelObservers() throws RemoteException {
        for (WaterLevelObserver observer : observers) {
            observer.update(waterLevel);
        }
    }

}
