package com.io.nology;

public class runner {

    private int energy = 0;
    private int milesRun = 0;
    private int  daysSlept = 0;
    private boolean isHungry = false;
    private boolean needsTheLoo = false;
    private boolean isDead = false;

    public String run(int miles) {
        //    - reduces energy level by 1 for every two miles run.
//            - if has run 10 miles, isHungry becomes true
//            - if has run 14 miles, needsTheLoo becomes true
//            - if isHungry or needsTheLoo, the runner can't run until this is fixed
//            - if the runner has no energy, the runner dies.

        if (isHungry || needsTheLoo) {
        }
        this.milesRun += miles;
        int energyImpact = miles / 2;
        this.energy -= energyImpact;
        if(milesRun % 10 == 0) isHungry = true;
        if(milesRun % 14 == 0) needsTheLoo = true;
        checkIsDead();
    }

    public void eat() {
        this.isHungry = false;
        this.energy -= 1;
        checkIsDead();
    }

    public void wee(){
        this.needsTheLoo = false;
        this.energy -= 1;
        checkIsDead();
    }

    public void sleep(){
        this.energy = 10;
        this.daysSlept += 1;
    }

    private void checkIsDead () {
        if(this.energy <= 0) {
            this.isDead = true;
            //throw is dead
        }
    }

}
