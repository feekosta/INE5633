package ine5633.eightpuzzlesolver.tools;

import java.util.Arrays;

/**
 * Classe utilizada para duplicar um array bidimensional
 * Test class: {@link ArrayCopyTest}
 * @author feekosta
 */
public class ArrayCopy {
	
	public ArrayCopy() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static Integer[][] deepCopy(Integer[][] original) {
	    final Integer[][] result = new Integer[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}

}
