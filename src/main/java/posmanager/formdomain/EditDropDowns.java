package posmanager.formdomain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 3/7/17.
 */
public class EditDropDowns {

    private int id;

    private int selectedId;

    private Set<EditDropDown> editDropDown = new HashSet<>();

    public Set<EditDropDown> getEditDropDown() {
        return editDropDown;
    }

    public void setEditDropDown(Set<EditDropDown> editDropDown) {
        this.editDropDown = editDropDown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }
}
