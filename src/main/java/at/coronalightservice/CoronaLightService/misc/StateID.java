package at.coronalightservice.CoronaLightService.misc;

public enum StateID {

    Burgenland (1L),
    Kärten (2L),
    Niederösterreich (3L),
    Oberösterreich (4L),
    Salzburg (5L),
    Steiermark (6L),
    Tirol (7L),
    Vorarlberg (8L),
    Wien (9L);

    private final Long ID;
    private static String name;

    public static Long getIdByName(String name) {
        StateID.name = name;
        return StateID.valueOf(name).getId();
    }

    public Long getId() {
        return ID;
    }

    StateID(Long id) {
        this.ID = id;
    }
}
