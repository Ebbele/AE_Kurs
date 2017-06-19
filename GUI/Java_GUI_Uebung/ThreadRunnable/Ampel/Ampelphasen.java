package ThreadRunnable.Ampel;

public enum Ampelphasen {
	NONE(0_000), 
	GREEN(2_000), 
	YELLOW(2_000),
	RED(2_000), 
	RED_YELLOW(2_000), 
	YELLOW_BLINK(0_000);

	int duration;

	private Ampelphasen(int duration) {
		this.duration = duration;
	}

	private int next() {
		return (ordinal() + 1) % Ampelphasen.values().length;
	}
	
	public Ampelphasen getNextPhase() {
		return values()[next()];
	}
}
