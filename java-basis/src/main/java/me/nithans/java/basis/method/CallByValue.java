package me.nithans.java.basis.method;

/**
 * 值调用，基本数据类型单值调用；
 * 对象引用涉及到对对象实例的修改会发生变化，传入对象的引用，而方法体使用的是对象引用的拷贝，
 * 因为传入的引用和拷贝的引用指向同一个对象实例
 */
public class CallByValue {


    public static void main(String[] args) {
        int num1,num2;
        num1=1;num2=2;
        swap(num1,num2);
        System.out.println("num1 ="+num1);
        System.out.println("num2 ="+num2);

        Person tom = new Person("tom","male");
        Person anna = new Person("anna","female");
        swapPerson(tom, anna);
        System.out.println("tom's sex:"+tom.getSex());
        System.out.println("anna's sex:"+anna.getSex());
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    private static void swapSex(Person tomCopy, Person annaCopy) {
        String tomSex = tomCopy.getSex();
        String annaSex = annaCopy.getSex();
        tomCopy.setSex(annaSex);
        annaCopy.setSex(tomSex);
        System.out.println("tomCopy's sex:"+tomCopy.getSex());
        System.out.println("annaCopy's sex:"+annaCopy.getSex());
    }

    private static void swapPerson(Person tomCopy, Person annaCopy) {
        Person temp = tomCopy;
        tomCopy = annaCopy;
        annaCopy = tomCopy;
        System.out.println("tomCopy's sex:"+tomCopy.getSex());
        System.out.println("annaCopy's sex:"+annaCopy.getSex());
    }

    private static class Person {
        private String name;
        private String sex;

        public Person(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
