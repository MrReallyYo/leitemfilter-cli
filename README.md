# Last Epoch Item Filter CLI

Its currently intended to simplify strict filtering of different bases with affixes.
Affix rules will be combined with bases rules and generate new combined rules.

Named rules and rules with multiple conditions are kept.

Also supports merging of multiple filter files and recoloring of secondary filter rules.
This may or not be something useful for the multiplayer patch.

TL;DR: I am trying to figure out how to make a proper filter for me and my friends.



# Usage
> java -jar leitemfilter-cli-*.*.jar -cf player1,player2 -o multiplayer

*Example filters and the result can be found under releases*

# Example 

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
