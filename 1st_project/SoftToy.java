public class SoftToy extends Toy {
  private String material;
  private double softnessLevel;

  public SoftToy(String name, double price, 
    String material, double softnessLevel) {
      super(name, price);
      this.material = material;
      setSoftnessLevel(softnessLevel);
  }

  public String getMaterial() {
      return material;
  }

  public void setMaterial(String material) {
      this.material = material;
  }

  public double getSoftnessLevel() {
      return softnessLevel;
  }

  public void setSoftnessLevel(double softnessLevel) {
      if (softnessLevel >= 1 && softnessLevel <= 10) {
          this.softnessLevel = softnessLevel;
      } else {
          throw new IllegalArgumentException(
            "The softness level should be between 1 and 10."
            );
      }
  }

  @Override
  public String toString() {
      return super.toString() + " SoftToy{" + "material='" + material + '\'' + 
        ", softnessLevel=" + softnessLevel + '}';
  }
}
