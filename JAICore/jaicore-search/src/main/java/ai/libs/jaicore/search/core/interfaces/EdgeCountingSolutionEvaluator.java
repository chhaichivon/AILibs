package ai.libs.jaicore.search.core.interfaces;

import org.api4.java.common.attributedobjects.IObjectEvaluator;

import ai.libs.jaicore.search.model.other.SearchGraphPath;

/**
 * Uses Double to be compliant with algorithms that MUST work with double instead of Integer (such as AStar)
 *
 * @author fmohr
 *
 * @param <N>
 */
public class EdgeCountingSolutionEvaluator<N, A> implements IObjectEvaluator<SearchGraphPath<N, A>, Double> {

	@Override
	public Double evaluate(final SearchGraphPath<N, A> solutionPath) {
		return solutionPath.getNodes().size() * 1.0;
	}
}
