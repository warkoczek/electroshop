package pl.pozsda19.electroshop.domain;


public enum Category {

    CZESCIZAMIENNE("CZESCIZAMIENNE"), TECHNIKAPOMIAROWA("TECHNIKAPOMIAROWA")
    , AKCESORIA_OSPRZET("AKCESORIA/OSPRZET"), ELEKTRONARZEDZIA("ELEKTRONARZEDZIA");

    public String label;

    Category(String label) {
        this.label = label;
    }


    @Override
    public String toString() {
        return label;
    }
}
