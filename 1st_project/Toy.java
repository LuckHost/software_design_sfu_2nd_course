import java.util.Objects;

public class Toy {
  private String name;
  private double price;

  // Конструктор по умолчанию
  public Toy() {
      this.name = "Unknown";
      this.price = 0.0;
  }

  // Конструктор с параметрами
  public Toy(String name, double price) {
      this.name = name;
      setPrice(price); // Используем метод setPrice для проверки
  }

  // Геттеры и сеттеры
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public double getPrice() {
      return price;
  }

  public void setPrice(double price) {
      if (price >= 0) {
          this.price = price;
      } else {
          throw new IllegalArgumentException(
            "The price should be positive.");
      }
  }

  // Переопределение методов equals(), hashCode(), toString()
  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Toy toy = (Toy) obj;
      return Double.compare(toy.price, price) == 0 && name.equals(toy.name);
  }

  @Override
  public int hashCode() {
      return Objects.hash(name, price);
  }

  @Override
  public String toString() {
      return "Toy{" + "name='" + name + '\'' + ", price=" + price + '}';
  }
}
