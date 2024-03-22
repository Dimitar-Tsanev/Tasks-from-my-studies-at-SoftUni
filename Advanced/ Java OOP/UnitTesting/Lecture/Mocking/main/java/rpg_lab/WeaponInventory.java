package rpg_lab;

public interface WeaponInventory {
    void addWeapon( Weapon weapon);
    Weapon dropRandomWeapon();
    Iterable<Weapon> getInventory();
}
