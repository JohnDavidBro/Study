package www.dream.cdp.Factory;

import java.util.Optional;

import www.dream.model.Insu;
import www.dream.model.SleepingPlace;
	/** AF Factory 패턴 // SleepingPlace와 Insu 안에 값 중 둘중 하나를 해라. */
public abstract class AF {
	public abstract Optional<SleepingPlace> createSP();
	public abstract Optional<Insu> createInsu();
		
}
