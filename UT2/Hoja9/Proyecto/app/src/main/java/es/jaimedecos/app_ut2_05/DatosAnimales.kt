package es.jaimedecos.app_ut2_05

import android.media.Image

object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return  arrayListOf<Animal>(
             Animal("Ballena", R.drawable.ballena,"",0),
             Animal("Bisonte",R.drawable.bisonte,"",0),
            Animal("Camaleón",R.drawable.camaleon,"",0),
            Animal("Cebra",R.drawable.cebra,"",0),
            Animal("Cocodrilo",R.drawable.cocodrilo,"",0),
            Animal( "Elefante",R.drawable.elefante,"",0),
            Animal( "Hipopótamo",R.drawable.hipopotamo,"",0),
            Animal("Jirafa",R.drawable.jirafa,"",0),
            Animal("Mono",R.drawable.mono,"",0),
            Animal("Venado",R.drawable.venado,"",0),
            Animal("Zorro",R.drawable.zorro,"",0)
        )
    }
}