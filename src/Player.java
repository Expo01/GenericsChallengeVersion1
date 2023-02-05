public abstract class Player { //class is eventually just a constructor for non-abstract subclasses
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
