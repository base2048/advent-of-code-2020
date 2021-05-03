## [AoC 2020 Day 16: Ticket Translation](https://adventofcode.com/2020/day/16)

Part one, pretty straight forward: tic-tac-toe -> done -> champagne - um, cookies for everyone.

Part two: much more keystrokes, very much more... (takes almost more than just champagne). In short: first all valid tickets are filtered out with *getValidTickets()*. Then with *groupValuesByPosition()* all values of one position are grouped:

>- Group **0**
>    - Value of pos **0** from ticket 0 
>    - Value of pos **0** from ticket 1
>    - ...
>- Group **1**
>    - Value of pos **1** from ticket 0
>    - Value of pos **1** from ticket 1
>    - ...
>- ...

The index positions of the groups in their parent list correspond to the positions on the ticket. Next, with *assignPotentialFieldNamesToPosition()* a Map is created whose keys represent the field-positions and whose values contain a list of all possible field-names. By now at least one position must already contain a list with only one possible and thus definitive field name. In the last step, the recursive method *determineFieldNames()* determines all field names and assigns them to their positions.

Since complex streams are not everyone's business, here an alternative variant to *assignPotentialFieldNamesToPosition()*:

```Java
private Map<Integer, List<String>> assignPotentialFieldNamesToPosition(List<List<Integer>> groupedValues) {
    Map<Integer, List<String>> fieldNamesAtPosition = new HashMap<>();

    for (int i = 0; i < groupedValues.size(); i++) {
        List<String> fieldNames = new ArrayList<>();

        for (Rule rule : rules)
            if (groupedValues.get(i).stream().allMatch(rule::isValueValid))
                fieldNames.add(rule.getFieldName());

        fieldNamesAtPosition.put(i, fieldNames);
    }
    return fieldNamesAtPosition;
}
```

Personally I prefer to use streams, as long as they are readable and don't cost too much in runtime.

---

![AoC 2020 Day 16](day16--Ticket_Translation.png?raw=true)
