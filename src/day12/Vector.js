const Vector = class {

    constructor({ direction, length }) {
        this._direction = direction;
        this._length = length;
    }

    get direction() {
        return this._direction;
    }

    get length() {
        return this._length;
    }
};

module.exports = Vector;
