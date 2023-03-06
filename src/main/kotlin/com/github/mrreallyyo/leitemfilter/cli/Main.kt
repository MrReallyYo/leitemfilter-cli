package com.github.mrreallyyo.leitemfilter.cli

import com.github.mrreallyyo.api.ItemFilterMerger
import com.github.mrreallyyo.api.definitions.ItemFilter
import java.io.File


fun main(arguments: Array<String>) {

    val args = Args(arguments)

    //val header = LootFilterAccess.loadFilter(args.header ?: "_header", args.header == null)
    // val footer = LootFilterAccess.loadFilter(args.footer ?: "_footer", args.footer == null)


    val colors = args.secondaryColors?.split(",")?.map { it.toInt() }?.filter { it in 0..17 } ?: listOf(17, 14, 12)

    val compactFilters = args.compactFilters.split(",").map {
        var name = it
        if (!name.endsWith(".xml")) {
            name += ".xml"
        }
        File(name).inputStream().use {
            ItemFilter.load(it)
        }
    }


    val merged = ItemFilterMerger.mergeFilter(
        compactFilters,
        colors
    )

    var output = args.output
    if (!output.endsWith(".xml")) {
        output += ".xml"
    }

    File(output).outputStream().use {
        merged.write(it)
    }

}