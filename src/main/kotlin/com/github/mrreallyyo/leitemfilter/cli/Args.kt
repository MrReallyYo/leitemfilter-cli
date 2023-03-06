package com.github.mrreallyyo.leitemfilter.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

class Args(args: Array<String>) {

    val parser = ArgParser("leitemfilter")

    val compactFilters by parser.option(ArgType.String, shortName = "cf", description = "Compact filter containing the affixes, bases and extra named rules. Can contain multiple files separated by \",\".").required()
    val output by parser.option(ArgType.String, shortName = "o", description = "Output file").required()
    val secondaryColors by parser.option(ArgType.String, shortName = "sc", description = "Overwrites the colors of secondary filters with the given color/colors. Can contain multiple colors separated by \",\".")
    val header by parser.option(ArgType.String, shortName = "h", description = "Header file")
    val footer by parser.option(ArgType.String, shortName = "f", description = "Footer file")

    init {
        parser.useDefaultHelpShortName = false
        parser.parse(args)
    }

}