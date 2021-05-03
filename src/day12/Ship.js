const Direction = require('./Direction');
const Position = require('./Position');

const Ship = class {

    constructor() {
        this._position = new Position(0, 0);
        this._direction = new Direction(Direction.cardinalPoints.E);
    }

    executeCommands(commands) {
        commands.forEach(c => this.executeCommand(c));
    }

    get position() {
        return this._position;
    }

    get direction() {
        return this._direction;
    }
}

module.exports = Ship;
