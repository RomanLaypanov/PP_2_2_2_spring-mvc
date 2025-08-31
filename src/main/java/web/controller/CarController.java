package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    @GetMapping
    public String carShow(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> allCars = carCreat();
        List<Car> carsToShow;

        if (count == null) {
            carsToShow = allCars;
        } else if (count <= carCreat().size() && count > 0) {
            carsToShow = allCars.subList(0, count);
        } else {
            carsToShow = allCars;
        }

        model.addAttribute("cars", carsToShow);

        return "cars";
    }

    private List<Car> carCreat() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("Mercedes-Benz", "Black", 7_900_000));
        carList.add(new Car("BMW", "White", 5_600_000));
        carList.add(new Car("Volkswagen", "Silver", 1_200_000));
        carList.add(new Car("Ford", "Yellow", 790_000));
        carList.add(new Car("Kia", "Grey", 2_300_000));

        return carList;
    }
}
