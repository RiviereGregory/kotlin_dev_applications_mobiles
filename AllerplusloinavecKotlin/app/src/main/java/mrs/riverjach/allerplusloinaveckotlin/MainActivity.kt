package mrs.riverjach.allerplusloinaveckotlin

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mrs.riverjach.allerplusloinaveckotlin.activities.FrameLayoutActivity
import mrs.riverjach.allerplusloinaveckotlin.activities.LayoutActivity
import mrs.riverjach.allerplusloinaveckotlin.activities.ProgressBarActivity
import mrs.riverjach.allerplusloinaveckotlin.activities.SecondActivity
import mrs.riverjach.allerplusloinaveckotlin.activities.SwipeRefreshActivity
import mrs.riverjach.allerplusloinaveckotlin.activities.WebViewActivity
import mrs.riverjach.allerplusloinaveckotlin.db.Database
import mrs.riverjach.allerplusloinaveckotlin.model.User
import mrs.riverjach.allerplusloinaveckotlin.model.UserForBD
import mrs.riverjach.allerplusloinaveckotlin.parser.GetData
import mrs.riverjach.allerplusloinaveckotlin.services.HttpServiceJson
import mrs.riverjach.allerplusloinaveckotlin.services.HttpServiceString
import mrs.riverjach.allerplusloinaveckotlin.threads.Threading
import mrs.riverjach.allerplusloinaveckotlin.utils.Armes
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure.Unite.description
import mrs.riverjach.allerplusloinaveckotlin.utils.filterArrayInt
import mrs.riverjach.allerplusloinaveckotlin.utils.filterArrayIntMultiplek
import mrs.riverjach.allerplusloinaveckotlin.utils.filterMulitple
import mrs.riverjach.allerplusloinaveckotlin.utils.filterMultiple3
import mrs.riverjach.allerplusloinaveckotlin.utils.filterPair
import mrs.riverjach.allerplusloinaveckotlin.utils.filterPositif
import mrs.riverjach.allerplusloinaveckotlin.utils.isEvent
import mrs.riverjach.allerplusloinaveckotlin.utils.swap
import mrs.riverjach.allerplusloinaveckotlin.utils.switch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.Arrays

private const val SEPARATOR = "###### ###### #####"

class MainActivity : AppCompatActivity() {

    val PERMISSION_CALL_PHONE = 0

    val helloWorldLazy: TextView by lazy {
        println("Initialisation de helloWorldLazy")
        findViewById(R.id.hello_world) as TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        println(SEPARATOR)
        println("###### enumClass #####")
        println(SEPARATOR)
        enumClass()
        println(SEPARATOR)
        println("###### sealedClass #####")
        println(SEPARATOR)
        sealedClass()
        println(SEPARATOR)
        println("###### highOrderFunction #####")
        println(SEPARATOR)
        highOrderFunction()
        println(SEPARATOR)
        println("###### lambdaFunction #####")
        println(SEPARATOR)
        lambdaFunction()
        println(SEPARATOR)
        println("###### elvisOperator #####")
        println(SEPARATOR)
        elvisOperator()
        println(SEPARATOR)
        println("###### collectionList #####")
        println(SEPARATOR)
        collectionList()
        println(SEPARATOR)
        println("###### collectionSet #####")
        println(SEPARATOR)
        collectionSet()
        println(SEPARATOR)
        println("###### collectionMap #####")
        println(SEPARATOR)
        collectionMap()
        println("###### Lazy init #####")
        println(SEPARATOR)
        println(helloWorldLazy.text)
        println(helloWorldLazy.text)
        println("###### Lazy init 2#####")
        println(SEPARATOR)
        lazyInit()
        print(SEPARATOR)
        println(SEPARATOR)
        println("###### Fonction Extension #####")
        print(SEPARATOR)
        println(SEPARATOR)
        println("###### Custom 1 #####")
        fonctionExtensionCustom1()
        println("###### Custom 2 #####")
        fonctionExtensionCustom2()
        println("###### Custom 3 #####")
        fonctionExtensionCustom3()
        println("###### Native Kotlin #####")
        fonctionExtensionNativeKotlin()
        println(SEPARATOR)
        println("###### i18n #####")
        println(SEPARATOR)
        fonctionI18n()
        println(SEPARATOR)
        println("###### fragment #####")
        println(SEPARATOR)
        fonctionFragment()
        println(SEPARATOR)
        println("###### frame layout #####")
        println(SEPARATOR)
        fonctionFrameLayout()
        println(SEPARATOR)
        println("###### Permissions #####")
        println(SEPARATOR)
        fonctionPermissions()
        println(SEPARATOR)
        println("###### ProgressBar #####")
        println(SEPARATOR)
        fonctionProgressBar()
        println(SEPARATOR)
        println("###### Swipe refresh layout #####")
        println(SEPARATOR)
        fonctionSwipeRefresh()
        println(SEPARATOR)
        println("###### WebView #####")
        println(SEPARATOR)
        fonctionWebView()
        println(SEPARATOR)
        println("###### HTTP #####")
        println(SEPARATOR)
        fonctionHttp()
        println(SEPARATOR)
        println("###### Database #####")
        println(SEPARATOR)
        fonctionDatabase()
        println(SEPARATOR)
        println("###### Thread Use #####")
        println(SEPARATOR)
        println("${Thread.currentThread()} a été  exécuté.")
        println(SEPARATOR)
        println("###### Thread Use #####")
        println(SEPARATOR)
        fonctionThread()
        println("###### Coroutines #####")
        println(SEPARATOR)
        fonctionCoroutines()
        println("###### Coroutines Portée #####")
        println(SEPARATOR)
        fonctionCoroutinesPortee()
        println("###### Coroutines Suspend #####")
        println(SEPARATOR)
        fonctionCoroutinesSuspend()
        println(SEPARATOR)
        println("###### Coroutines Channels #####")
        println(SEPARATOR)
        fonctionCoroutinesChannels()
        println(SEPARATOR)
    }

    private fun fonctionCoroutinesChannels() {
        fonctionChannel()
        fonctionChannelProducerConsumer()
        fonctionChannelProducerConsumerPipeline()
    }

    private fun fonctionChannelProducerConsumerPipeline() =
        runBlocking {
            val numbers = produceNumbers()
            val square = produceSquares(numbers)
            for (i in 1..10) print(square.receive())
            println("done!!")
            square.cancel() // arret des coroutines
            numbers.cancel()
        }

    fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce()
    {
        var x = 1
        while (true) {
            print("*")
            send(x++)
        }
    }

    fun CoroutineScope.produceSquares(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce()
    {
        for (x in numbers) {
            print("#")
            send(x * x)
        }
    }

    private fun fonctionChannelProducerConsumer() =
        runBlocking {
            val square = produceSquares(10)
            square.consumeEach {
                print("$it/")
            }
            println("done!!")
        }

    fun CoroutineScope.produceSquares(n: Int): ReceiveChannel<Int> = produce()
    {
        for (x in 1..n) {
            print("*")
            send(x * x)
        }
    }

    private fun fonctionChannel() =
        runBlocking {
            val channel = Channel<Int>()
            launch {
                for (x in 1..5) channel.send(x * x)
            }
            repeat(5) { println(channel.receive()) }

            println("done !")
        }

    private fun fonctionCoroutinesSuspend() =
        runBlocking {
            launch {
                doWorld()
            }
            println("Hello,")

        }

    suspend private fun doWorld() { // suspend permet d'utiliser delay
        delay(1000)
        println("World!")
    }


    private fun fonctionCoroutinesPortee() =
        runBlocking {
            launch {
                delay(200)
                print("Thread: ${Thread.currentThread().name} ==>")
                println("Task from runBlocking")
            }

            coroutineScope {
                launch {
                    delay(500)
                    print("Thread: ${Thread.currentThread().name} ==>")
                    println("Task from nesed launch")
                }
                delay(100)
                print("Thread: ${Thread.currentThread().name} ==>")
                println("Task from coroutinescope")
            }
            print("Thread: ${Thread.currentThread().name} ==>")
            println("Coroutine scope is over")
        }

    private fun fonctionCoroutines() =
        runBlocking { // utisation explicite du caractère bloquant de la focntion
            val start = System.currentTimeMillis()
            val job = GlobalScope.launch {
                delay(1000)
                println("Thread: ${Thread.currentThread().name}")
                println("World!")
                println("Temps d'execution coroutine : ${System.currentTimeMillis() - start} ms")
            }
            println("Thread: ${Thread.currentThread().name}")
            println("Hello,")
            job.join() // permet d'attendre que l'execution de job ce finisse
            println("Temps d'execution UI Thread : ${System.currentTimeMillis() - start} ms")
        }

    private fun fonctionThread() {
        val start = System.currentTimeMillis()
        val t1 = Threading()
        val t2 = Threading()
        t1.start()
        t1.join() // t1 doit finir avant de passer à un autre thread
        t2.start()
        t2.join() // t2 doit finir avant de passer à un autre thread
        for (i in 1..3) {
            println("${Thread.currentThread()} : $i")
        }
        println("durée d'exécution : ${System.currentTimeMillis() - start}")
    }

    private fun fonctionDatabase() {
        val button: Button = findViewById(R.id.databseButton)
        button.setOnClickListener {
            val database = Database(this)
            if (database.getUserCount() == 0) {
                database.createUser(UserForBD("Tom", 16, "tom@domain.fr"))
                database.createUser(UserForBD("Charlotte", 21, "charlotte@domain.fr"))
                database.createUser(UserForBD("Morgane", 24, "morgane@domain.fr"))
            }
            val users = database.getAllUsers()
            for (user in users) {
                println("Utilisateur lu la BDD: $user")
            }
        }
    }

    private fun fonctionHttp() {
        httpString()

        httpJson()
    }

    private fun httpString() {
        val button: Button = findViewById(R.id.httpButton)
        button.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://httpbin.org")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
            val service: HttpServiceString = retrofit.create(HttpServiceString::class.java)
            val call = service.getUserAgent()
            call.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    println("Erreur communication serveur :${t.message}")
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    println("Réponse serveur : ${response.code()} / ${response.body()}")
                }
            })
        }
    }

    private fun httpJson() {
        val button: Button = findViewById(R.id.httpJsonButton)
        button.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://httpbin.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service: HttpServiceJson = retrofit.create(HttpServiceJson::class.java)
            val call = service.getUserInfo()
            call.enqueue(object : Callback<GetData> {
                override fun onFailure(call: Call<GetData>, t: Throwable) {
                    println("Erreur communication serveur :${t.message}")
                }

                override fun onResponse(call: Call<GetData>, response: Response<GetData>) {
                    val getData = response?.body()
                    println()
                    println("Réponse serveur : ${response.code()} / ${getData?.ip} - ${getData?.url}")
                }
            })
        }
    }

    private fun fonctionWebView() {
        val button: Button = findViewById(R.id.webViewButton)
        button.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fonctionSwipeRefresh() {
        val button: Button = findViewById(R.id.swipeRefresh)
        button.setOnClickListener {
            val intent = Intent(this, SwipeRefreshActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fonctionProgressBar() {
        val button: Button = findViewById(R.id.progressBar)
        button.setOnClickListener {
            val intent = Intent(this, ProgressBarActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fonctionPermissions() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(500)

        println("###### Permissions dangereuse #####")
        val callPhone: Button = findViewById(R.id.callPhone)
        callPhone.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    PERMISSION_CALL_PHONE
                )
            } else {
                call()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CALL_PHONE -> {
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    call()
                }
            }
        }
    }

    private fun call() {
        val callIntent = Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:0123456789")
        )
        startActivity(callIntent)
    }

    private fun fonctionFrameLayout() {
        val button: Button = findViewById(R.id.startFrameLayout)
        button.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fonctionFragment() {
        val button: Button = findViewById(R.id.startFragment)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fonctionI18n() {
        val button: Button = findViewById(R.id.startRecette)
        button.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            startActivity(intent)
        }
    }


    private fun fonctionExtensionNativeKotlin() {
        println(" ==> LET")
        println("    Permet de vérifier que la variable est != null")
        println("    Ex : File(\"config\").let{ file -> ... ")
        println(" ==> APPLY")
        println("    Permet d executer unlambda sur un objet et d'affecter le résutat")
        println("    Ex : var file = File(\"config\")..apply{mkdir()} ")
        println(" ==> WITH")
        println("    Permet de modifier plusieurs variable d'un objet")
        println("    Ex : var paint = Paint() ")
        println("    with(paint) { ")
        println("       alpha = 130 ")
        println("       color = color.RED ")
        println("       strokeWidth = 2.0f} ")
        println(" ==> RUN")
        println("    combinaison de LET et WITH")
        println("     - restreindre la portée")
        println("     - appeler une variable sans avoir à la référencer explicitement")
        println("    Ex : var monString = StringBuilder().run{ ")
        println("       append(\"koltin\") ")
        println("       append(\"et Java sont\") ")
        println("       append(2) ")
        println("       append(\" langages inter-operable\") ")
        println("       toString() } ")
        println(" ==> USE")
        println("    Permet de fermer automatiquement les objet Closeable")
        println("    Ex : val outPutStreamWriter = OutPutStreamWriter(file) ")
        println("         outPutStreamWriter.use{ ")
        println("            properties.store(it,null) ")
        println("            println(\"Sauvegarde effecuée\" ")
        println("         } ")
    }

    private fun fonctionExtensionCustom3() {
        val monTextView = findViewById(R.id.hello_world) as TextView
        val myTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(p0: Long) {
                monTextView.switch()
            }

            override fun onFinish() {
                println("Timer is finish")
            }
        }
        myTimer.start()
    }

    private fun fonctionExtensionCustom2() {
        val maList = mutableListOf<Int>(1, 2, 5, 10, 20, 40, 100)
        println(maList)
        maList.swap(0, 3)
        println("Swap list index 0 and 3")
        println(maList)
    }

    private fun fonctionExtensionCustom1() {
        println(21.isEvent())
        val age = 56
        println(age.isEvent())
    }

    private fun lazyInit() {
        val user = User("Tom", "tomtom@kotlin.com")
        println("premier appel :")
        println(user.sports)
        println("deuxième appel :")
        println(user.sports)

    }

    private fun collectionMap() {
        val maMap = mutableMapOf(
            44000 to "NANTES",
            44110 to "SOUDAN",
            44600 to "SAINT-NAZAIRE"
        )
        println(maMap)
        maMap.put(44400, "REZE")
        println(maMap)
        println("Valeur correspondant à la clé 44600 : ${maMap[44600]}")
        // Utilisation key et map[key]
        for (key in maMap.keys) {
            println("clé : $key => valeur : ${maMap[key]}")
        }
        // Utilisation entry
        for (entry in maMap.entries) {
            println("clé : ${entry.key} ==> valeur : ${entry.value}")
        }
        // Utilisation key et value
        for ((key, value) in maMap) {
            println("clé : $key ===> valeur : $value")
        }

    }

    private fun collectionSet() {
        val monSet = mutableSetOf("Tom", 1500, "Charlotte", 28.56, "Morgane", 1200)
        val monSet2 = mutableSetOf(2, 5, 9, 18, 1, 5, 22, 50, 3)
        // Permet d'avoir un type Pair avec le prédicat vrai
        // et l'autre avec les autre élément
        val maListPartion = monSet.partition { it is String }
        println(maListPartion)
        println(maListPartion.first)
        println(maListPartion.second)
        // Permet de coupé la liste en collection plus petite
        val maListChunked = monSet2.sorted().chunked(3)
        println(maListChunked)
        for (i in 0..maListChunked.size - 1) {
            println(maListChunked[i])
        }
    }

    private fun collectionList() {
        exempleList1()
        exempleList2()
        exempleList3()
    }

    private fun exempleList1() {
        val maList = listOf(5, 10, 20, 50, 100, 200, 500)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 2 : ${maList[2]}")
        println("Le dernier élément : ${maList.last()}")
        println("Index de l'Elément 200 : ${maList.indexOf(200)}")
        println("Index de l'Elément 1000 : ${maList.indexOf(1000)}")
    }

    private fun exempleList2() {
        val maList = listOf(20, "Tom", 1250.30)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 0 : ${maList[0]}")
        println("Contient \"Bob\" ? : ${maList.contains("Bob")}")
        println("Contient \"Tom\" ? : ${maList.contains("Tom")}")
    }

    private fun exempleList3() {
        val maList = mutableListOf<Int>(5, 10, 20, 50, 100, 200, 500)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 6 : ${maList[6]}")
        println("Contient 1000 : ${maList.contains(1000)}")
        maList.add(40)
        maList.add(100)
        maList.add(1000)
        println(maList)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 6 : ${maList[6]}")
        println("Contient 1000 : ${maList.contains(1000)}")
        maList.remove(100)
        println(maList)
        maList.add(10)
        maList.add(300)
        maList.add(10)
        maList.add(300)
        println(maList)
        // remove tous les 10
        maList.removeAll { it == 10 }
        println(maList)
        maList.add(10)
        maList.add(300)
        maList.add(10)
        maList.add(300)
        println(maList)
        // filtre au dessus de 10
        val maList2 = maList.filter { it > 10 }
        println(maList2)
        // filtre au dessus ou égale de 10 et modulo 3
        val maList3 = maList.filter { it >= 10 }
            .filter { it % 3 == 0 }
        println(maList3)
        // mélange aléatoire
        val maListHazard = maList.shuffled()
        println(maListHazard)
        // tri ascendent
        val maListSorted = maList.sorted()
        println(maListSorted)
        // tri descendent
        val maListSortedDes = maList.sortedDescending()
        println(maListSortedDes)

    }

    private fun elvisOperator() {
        var name: String? = null
        var sizeElvis: Int? = name?.length ?: -1
        println(sizeElvis)

        val user1 = User(null, null)
        val user2 = User("Tom", null)
        val user3 = User("Tom", "tomtom@kotlin.com")

        user1.updateName("bob")
        user2.updateName(null)

        try {
            user3.updateEmail(null)
        } catch (e: Exception) {
            println(e.message)
        }
        try {
            user1.updateEmail("bobbob@kotlin.com")
        } catch (e: Exception) {
            println(e.message)
        }

        println("user1 : ${user1.name} ; ${user1.email}")
        println("user2 : ${user2.name} ; ${user2.email}")
        println("user3 : ${user3.name} ; ${user3.email}")


    }

    private fun lambdaFunction() {
        val numbers = arrayOf(-121, -119, -57, -50, -8, -6, 0, 3, 5, 7, 51, 58, 68, 99, 122)
        println("Tableau initial : ${Arrays.toString(numbers)}")
        val numbersPositif = numbers.filter { it >= 0 }
        println("Tableau filtre positif avec lambda : ${Arrays.toString(numbersPositif.toIntArray())}")
        val numbersPositifMultiple3 = (numbers.filter { it >= 0 }).filter { it % 3 == 0 }
        println(
            "Tableau filtre positif + Multiple 3 avec lambda : ${
                Arrays.toString(
                    numbersPositifMultiple3.toIntArray()
                )
            }"
        )

        val numbersPair = numbers.filter { it % 2 == 0 }
        numbersPair.forEach { print("v=$it ;") }
        println()
        numbersPair.forEachIndexed { index, valeur -> print("i=$index/v=$valeur ;") }
        println()
        numbersPair.forEachIndexed { index, _ -> print("j=${2 * index + 1} ;") }
        println()

    }

    private fun highOrderFunction() {
        val numbers = arrayOf(-121, -119, -57, -50, -8, -6, 0, 3, 5, 7, 51, 58, 68, 99, 122)
        println("Tableau initial : ${Arrays.toString(numbers)}")
        val numbersPositif = filterArrayInt(numbers, ::filterPositif)
        println("Tableau filtre positif : ${Arrays.toString(numbersPositif)}")
        val numbersPair = filterArrayInt(numbers, ::filterPair)
        println("Tableau filtre Pair : ${Arrays.toString(numbersPair)}")
        val numbersMultiple3 = filterArrayInt(numbers, ::filterMultiple3)
        println("Tableau filtre Multiple 3 : ${Arrays.toString(numbersMultiple3)}")
        val numbersPositifMultiple3 =
            filterArrayInt(filterArrayInt(numbers, ::filterPositif), ::filterMultiple3)
        println("Tableau filtre positif + Multiple 3 : ${Arrays.toString(numbersPositifMultiple3)}")

        // Exemple 2
        for (k in 2..9) {
            var numbersFiltre = filterArrayIntMultiplek(numbers, k, ::filterMulitple)
            println("Tableau Multiple de $k : ${Arrays.toString(numbersFiltre)}")
        }
    }

    private fun sealedClass() {
        var figures = mutableListOf<Figure>()
        figures.add(Figure.Cercle(3.0))
        figures.add(Figure.Carre(7.5))
        figures.add(Figure.Rectangle(3.55, 4.0))
        figures.add(Figure.Triangle(3.5, 4.1, 6.2))
        figures.add(Figure.Unite)

        for (figure in figures) {
            description(figure)
        }


    }

    private fun enumClass() {
        Armes.valueOf("ARC").degats = 15
        for (arme in Armes.values()) {
            arme.description()
            println(arme.commentaire())
        }
    }
}
