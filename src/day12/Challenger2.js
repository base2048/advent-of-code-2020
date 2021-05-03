const Direction = require('./Direction');
const Position = require('./Position');
const Vector = require('./Vector');
const Ship = require('./Ship');

const Challenger2 = class extends Ship {

    constructor() {
        super();
        this._waypoint = new Position(10, 1);
    }

    moveShip(command) {
        this.position.x += this.waypoint.x * command.value;
        this.position.y += this.waypoint.y * command.value;
    }

    moveWaypoint(command) {
        const direction = Direction.cardinalPoints[command.action];
        const vector = new Vector({ direction, length: command.value });
        this.waypoint.addVector(vector);
    }

    rotateWaypoint(command) {
        this.waypoint.rotateAround({ rotateTo: command.action, angle: command.value });
    }

    executeCommand(command) {
        switch (command.action) {
            case 'N':
            case 'E':
            case 'S':
            case 'W': this.moveWaypoint(command);
                break;
            case 'F': this.moveShip(command);
                break;
            case 'L':
            case 'R': this.rotateWaypoint(command);
                break;
        }
    }

    get waypoint() {
        return this._waypoint;
    }
}

module.exports = Challenger2;
