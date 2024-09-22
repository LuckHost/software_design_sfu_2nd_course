public class RemoteControlToy extends Toy {
  private double range;
  private String controlType;

  public RemoteControlToy(String name, double price, 
    double range, String controlType) {
      super(name, price);
      setRange(range);
      this.controlType = controlType;
  }

  public double getRange() {
      return range;
  }

  public void setRange(double range) {
      if (range > 0) {
          this.range = range;
      } else {
          throw new IllegalArgumentException(
            "The range should be positive.");
      }
  }

  public String getControlType() {
      return controlType;
  }

  public void setControlType(String controlType) {
      this.controlType = controlType;
  }

  @Override
  public String toString() {
      return super.toString() + " RemoteControlToy{" + "range=" + range + 
        ", controlType='" + controlType + '\'' + '}';
  }
}
