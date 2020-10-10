package mshcalculator;

import java.util.ArrayList;
import java.util.Scanner;

import mshcalculator.Element.Operation;

public class Test {

	public static void main(String[] args) {
		String str = "";
		Scanner scan = new Scanner(System.in);

		System.out.print("������� ���������:\n");
		str = scan.nextLine();
		ArrayList<Element> tokens = SpisokCalc.tokenize(str);
		SpisokCalc.SpisokUpdate(tokens, Operation.MULTIPLY, Operation.DIVIDE);
		SpisokCalc.SpisokUpdate(tokens, Operation.ADD, Operation.SUBTRACT);
		Element result = tokens.get(0);
		double itog = result.calculate();
		if (Double.isInfinite(itog)) {
			System.out.println("������� �� 0 ������������");
		} else {
			System.out.println("��������� = " + itog);
		}
		scan.close();
	}
}
