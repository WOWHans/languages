package me.nithans.groovy.basis

class MatcherTest {
    static void main(String[] args) {
        /**
         * <p>
         *     1. 使用 ~ 定义正则表达式，打印出来的reg类型为 Pattern 类型而不是个字符串
         *     2. = 和 ~ 之间存在空格；
         *     3. groovy存在 =~ 操作符号 返回的是Matcher类型；
         *     4. 也存在 ==~ 操作符，后面跟正则表达式，返回的是Boolean类型
         * </p>
         */
        def reg1 = ~'he*llo'
        def reg2 = ~/(你有)?[\d,\.]+\.?\d+(元可用)?/
        println "reg1 type is ${reg1.class}"
        println "reg2 type is ${reg2.class}"
        println "hello".matches(reg1)
        println "你有55,000元可用".matches(reg2)

        def  matcher=":677"=~/[^\d]*(\d+)[^\d]*/
        println matcher.class
        println matcher.matches()
        println matcher.group(1)


        def matcherDo = "个人信息"=~'.*信息'
        println matcherDo.class
        println matcherDo.matches()
        println matcherDo.groupCount()
        println matcherDo.group()

        def matcherNum = "开啊你有55,000元可用" =~ /(.*你有)?[\d,\.]+\.?\d+(元可用)?/
        println matcherNum.class
        println matcherNum.matches()
    }
}
