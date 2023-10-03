import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentSplashScreenBinding
import com.example.recipesapp.ui.viewmodel.SplashScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    private lateinit var tasarim: FragmentSplashScreenBinding
    private lateinit var viewModel: SplashScreenViewModel

    // Splash ekranının görüntüleneceği süre (milisaniye cinsinden)
    private val SPLASH_DELAY = 3000L // Örneğin, 3 saniye

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return tasarim.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel'i başlat
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)

        // Belirli bir süre sonra ana sayfaya geçiş yap
        Handler(Looper.getMainLooper()).postDelayed({

            // Ana sayfaya geçiş yapmak için Navigation Component kullanılır
            findNavController().navigate(R.id.splashAnasayayaGecis)
        }, SPLASH_DELAY)
    }
}
