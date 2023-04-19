package com.example.app_ut2_07

object Datos
{
    private val categorias = listOf<Categoria>(
        Categoria("Fruta",
        listOf<Producto>(
            Producto(1,"Manzanas",R.drawable.manzanas),
            Producto(2, "Peras", R.drawable.peras),
            Producto(3,"Platanos",R.drawable.platanos),
            Producto(4,"Mandarinas",R.drawable.mandarinas)
        )),
        Categoria("Legumbres",
        listOf<Producto>(
            Producto(5,"Alubias",R.drawable.alubias),
            Producto(6,"Arroz Largo",R.drawable.arroz_largo),
            Producto(7,"Arroz Redondo",R.drawable.arroz_redondo),
            Producto(8,"Garbanzos",R.drawable.garbanzos),
            Producto(9,"Lentejas",R.drawable.lentejas)
        )),
        Categoria("Carniceria",
        listOf<Producto>(
            Producto(10,"Pollo",R.drawable.pollo),
            Producto(11,"Pavo",R.drawable.pavo),
            Producto(12,"Cerdo",R.drawable.cerdo),
            Producto(13,"Conejo",R.drawable.conejo),
            Producto(14,"Cordero",R.drawable.cordero),
            Producto(15,"Ternera",R.drawable.ternera)
        )),
        Categoria("Refrescos",
        listOf<Producto>(
            Producto(16,"Cola",R.drawable.cola),
            Producto(17,"Naranja",R.drawable.naranja),
            Producto(18,"Limon",R.drawable.limon),
            Producto(19,"Tonica",R.drawable.tonica)
        ))
    )

    fun nombresCategorias() : List<String>
    {
       return categorias.map { it.nombre }
    }
    fun getProductosCategoria(nombre: String): List<Producto>
    {
       return categorias.first{it.nombre == nombre }.productos
    }
}