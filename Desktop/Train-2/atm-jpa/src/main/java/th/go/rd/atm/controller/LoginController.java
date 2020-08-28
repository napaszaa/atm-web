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
@RequestMapping("/login")
public class LoginController {
  private CustomerService customerService;
    public LoginController(CustomerService customerService) {  //dependency injection
        this.customerService = customerService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }


    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {
        // 1. เอา id กับ pin ไปเช็คกับข้อมูล customer ที่มีอยู่ ว่าตรงกันบ้างไหม
        Customer matchingCustomer = customerService.checkPin(customer);   //matchingCustomer  เป็น object

        // 2. ถ้าตรง ส่งข้อมูล customer กลับไปแสดงผล (ไม่ส่ง pin ไปด้วย)
        if (matchingCustomer != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingCustomer.getName());

        } else {
            // 3. ถ้าไม่ตรง แจ้งว่าไม่มีข้อมูล customer นี้
            model.addAttribute("greeting", "Can't find customer");
        }
        return "home";

    }

}