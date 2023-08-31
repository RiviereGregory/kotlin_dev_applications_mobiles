package mrs.riverjach.console.mesclasses.innerclass

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }

}