package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepo;
import com.springboot.serviceIMPL.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeServiceImpl empservice;
	
	
	
@GetMapping("/home")
	public String homePage() {
		return "welcome to employee management";
	}

// add

@PostMapping("/addEmp")
public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
	
	Employee emp=empservice.addEmployee(employee);
	return  new ResponseEntity<Employee>(emp,HttpStatus.CREATED ) ;
}
//delete

@DeleteMapping("/removeEmp/{id}")
public ResponseEntity<String> removeEmployee(@PathVariable int id){
	empservice.removeEmployee(id);
	return  new ResponseEntity<String>("remove sucessfully ", HttpStatus.ACCEPTED ) ;
}

//update 

@GetMapping("/updateEmp/{id}")
public ResponseEntity<String> updateEmployee(@PathVariable int id){
	empservice.updateEmployee(id);
	return  new ResponseEntity<String>("update sucessfully ", HttpStatus.ACCEPTED ) ;
}







//find

@GetMapping("/findEmp/{id}")
 public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){ 
Optional<Employee>emps= empservice.findEmpById(id);
return  new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED ) ;
}
// list 
@GetMapping("/listEmp")
public ResponseEntity<List<Employee>> listOfEmployees(){
	List<Employee> Emp = empservice.getAllEmployee();
	return new ResponseEntity<List<Employee>>(Emp,HttpStatus.ACCEPTED);
}






}
