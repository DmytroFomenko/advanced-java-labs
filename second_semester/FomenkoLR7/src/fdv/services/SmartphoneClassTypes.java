package fdv.services;

public enum SmartphoneClassTypes {

    FLAGSHIP(11),
    SUB_FLAGSHIP(12),
    BUDGET(21);

    int codType;


    SmartphoneClassTypes(int codType) {
        this.codType = codType;
    }

    public int getCodType() {
        return codType;
    }
}
