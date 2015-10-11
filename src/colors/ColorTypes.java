package colors;

public enum ColorTypes {
	RED(1, 3.4), BLUE(2, 0.0), GREEN(3, 1.0), YELLOW(4, 8.0);
	private final Integer number;
	private final Double cost;

	private ColorTypes(Integer number, Double cost) {
		this.number = number;
		this.cost= cost;
	}

	public Integer getNumber() {
		return this.number;
	}
	Double getCost(){
		return this.cost;
	}

}
