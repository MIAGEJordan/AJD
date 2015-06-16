//package web;
//package main.java.web;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Car;
//
//import org.springframework.hateoas.ResourceSupport;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import dto.CarDTO;
//
//@Controller
//public class MyRentController implements RentService{
//
//	List<Car> cars = new ArrayList<Car>();	// repr�sente base de dojnn�es
//	
//	public MyRentController(){
//		Car car = new Car();
//		car.setPlateNumber("11AA22");
//		car.setRented(false);		
//		cars.add(car);
//		car = new Car();
//		car.setPlateNumber("22BB33");
//		car.setRented(false);		
//		cars.add(car);
//	}
//	
//	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public ResourceSupport get() {
//		
//		return null;
//	}
//
//	/**
//	*
//	* @return all cars not rented
//	*/
//	@RequestMapping(value = "/car", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public List<CarDTO> getCars() {
//		CarDTO carDTO;
//		List<CarDTO> dtos = new ArrayList<CarDTO>();
//		for(Car car : cars){
//			if(car.isRented() == false){
//				carDTO = new CarDTO(car);
//				dtos.add(carDTO);
//			}
//		}
//		return dtos;
//	}
//
//	/**
//	* Return specifications of a car.
//	* @param plateNumber
//	* @return car specifications only (if not rented)
//	* @throws Exception no car with this plate number
//	*/
//	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public CarDTO getCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
//		int  i = 0;
//		while(i<cars.size() && cars.get(i).getPlateNumber().equals(plateNumber)==false){
//			i++;
//		}
//		if(i < cars.size()){
//			return new CarDTO(cars.get(i));
//		} else {
//			throw new Exception("No car with such a plate number");
//		}
//	}
//
//	/**
//	* Rent a car.
//	* @param plateNumber
//	* @return car specifications
//	* @throws Exception no car with this plate number or already rented
//	*/
//	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.OK)
//	@Override
//	public void rentCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
//		int  i = 0;
//		while(i<cars.size() && cars.get(i).getPlateNumber().equals(plateNumber)==false){
//			i++;
//		}
//		if(i < cars.size()){
//			if(cars.get(i).isRented() == false){
//				cars.get(i).setRented(true);
//			} else {
//				throw new Exception("Car already rented");
//			}
//		} else {
//			throw new Exception("No car with such a plate number");
//		}
//	}
//
//	/**
//	*
//	** @return actions to be done
//	* @throws Exception no car with this plate number or not rented
//	*/
//	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.OK)
//	@Override
//	public void renderCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
//		int  i = 0;
//		while(i<cars.size() && cars.get(i).getPlateNumber().equals(plateNumber)==false){
//			i++;
//		}
//		if(i < cars.size()){
//			if(cars.get(i).isRented() == true){
//				cars.get(i).setRented(false);
//			} 
//		} else {
//			throw new Exception("No car with such a plate number");
//		}
//	}
//
//}
