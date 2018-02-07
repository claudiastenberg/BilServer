/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

/**
 *
 * @author claudiastenberg
 */
public class BackendCar {
    protected String clientName;
    protected String carModel;
    protected String reg;
    protected String color;
    
    BackendCar(){}
    
    BackendCar(String clientName, String carModel, String reg, String color){
        this.clientName = clientName;
        this.carModel = carModel;
        this.reg = reg;
        this.color = color;
    }
    
    public String getClientName(){
        return clientName;
    }
    
    public String getCarModel(){
        return carModel;
    }
    
    public String getReg(){
        return reg;
    }
   
    public String getColor(){
        return color;
    }
    
    public String getAllData(){
     return "Ägare: " + clientName + " Modell: " + carModel + " Regnr: " + reg + " Färg: " + color;
    }
  
}
