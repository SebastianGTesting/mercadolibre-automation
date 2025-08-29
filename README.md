# Mercado Libre Automation (Serenity BDD + Cucumber + Screenplay)

Proyecto base para automatizar **Mercado Libre Colombia** usando **Serenity BDD + Cucumber + Screenplay** con **Java 17** en **Mac**. Ejecuta en **Chrome maximizado** y maneja el **ChromeDriver automáticamente** con WebDriverManager.

## Requisitos
- **Java 17** (recomendado)
- **Maven 3.8+**
- **IntelliJ IDEA** (plugin *Cucumber for Java* recomendado)
- Google **Chrome** instalado

### Instalar Java 17 en Mac
Con Homebrew:
```bash
brew install openjdk@17
/opt/homebrew/opt/openjdk@17/bin/java -version
```

Con SDKMAN:
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 17.0.11-tem
java -version
```

## Estructura
```
src/test/java/com/mercadolibre/automation
├── runners
│   └── SearchRunner.java
├── stepdefinitions
│   └── SearchStepDefinitions.java
├── tasks
│   └── SearchProduct.java
├── questions
│   └── SearchResult.java
└── userinterfaces
    └── HomePage.java

src/test/resources
├── serenity.conf
└── features/search
    └── search_product.feature
```

## Ejecutar
Desde terminal:
```bash
mvn clean verify
```


## Notas
- Si el selector del buscador cambia en Mercado Libre, actualiza los `Target` en `HomePage.java`.
- Si quieres correr en **headless**, agrega en `serenity.conf`:
  ```hocon
  chrome {
    switches = "--headless=new --window-size=1920,1080"
  }
  ```
