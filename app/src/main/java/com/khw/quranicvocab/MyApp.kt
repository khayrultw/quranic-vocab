package com.khw.quranicvocab

import android.app.Application
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.data.repo.VocabRepo
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

@HiltAndroidApp
class MyApp: Application() {

    @Inject
    lateinit var repo: VocabRepo

    override fun onCreate() {
        super.onCreate()
        val `is` = resources.openRawResource(R.raw.vocabs)
        val reader = BufferedReader(InputStreamReader(`is`))
        val ioScope = CoroutineScope(SupervisorJob())


        ioScope.launch(Dispatchers.IO) {
            repo.clear()
            while (true) {
                try {
                    reader.readLine()?.also {
                        val wp = it.split("#")
                        if(wp.size == 3) {
                            vocabs[wp[1]] = wp[2]
                            val vocab = Vocab(id = wp[0].toInt(), word = wp[1], meanings = wp[2])
                            repo.insert(vocab)
                        }
                    } ?: break
                } catch (e: Exception) {
                    e.printStackTrace()
                    throw e
                }
            }
            `is`.close()
        }
    }

    companion object {
        init {
            System.loadLibrary("quranicvocab")
        }
        var vocabs = mutableMapOf<String, String>()
    }
}