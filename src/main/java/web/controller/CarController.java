package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.services.CarServices;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String carShow(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarServices carServices = new CarServices();
        List<Car> carsToShow;

        if (count == null) {
            carsToShow = carServices.carCreat();
        } else if (count <= carServices.carCreat().size() && count > 0) {
            carsToShow = carServices.carCreat().subList(0, count);
        } else {
            carsToShow = carServices.carCreat();
        }

        model.addAttribute("cars", carsToShow);
        model.addAttribute("number", carServices.quantityCarsFromList());

        return "cars";
    }
}
