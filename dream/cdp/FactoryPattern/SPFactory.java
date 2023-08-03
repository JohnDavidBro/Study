package www.dream.cdp.FactoryPattern;

import java.util.Optional;

import www.dream.model.Car;
import www.dream.model.House;
import www.dream.model.SleepingPlace;

public class SPFactory {
	/** FactoryPattern */
	public static Optional<SleepingPlace> createVehicle(String carType) {
		
		switch (carType) {
		case "Car" :
			return Optional.of(new Car());
		case "House" :
			return Optional.of(new House());
		}
		return Optional.empty();
	
}
}
