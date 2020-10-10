package mshcalculator;

abstract class Element {
	public static enum Operation {
		MULTIPLY, DIVIDE, ADD, SUBTRACT
	};
	public abstract boolean set(Element left, Element right, Operation op);
	public abstract double calculate();
}