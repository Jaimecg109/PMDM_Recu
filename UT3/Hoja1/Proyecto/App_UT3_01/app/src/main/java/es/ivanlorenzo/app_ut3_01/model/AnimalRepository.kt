package es.ivanlorenzo.app_ut3_01.model

class AnimalRepository
{
    suspend fun get(): List<Animal> = DatosAnimales.getDatosAnimales()
}