package www.dream.cdp.FactoryPattern;

import java.util.Optional;

import www.dream.model.FInsu;
import www.dream.model.Insu;
import www.dream.model.VINsu;

public class InsuFactory {
	/** FactoryPattern */
	public static Optional<Insu> createInsu(String insuType) {

		switch (insuType) {
		case "Car":
			return Optional.of(new VINsu());
		case "House":
			return Optional.of(new FInsu());
		}
		return Optional.empty();

	}
}
