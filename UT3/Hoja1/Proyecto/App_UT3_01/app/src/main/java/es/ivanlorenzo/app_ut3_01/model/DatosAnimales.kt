package es.ivanlorenzo.app_ut3_01.model

import es.ivanlorenzo.app_ut3_01.R
import es.ivanlorenzo.app_ut3_01.model.Animal

object DatosAnimales
{
    fun getDatosAnimales(): List<Animal>
    {
        return arrayListOf(
            Animal("Ballena", R.drawable.ballena, "Estos mamíferos tienen un largo cráneo de hasta un tercio de la longitud total de su cuerpo, que en edad adulta mide de 15 a 17 metros y pesa de 50 a 80 toneladas.1\u200B Poseen un estrecho y arqueado maxilar, lo que da a estos animales un perfil convexo."),
            Animal("Bisonte", R.drawable.bisonte, "Los bisontes son potentes ungulados de carácter muy vivaz y de una asombrosa agilidad. Forman rebaños independientes de machos y hembras que se unen únicamente en la época de celo, en la que los machos son más vigorosos. Finalizado este periodo, las hembras se alejan de la manada y vuelven a su vida tranquila; nueve meses después dan a luz un ternero.\n" +
                    "\n" +
                    "Ha sido una de las especies más representadas artísticamente por el hombre del Paleolítico en arte rupestre. Se han hallado numerosas representaciones de bisontes a lo largo de toda Europa, destacando las de Altamira (Santillana del Mar) y Covaciella (Cabrales) por su belleza y grado de detalle.\n" +
                    "\n" +
                    "Antaño se encontraba en todo el continente, pero desapareció totalmente de los bosques a finales de la primera guerra mundial. Actualmente solo vive en los bosques de Bialoweiza, repoblados a partir de 1956 con unos pocos animales de raza pura preservados en los zoos."),
            Animal("Camaleón", R.drawable.camaleon, "Los camaleones varían grandemente en tamaño, desde los pequeños camaleones de la familia Brookesia los cuales tienen desde 2,9 cm de largo Brookesia micra hasta los grandes de 80 cm Calumna parsonii. La especie más pequeña vive en la isla de Nosy-bé en Madagascar es Brookesia minima y en su fase adulta difícilmente supera el centímetro y medio. Muchos de ellos tienen adornos en la cabeza o en la cara como protuberancias nasales e incluso cuernos como en el caso de Trioceros jacksonii o largas crestas en la parte superior de la cabeza como Chamaeleo calyptratus. Muchas especies presentan dimorfismo sexual y los machos suelen estar más adornados que sus pares femeninas.\n" +
                    "\n" +
                    "Las características principales que son compartidas por toda la familia son la estructura de sus patas, los ojos, la falta de oído y la lengua. Aunque no tengan oído externo son capaces de detectar vibraciones y sonidos de baja frecuencia, de unos 200Hz."),
            Animal("Cebra", R.drawable.cebra, "Hoy en día los équidos salvajes se han vuelto escasos. Sólo subsisten siete especies, entre ellas las tres de cebras de África.\n" +
                    "\n" +
                    "Es el único representante del género equus que posee unas rayas tan características, acerca de las cuales hay varias teorías: unos sostienen que crean una ilusión óptica que confunde a sus depredadores a la hora de atacarlas; otros que las protege de la mosca tse-tse; y por último están los que creen que hacen la función de persiana veneciana, esparciendo el calor. Pero lo realmente cierto es que les sirven como identificación: las rayas que poseen en el hombro son las que las diferencian, sus \"huellas dactilares\".\n" +
                    "\n" +
                    "La manada de cebras está formada por grupos familiares distintos, cada uno de ellos encabezado siempre por el macho dominante, que está alerta al peligro y no pierde de vista a su familia. Durante las migraciones, la cohesión del grupo significa una mayor protección ante los depredadores, por ello cuando una cebra está herida aminoraran el ritmo del viaje o incluso la esperan si es necesario.\n" +
                    "\n" +
                    "Como todas las cebras, saben nadar, pero no le gusta nada hacerlo. Necesita una motivación especial para decidirse a atravesar el agua, como pastos suculentos o la presencia de una hembra interesante en la otra orilla.\n" +
                    "\n" +
                    "Las cebras deben beber al menos una vez al día en la estación seca y entre las comidas dormitan de pie, en equilibrio sobre las cuatro patas y con la cabeza baja, o se acuestan para dormir de verdad. Estos sueños no suelen sumar más de 3 horas en un día."),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Son reptiles que viven en las áreas tropicales de África, Asia, América y Australia. Son excelentes nadadores gracias a que tienen piel entre los dedos de las patas traseras para ayudarlos a nadar con mayor rapidez, su apariencia es parecida a la de las aletas de buceo. Suelen vivir en ríos de corriente lenta y se alimentan de una amplia variedad de animales, preferentemente vivos.\n" +
                    "Una especie, el cocodrilo marino (Crocodylus porosus), es el mayor de los cocodrilos de la actualidad (el más grande del que se tiene noticia medía 8,5 m y pesaba 1700 kg, y fue capturado en Queensland (Australia) en 1957). Le sigue en tamaño el cocodrilo del Nilo (Crocodylus niloticus), con ejemplares que sobrepasan los 6 m y casi 750 kg de peso."),
            Animal("Elefante", R.drawable.elefante, "El elefante africano es el mayor mamífero terrestre. Viven en una sociedad matriarcal de estructura muy compleja, dirigida por la hembra de mayor edad, que tiene a su cargo a las hembras adultas y crías menores de 14 años, a quienes no duda en proteger de todo peligro.\n" +
                    "\n" +
                    "Se desplazan en fila india, siguiendo un orden preestablecido según la jerarquía de cada miembro, y se moverán de un punto a otro dependiendo de las decisiones de la matriarca, que es quien dicta cuándo y a dónde dirigirse. Para comunicarse utilizan diferentes tipos de señales, algunas de ellas imperceptibles para el hombre por su baja frecuencia, pero que los elefantes pueden escuchar a más de 10 kilómetros de distancia.\n" +
                    "\n" +
                    "La trompa es un apéndice nasal compuesto de 12.000 músculos y tendones, lo que le proporciona una fuerza y precisión extraordinarias, siendo capaces de levantar con ella hasta una tonelada de peso. También les sirve para acariciar, alimentarse, asearse, olfatear, generar sonidos, respirar bajo el agua y realizar aspersiones de polvo o agua, con una capacidad de absorción de hasta 16 litros.\n" +
                    "\n" +
                    "En las orejas poseen gran cantidad de vasos sanguíneos, por los cuales hacen circular la sangre refrigerando así todo su cuerpo. No es raro verlos en Cabárceno dándose baños de barro o agua para ayudar a esta refrigeración.\n" +
                    "\n" +
                    "El recinto de los elefantes consta de 20 hectáreas, y está situado junto al pueblo que da su nombre al Parque: Cabárceno. Antiguamente en esta localización se situaba el “lavadero Alicia”, y se destinó a esta especie debido a que en la época de aprovechamiento minero sufrió una explotación tal que prácticamente quedó sin karst y con una orografía bastante llana, lo cual beneficia a sus actuales pobladores."),
            Animal("Hipopótamo", R.drawable.hipopotamo, "El hipopótamo enano o pigmeo vive en la húmeda selva ecuatorial africana, donde abundan los terrenos pantanosos, lagunas, cenagales y cursos de agua.\n" +
                    "\n" +
                    "No forman grupos, sino que se desplazan por las selvas aislados o en parejas. En la época de sequía se refugian en las cuevas de las orillas de los ríos.\n" +
                    "\n" +
                    "No se trata de animales territoriales; cuando se encuentran dos machos simplemente se ignoran. Para protegerse no lo hacen en el agua, sino que se esconden en la penumbra de los sotobosques. Las madres protegen a sus crías durante los primeros días de su vida dentro del agua.\n" +
                    "\n" +
                    "Cuando el primer espécimen de hipopótamo pigmeo fue descrito como una especie, muchos científicos pensaron que era un hipopótamo común juvenil o atrofiado. La existencia de esta especie no se confirmó científicamente hasta 1911.\n" +
                    "\n" +
                    "Se encuentra en grave peligro de extinción debido al creciente desarrollo de la agricultura, que va destruyendo la selva donde habita; y a su caza por parte de las poblaciones indígenas, ya que su carne es muy apreciada."),
            Animal("Jirafa", R.drawable.jirafa, "Es un animal apacible y sociable que vive en pequeños rebaños conducidos por un macho adulto que lidera un grupo de hembras con sus crías y otros machos que aún no han alcanzado la madurez sexual.\n" +
                    "\n" +
                    "Su alimentación es exclusivamente hervíbora, alimentándose de las ramas de los árboles. Es muy raro ver una jirafa pacer puesto que la postura que adopta separando, las patas delanteras, las convierte en una presa fácil para los depredadores (por esta razón pasan dias enteros sin beber agua). Las manchas que cubren la piel de las jirafas varía segun la región en la que viven."),
            Animal("León", R.drawable.leon, "Los leones son los únicos felinos que viven formando un grupo social jerarquizado con una división clara de papeles: los machos vigilan y defienden el territorio y las hembras cazan y cuidan de los cachorros.\n" +
                    "\n" +
                    "Si las hembras de una manada pariesen con unos meses de diferencia entre ellas criarían juntas a sus cachorros, incluso llegando a amamantar a las crías de la otra hembra. Cuando crezcan, si son hembras se incorporan a la manada, reforzando y cohesionando el grupo; pero si son machos serán expulsados por su padre a los tres años de edad y vagarán, solos o en grupos muy reducidos, esperando que algún macho que tenga constituida una familia muestre un signo de debilidad, circunstancia que será aprovechada para enfrentarse a él y sustituirle.\n" +
                    "\n" +
                    "Los machos viejos, muchas veces heridos por la lucha, sobreviven durante poco tiempo y, si se recuperan de sus heridas se convertirán en solitarios carroñeros. Como dato curioso, los machos comienzan a desarrollar su melena a los 2 años aproximadamente, pero no crecen completamente hasta los 4 -5 años, se oscurece a los 9 años y pueden perderla si se les malhiere.\n" +
                    "\n" +
                    "Poseen un bajo porcentaje de éxito en la caza, capturando una presa de cinco intentos. A diferencia del resto de felinos, su corazón es más pequeño en relación a su cuerpo, aproximadamente la mitad, por ello no pueden correr a gran velocidad durante mucho tiempo. Si la captura de una presa les exige demasiado esfuerzo, renunciarán a ella para guardar energía.\n" +
                    "\n" +
                    "Su alimentación se basa en gacelas, cebras, ñús y otros antílopes, aunque no desprecian nunca la oportunidad de robar presas a otros cazadores menos robustos o incluso alimentarse de carroña."),
            Animal("Mono", R.drawable.mono, "Es el único simio salvaje de Europa que vive en libertad, concretamente en el peñón de gibraltar.\n" +
                    "\n" +
                    "Las poblaciones más importantes se sitúan en las montañas de Marruecos, y en menor número en Argelia.\n" +
                    "\n" +
                    "Habitan en bosques de encinas, cedros del Atlas y abetos. También pueblan biotipos rocosos y de sotobosque mediterráneo.\n" +
                    "\n" +
                    "Son diurnos y viven preferentemente en el suelo. Forman grupos numerosos que se hallan socialmente bien organizados, liderados por un fuerte macho. Poseen por tanto sus propias jerarquías, hábitos y costumbres."),
            Animal("Ciervo", R.drawable.venado, "Cérvido de gran tamaño, pudiendo los machos pesar hasta los 200 kg. Las hembras en esta especie son de menor tamaño.\n" +
                    "\n" +
                    "Los machos presentan cuernas que renuevan cada año, desarrollándose durante el verano y adquiriendo mayor tamaño, longitud y número de puntas a medida que avanza la edad del ejemplar.\n" +
                    "\n" +
                    "Les gusta vivir en grupo, pero en la época de celo se vuelven muy territoriales y forman un harén. Es la época de los enfrentamientos entre los machos, conocida como “La berrea”."),
            Animal("Zorro", R.drawable.zorro, "El zorro es el mamífero carnívoro más abundante del planeta. Alcanza casi el metro de longitud, destacando en su figura la cola de unos 35 cms. de larga. La cabeza la tiene ancha, el hocico puntiagudo y las orejas son grandes y puntiagudas.\n" +
                    "\n" +
                    "El zorro es un animal curioso e inteligente que sin embargo por su naturaleza sospechosa y tímida, les obliga a evitar el peligro. Es un animal generalmente solitario, aunque también pueden vivir en parejas permanentes o en grupos de un macho y dos o tres hembras, generalmente emparentadas entre sí y con una jerarquía establecida entre ellas.\n" +
                    "\n" +
                    "Es un buen corredor, nada con soltura y puede trepar a los árboles con relativa facilidad. El olfato lo tiene muy desarrollado, considerándose el mejor de sus sentidos, el que agudiza durante la noche. El oído está también muy desarrollado y con él puede localizar presas que emiten sonidos de baja frecuencia. La vista la tiene bien adaptada a la visión nocturna, aunque también ve perfectamente durante el día. Cuando corre puede alcanzar una velocidad punta de 55 Kms/hora.")
        )
    }
}

