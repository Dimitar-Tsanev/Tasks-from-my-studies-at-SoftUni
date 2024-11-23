package game_store.data.entities.DTOs;

import java.util.Set;

public class EditGameDTO {

    private Long id;

    private Set<String> values;

    public EditGameDTO ( Long id, Set<String> values ) {
        this.id = id;
        this.values = values;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public Set<String> getValues () {
        return values;
    }

    public void setValues ( Set<String> values ) {
        this.values = values;
    }
}
