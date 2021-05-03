const Timer = class {

    constructor() {
        this.timer = 0;
    }
};

Timer.startTimer = _ => this.timer = Date.now();

Timer.getElapsedTime = _ => Date.now() - this.timer;

module.exports = Timer;
