package ine5633.eightpuzzlesolver;

import ine5633.eightpuzzlesolver.model.Node;
import ine5633.eightpuzzlesolver.tools.ArrayTools;

/**
 * Main class
 * <br>Test class: {@link MainTest}
 * <br>@author feekosta
 *
 */
public class Main {

	public Main() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	public static void main(String[] args) throws Exception {
		Long start = System.currentTimeMillis();
		//Integer[][] state = new Integer[][]{{null,7,8},{5,6,3},{4,1,2}};
		Integer[][] state = new Integer[][]{{7,8,5},{6,3,4},{1,2,null}};
		Integer[][] objective = new Integer[][]{{1,2,3},{4,5,6},{7,8,null}};
		EightPuzzleSolver eightPuzzleSolver = new EightPuzzleSolver(objective);
		Node solv = eightPuzzleSolver.solv(state);
		System.out.println("\nFINALIZED IN "+(System.currentTimeMillis()-start)+" MILLIS");
		System.out.println("EVALUATED NODES: "+eightPuzzleSolver.getEvaluatedNodes());
		System.out.println("MAX NODES IN FRONTIER: "+eightPuzzleSolver.getMaxNodeInFrontier());
		System.out.println("LEVELS: "+solv.getLevel());
		System.out.println("\nSOLUTION:");
		ArrayTools.print(solv);
	}
}

