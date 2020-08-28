package th.go.rd.atm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;

@Controller
@RequestMapping("/searchcustomer")
public class SearchCustomerController {
    private CustomerService customerService;
    private Customer searchCustomer;
    public SearchCustomerController(CustomerService customerService) {  //dependency injection
        this.customerService = customerService;
    }
    @GetMapping

    public String getSearchCustomerPage( Model model) {
        model.addAttribute("customer", searchCustomer);
        return "searchcustomer";   // return login.html
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        searchCustomer = customerService.findCustomer(customer.getId());
        model.addAttribute("customer", searchCustomer);
        return "redirect:searchcustomer";
    }


}
