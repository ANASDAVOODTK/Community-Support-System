package com.live.clg_project.Model;

import java.util.ArrayList;

public class LocalBodyModel {

    ArrayList<LocalBodyModel.data> data;

    public ArrayList<LocalBodyModel.data> getData() {
        return data;
    }

    public void setData(ArrayList<LocalBodyModel.data> data) {
        this.data = data;
    }

    public class data
    {
        String Houses;
        String Males;
        String Females;
        String Children;
        String Adults;
        String Aged;

        public String getHouses() {
            return Houses;
        }

        public void setHouses(String houses) {
            Houses = houses;
        }

        public String getMales() {
            return Males;
        }

        public void setMales(String males) {
            Males = males;
        }

        public String getFemales() {
            return Females;
        }

        public void setFemales(String females) {
            Females = females;
        }

        public String getChildren() {
            return Children;
        }

        public void setChildren(String children) {
            Children = children;
        }

        public String getAdults() {
            return Adults;
        }

        public void setAdults(String adults) {
            Adults = adults;
        }

        public String getAged() {
            return Aged;
        }

        public void setAged(String aged) {
            Aged = aged;
        }
    }
}
