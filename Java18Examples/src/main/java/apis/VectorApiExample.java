package apis;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
//Für Eclipse RUN CONFIGURATION: --add-modules jdk.incubator.vector
//Ausführen auf Konsole java --add-modules jdk.incubator.vector VectorApiExample

public class VectorApiExample {
	public static void main(final String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8 };

		var c = new int[a.length];
		var vectorA = IntVector.fromArray(IntVector.SPECIES_256, a, 0);
		var vectorB = IntVector.fromArray(IntVector.SPECIES_256, b, 0);
		var vectorC = vectorA.add(vectorB);
		// var vectorC = vectorA.mul(vectorB);
		vectorC.intoArray(c, 0);

		System.out.println(vectorC);

	}

	void scalarComputation(float[] a, float[] b, float[] c) {
		for (int i = 0; i < a.length; i++) {
			c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
		}
	}

	static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

	void vectorComputation(float[] a, float[] b, float[] c) {
		int i = 0;
		int upperBound = SPECIES.loopBound(a.length);
		for (; i < upperBound; i += SPECIES.length()) {
			// FloatVector va, vb, vc;
			var va = FloatVector.fromArray(SPECIES, a, i);
			var vb = FloatVector.fromArray(SPECIES, b, i);
			var vc = va.mul(va).add(vb.mul(vb)).neg();
			vc.intoArray(c, i);
		}

		for (; i < a.length; i++) {
			c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
		}
	}
}