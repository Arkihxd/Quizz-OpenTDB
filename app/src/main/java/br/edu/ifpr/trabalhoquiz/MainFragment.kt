package br.edu.ifpr.trabalhoquiz

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.concurrent.thread


class MainFragment : Fragment() {

    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar.visibility = View.VISIBLE

        var conexao = isOnline()
        if (!conexao){
            txtMessagem.text = getString(R.string.main_conexao)
            Toast.makeText(context, getString(R.string.main_conexao), Toast.LENGTH_SHORT).show()
        }
        Handler().postDelayed({
            run {
                while (!conexao){
                    conexao = isOnline()
                    progressBar.progress += 10
                }
                if (conexao){
                    iniciarJogo()
                }
            }
        }, 3000)

    }
    private fun isOnline(): Boolean {
        val manager = activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo != null && manager.activeNetworkInfo.isConnectedOrConnecting
    }

    private fun iniciarJogo(){
        val nav = Navigation.findNavController(this@MainFragment.activity!!, R.id.fragmentContent)
        nav.navigate(R.id.mainToLogin)
    }
}


