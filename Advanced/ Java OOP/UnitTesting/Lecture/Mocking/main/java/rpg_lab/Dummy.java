package rpg_lab;

import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private WeaponInventory possibleLoot;

    public Dummy ( int health, int experience, WeaponInventory possibleLoot ) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
    }@Override
    public Iterable<Weapon> getPossibleLoot () {
        return this.possibleLoot.getInventory ();
    }

    @Override
    public int getHealth () {
        return this.health;
    }

    @Override
    public void takeAttack ( int attackPoints ) {
        if ( this.isDead ( ) ) {
            throw new IllegalStateException ( "Dummy is dead." );
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience () {
        if ( !this.isDead ( ) ) {
            throw new IllegalStateException ( "Target is not dead." );
        }

        return this.experience;
    }
    @Override
    public Weapon dropLoot () {
        if ( !this.isDead ( ) ) {
            throw new IllegalStateException ( "Target is not dead." );
        }

        return this.possibleLoot.dropRandomWeapon ();
    }

    @Override
    public boolean isDead () {
        return this.health <= 0;
    }
}
