package siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Customer;
import siit.model.exception.ValidationException;
import siit.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayList(HttpSession session) {

        Map<String, Object> model = new HashMap<>();

        model.put("customers", customerService.getAllCustomers());

        return new ModelAndView("customer-list", model);
    }

    @RequestMapping(path = "/{customerId}/edit", method = RequestMethod.GET)
    public ModelAndView displayEdit(@PathVariable int customerId) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.getCustomerById(customerId));
        return new ModelAndView("customer-edit", model);
    }

    @RequestMapping(path = "/{customerId}/edit", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable int customerId,
                             @ModelAttribute Customer customer) {
        customer.setId(customerId);
        try {
            customerService.update(customer);
            return new ModelAndView("redirect:/customers");
        } catch (ValidationException e) {
            Map<String, Object> model = new HashMap<>();
            model.put("error", e.getMessage());
            return new ModelAndView("customer-edit", model);
        }

    }

    @RequestMapping(path = "/{customerId}/orders")
    public ModelAndView viewOrders(@PathVariable int customerId){
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.getCustomerById(customerId));
        return new ModelAndView("customer-orders", model);
    }


}
