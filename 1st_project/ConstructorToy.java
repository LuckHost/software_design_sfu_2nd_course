public class ConstructorToy extends Toy {
  private int pieces;
  private String theme;

  public ConstructorToy(String name, double price, int pieces, String theme) {
      super(name, price);
      setPieces(pieces);
      this.theme = theme;
  }

  public int getPieces() {
      return pieces;
  }

  public void setPieces(int pieces) {
      if (pieces > 0) {
          this.pieces = pieces;
      } else {
          throw new IllegalArgumentException(
            "The number of parts must be positive."
            );
      }
  }

  public String getTheme() {
      return theme;
  }

  public void setTheme(String theme) {
      this.theme = theme;
  }

  @Override
  public String toString() {
      return super.toString() + " ConstructorToy{" + "pieces=" + 
        pieces + ", theme='" + theme + '\'' + '}';
  }
}
