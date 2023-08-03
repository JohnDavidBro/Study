package www.dream.cdp.FactoryPattern;

import www.dream.cdp.Factory.AF;
import www.dream.cdp.Factory.AF4F;
import www.dream.cdp.Factory.AF4M;

public class AFFactory {
	/** FactoryPattern */
	public static AF createAF(String afType) {

		switch (afType) {
		case "M":
			return new AF4M();
		case "F":
			return new AF4F();
		}
		return null;

	}
}
