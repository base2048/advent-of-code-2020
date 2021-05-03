const Direction = class {

    constructor(coords) {
        this._x = coords.x;
        this._y = coords.y;
    }

    change({ turnTo, angle }) {
        const ticks = angle / 90;
        const currentFacingCoords = { x: this.x, y: this.y };

        const turnNumberOfTicksRight = (currentFacing, ticks) => {
            if (ticks == 0) return currentFacing;
            return turnNumberOfTicksRight({ x: currentFacing.y, y: currentFacing.x * -1 }, --ticks);
        }

        const turnNumberOfTicksLeft = (currentFacing, ticks) => {
            if (ticks == 0) return currentFacing;
            return turnNumberOfTicksLeft({ x: currentFacing.y * -1, y: currentFacing.x }, --ticks);
        }

        const newFacingCoords = turnTo === 'R'
            ? turnNumberOfTicksRight(currentFacingCoords, ticks)
            : turnNumberOfTicksLeft(currentFacingCoords, ticks);

        ({ x: this.x, y: this.y } = newFacingCoords);
    }

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

Direction.cardinalPoints = {
    N: { x: 0, y: 1 },
    E: { x: 1, y: 0 },
    S: { x: 0, y: -1 },
    W: { x: -1, y: 0 }
};

module.exports = Direction;
