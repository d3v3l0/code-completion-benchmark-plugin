package org.jetbrains.research.groups.ml_methods.code_completion_benchmark.ngram.completion.core.model.ngrams


import org.jetbrains.research.groups.ml_methods.code_completion_benchmark.ngram.completion.core.model.base.Model
import org.jetbrains.research.groups.ml_methods.code_completion_benchmark.ngram.completion.core.model.base.PredictionWithConf
import org.jetbrains.research.groups.ml_methods.code_completion_benchmark.ngram.counter.Counter
import org.jetbrains.research.groups.ml_methods.code_completion_benchmark.ngram.counter.storage.MapTrieCounter
import java.io.File

class JMModel(
        order: Int = 6,
        private val lambda: Double = DEFAULT_LAMBDA,
        counter: Counter = MapTrieCounter()
) : NGramModel(order, counter) {

    override fun modelWithConfidence(subList: List<Int>, counts: LongArray): PredictionWithConf {
        val count = counts[0]
        val contextCount = counts[1]

        // Probability calculation
        val MLE = count / contextCount.toDouble()
        return PredictionWithConf(MLE, this.lambda)
    }


    override fun load(directory: File): Model {
        return JMModel()
    }

    override fun save(directory: File) {

    }

    companion object {

        private val DEFAULT_LAMBDA = 0.5
    }
}