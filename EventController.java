package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Customer;
import springdemo.entity.Event;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/showEvents")
	public String showEvents(@RequestParam("customerId") int theId,Model theModel)
	{
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customerProfile", theCustomer);
		List<Event> theEvents = customerService.getEvents(theId);
		theModel.addAttribute("events",theEvents);
		return "events-page";
	}

	@GetMapping("/AddEventForm")
	public String showFormForUpdate(Model theModel) {

		// get the customer from our service
		Event theEvent = new Event();	

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("event", theEvent);

		// send over to our form		
		return "event-form";
	}

	@GetMapping("/saveEvent")
	public String saveCustomer(@ModelAttribute("event") Event theEvent,@ModelAttribute("customer") 
	Customer theCustomer) {

		// save the customer using our service
		customerService.saveEvent(theEvent,theCustomer);	

		return "redirect:/event/showEvents";
	}
}