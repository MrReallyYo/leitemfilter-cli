# Last Epoch Item Filter CLI

Its currently intended to simplify strict filtering of different bases with affixes.
Affix rules will be combined with bases rules and generate new combined rules.

Named rules and rules with multiple conditions are kept.

Also supports merging of multiple filter files and recoloring of secondary filter rules.
This may or not be something useful for the multiplayer patch.

TL;DR: I am trying to figure out how to make a proper filter for me and my friends.

# Usage
> java -jar leitemfilter-cli-*.*.jar -b player1,player2 -o multiplayer

*Example filters and the result can be found under releases*

# Options
```
    --baseFilters, -b -> The base filter to work with. Can contain multiple files separated by"," e.g. for multiplayer. (always required) { String }
    --output, -o -> The generated output filter file (always required) { String }
    --gr, -Generate rules with the affixes/bases scheme. [true]
    --header, -h -> A header file containing rules like showing all uniques. A default is included and will be used by default. { String }
    --sh, -Skip header rules. [false]
    --footer, -f -> A footer file containing rules like hiding all items. A default is included and will be used by default. { String }
    --sf, -Skip footer rules. [false]
    --or, -Override filter colors from secondary filters [true]
    --colors, -c [17,14,12] -> The colors of secondary filters with the given color/colors. Can contain multiple colors separated by ",". { String }
    --ruleLimt, -r [75] -> The limit of rules for the final filter. { Int }
    --help -> Usage info
```

# Example (outdated)

**Input**
> Filters (e.g. your own and of another player once multiplayer hits) that contain some static rules and rules for affixes and bases.
<img src="images/player1.png?raw=true" width="512">
<img src="images/player2.png?raw=true" width="512">

**Output**
> Generates a filter with all static rules and combines affix/base rules for strict filtering of items.
> Secondary filters will be recolored to a single color.
<img src="images/merge1.png?raw=true" width="512">
<img src="images/merge2.png?raw=true" width="512">
<img src="images/merge3.png?raw=true" width="512">
