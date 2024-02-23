package mrs.riverjach.allerplusloinaveckotlin.threads

class Threading : Thread() {
    override fun run() {
        for (i in 1..3) {
            println("${Thread.currentThread()} : $i")
            Thread.sleep(500)
        }
    }
}