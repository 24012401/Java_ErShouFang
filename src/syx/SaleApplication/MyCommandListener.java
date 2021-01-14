package syx.SaleApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class MyCommandListener implements ActionListener {
    public abstract void setHname_in(JTextField hname_in);
    public abstract void setHtype_select(JComboBox htype_select);
    public abstract void setHarea_in(JTextField harea_in);
    public abstract void setHprice_in(JTextField hprice_in);
    public abstract void setHfloor_in(JTextField hfloor_in);
    public abstract void setHdirection_select(JComboBox hdirection_select);
    public abstract void setHrenovition_select(JComboBox hrenovition_select);
    public abstract void setBuildingtype_select(JComboBox buildingtype_select);
    public abstract void setHeatingmote_select(JComboBox heatingmote_select);
    public abstract void setLighting_select(JComboBox lighting_select);
    public abstract void setBuildingage_in(JTextField buildingage_in);
    public abstract void setTaxation_in(JTextField taxation_in);
    public abstract void setVillage_in(JTextField village_in);
    public abstract void setElevator_select(JComboBox elevator_select);
    public abstract void setProperty_right_select(JComboBox property_right_select);
    public abstract void setDown_payment_in(JTextField down_payment_in);
    public abstract void setSelling_points_in(JTextField selling_points_in);
    public abstract void setOwner_mentality_in(JTextField owner_mentality_in);
    public abstract void setSuitable_population_in(JTextField suitable_population_in);
    public abstract void setProvince_in(JTextField province_in);
    public abstract void setCities_in(JTextField cities_in);
    public abstract void setRegion_in(JTextField region_in);
    public abstract void setStreet_in(JTextField street_in);
    public abstract void setSpecific_in(JTextField specific_in);

}
