package gamesolver;

import java.io.IOException;
import java.util.List;

public interface BoggleSolver {
	List<String> solve(Board board) throws IOException;
}
