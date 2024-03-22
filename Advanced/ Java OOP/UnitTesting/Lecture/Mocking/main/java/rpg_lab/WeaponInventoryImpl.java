package rpg_lab;

import java.util.*;

public class WeaponInventoryImpl implements WeaponInventory {
    private List<Weapon> weapons;
    public WeaponInventoryImpl ( Weapon... weapons) {
        this.setWeapons ( weapons );
    }
    private void setWeapons(Weapon... weapons){
        if (weapons == null){
            throw new NoSuchElementException ( "No weapon to add!" );
        }
        if (weapons.length == 0){
           this.weapons = new ArrayList<> ();
        }
        this.weapons.addAll ( List.of ( weapons ) );
    }
    public void addWeapon( Weapon weapon){
        this.weapons.add ( weapon );
    }
    public Weapon dropRandomWeapon(){
        if (this.weapons.isEmpty ()){
            throw new IllegalStateException ( "Inventory is empty" );
        }
        Random random = new Random ();
        int index = random.nextInt ( this.weapons.size ());
        return this.weapons.remove ( index );
    }
    @Override
    public Iterable<Weapon> getInventory () {
        return Collections.unmodifiableCollection ( this.weapons );
    }
}
