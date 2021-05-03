const Challenger1 = require('./Challenger1');
const Challenger2 = require('./Challenger2');

const ShipFactory = class {

    constructor() {
        if (this instanceof ShipFactory) throw TypeError('This class is not instantiable!')
    }
};

ShipFactory.create = config => ({
    'partOne': new Challenger1(),
    'partTwo': new Challenger2()
})[config.shipType];

module.exports = ShipFactory;
