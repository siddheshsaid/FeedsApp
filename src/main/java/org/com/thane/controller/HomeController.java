package org.com.thane.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.com.thane.model.RegistedEmployee;
import org.com.thane.model.UserFeeds;
import org.com.thane.service.RegistedEmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	@Autowired
RegistedEmployeeDetails registedEmployeeDetails;
//	@RequestMapping(value="/")
//	public ModelAndView test(HttpServletResponse response) throws IOException{
//		return new ModelAndView("home");
//	}

	@RequestMapping(value="/")
	public RedirectView test1(HttpServletResponse response) throws IOException{
		RedirectView redirectView=new RedirectView();

		redirectView.setUrl("home");

		return redirectView;


	}
	@RequestMapping(value="/home")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("RegistedEmployee", new RegistedEmployee());
		modelAndView.setViewName("home");

		return modelAndView;


	}
	@RequestMapping(value="/createregister",method = RequestMethod.POST)
	public ModelAndView createRegister(@Valid @ModelAttribute("RegistedEmployee") RegistedEmployee registedEmployee, BindingResult bindingResult){
		ModelAndView mv=new ModelAndView();
		if(bindingResult.hasErrors()){
			mv.setViewName("home");
		}
		else{
			registedEmployeeDetails.persist(registedEmployee);
		}

		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/loginpage")
	public ModelAndView loginDetails(HttpServletResponse response) throws IOException {

		ModelAndView modelAndView = new ModelAndView();
		List<RegistedEmployee> allRegistedEmployees = registedEmployeeDetails.readallReigstedEmployee();
		//System.out.println(loginPassword+loginEmail);
		System.out.println(allRegistedEmployees);
		modelAndView.setViewName("login");

		return modelAndView;

	}
	@RequestMapping(value="/createlogin",method=RequestMethod.POST)

	public ModelAndView createLoginDetails(HttpServletResponse response, @RequestParam("loginemail")  String loginEmail, @RequestParam("loginpassword")    String loginPassword, HttpSession session) throws IOException{

		ModelAndView modelAndView = new ModelAndView();
		List<RegistedEmployee> allRegistedEmployees = registedEmployeeDetails.readallReigstedEmployee();
		//System.out.println(loginPassword+loginEmail);
		List<String>eemail =allRegistedEmployees.stream().map(RegistedEmployee::getEemail).collect(Collectors.toList());
		List<String>epassword=allRegistedEmployees.stream().map(RegistedEmployee::getEpassword).collect(Collectors.toList());
		List<String>role=allRegistedEmployees.stream().map(RegistedEmployee::getYourField).collect(Collectors.toList());
		System.out.print(epassword);
		System.out.println(eemail);
		for (int i = 0; i < eemail.size(); i++) {
			if (eemail.get(i).equals(loginEmail) && epassword.get(i).equals(loginPassword) && !role.get(i).equals("Role_Admin") ) {
				ModelAndView mv = new ModelAndView();
				System.out.println("ABOVE FIND BY METHOD");
				Optional<RegistedEmployee> registedEmployee =registedEmployeeDetails.findEmployeeByGmail(loginEmail);

				if (registedEmployee.isPresent()) {
					RegistedEmployee registeredEmployee = registedEmployee.get();
					int eid = registeredEmployee.getEID();
					session.setAttribute("eid",eid);
					System.out.println(eid);
				} else {
					System.out.println("Employee is not found");
				}

//				System.out.println("EID IN LOGINDETAILS"+EID);
				System.out.println("EEMAIL"+loginEmail);
				session.setAttribute("loginemail",loginEmail);

				//mv.addObject("allRegistedEmployees", allRegistedEmployees);
//				session.setAttribute("");

//

				//	System.out.println("LoginEmailIS ANshika"+loginEmail);
				//	session.setAttribute("LoginEmail",loginEmail);
				//	mv.addObject("LoginEmail",loginEmail);
				LocalDate logInDay=LocalDate.now();
				//LocalDate logInDay = LocalDate.of(2020,12,11);
				//registedEmployeeDetails.updatelogInDay(loginEmail,logInDay);

//				String login=(String)session.getAttribute("loginemail");
//				System.out.println("MMMMM"+login);
//				Optional<RegistedEmployee>allRegistedEmployee=registedEmployeeDetails.findEmployeeByGmail(loginEmail);
//
//				RegistedEmployee registedEmployee2=allRegistedEmployee.orElseGet(null);
//
//
//				String Ename=registedEmployee2.getEname();
//
//				mv.addObject("Ename",Ename);
				mv.setViewName("userfeeds");
				return mv;



			}
			else{
				if(eemail.get(i).equals(loginEmail) && epassword.get(i).equals(loginPassword) && role.get(i).equals("Role_Admin")) {
					ModelAndView mvo = new ModelAndView();
					mvo.setViewName("adminpage");
					return mvo;
				}

				}


		}

		ModelAndView mv = new ModelAndView();
		//mv.addObject("allRegistedEmployees", allRegistedEmployees);
		System.out.println("ok");
		mv.addObject("errorMessage", "Invalid email or password"); // Add error message
		mv.setViewName("login");
		return mv;





	}

	@RequestMapping(value="/post")
	public ModelAndView post(HttpServletResponse response) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("RegistedEmployee", new RegistedEmployee());
		modelAndView.setViewName("userfeeds");

		return modelAndView;


	}
	@RequestMapping(value="/createpost",method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam("Epost") String post,@RequestParam("button") String buttonId,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String loginEmail = session.getAttribute("loginemail").toString();
		System.out.println("INSIDE CREATEPOST");
		System.out.println(post + loginEmail);
//		if(bindingResult.hasErrors()){
//			mv.setViewName("userfeeds");
//		}
		if ("createpost".equals(buttonId)) {
			System.out.println("INSIDE CREATEPOST BUTTON");
			registedEmployeeDetails.persistPost(post, loginEmail);
			mv.setViewName("redirect:/post");
		}  else if ("viewmypost".equals(buttonId)) {
			System.out.println("INSIDE ViewMyPost BUTTON");
			Optional<RegistedEmployee> registedEmployee = registedEmployeeDetails.findEmployeeByGmail(loginEmail);
			Integer firstEmployeeId = registedEmployee.map(RegistedEmployee::getEID)
					.orElse(-1); // Default value if Optional is empty
			System.out.println("First Employee ID: " + firstEmployeeId);
			Optional<List<UserFeeds>> viewMyallPost = registedEmployeeDetails.findPostsByEid(firstEmployeeId);
			if (viewMyallPost.isPresent()) {
				mv.addObject("viewMyallPost", viewMyallPost.get());
			}
			System.out.println("INSIDE VIEWMYPOST" + viewMyallPost);
			mv.setViewName("viewmyposts");


		}    else if ("viewotherapprovedusers".equals(buttonId)){
			Optional<RegistedEmployee> registedEmployee = registedEmployeeDetails.findEmployeeByGmail(loginEmail);
			Integer firstEmployeeId = registedEmployee.map(RegistedEmployee::getEID)
					.orElse(-1); // Default value if Optional is empty
			List<UserFeeds> allAdminApprovedFeeds= registedEmployeeDetails.findAdminApprovedPost();

				mv.addObject("allAdminApprovedFeeds", allAdminApprovedFeeds);
			    mv.setViewName("adminapprovedusers");





		}


		else {
			mv.setViewName("redirect:/post");
		}
		return mv;

	}



}
