import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipesapp.data.entity.Tarifler
import com.example.recipesapp.databinding.CardTasarimBinding
import com.example.recipesapp.ui.fragment.AnasayfaFragmentDirections
import com.example.recipesapp.util.gecisYap

class TariflerAdapter(
    var mContext: Context,
    var tarifListesi: List<Tarifler>
) : RecyclerView.Adapter<TariflerAdapter.CardTasarimTutucu>() {
   // lateinit var navController: NavController

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {

        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return tarifListesi.size
    }

    override fun onBindViewHolder(
        holder: CardTasarimTutucu,
        position: Int
    ) {
        val tarif = tarifListesi[position]

        val t = holder.tasarim
        //val context = t.root.context
        t.textViewTarifBilgi.text = "${tarif.name}"

        // bind fonksiyonunu çağırarak resmi yükle
        bind(position, t)

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.tarifDetayGecis(tarif.id)
            Navigation.gecisYap(it, gecis)
        }

        t.guncelleButton.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.tarifGuncelleGecis(tarif.id)
            Navigation.gecisYap(it, gecis)
        }
    }

    // bind fonksiyonunu onCreateViewHolder içinde çağırmayı unutmayın
    private fun bind(position: Int, t: CardTasarimBinding) {
        val resimList = listOf(
            "https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/566566/pexels-photo-566566.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/992824/pexels-photo-992824.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load",
            "https://images.pexels.com/photos/539451/pexels-photo-539451.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/750941/pexels-photo-750941.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        )

        // position değerini resimListesi boyutuna uygun hale getirme işlemi yaptım.
        val adjustedPosition = position % resimList.size

        val resimUrl = resimList[adjustedPosition]
        Glide.with(mContext)
            .load(resimUrl)
            .into(t.imageViewYemek)
    }

}
