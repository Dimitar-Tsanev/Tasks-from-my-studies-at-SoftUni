class Vehicle{
    constructor(type, model, parts,fuel ){
        this.type = type;
        this.model = model;
        this.parts = {
            ...parts,
            quality: parts.engine * parts.power,
        }
        this.fuel = fuel;
    }
    drive(consumption){
        this.fuel -= consumption;
    }
}
