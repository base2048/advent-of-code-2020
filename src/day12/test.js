const Parser = require('./Parser');
const Challenge = require('./Challenge');

const input = `F10
N3
F7
R90
F11`;

const challenge = new Challenge(Parser.parseText(input));

const resultPart1 = challenge.solvePart1();     // 25
const resultPart2 = challenge.solvePart2();     // 286

console.log("Part1 Test passed: " + (resultPart1 === 25));
console.log("Part2 Test passed: " + (resultPart2 === 286));
