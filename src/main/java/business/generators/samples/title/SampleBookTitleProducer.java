package business.generators.samples.title;

import javax.enterprise.inject.Produces;

import persistence.qualifiers.Fake;
import persistence.qualifiers.Real;

public class SampleBookTitleProducer {

	
	@Produces @Fake
	public String produceFakeBookTitle() {
		return "this is fake title";

	}
	@Produces @Real
	public String produceRealBookTitle() {
		return "Begining JavaEE";

	}
}
