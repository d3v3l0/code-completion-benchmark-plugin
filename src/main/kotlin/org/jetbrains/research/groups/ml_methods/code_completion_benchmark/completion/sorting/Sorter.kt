package org.jetbrains.research.groups.ml_methods.code_completion_benchmark.completion.sorting

import com.intellij.codeInsight.completion.CompletionFinalSorter
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher
import com.intellij.openapi.project.Project

import com.intellij.openapi.util.Pair
import org.jetbrains.research.groups.ml_methods.code_completion_benchmark.completion.ngram.NGram

@Suppress("DEPRECATION")
class CompletionSorterFactory : CompletionFinalSorter.Factory {
    override fun newSorter() = Sorter()
}

class Sorter : CompletionFinalSorter() {

    private fun rankItems(items: MutableIterable<LookupElement>): MutableIterable<LookupElement> {
        //TODO: implement ranking
        return items
    }

    override fun sort(items: MutableIterable<LookupElement>, parameters: CompletionParameters): MutableIterable<LookupElement> {
        val sorted = rankItems(items)
        return sorted
    }

    override fun getRelevanceObjects(elements: MutableIterable<LookupElement>): Map<LookupElement, MutableList<Pair<String, Any>>> {
        return elements.associateWith { listOf(Pair.create("", "" as Any)).toMutableList() }
    }

    private inner class NGramWeighter(parameters: CompletionParameters): LookupElementWeigher("ngram_weighter") {
        val project: Project
        val nGram: NGram

        init {
            val origPosition = parameters.position
            project = origPosition.project
            nGram = NGram.getNGramForElement(origPosition)
        }
    }
}