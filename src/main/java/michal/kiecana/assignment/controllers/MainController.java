package michal.kiecana.assignment.controllers;

import michal.kiecana.assignment.dto.Input;
import michal.kiecana.assignment.dto.SetOfNumbers;
import michal.kiecana.assignment.services.connect.ConnectNumberService;
import michal.kiecana.assignment.services.random.RandomNumberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class MainController {

    private final RandomNumberService randomNumberServiceFirst;
    private final RandomNumberService randomNumberServiceSecond;
    private final ConnectNumberService connectNumberService;

    public MainController(@Qualifier("randomNumberServiceFirst") RandomNumberService randomNumberServiceFirst, @Qualifier("randomNumberServiceSecond")RandomNumberService randomNumberServiceSecond, ConnectNumberService connectNumberService) {
        this.randomNumberServiceFirst = randomNumberServiceFirst;
        this.randomNumberServiceSecond = randomNumberServiceSecond;
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
        List<Double> randomDbNumbers = randomNumberServiceFirst.getRandomNumber(amount);
        List<Double> randomJavaNumbers = randomNumberServiceSecond.getRandomNumber(amount);
        List<SetOfNumbers> setOfNumbersList = connectNumberService.connectNumbers(randomDbNumbers, randomJavaNumbers, Double::sum);
        model.addAttribute("numbers", setOfNumbersList);
        return "numbers/list";

    }
}