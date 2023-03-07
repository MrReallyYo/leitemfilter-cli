package com.github.mrreallyyo.leitemfilter.cli

import com.github.mrreallyyo.api.ItemFilterMerger
import com.github.mrreallyyo.api.MergerOptions
import com.github.mrreallyyo.api.definitions.ItemFilter
import java.io.File


private fun loadFilter(name: String?): ItemFilter? {
    if (name == null) return null
    var name = name
    if (!name.endsWith(".xml")) {
        name += ".xml"
    }
    val file = File(name)
    return file.inputStream().use {
        ItemFilter.load(it).apply { fileName = file.nameWithoutExtension }
    }
}

fun main(arguments: Array<String>) {

    val args = Args(arguments)

    val header = loadFilter(args.header)
    val footer = loadFilter(args.footer)
    val colors = args.colors.split(",").map { it.toInt() }.filter { it in 0..17 }
    val baseFilters = args.baseFilters.split(",").mapNotNull {
        loadFilter(it)
    }

    val opts = MergerOptions(
        header = header,
        useEmbeddedHeader = !args.skipHeader,
        footer = footer,
        useEmbeddedFooter =  !args.skipFooter,
        baseFilters = baseFilters,
        generateRules = args.generateRules,
        multiplayerColors = colors,
        overrideColors = args.overrideColors,
        ruleLimit = args.ruleLimt
    )


    val merged = ItemFilterMerger(opts).mergeFilter()

    var output = args.output
    if (!output.endsWith(".xml")) {
        output += ".xml"
    }

    File(output).outputStream().use {
        merged.write(it)
    }

}