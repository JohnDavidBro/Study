package www.dream.cdp.Factory;

import java.util.Optional;

import www.dream.model.Car;
import www.dream.model.Insu;
import www.dream.model.SleepingPlace;
import www.dream.model.VINsu;
	/** AM 패턴 // SleepingPlace 라고 불리는 것 안의 "Car"와,
	 *  Insu 라고 불리는 것 안의 "VInsu" 값 중 둘중 하나를 해라. */
public class AF4M extends AF {

	@Override
	public Optional<SleepingPlace> createSP() {
		return Optional.of(new Car());
	}

	@Override
	public Optional<Insu> createInsu() {
		return Optional.of(new VINsu());
	}

}
