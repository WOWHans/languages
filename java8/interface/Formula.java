interface Formula {
  double calculate(int a);

  /**
   * default -非抽象方法的实现，类似扩展方法
   * @param a
   * @return
   */
  default double sqrt(int a) {
    return Math.sqrt(a);
  }
}