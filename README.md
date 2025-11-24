# 📱🔗 Automation Challenge – Mobile + API Testing (Java + Appium + RestAssured)

Este proyecto contiene un framework de automatización orientado a pruebas Mobile (Android) con Appium y pruebas de API utilizando RestAssured, construido en Java y ejecutado con JUnit 5 y Maven.

Su objetivo es demostrar buenas prácticas de automatización, diseño modular y un approach escalable para QA Automation.

## 🚀 Tecnologías Utilizadas
### Mobile
- Appium 8.x
- AndroidDriver (uiautomator2)
- Google Calculator APK
- Emuladores Android (AVD)

### API
- RestAssured
- JSON Schema validation
- HTTP methods (GET, POST, PUT, DELETE)

### Core
- Java 17
- JUnit 5
- Maven
- Page Object Model
- Diseño modular (base classes, utils, config)

## 📁 Estructura del Proyecto
```
src
└── test
├── java
│    ├── api
│    │    ├── tests
│    │    └── clients
│    ├── mobile
│    │    ├── pages
│    │    ├── tests
│    │    └── MobileBaseTest.java
│    └── utils
└── resources
├── apps
│    └── calculator.apk
└── schemas
└── *.json
```

## ⚙️ Requisitos Previos
### General
- Java 17+
- Maven 3+

### Mobile
- Android Studio instalado
- Variables de entorno configuradas:
```
ANDROID_HOME = F:\Android\Sdk
platform-tools agregado al PATH
```
- Appium Server (Appium Desktop o Appium server por terminal)
- Un emulador creado (ej: emulator-5554)

### API
- No requiere configuración extra (usa endpoints públicos o mockeados)

## ▶️ Cómo Ejecutar las Pruebas
Clonar el repositorio
```bash
git clone https://github.com/tu_usuario/automation-mobile-api.git
cd automation-mobile-api
```

## 📱 Ejecutar pruebas Mobile
1. Iniciar Appium Server:
```
appium
```
2. Iniciar un emulador:
```
emulator -avd NombreDeTuEmulador
```
3. Ejecutar solo tests Mobile:
```
mvn -Dtest=mobile.* test
```

## 🌐 Ejecutar pruebas API
```
mvn -Dtest=api.* test
```

## 🔄 Ejecutar todo el proyecto
```
mvn test
```

## 🧪 Ejemplo de Test Mobile
```java
@Test
public void testAddition() {
CalculatorPage calc = new CalculatorPage(driver);
calc.pressNumber("2");
calc.pressOperator("plus");
calc.pressNumber("3");
calc.pressOperator("equals");
assertEquals("5", calc.getResult());
}
```

## 🌐 Ejemplo de Test API
```java
@Test
public void testGetUsers() {
given()
.baseUri("https://reqres.in/api")
.when()
.get("/users?page=2")
.then()
.statusCode(200)
.body("data", not(empty()));
}
```

## 🏗️ Buenas Prácticas Utilizadas
- Page Object Model
- Reutilización de código mediante clases base
- Capabilities dinámicas para Mobile
- Validación de respuesta con JSON Schema
- Tests independientes y desacoplados
- Organización por capas (tests → clients/pages → utils)

## 📝 Próximas Mejoras
- Añadir reporter Allure
- Integración CI (GitHub Actions / Jenkins)
- Paralelismo
- Reintentos configurables
- Más endpoints y escenarios complejos para API

## 👨‍💻 Autor
Farid Atala

QA Automation Engineer

LinkedIn: https://www.linkedin.com/in/farid-atala-4363171a6/