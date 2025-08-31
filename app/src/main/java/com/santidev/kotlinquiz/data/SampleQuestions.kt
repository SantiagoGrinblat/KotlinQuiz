package com.santidev.kotlinquiz.data

val sampleQuestions = listOf(
  Question(
    id = 1,
    text = "Cuál es la palabra clave para declarar una clase de datos?",
    options = listOf("class", "data class", "object"),
    correctAnswer = "data class",
    explanation = "Las clases de datos se utilizan para representar datos inmutables."
  ),
  Question(
    id = 2,
    text = "¿Cómo se declara una función en Kotlin?",
    options = listOf("def", "fun", "func"),
    correctAnswer = "fun",
    explanation = "En Kotlin, se utiliza la palabra clave 'fun' para declarar funciones."
  ),
  Question(
    id = 3,
    text = "¿Cual es la forma correcta de recordar un estado a travez de la recomposicion?",
    options = listOf("remember", "rememberUpdatedState", "rememberSaveable"),
    correctAnswer = "rememberSaveable",
    explanation = "rememberSaveable es la forma que tiene jetpack compose, para recordar el estado actual de un composable y evitar la recomposicion al girar la pantalla del dispositivo"
  ),
  Question(
    id = 4,
    text = "¿Qué palabra clave se usa para crear una corrutina en Kotlin?",
    options = listOf("launch", "async", "suspend", "runBlocking"),
    correctAnswer = "launch",
    explanation = "launch inicia una nueva corrutina sin bloquear el hilo actual."
  ),
  Question(
    id = 5,
    text = "Cuál es la diferencia entre una data class y una class normal?",
    options = listOf("Las data class generan equals, hashCode y toString automáticamente",
      "Las class normales no pueden heredar",
      "Las data class no aceptan constructores",
      "No hay diferencia"),
    correctAnswer = "Las data class generan equals, hashCode y toString automáticamente",
    explanation = "Data class genera automáticamente funciones útiles como equals y toString."
  ),
  Question(
    id = 6,
    text = "Cuál es la forma correcta de ver si un numero es Par O Impar?",
    options = listOf("if (numero / 2 == 0)","if (numero * 2 == 0)","if (numero % 2 == 0)", "if (numero / 2 == 2)"),
    correctAnswer = "if (numero % 2 == 0)",
    explanation = "El operador ( % ) en Kotlin se llama módulo y comprueba si es divisible por 2, si lo es devulve 'Par', si no lo es devuelve 'Impar' "
  ),
  Question(
    id = 7,
    text = "Qué hace el operador !! en Kotlin",
    options = listOf("Convierte null en 0","Lanza una excepción si la variable es null","Ignora el valor null", "Cambia el tipo de la variable a String"),
    correctAnswer = "Lanza una excepción si la variable es null",
    explanation = "El operador ( !! ) fuerza que una variable nullable no sea null; si lo es, lanza NullPointerException."
  ),
  Question(
    id = 8,
    text = "Cuál es la forma correcta de cambiar el texto de un Text según un estado mutable",
    options = listOf("Text { miEstado }","Text(miEstado.setValue())","Text(miEstado.value)", "Text(text = miEstado)"),
    correctAnswer = "Text(text = miEstado)",
    explanation = "Al pasar la variable miEstado al parámetro text, Compose actualiza el texto automáticamente cuando cambia."
  ),
  Question(
    id = 9,
    text = "¿Cuál composable se usa para superponer elementos?",
    options = listOf("Box { ... }","Column { ... }","Stack { ... }", "Row { ... }"),
    correctAnswer = "Box { ... }",
    explanation = "Box permite apilar elementos unos sobre otros."
  ),
  Question(
    id = 10,
    text = "Cuál es la forma correcta de cambiar el color de un Text",
    options = listOf("Text('Hola', Color.Red)","Text('Hola', color = Color.Red)","Text('Hola').color(Color.Red)", "Text(\"Hola\", textColor = Color.Red)"),
    correctAnswer = "Text('Hola', color = Color.Red)",
    explanation = "El parámetro color define el color del texto."
  ),
)