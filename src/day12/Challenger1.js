const Direction = require('./Direction');
const Position = require('./Position');
const Vector = require('./Vector');
const Ship = require('./Ship');

const Challenger1 = class extends Ship {

    constructor() {
        super();
    }

    moveShip(command) {
        const direction = command.action === 'F' ? this.direction : Direction.cardinalPoints[command.action];
        const vector = new Vector({ direction, length: command.value });
        this.position.addVector(vector);
    }

    turnShip(command) {
        this.direction.change({ turnTo: command.action, angle: command.value });
    }

    executeCommand(command) {
        switch (command.action) {
            case 'N':
            case 'E':
            case 'S':
            case 'W':
            case 'F': this.moveShip(command);
                break;
            case 'L':
            case 'R': this.turnShip(command);
                break;
        }
    }
}

module.exports = Challenger1;
