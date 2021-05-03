const Position = require('./Position');
const ShipFactory = require('./ShipFactory');

const Challenge = class {

    constructor(commands) {
        this._commands = commands;
        this._shipPartOne = ShipFactory.create({ shipType: 'partOne' });
        this._shipPartTwo = ShipFactory.create({ shipType: 'partTwo' });
    }

    solvePart1() {
        this._shipPartOne.executeCommands(this._commands);
        return Position.getManhattanDistance({
            position1: new Position(0, 0),
            position2: this._shipPartOne.position
        });
    }

    solvePart2() {
        this._shipPartTwo.executeCommands(this._commands);
        return Position.getManhattanDistance({
            position1: new Position(0, 0),
            position2: this._shipPartTwo.position
        });
    }
}

module.exports = Challenge;
