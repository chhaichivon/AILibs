
    package de.upb.crc901.mlplan.evaluablepredicates.mlplan.classifier.clustering.GradientBoostingClassifier;

    import de.upb.crc901.mlplan.evaluablepredicates.mlplan.NumericRangeOptionPredicate;

    /*
        subsample : float, optional (default=1.0)
        The fraction of samples to be used for fitting the individual base
        learners. If smaller than 1.0 this results in Stochastic Gradient
        Boosting. `subsample` interacts with the parameter `n_estimators`.
        Choosing `subsample < 1.0` leads to a reduction of variance
        and an increase in bias.


    */
    public class OptionsFor_GradientBoostingClassifier_subsample extends NumericRangeOptionPredicate {
        
        @Override
        protected double getMin() {
            return 1
                ;
        }

        @Override
        protected double getMax() {
            return 1
                ;
        }

        @Override
        protected int getSteps() {
            return -1
                ;
        }

        @Override
        protected boolean needsIntegers() {
            return false; // already set by generator
        }

        @Override
        protected boolean isLinear() {
			return true;
		}
    }
    
