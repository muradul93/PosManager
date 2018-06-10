package posmanager.formdomain;



import posmanager.domain.Proclamation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/6/17.
 */
public class FormProclamation {

    private List<Proclamation> proclamations = new ArrayList<>();
    private int size;

    public FormProclamation() {
    }

    public FormProclamation(List<Proclamation> proclamations, int size) {
        this.proclamations = proclamations;
        this.size = size;
    }

    public List<Proclamation> getProclamations() {
        return proclamations;
    }

    public void setProclamations(List<Proclamation> proclamations) {
        this.proclamations = proclamations;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
