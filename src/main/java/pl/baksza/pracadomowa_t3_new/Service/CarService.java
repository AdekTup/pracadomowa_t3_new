package pl.baksza.pracadomowa_t3_new.Service;

import org.springframework.stereotype.Service;
import pl.baksza.pracadomowa_t3_new.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    List<Car> carslist;

    public CarService() {
        carslist = new ArrayList<>();

        Car car1 = new Car(1l,"BMW","i8","red");
        Car car2 = new Car(2l,"Filat","Punto","green");
        Car car3 = new Car(3l,"Renault","Clieo","red");
        Car car4 = new Car(4l,"Opel","Corsa","yellow");

        carslist.add(car1);
        carslist.add(car2);
        carslist.add(car3);
        carslist.add(car4);
    }

    public List<Car> getAllCars() {
        return carslist;
    }

    public Optional<Car> getCarById(long id) {
        return carslist.stream().filter(car -> car.getId() == id).findFirst();
    }

    public boolean addCar(Car caradd) {
        Optional<Car> carfind = carslist.stream().filter(car -> car.getId() == caradd.getId()).findFirst();
        if (!carfind.isPresent()) {
            return carslist.add(caradd);
        }
        return false;
    }

    public boolean deleteCar(long id) {
        Optional<Car> carfind = getCarById(id);
        System.out.println(carfind.toString());
        if (carfind.isPresent()) {
            System.out.println(carslist.remove(carfind.get()));
            return true;
        }
        return false;
    }

    public List<Car> getCarByColor(String color){
        List<Car> carscolorlist = carslist.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
        return carscolorlist;
    }



}
