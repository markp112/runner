package com.io.nology;

public class Runner {

    private int energy = 0;
    private int milesRun = 0;
    private int  daysSlept = 0;
    private boolean isHungry = false;
    private boolean needsTheLoo = false;
    private boolean isDead = false;
    private String message = "run has run " + milesRun + " miles and has " + energy + " energy remaining" + " and has slept for " + daysSlept + " days";

    public Runner(int energy) throws InvalidEnergyLevel {
        if (energy >=0 && energy <=10 ) {
            this.energy = energy;
        } else {
            throw new InvalidEnergyLevel("Starting energy must be between 0 and 10");
        }
    }

    public String run(int miles) {
        //    - reduces energy level by 1 for every two miles run.
//            - if has run 10 miles, isHungry becomes true
//            - if has run 14 miles, needsTheLoo becomes true
//            - if isHungry or needsTheLoo, the runner can't run until this is fixed
//            - if the runner has no energy, the runner dies.

        if (isHungry) {
            //throw can't run error
            message ="Runner is hungry";
            return message;
        }
        if(needsTheLoo) {
            message ="Runner needs to wee";
            return message;
        }
        this.milesRun += miles;
        int energyImpact = miles / 2;
        this.energy -= energyImpact;
        if(this.milesRun % 10 == 0) isHungry = true;
        if(this.milesRun % 14 == 0) needsTheLoo = true;
        if (checkIsDead()) {
            message = "The runner has died";
            return message;
        }
        message = "The runner has run " + milesRun + " miles and has " + energy + " energy remaining" + " and has slept for " + daysSlept + " days";
        return message;
    }

    public String eat() {
        this.isHungry = false;
        this.energy -= 1;
        if (checkIsDead()) {
            message = "The runner has died";
            return message;
        }
        message = "Runner has eaten and ";
        message += "has run " + milesRun + " miles and has " + energy + " energy remaining" + " and has slept for " + daysSlept + " days";
        return message;
    }

    public String wee(){
        this.needsTheLoo = false;
        this.energy -= 1;
        if (checkIsDead()) {
            message = "The runner has died";
            return message;
        }
        message = "runner had a wee and ";
        message += "has run " + milesRun + " miles and has " + energy + " energy remaining" + " and has slept for " + daysSlept + " days";
        return message;
    }

    public String sleep(){
        this.energy = 10;
        this.daysSlept += 1;
        message = "runner has slept and ";
        message += "has run " + milesRun + " miles and has " + energy + " energy remaining" + " and has slept for " + daysSlept + " days";
        return message;
    }

    private boolean checkIsDead () {
        return (this.energy <= 0) ? true : false;
            //throw is dead
    }
}
