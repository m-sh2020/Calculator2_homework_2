package mshcalculator;

import java.util.ArrayList;

public class SpisokCalc extends Element {

	private Element left = null;
	private Element right = null;
	private Operation op;

	public SpisokCalc(Operation op) {
		this.op = op;
	}

	public boolean set(Element left, Element right, Operation op) {
		if (this.op == op) {
			this.left = left;
			this.right = right;
			return true;
		}
		return false;
	}

	public double calculate() {
		double l = left == null ? 0 : left.calculate();
		double r = right == null ? 0 : right.calculate();
		switch (this.op) {
		case MULTIPLY:
			return (l * r);
		case DIVIDE:
			return (l / r);
		case SUBTRACT:
			return (l - r);
		default:
			return (l + r);
		}
	}

	public static ArrayList<Element> tokenize(String str) {
		int i = 0, p = 0;
		int l = str.length();
		ArrayList<Element> tokens = new ArrayList<Element>();
		while (i < l) {
			SpisokCalc s;
			switch (str.charAt(i)) {
			case '*':
				s = new SpisokCalc(Operation.MULTIPLY);
				break;
			case '/':
				s = new SpisokCalc(Operation.DIVIDE);
				break;
			case '+':
				s = new SpisokCalc(Operation.ADD);
				break;
			case '-':
				s = new SpisokCalc(Operation.SUBTRACT);
				break;
			default:
				i++;
				continue;
			}

			double value = Double.parseDouble(str.substring(p, i));
			p = ++i;
			tokens.add(new ElementNode(value));
			tokens.add(s);
		}

		double value = Double.parseDouble(str.substring(p));
		tokens.add(new ElementNode(value));
		return tokens;
	}

	public static void SpisokUpdate(ArrayList<Element> tokens, Operation op, Operation op2) {
		for (int i = tokens.size() - 2; i >= 1; i--) {
			Element node = tokens.get(i);
			if ((node.set(tokens.get(i - 1), tokens.get(i + 1), op))|| (node.set(tokens.get(i - 1), tokens.get(i + 1), op2))) {
				tokens.remove(i + 1);
				tokens.remove(i - 1);
				i--;
			}
		}
	}
}