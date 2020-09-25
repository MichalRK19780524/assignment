package michal.kiecana.assignment.controllers;

import michal.kiecana.assignment.dto.Input;
import michal.kiecana.assignment.dto.SetOfNumbers;
import michal.kiecana.assignment.services.connect.ConnectNumberService;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceH2Impl;
import michal.kiecana.assignment.services.random.impl.RandomNumberServiceJavaImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class MainController {

    private final RandomNumberServiceH2Impl randomNumberServiceH2;
    private final RandomNumberServiceJavaImpl randomNumberServiceJava;
    private final ConnectNumberService connectNumberService;

    public MainController(RandomNumberServiceH2Impl randomNumberServiceH2, RandomNumberServiceJavaImpl randomNumberServiceJava, ConnectNumberService connectNumberService) {
        this.randomNumberServiceH2 = randomNumberServiceH2;
        this.randomNumberServiceJava = randomNumberServiceJava;
        this.connectNumberService = connectNumberService;
    }

    @GetMapping("/input_number")
    public String showForm(Model model) {
        Input amount = new Input();
        model.addAttribute("amount", amount);
        return "numbers/input_number_form";
    }

    @PostMapping("/input_number")
    public String submitForm(@ModelAttribute("amount") Integer amount, Model model, RedirectAttributes redirectAttributes) {
        if (amount < 1 || amount > 10000) {
            redirectAttributes.addFlashAttribute("errorMessage", "The amount of numbers have to be between 1 and 10000");
            return "redirect:/input_number";
        }
        List<Double> randomBbNumbers = randomNumberServiceH2.getRandomNumber(amount);
        List<Double> randomJavaNumbers = randomNumberServiceJava.getRandomNumber(amount);
        List<SetOfNumbers> setOfNumbersList = connectNumberService.connectNumbers(randomBbNumbers, randomJavaNumbers, Double::sum);
        model.addAttribute("numbers", setOfNumbersList);
        return "numbers/list";

    }
}