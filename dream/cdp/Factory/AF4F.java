package www.dream.cdp.Factory;

import java.util.Optional;

import www.dream.model.FInsu;
import www.dream.model.House;
import www.dream.model.Insu;
import www.dream.model.SleepingPlace;
	/** AF 패턴 // SleepingPlace 라고 불리는 것 안의 "House"와,
	 *  Insu 라고 불리는 것 안의 "FInsu" 값 중 둘중 하나를 해라. */
public class AF4F extends AF {
	
	@Override
	public Optional<SleepingPlace> createSP() {
		return Optional.of(new House());
	}

	@Override
	public Optional<Insu> createInsu() {
		return Optional.of(new FInsu());
	}
}
