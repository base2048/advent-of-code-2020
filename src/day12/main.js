const Timer = require('./Timer');
const Parser = require('./Parser');
const Challenge = require('./Challenge');

const runChallenge = async _ => {

    const challenge = new Challenge(await Parser.parseFile('./data.txt'));

    Timer.startTimer();
    const resultPart1 = challenge.solvePart1();
    const timer1 = Timer.getElapsedTime();
    console.log(`Result part 1: ${resultPart1} | Part 1 took ${timer1} ms`);     // 415

    Timer.startTimer();
    const resultPart2 = challenge.solvePart2();
    const timer2 = Timer.getElapsedTime();
    console.log(`Result part 2: ${resultPart2} | Part 2 took ${timer2} ms`);     // 29401

};

runChallenge();
