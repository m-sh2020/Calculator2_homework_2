package mshcalculator;

class ElementNode extends Element {
	private double value;

	public ElementNode(double v) {
		this.value = v;
	}

	public boolean set(Element left, Element right, Operation op) {
		return false;
	}

	public double calculate() {
		return value;
	}
}