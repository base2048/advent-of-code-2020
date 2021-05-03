const fs = require('fs').promises;

const Parser = class {
};

const parseInstruction = instruction => ({ action: instruction[0], value: parseInt(instruction.slice(1)) });

Parser.parseText = data => data.split('\n').map(parseInstruction);

Parser.parseFile = async filePath => {
    const data = await fs.readFile(filePath, { encoding: 'utf-8' });
    return data.split('\n').map(parseInstruction);
};

module.exports = Parser;
