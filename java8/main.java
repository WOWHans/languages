import java.util.List;
import java.util.function.Predicate;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class main{
  static int outerScopeNum=0;
  public static void main(String[] args) {
    // Formula formula = new Formula(){
    
    //   @Override
    //   public double calculate(int a) {
    //     return sqrt(a*100);
    //   }
    // };
    Formula formula = (a) -> Math.sqrt(a*100);
  
    System.out.println(formula.sqrt(16));
    System.out.println(formula.calculate(16));


    // lambda expressions
    List<String> names = Arrays.asList("peter","anan","mike");
    // Collections.sort(names, new Comparator<String>() {
    //   @Override
    //   public int compare(String a, String b) {
    //     return a.compareTo(b);
    //   }
    // });
    Collections.sort(names, (a,b)->{ return a.compareTo(b);});
    System.out.println(names);

    // annotation FunctionalInterface
    FunctionalInterfaceTest<String,Integer> test = (from) -> Integer.valueOf(from);
    Integer converted = test.convert("123");
    System.out.println(converted);

    FunctionalInterfaceTest<Integer,String> testScope = (from) -> {
      outerScopeNum = 23;
      int sum = outerScopeNum+from;
      return String.valueOf(sum);
    };
    String testScope_result = testScope.convert(17);
    System.out.println(testScope_result);


    FunctionalInterfaceTest<String,Integer> test_simple = Integer::valueOf;
    Integer converted_simple = test_simple.convert("456");
    System.out.println(converted_simple);

    TestClass testClass = new TestClass();
    FunctionalInterfaceTest<String,String> test_outclass = testClass::startWith;
    String startStr = test_outclass.convert("java");
    System.out.println(startStr);

    PersonFactory<Person> personFactory = Person::new;
    Person person = personFactory.create("Perter", "Parker");
    System.out.println(person.toString());

    // Predicate
    Predicate<String>  predicate = (s) -> s.length() > 0;
    System.out.println(predicate.test("foo"));

  }
  
}
