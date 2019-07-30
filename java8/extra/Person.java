public class Person {
  private String firstName;
  private String lastName;

  Person() {
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  @Override
  public String toString() {
    return firstName+" "+lastName;
  }
}