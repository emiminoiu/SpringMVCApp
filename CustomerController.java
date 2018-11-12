package springdemo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import springdemo.entity.Customer;
import springdemo.entity.CustomerDetail;
import springdemo.entity.Event;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}
	@GetMapping("/showProfile")
	public String showProfile(@RequestParam("customerId") int theId,Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customerProfile", theCustomer);
		CustomerDetail theCustomerDetail = customerService.getCustomerDetail(theId);	
		// set customer details as a model attribute to pre-populate the form
		theModel.addAttribute("customerDetail", theCustomerDetail);
		byte[] photoencodeBase64 = theCustomerDetail.getImage();
		String base64Encoded;

		try {
			try {
			// convert byte array back to BufferedImage
				InputStream in = new ByteArrayInputStream(photoencodeBase64);
				BufferedImage bImageFromConvert = ImageIO.read(in);
				theModel.addAttribute("accPicture", bImageFromConvert);




			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//theModel.addAttribute("accPicture", photoencodeBase64);
		return "profile-page";

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);	

		return "redirect:/customer/list";
	}
	@PostMapping("/saveCustomerDetails")
	public String saveCustomer(@ModelAttribute("customerDetail") CustomerDetail theCustomerDetail) {

		// save the customer using our service
		customerService.saveCustomerDetail(theCustomerDetail);	

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form		
		return "customer-form";
	}
	@GetMapping("/editCustomerDetails")
	public String editCustomerDetails(//@RequestParam("customerDetailId") int theId,
			@RequestParam("customerId") int theCustomerId,
			Model theModel)
	{
		//theId = theCustomerId;
		// get the customer details from our service
		CustomerDetail theCustomerDetail = customerService.getCustomerDetail(theCustomerId);	

		// set customer details as a model attribute to pre-populate the form
		theModel.addAttribute("customerDetail", theCustomerDetail);
		return "additional-info";
	}
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
			Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";        
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// delete the customer
		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}
}










