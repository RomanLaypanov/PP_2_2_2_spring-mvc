package web.services;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServicesImp implements CarServices {

    @Override
    public List<Car> carCreat() {
        List<Car> carList = new ArrayList<>(10);

        carList.add(new Car("Mercedes-Benz", "Black", 7_900_000));
        carList.add(new Car("BMW", "White", 5_600_000));
        carList.add(new Car("Volkswagen", "Silver", 1_200_000));
        carList.add(new Car("Ford", "Yellow", 790_000));
        carList.add(new Car("Kia", "Grey", 2_300_000));

        return carList;
    }

    @Override
    public int quantityCarsFromList() {
        return carCreat().size();
    }
}
