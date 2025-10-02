package com.santidev.kotlinquiz.data

val sampleQuestions = listOf(
  Question(
    id = 1,
    text = "Cuál es la palabra clave para declarar una clase de datos?",
    options = listOf("class", "data class", "object"),
    correctAnswer = "data class",
    explanation = "Las data classes generan automáticamente equals(), hashCode(), toString() y copy(). Son ideales para representar datos simples.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 2,
    text = "¿Cómo se declara una función en Kotlin?",
    options = listOf("def", "fun", "func"),
    correctAnswer = "fun",
    explanation = "En Kotlin, se utiliza la palabra clave 'fun' para declarar funciones.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 3,
    text = "¿Cuál es la forma correcta de mantener un estado a través de las recomposiciones?",
    options = listOf("var estado = ...", "remember { mutableStateOf(...) }", "rememberSaveable { mutableStateOf(...) }"),
    correctAnswer = "remember { mutableStateOf(...) }",
    explanation = "remember{} mantiene el estado durante recomposiciones. Para sobrevivir cambios de configuración (rotación), usa rememberSaveable{}.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 4,
    text = "¿Qué función se usa para lanzar una corrutina sin retornar un resultado?",
    options = listOf("launch", "async", "suspend", "runBlocking"),
    correctAnswer = "launch",
    explanation = "launch inicia una corrutina y retorna un Job. async retorna un Deferred con un resultado. suspend marca funciones suspendibles.",
    category = QuestionCategory.ADVANCED.displayName
  ),
  Question(
    id = 5,
    text = "¿Qué palabra clave se usa para permitir que una clase pueda ser heredada?",
    options = listOf("open", "abstract", "sealed", "public"),
    correctAnswer = "open",
    explanation = "En Kotlin, las clases son final por defecto. Se usa 'open' para permitir herencia, o 'abstract' si queremos forzarla.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 6,
    text = "¿Cuál es la forma correcta de verificar si un número es par?",
    options = listOf("if (numero / 2 == 0)","if (numero * 2 == 0)","if (numero % 2 == 0)", "if (numero / 2 == 2)"),
    correctAnswer = "if (numero % 2 == 0)",
    explanation = "El operador módulo (%) devuelve el resto de la división. Si numero % 2 == 0, el resto es 0, por lo tanto es par.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 7,
    text = "Qué hace el operador ( !! ) en Kotlin",
    options = listOf("Convierte null en 0","Lanza una excepción si la variable es null","Ignora el valor null", "Cambia el tipo de la variable a String"),
    correctAnswer = "Lanza una excepción si la variable es null",
    explanation = "El operador ( !! ) fuerza que una variable nullable no sea null; si lo es, lanza NullPointerException.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 8,
    text = "Si tienes 'val miEstado = remember { mutableStateOf('Hola!, Soy un titulo de estado') }', ¿cómo accedes al valor en un Text?",
    options = listOf("Text(miEstado)", "Text(text = miEstado.value)", "Text { miEstado.value }", "Text(miEstado.get())"),
    correctAnswer = "Text(text = miEstado.value)",
    explanation = "MutableState<T> encapsula el valor. Debes acceder a ( .value ) para obtener el String. Compose observa los cambios automáticamente.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 9,
    text = "¿Cuál composable se usa para superponer elementos?",
    options = listOf("Box { ... }","Column { ... }","Stack { ... }", "Row { ... }"),
    correctAnswer = "Box { ... }",
    explanation = "Box permite apilar elementos unos sobre otros.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 10,
    text = "Cuál es la forma correcta de cambiar el color de un Text",
    options = listOf("Text('Hola', Color.Red)","Text('Hola', color = Color.Red)","Text('Hola').color(Color.Red)", "Text(\"Hola\", textColor = Color.Red)"),
    correctAnswer = "Text('Hola', color = Color.Red)",
    explanation = "El parámetro 'color' es un parámetro nombrado que define el color del texto en Compose.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 11,
    text = "¿Cuál es la diferencia entre 'val' y 'var' en Kotlin?",
    options = listOf("No hay diferencia", "val es de solo lectura, var es reasignable", "var es inmutable, val es mutable"),
    correctAnswer = "val es de solo lectura, var es reasignable",
    explanation = "'val' declara una variable de solo lectura (no se puede reasignar un valor), mientras que 'var' permite reasignación de valores. Nota: val no garantiza inmutabilidad del objeto.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 12,
    text = "¿Qué anotación se usa para crear un Composable en Jetpack Compose?",
    options = listOf("@Component", "@Composable", "@Compose"),
    correctAnswer = "@Composable",
    explanation = "La anotación @Composable marca una función como componente de UI en Jetpack Compose.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 13,
    text = "¿Qué operador se usa para declarar que una variable puede contener null?",
    options = listOf("( ! )", "( ? )", "( ?: )", "nullable"),
    correctAnswer = "( ? )",
    explanation = "El operador ( ? ) después del tipo (ej: String?) indica que la variable puede ser null. Kotlin distingue tipos nullable de non-nullable.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 14,
    text = "¿Qué símbolo se usa para heredar de una clase en Kotlin?",
    options = listOf("extends", ":", "->", "inherits"),
    correctAnswer = ":",
    explanation = "Se usa el operador ':' después del nombre de la clase. Ejemplo: class Perro : Animal(). También se usa para implementar interfaces.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 15,
    text = "¿Cuál es la función principal de remember() en Compose?",
    options = listOf("Recordar el estado anterior", "Mantener valores entre recomposiciones", "Guardar datos permanentemente"),
    correctAnswer = "Mantener valores entre recomposiciones",
    explanation = "remember() almacena valores en la composición para que persistan durante las recomposiciones.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 16,
    text = "¿Qué es una lambda en Kotlin?",
    options = listOf("Una clase especial", "Una función anónima", "Un tipo de variable"),
    correctAnswer = "Una función anónima",
    explanation = "Las lambdas son funciones anónimas que se pueden pasar como parámetros o asignar a variables.",
    category = QuestionCategory.ADVANCED.displayName
  ),
  Question(
    id = 17,
    text = "¿Qué palabra clave permite inicializar una propiedad no nula después de su declaración?",
    options = listOf("lazy", "lateinit", "by", "delegate"),
    correctAnswer = "lateinit",
    explanation = "lateinit permite declarar propiedades var no nulas que se inicializarán más tarde. Restricciones: solo con var, no con tipos primitivos, y lanza UninitializedPropertyAccessException si se accede antes de inicializar.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 18,
    text = "¿Qué operador se usa para el safe call en Kotlin?",
    options = listOf("( !! )", "( ?. )", "( ?.let )"),
    correctAnswer = "( ?. )",
    explanation = "El operador ?. permite llamar métodos o acceder a propiedades solo si el objeto no es null, evitando NullPointerException.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 19,
    text = "¿Cuál es la diferencia entre '==' y '===' en Kotlin?",
    options = listOf("No hay diferencia", "== compara valor, === compara referencia", "== compara referencia, === compara valor"),
    correctAnswer = "== compara valor, === compara referencia",
    explanation = "== compara el contenido (llama a equals()), mientras que === compara si son el mismo objeto en memoria.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 20,
    text = "¿Cuál es el operador Elvis en Kotlin?",
    options = listOf("( ?: )", "( ?? )", "( ?! )"),
    correctAnswer = "( ?: )",
    explanation = "El operador Elvis (?:) proporciona un valor por defecto cuando la expresión es null. Ejemplo: val largo = texto?.length ?: 0",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 21,
    text = "¿Cuál es la diferencia entre 'LazyColumn' y 'Column'?",
    options = listOf("LazyColumn solo soporta listas pequeñas", "Column siempre recicla vistas, LazyColumn no", "LazyColumn solo renderiza elementos visibles"),
    correctAnswer = "LazyColumn solo renderiza elementos visibles",
    explanation = "LazyColumn es eficiente porque solo compone los ítems visibles y algunos adicionales para el scroll.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 22,
    text = "¿Cuál es el propósito principal de 'SideEffect' en Compose?",
    options = listOf("Ejecutar código una sola vez al crear el composable", "Sincronizar estado de Compose con APIs externas después de cada recomposición exitosa", "Manejar efectos secundarios con cancelación", "Guardar estado entre configuraciones"),
    correctAnswer = "Sincronizar estado de Compose con APIs externas después de cada recomposición exitosa",
    explanation = "SideEffect se ejecuta después de cada recomposición exitosa, útil para sincronizar estado de Compose con APIs no-Compose (ej: actualizar una View de Android).",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 23,
    text = "¿Qué hace 'AnimatedVisibility'?",
    options = listOf("Cambia colores de fondo", "Muestra u oculta un composable con animación", "Redibuja automáticamente al cambiar de estado"),
    correctAnswer = "Muestra u oculta un composable con animación",
    explanation = "AnimatedVisibility es ideal para transiciones suaves al mostrar/ocultar elementos.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 24,
    text = "¿Cuál es el rol del 'Scaffold' en Compose?",
    options = listOf("Proporcionar una estructura de pantalla con barra superior, inferior, FAB, etc.", "Crear layouts flexibles", "Mostrar datos en tablas"),
    correctAnswer = "Proporcionar una estructura de pantalla con barra superior, inferior, FAB, etc.",
    explanation = "Scaffold organiza pantallas completas con componentes de Material Design de manera coherente.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 25,
    text = "¿Qué composable se usa para detectar gestos como arrastrar o pulsar largo?",
    options = listOf("GestureDetector", "Modifier.pointerInput", "Modifier.clickable"),
    correctAnswer = "Modifier.pointerInput",
    explanation = "pointerInput permite manejar gestos personalizados como drag, long press o multitouch.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 26,
    text = "¿Qué hace 'Crossfade' en Compose?",
    options = listOf("Aplica transición de opacidad entre dos composables", "Duplica un composable", "Cambia el color de fondo gradualmente"),
    correctAnswer = "Aplica transición de opacidad entre dos composables",
    explanation = "Crossfade permite animar un cambio entre dos composables con efecto de desvanecimiento.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 27,
    text = "¿Qué función usas para observar un Flow en Compose?",
    options = listOf("observeAsState()", "collectAsState()", "rememberFlow()"),
    correctAnswer = "collectAsState()",
    explanation = "collectAsState convierte un Flow en un State observable por Compose.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 28,
    text = "¿Qué diferencia hay entre 'LocalContext.current' y 'LocalLifecycleOwner.current'?",
    options = listOf("LocalContext da acceso al contexto de Android, LocalLifecycleOwner al ciclo de vida", "Son equivalentes", "Ambos devuelven un Context"),
    correctAnswer = "LocalContext da acceso al contexto de Android, LocalLifecycleOwner al ciclo de vida",
    explanation = "LocalContext.current da el contexto Android, LocalLifecycleOwner.current permite acceder al ciclo de vida actual.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 29,
    text = "¿Cuál es la principal diferencia entre 'interface' y 'abstract class' en Kotlin?",
    options = listOf("No hay diferencia en Kotlin moderno", "Una clase solo puede heredar de una abstract class, pero implementar múltiples interfaces", "Las interfaces no pueden tener constructores", "Las abstract class no pueden tener métodos implementados"),
    correctAnswer = "Una clase solo puede heredar de una abstract class, pero implementar múltiples interfaces",
    explanation = "La diferencia clave es la herencia: solo puedes extender una abstract class, pero implementar múltiples interfaces. Las abstract class pueden tener constructores con parámetros. Dato: En kotlin apartir de la version 1.9, las interfaces SÍ pueden tener estado",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 30,
    text = "¿Qué es el polimorfismo en Kotlin?",
    options = listOf("La posibilidad de usar genéricos", "El paso por referencia", "La capacidad de una función/clase de tener múltiples formas",),
    correctAnswer = "La capacidad de una función/clase de tener múltiples formas",
    explanation = "El polimorfismo permite que objetos de diferentes tipos sean tratados a través de una interfaz común. Incluye herencia (override) y sobrecarga (overload) de funciones.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 31,
    text = "¿Qué diferencia hay entre 'companion object' y 'object' normal?",
    options = listOf("Son equivalentes", "companion object está ligado a una clase, object normal es un singleton global", "companion object no puede contener métodos"),
    correctAnswer = "companion object está ligado a una clase, object normal es un singleton global",
    explanation = "El companion object sirve para miembros estáticos asociados a una clase.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 32,
    text = "¿Qué es la herencia en Kotlin?",
    options = listOf("Definir múltiples funciones con el mismo nombre", "Compartir variables entre objetos", "Una clase que puede extender otra para reutilizar su comportamiento"),
    correctAnswer = "Una clase que puede extender otra para reutilizar su comportamiento",
    explanation = "La herencia permite que una clase hijo reutilice y extienda la lógica de la clase padre.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 33,
    text = "¿Qué es un CoroutineScope?",
    options = listOf("Un tipo de deferred", "Un contexto que define el ciclo de vida de corrutinas", "Una función suspendida"),
    correctAnswer = "Un contexto que define el ciclo de vida de corrutinas",
    explanation = "El CoroutineScope controla cuándo inician y cuándo se cancelan corrutinas asociadas.",
    category = QuestionCategory.ADVANCED.displayName
  ),
  Question(
    id = 34,
    text = "¿Qué diferencia hay entre 'lazy' y 'lateinit'?",
    options = listOf("'lazy' inicializa al primer acceso, 'lateinit' se inicializa manualmente antes de usarse", "Son equivalentes", "lateinit solo aplica a constantes"),
    correctAnswer = "'lazy' inicializa al primer acceso, 'lateinit' se inicializa manualmente antes de usarse",
    explanation = "'lazy' asegura inicialización diferida automática, 'lateinit' requiere inicializar explícitamente antes del uso.",
    category = QuestionCategory.ADVANCED.displayName
  ),
  Question(
    id = 35,
    text = "¿Qué es un 'mock' en pruebas?",
    options = listOf("Un objeto simulado que reemplaza dependencias reales", "Un test duplicado", "Un bug en el código"),
    correctAnswer = "Un objeto simulado que reemplaza dependencias reales",
    explanation = "Los mocks simulan dependencias externas para aislar la lógica que se está probando.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 36,
    text = "¿Qué framework de pruebas unitarias se usa comúnmente en Kotlin con Android Studio?",
    options = listOf("JUnit", "Mockito", "Espresso"),
    correctAnswer = "JUnit",
    explanation = "JUnit es el framework principal para pruebas unitarias en Android y Kotlin.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 37,
    text = "¿Qué diferencia hay entre un test unitario y uno instrumentado?",
    options = listOf("El unitario necesita un emulador, el instrumentado no", "El unitario corre en la JVM, el instrumentado corre en un dispositivo/emulador", "Son equivalentes"),
    correctAnswer = "El unitario corre en la JVM, el instrumentado corre en un dispositivo/emulador",
    explanation = "Los tests unitarios prueban la lógica sin Android Framework, mientras que los instrumentados prueban en un entorno Android real.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 38,
    text = "¿Qué anotación se usa para indicar un método de test en JUnit?",
    options = listOf("@RunWith", "@Mock", "@Test",),
    correctAnswer = "@Test",
    explanation = "La anotación @Test marca un método como una prueba unitaria ejecutable por JUnit.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 39,
    text = "¿Qué se usa en pruebas para verificar que un valor es el esperado?",
    options = listOf("assertEquals", "println", "checkValue"),
    correctAnswer = "assertEquals",
    explanation = "assertEquals compara el resultado esperado con el obtenido y falla si no coinciden.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 40,
    text = "¿Qué librería se usa para simular objetos (mocks) en pruebas?",
    options = listOf("Mockito o MockK", "JUnit", "Espresso"),
    correctAnswer = "Mockito o MockK",
    explanation = "Mockito y MockK permiten crear objetos simulados. MockK está diseñado específicamente para Kotlin.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 41,
    text = "¿Qué opción en Android Studio ejecuta todos los tests del proyecto",
    options = listOf("Build → Make Project", "Run → Run Tests", "File → Sync Project"),
    correctAnswer = "Run → Run Tests",
    explanation = "La opción 'Run → Run Tests' ejecuta todos los tests. También puedes usar Gradle: ./gradlew test",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 42,
    text = "¿Qué diferencia hay entre assertTrue y assertFalse?",
    options = listOf("assertTrue lanza error, assertFalse no", "No hay diferencia", "assertTrue pasa si la condición es verdadera, assertFalse si es falsa",),
    correctAnswer = "assertTrue pasa si la condición es verdadera, assertFalse si es falsa",
    explanation = "Son métodos de aserción que validan condiciones booleanas.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 43,
    text = "¿Qué se usa para probar interfaces de usuario en Jetpack Compose?",
    options = listOf("Espresso", "Compose UI Testing", "Mockito", "JUnit"),
    correctAnswer = "Compose UI Testing",
    explanation = "Compose UI Testing (androidx.compose.ui:ui-test) está diseñado específicamente para probar composables.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 44,
    text = "¿Qué es un test de integración?",
    options = listOf("Un test de UI", "Un test unitario con mocks", "Una prueba que valida cómo interactúan varios módulos juntos",),
    correctAnswer = "Una prueba que valida cómo interactúan varios módulos juntos",
    explanation = "Los tests de integración aseguran que distintos componentes funcionen correctamente en conjunto.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 45,
    text = "¿Qué ventaja tiene usar pruebas automatizadas?",
    options = listOf("Reemplazar la necesidad de programar", "Detectar errores rápido y asegurar calidad del código", "Evitar usar Android Studio"),
    correctAnswer = "Detectar errores rápido y asegurar calidad del código",
    explanation = "Las pruebas automatizadas reducen errores, ahorran tiempo y mejoran la mantenibilidad.",
    category = QuestionCategory.TEST.displayName
  ),
  Question(
    id = 46,
    text = "¿Qué significa MVVM?",
    options = listOf("Model-View-ViewModel", "Model-Variable-ViewModel", "Manager-View-ViewModel", "Model-View-ViewManager"),
    correctAnswer = "Model-View-ViewModel",
    explanation = "MVVM es un patrón arquitectónico que separa la lógica de negocio (ViewModel) de la UI (View) usando un Model para los datos.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 47,
    text = "¿Cuál es la principal responsabilidad de un ViewModel en MVVM?",
    options = listOf("Manejar navegación entre pantallas", "Contener la lógica de negocio y preparar datos para la UI", "Acceder directamente a la base de datos", "Renderizar los composables"),
    correctAnswer = "Contener la lógica de negocio y preparar datos para la UI",
    explanation = "El ViewModel maneja la lógica de presentación, expone estados observables y sobrevive a cambios de configuración. No debe conocer detalles de la UI.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 48,
    text = "¿Qué es el Repository Pattern?",
    options = listOf("Un patrón para guardar datos solo en memoria", "Una capa que abstrae las fuentes de datos y provee una API limpia", "Un tipo especial de ViewModel", "Una base de datos local"),
    correctAnswer = "Una capa que abstrae las fuentes de datos y provee una API limpia",
    explanation = "El Repository centraliza el acceso a datos (API, base de datos, caché) y decide de dónde obtenerlos, ocultando esta complejidad al ViewModel.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 49,
    text = "¿En qué capa de Clean Architecture van los casos de uso (Use Cases)?",
    options = listOf("Presentation Layer", "Data Layer", "Domain Layer", "UI Layer"),
    correctAnswer = "Domain Layer",
    explanation = "Los Use Cases están en el Domain Layer, contienen la lógica de negocio pura e independiente de frameworks. Son el núcleo de la aplicación.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 50,
    text = "¿Qué principio arquitectónico establece que debe haber una única fuente de verdad para los datos?",
    options = listOf("Dependency Inversion", "Single Source of Truth (SSOT)", "Separation of Concerns", "Don't Repeat Yourself (DRY)"),
    correctAnswer = "Single Source of Truth (SSOT)",
    explanation = "SSOT significa que cada dato tiene una única fuente autoritativa, evitando inconsistencias. Por ejemplo, el Repository es el SSOT para datos de negocio.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 51,
    text = "¿Cuál es la diferencia principal entre MVVM y MVI?",
    options = listOf("MVI no usa ViewModels", "MVI maneja el estado de la UI como un flujo unidireccional de eventos", "MVVM es solo para Android, MVI para multiplataforma", "No hay diferencia real"),
    correctAnswer = "MVI maneja el estado de la UI como un flujo unidireccional de eventos",
    explanation = "MVI (Model-View-Intent) enfatiza un flujo unidireccional: Intent → Model → View. El estado es inmutable y cada acción genera un nuevo estado.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 52,
    text = "¿Por qué un ViewModel NO debe tener referencias a Views o Context de Activity?",
    options = listOf("Porque causaría memory leaks al sobrevivir cambios de configuración", "Porque Android Studio lo prohíbe", "No hay problema en tenerlas", "Solo en modo debug está prohibido"),
    correctAnswer = "Porque causaría memory leaks al sobrevivir cambios de configuración",
    explanation = "El ViewModel sobrevive a la recreación de Activities/Fragments. Si tiene referencias a Views o Context, provocará memory leaks y posibles crashes.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 53,
    text = "¿Qué son las capas en Clean Architecture?",
    options = listOf("Solo UI y Data", "Presentation, Domain y Data (con dependencias hacia el centro)", "Model y View únicamente", "Frontend y Backend"),
    correctAnswer = "Presentation, Domain y Data (con dependencias hacia el centro)",
    explanation = "Clean Architecture divide la app en capas concéntricas: Domain (centro, lógica pura), Data (fuentes de datos) y Presentation (UI). Las dependencias apuntan hacia adentro.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 54,
    text = "¿Cuándo es recomendable usar Use Cases en lugar de llamar directamente al Repository desde el ViewModel?",
    options = listOf("Nunca, siempre llamar directo al Repository", "Cuando la lógica de negocio es compleja o combina múltiples fuentes de datos", "Solo en apps grandes con más de 50 pantallas", "Use Cases y Repository son lo mismo"),
    correctAnswer = "Cuando la lógica de negocio es compleja o combina múltiples fuentes de datos",
    explanation = "Los Use Cases encapsulan lógica de negocio reutilizable. Son útiles cuando hay reglas complejas, múltiples repositorios, o lógica que no pertenece al ViewModel.",
    category = QuestionCategory.ARCHITECTURE.displayName
  ),
  Question(
    id = 55,
    text = "¿Qué patrón arquitectónico se recomienda oficialmente para apps Android modernas?",
    options = listOf("MVC (Model-View-Controller)", "MVP (Model-View-Presenter)", "MVVM con arquitectura de capas", "Ninguno, es libre elección sin recomendación"),
    correctAnswer = "MVVM con arquitectura de capas",
    explanation = "Google recomienda MVVM con separación en capas (UI, Domain, Data) en su guía oficial de arquitectura para apps Android modernas.",
    category = QuestionCategory.ARCHITECTURE.displayName
  )
)
