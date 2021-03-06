package autofe.algorithm.hasco.evaluation;

import org.api4.java.common.attributedobjects.ObjectEvaluationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import autofe.algorithm.hasco.filter.meta.FilterPipeline;
import autofe.util.DataSet;
import autofe.util.EvaluationUtils;

public class EnsembleObjectEvaluator extends AbstractHASCOFEObjectEvaluator {
	private static final Logger logger = LoggerFactory.getLogger(EnsembleObjectEvaluator.class);

	@Override
	public Double evaluate(final FilterPipeline pipeline) throws InterruptedException, ObjectEvaluationFailedException {
		logger.info("Applying and evaluating pipeline {}", pipeline);
		long startTimestamp = System.currentTimeMillis();
		DataSet dataSet = pipeline.applyFilter(this.data, false);

		logger.debug("Applied pipeline. Starting benchmarking...");
		try {
			double ensembleScore = EvaluationUtils.performEnsemble(dataSet.getInstances());
			double finalScore = ensembleScore - ATT_COUNT_PENALTY * EvaluationUtils.calculateAttributeCountPenalty(this.data.getInstances());

			logger.debug("Ensemble benchmark result: {}", finalScore);

			this.storeResult(pipeline, finalScore, (System.currentTimeMillis() - startTimestamp));
			return 1 - finalScore;
		} catch (Exception e) {
			throw new ObjectEvaluationFailedException("Could not evaluate ensemble.", e);
		}
	}
}
