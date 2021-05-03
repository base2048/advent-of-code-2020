const Position = class {

    constructor(x, y) {
        this._x = x;
        this._y = y;
    }

    addVector(vector) {
        this.x += vector.direction.x * vector.length;
        this.y += vector.direction.y * vector.length;
    }

    rotateAround({ rotateTo, angle }) {
        const ticks = angle / 90;
        const currentPosition = { x: this.x, y: this.y };

        const rotateNumberOfTicksRight = (currentPos, ticks) => {
            if (ticks === 0) return currentPos;
            return rotateNumberOfTicksRight({ x: currentPos.y, y: currentPos.x * -1 }, --ticks);
        }

        const rotateNumberOfTicksLeft = (currentPos, ticks) => {
            if (ticks === 0) return currentPos;
            return rotateNumberOfTicksLeft({ x: currentPos.y * -1, y: currentPos.x }, --ticks);
        }

        const newPosition = rotateTo === 'R'
            ? rotateNumberOfTicksRight(currentPosition, ticks)
            : rotateNumberOfTicksLeft(currentPosition, ticks);

        ({ x: this.x, y: this.y } = newPosition);
    };

    get x() {
        return this._x;
    }

    set x(x) {
        if (typeof x === 'undefined' || isNaN(parseFloat(x)) || !isFinite(x))
            throw TypeError('Value to be set must be a number!')
        this._x = x;
        return this;
    }

    get y() {
        return this._y;
    }

    set y(y) {
        if (typeof y === 'undefined' || isNaN(parseFloat(y)) || !isFinite(y))
            throw TypeError('Value to be set must be a number!')
        this._y = y;
        return this;
    }
};

Position.getManhattanDistance = ({ position1, position2 }) => {
    return Math.abs(position1.x - position2.x) + Math.abs(position1.y - position2.y);
};

module.exports = Position;
