package com.santidev.kotlinquiz.data

val sampleQuestions = listOf(
  Question(
    id = 1,
    text = "Cuál es la palabra clave para declarar una clase de datos?",
    options = listOf("class", "data class", "object"),
    correctAnswer = "data class",
    explanation = "Las clases de datos se utilizan para representar datos inmutables.",
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
    text = "¿Cual es la forma correcta de recordar un estado a travez de la recomposicion?",
    options = listOf("remember{}", "rememberUpdatedState{}", "rememberSaveable{}"),
    correctAnswer = "rememberSaveable{}",
    explanation = "rememberSaveable es la forma que tiene jetpack compose, para recordar el estado actual de un composable y evitar la recomposicion al girar la pantalla del dispositivo",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 4,
    text = "¿Qué palabra clave se usa para crear una corrutina en Kotlin?",
    options = listOf("launch", "async", "suspend", "runBlocking"),
    correctAnswer = "launch",
    explanation = "launch inicia una nueva corrutina sin bloquear el hilo actual.",
    category = QuestionCategory.ADVANCED.displayName
  ),
  Question(
    id = 5,
    text = "Cuál es la diferencia entre una data class y una class normal?",
    options = listOf("Las data class generan equals, hashCode y toString automáticamente",
      "Las class normales no pueden heredar",
      "Las data class no aceptan constructores",
      "No hay diferencia"),
    correctAnswer = "Las data class generan equals, hashCode y toString automáticamente",
    explanation = "Data class genera automáticamente funciones útiles como equals y toString.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 6,
    text = "Cuál es la forma correcta de ver si un numero es Par O Impar?",
    options = listOf("if (numero / 2 == 0)","if (numero * 2 == 0)","if (numero % 2 == 0)", "if (numero / 2 == 2)"),
    correctAnswer = "if (numero % 2 == 0)",
    explanation = "El operador ( % ) en Kotlin se llama módulo y comprueba si es divisible por 2, si lo es devulve 'Par', si no lo es devuelve 'Impar' ",
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
    text = "Cuál es la forma correcta de cambiar el texto de un Text según un estado mutable",
    options = listOf("Text { miEstado }","Text(miEstado.setValue())","Text(miEstado.value)", "Text(text = miEstado)"),
    correctAnswer = "Text(text = miEstado)",
    explanation = "Al pasar la variable miEstado al parámetro text, Compose actualiza el texto automáticamente cuando cambia.",
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
    explanation = "El parámetro color define el color del texto.",
    category = QuestionCategory.COMPOSE.displayName
  ),
  Question(
    id = 11,
    text = "¿Cuál es la diferencia entre 'val' y 'var' en Kotlin?",
    options = listOf("No hay diferencia", "val es inmutable, var es mutable", "var es inmutable, val es mutable"),
    correctAnswer = "val es inmutable, var es mutable",
    explanation = "'val' declara una propiedad de solo lectura (inmutable), mientras que 'var' permite modificar el valor.",
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
    text = "¿Cuál es la forma correcta de manejar nulos en Kotlin?",
    options = listOf("Usando try-catch", "Usando el operador ( ? )", "Kotlin no maneja nulos"),
    correctAnswer = "Usando el operador ( ? )",
    explanation = "Kotlin usa el sistema de tipos nullable con el operador ( ? ) para manejar valores que pueden ser nulos de forma segura.",
    category = QuestionCategory.FUNDAMENTALS.displayName
  ),
  Question(
    id = 14,
    text = "¿Qué manera se usa para heredar de una clase en Kotlin?",
    options = listOf("extends", "inherits", "( : )"),
    correctAnswer = "( : )",
    explanation = "En Kotlin se usa '( : )' después del nombre de la clase para indicar herencia o implementación de interfaces.",
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
    text = "¿Cuál es la palabra clave para crear una variable que NO puede ser nula?",
    options = listOf("var", "val", "lateinit"),
    correctAnswer = "lateinit",
    explanation = "lateinit permite declarar propiedades no nulas que se inicializan después, pero garantiza que no serán null cuando se accedan.",
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
    text = "¿Cuál es la diferencia entre '==' y '===' en Kotlin??",
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
    explanation = "se utiliza para manejar valores nulos de manera concisa y segura, proporcionando un valor predeterminado cuando una expresión es nula. Si la expresión a la izquierda del operador no es nula, se devuelve su valor; si es nula, se devuelve el valor a la derecha del operador.",
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
    text = "¿Cuál es el propósito de 'SideEffect' en Compose?",
    options = listOf("Ejecutar código cada vez que ocurre una recomposición", "Evitar fugas de memoria", "Persistir estado entre recomposiciones"),
    correctAnswer = "Ejecutar código cada vez que ocurre una recomposición",
    explanation = "SideEffect se usa para ejecutar acciones que deben ocurrir en cada recomposición.",
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
    text = "¿Cuál es la diferencia entre 'interface' y 'abstract class'?",
    options = listOf("Son equivalentes", "Una interface no guarda estado, una abstract class sí puede", "Solo las interfaces pueden tener constructores"),
    correctAnswer = "Una interface no guarda estado, una abstract class sí puede",
    explanation = "Las interfaces definen contratos sin estado, mientras que las abstract class pueden contener propiedades con estado.",
    category = QuestionCategory.POO.displayName
  ),
  Question(
    id = 30,
    text = "¿Qué es el polimorfismo en Kotlin?",
    options = listOf("La posibilidad de usar genéricos", "El paso por referencia", "La capacidad de una función/clase de tener múltiples formas",),
    correctAnswer = "La capacidad de una función/clase de tener múltiples formas",
    explanation = "El polimorfismo permite que una clase hija sobrescriba comportamientos de la clase padre o comparta una misma interfaz.",
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
)
