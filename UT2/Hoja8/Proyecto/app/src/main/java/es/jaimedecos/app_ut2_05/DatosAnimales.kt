package es.jaimedecos.app_ut2_05

import android.media.Image

object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return  arrayListOf<Animal>(
             Animal("Ballena", R.drawable.ballena,""),
             Animal("Bisonte",R.drawable.bisonte,""),
            Animal("Camaleón",R.drawable.camaleon,""),
            Animal("Cebra",R.drawable.cebra,""),
            Animal("Cocodrilo",R.drawable.cocodrilo,""),
            Animal( "Elefante",R.drawable.elefante,""),
            Animal( "Hipopótamo",R.drawable.hipopotamo,""),
            Animal("Jirafa",R.drawable.jirafa,""),
            Animal("Mono",R.drawable.mono,""),
            Animal("Venado",R.drawable.venado,""),
            Animal("Zorro",R.drawable.zorro,"")
        )
    }
}