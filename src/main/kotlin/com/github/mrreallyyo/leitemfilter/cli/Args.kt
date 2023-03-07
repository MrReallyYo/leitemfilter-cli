package com.github.mrreallyyo.leitemfilter.cli

import com.github.mrreallyyo.api.MergerOptions
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required

class Args(args: Array<String>) {

    val parser = ArgParser("leitemfilter")

    val baseFilters by parser.option(
        ArgType.String,
        shortName = "b",
        description = "The base filter to work with. Can contain multiple files separated by\",\" e.g. for multiplayer."
    ).required()
    val output by parser.option(ArgType.String, shortName = "o", description = "The generated output filter file")
        .required()

    val skipRuleGeneration by parser.option(
        ArgType.Boolean,
        shortName = "sr",
        description = "Skips generation of rules based affixes/bases scheme."
    )
        .default(!MergerOptions.defaultGenerateRules)

    val header by parser.option(
        ArgType.String,
        shortName = "h",
        description = "A header file containing rules like showing all uniques. A default is included and will be used by default."
    )
    val skipHeader by parser.option(
        ArgType.Boolean,
        shortName = "sh",
        description = "Skip header rules."
    )
        .default(!MergerOptions.defaultUseEmbeddedHeader)
    val footer by parser.option(
        ArgType.String,
        shortName = "f",
        description = "A footer file containing rules like hiding all items. A default is included and will be used by default."
    )
    val skipFooter by parser.option(
        ArgType.Boolean,
        shortName = "sf",
        description = "Skip footer rules."
    )
        .default(!MergerOptions.defaultUseEmbeddedFooter)

    val skipColors by parser.option(
        ArgType.Boolean,
        shortName = "or",
        description = "Skips override of colors from secondary filters."
    )
        .default(!MergerOptions.defaultOverrideColors)
    val colors by parser.option(
        ArgType.String,
        shortName = "c",
        description = "The colors of secondary filters with the given color/colors. Can contain multiple colors separated by \",\"."
    ).default(MergerOptions.defaultMultiplayerColors.joinToString(","))

    val ruleLimt by parser.option(
        ArgType.Int,
        shortName = "r",
        description = "The limit of rules for the final filter."
    ).default(MergerOptions.defaultRuleLimit)

    init {
        parser.useDefaultHelpShortName = false
        parser.parse(args)
    }
}