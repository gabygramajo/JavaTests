# Testing with Java

![Intellij idea](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JUnit 4](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
<img src="https://upload.wikimedia.org/wikipedia/commons/2/2c/Mockito_Logo.png" width="80" alt="mockito" style="background:white; padding: 4px">

![Test Everywhere](https://mailtrap.io/wp-content/uploads/2020/06/testing_meme3.png)

### JUnit 

- **`@Test`**: Anotación utilizada para marcar un método como un método de prueba. JUnit ejecutará los métodos marcados con **`@Test`** durante la ejecución de las pruebas.
- **`@Test(expected = IllegalArgumentException.class)`**: Anotación que se utiliza junto con **`@Test`** para indicar que se espera que el método de prueba lance una excepción específica, en este caso, una **`IllegalArgumentException`**.
- **`@Before`**: Anotación utilizada para marcar un método que se ejecutará antes de cada método de prueba en la misma clase. Se usa comúnmente para inicializar configuraciones necesarias para las pruebas.
- **`@BeforeEach`**: Similar a **`@Before`**, es una anotación utilizada en JUnit 5 para marcar un método que se ejecuta antes de cada método de prueba, facilitando la inicialización de recursos.
- **`Assert`**: Clase proporcionada por JUnit para realizar afirmaciones en las pruebas. Se utiliza para verificar si ciertas condiciones son verdaderas y generar resultados de prueba.
- **`assertEquals`**: Método de la clase **`Assert`** utilizado para verificar si dos valores son iguales. Útil para comparar valores esperados con resultados obtenidos durante las pruebas.**`assertEquals(expected, actual)`**
- **`assertTrue`**: Método de la clase **`Assert`** utilizado para verificar si una condición es verdadera. Se utiliza para afirmar que ciertas condiciones son ciertas durante las pruebas.
- **`assertFalse`**: Método de la clase **`Assert`** utilizado para verificar si una condición es falsa. Se utiliza para afirmar que ciertas condiciones son falsas durante las pruebas.

### Mockito

- **`Mockito`**: Un marco de prueba de Java que se utiliza para simular objetos y comportamientos. Facilita la creación de objetos de prueba simulados (mocks) para aislar y probar unidades de código.
- **`Mockito.mock(class)`**: Método de Mockito utilizado para crear un objeto simulado (mock) de una clase específica. Este objeto simulado se puede controlar para devolver valores predefinidos y registrar interacciones durante las pruebas.
- **`Mockito.when(class)`**: Método de Mockito utilizado para comenzar a definir el comportamiento de un objeto simulado. Se utiliza junto con **`thenReturn`** para especificar qué valor debe devolver el objeto simulado cuando se llama a un método específico.
- **`Mockito.when(class).thenReturn(2)`**: Ejemplo de uso de Mockito para indicar que, cuando se llama a un método específico en un objeto simulado, debe devolver el valor 2. Esto se utiliza para controlar el comportamiento del objeto simulado durante las pruebas.