package rpg_lab;

public class Hero {

    private String name;
    private int experience;
    private WeaponInventory inventory;
    private Weapon weapon;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new WeaponInventoryImpl ();
    }
    public Iterable<Weapon> getInventory () {
        return this.inventory.getInventory ();
    }

    public void putWeaponInInventory ( Weapon weapon){
        this.inventory.addWeapon ( weapon );
    }
    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.putWeaponInInventory ( target.dropLoot () );
        }
    }
}
