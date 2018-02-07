/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudiastenberg
 */
public class Database {
    
   // skapar objekt av klassen BackendCar 
   private final BackendCar car1 = new BackendCar("Amanda", "Volvo", "123ABC", "Red"); 
   private final BackendCar car2 = new BackendCar("Oscar", "Seat", "123CBA", "Black"); 
   private final BackendCar car3 = new BackendCar("Jessica", "Seat", "321ABC", "Orange"); 
   private final BackendCar car4 = new BackendCar("Daniel", "Volkswagen", "321CBA", "Blue"); 
   private final BackendCar car5 = new BackendCar("Robin", "Volvo", "111AAA", "Black"); 
   //skapar en lista, en arraylist.
   private final List<BackendCar> allCars  = new ArrayList<>();

        Database(){
        allCars.add(car1);
        allCars.add(car2);
        allCars.add(car3);
        allCars.add(car4);
        allCars.add(car5);
      }
        
      public List<BackendCar> getAllCarInfo(){
        return allCars;
      }
      
      //metod som hämtar den specifika bildens reg
      public String getCarReg(String reg){ 
          for (BackendCar bc : allCars) { // loop lista
              if(bc.getReg().equalsIgnoreCase(reg)){
                  return bc.getAllData();
              }
              
          }
          return null;
      }
 
}
